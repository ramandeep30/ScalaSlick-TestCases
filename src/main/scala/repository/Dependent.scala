package repository

import Connection.{DBComponent, MySqlComponent}

import scala.concurrent.Future

case class Dependent(id: Int, empId: Int, name: String, relation: String, age: Option[Int])

trait DependentTable extends EmployeeTable {

  this: DBComponent =>

  import driver.api._

  protected val dependentTableQuery = TableQuery[DependentTable]

  protected def dependentTableAutoInc = dependentTableQuery returning dependentTableQuery.map(_.id)

  private[repository] class DependentTable(tag: Tag) extends Table[Dependent](tag, "dependent") {

    val id = column[Int]("dependentid", O.PrimaryKey, O.AutoInc)
    val empId = column[Int]("empid")
    val name = column[String]("name")
    val relation = column[String]("relation")
    val age = column[Option[Int]]("age", O.Default(None))

    def employeeDependentFK = foreignKey("employee-dependent_fk", empId, employeeTableQuery)(_.id)

    def * = (id, empId, name, relation, age) <> (Dependent.tupled, Dependent.unapply)

  }

}

trait DependentRepo extends DependentTable {

  this: DBComponent =>

  import driver.api._

  def create(): Future[Unit] = db.run(dependentTableQuery.schema.create)

  def insert(dependent: Dependent): Future[Int] = db.run {
    dependentTableQuery += dependent
  }

  def delete(id: Int): Future[Int] = {
    val query = dependentTableQuery.filter(x => x.id === id)
    val action = query.delete
    db.run(action)
  }

  def updateName(id: Int, name: String): Future[Int] = {
    val query = dependentTableQuery.filter(_.id === id).map(_.name).update(name)
    db.run(query)
  }

  def upsert(dependent: Dependent): Future[Int] = {
    val query = dependentTableQuery.insertOrUpdate(dependent)
    dependentTableQuery += dependent
    db.run(query)
  }

  def getAll: Future[List[Dependent]] = db.run {
    dependentTableQuery.to[List].result
  }

  def updateTuple(id: Int, values: (String, Int, String, Option[Int])): Future[Int] = {
    val query = dependentTableQuery.filter(_.id === id).map(d => (d.name, d.empId, d.relation, d.age)).update(values)
    db.run(query)
  }

  def getDependentWithEmployee = {
    val res = for {
      (dependent, employee) <- dependentTableQuery join employeeTableQuery on (_.empId === _.id)
    } yield (dependent.name, employee.name)

    db.run(res.to[List].result)
  }

  /*def getDependentWithEmployee: Future[List[(Employee, Dependent)]] = db.run {
    (for {
      record <- dependentTableQuery
      employee <- record.employeeDependentFK
    }yield (employee, record)).to[List].result
  }
*/
  /* def getDependents: Future[List[(String, String)]] = db.run {
     (
       for {
       (e, d) <- employeeTableQuery join dependentTableQuery on (_.id === _.empId)
         } yield (e.name, d.name)
       ).to[List].result
   }
 */
  def insertPSQL(dependent: Dependent) = {
    val res = sqlu"insert into dependent values (${dependent.id}, ${dependent.empId}, ${dependent.name}, ${dependent.relation}, ${dependent.age})"
    db.run(res)
  }


}

object DependentRepo extends DependentRepo with MySqlComponent