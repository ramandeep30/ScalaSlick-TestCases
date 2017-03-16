import Connection.H2DBComponent
import repository.{Employee, EmployeeRepo}
import org.scalatest.AsyncFunSuite

class EmployeeSpec extends AsyncFunSuite with EmployeeRepo with H2DBComponent {

  test("insert into Employee table") {
    this.insert(Employee(101, "Pranjut",5)).map(res => assert(res === 1))
  }
}
