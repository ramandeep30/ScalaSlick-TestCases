import Connection.H2DBComponent
import repository.{DependentRepo, Employee}
import org.scalatest.AsyncFunSuite
import repository.Dependent

class DependentSpec extends AsyncFunSuite with DependentRepo with H2DBComponent {

  test("insert into Dependent table") {
    this.insert(Dependent(3,1,"Aman","Brother",Some(29))).map(res => assert(res === 1))
  }

  test("delete from Dependent table") {
    this.delete(1).map(res => assert(res === 1))
  }

  test("updateName from Dependent table") {
    this.updateName(2,"Anuj Saxena").map(res => assert(res === 1))
  }

  test("upsert into Dependent table") {
    this.upsert(Dependent(3,1,"Manpreet","Brother",Some(21))).map(res => assert(res === 1))
  }

  test("get the list of all the dependents") {
    this.getAll.map(res => assert(res.size === 2))
  }

  test("get Dependent and Employee names") {
    this.getDependentWithEmployee.map(res=> assert(res === List(("Aman","Raman"), ("Aman","Raman"))))
  }

  test("insert into Dependent table using psql") {
    this.insertPSQL(Dependent(4,1,"Manpreet","Brother",Some(21))).map(res => assert(res === 1))
  }
}

