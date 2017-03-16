package repository

import Connection.{DBComponent, MySqlComponent, PostgresComponent}

import scala.concurrent.Future

case class Project(projectId: Int, name: String, empId: Int, totalMembers: Int, lead: String)

trait ProjectTable extends EmployeeTable {

  this: DBComponent =>

  import driver.api._

  val projectTableQuery = TableQuery[ProjectTable]

  private[repository] class ProjectTable(tag: Tag) extends Table[Project](tag, "project") {

    val projectId = column[Int]("projectId", O.PrimaryKey)
    val name = column[String]("name")
    val empId = column[Int]("emp_id")
    val totalMembers = column[Int]("totalMembers")
    val lead = column[String]("lead")

    def employeeProjectFK = foreignKey(
      "employee_project_fk", empId,
      employeeTableQuery)(_.id)

    def * = (projectId, name, empId, totalMembers, lead) <> (Project.tupled, Project.unapply)
  }

}

trait ProjectRepo extends ProjectTable {

  this: DBComponent =>

  import driver.api._

  def create() = db.run(projectTableQuery.schema.create)

  def insert(project: Project) = db.run {
    projectTableQuery += project
  }

  def delete(projId: Int) = {
    val query = projectTableQuery.filter(x => x.projectId === projId)
    val action = query.delete
    db.run(action)
  }

  def updateName(projId: Int, name: String): Future[Int] = {
    val query = projectTableQuery.filter(_.projectId === projId).map(_.name).update(name)
    db.run(query)
  }

  def upsert(project: Project): Future[Int] = {
    val query = projectTableQuery.insertOrUpdate(project)
    projectTableQuery += project
    db.run(query)
  }

  def getAll: Future[List[Project]] = db.run {
    projectTableQuery.to[List].result
  }

  def updateTuple(projId: Int, values: (String, Int, Int, String)): Future[Int] = {
    val query = projectTableQuery.filter(_.projectId === projId).map(p => (p.name, p.empId, p.totalMembers, p.lead)).update(values)
    db.run(query)
  }

  def getProjectWithEmployee: Future[List[(Employee, Project)]] = db.run {
    (for {
      record <- projectTableQuery
      employee <- record.employeeProjectFK
    } yield (employee, record)).to[List].result
  }

}

object ProjectRepo extends ProjectRepo with MySqlComponent