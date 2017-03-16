package repository


import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration

object Implementation extends App {

    /*EmployeeRepo.create*/
    /*Thread.sleep(10000)*/
    /*val insertRes = EmployeeRepo.insert(Employee(1, "Raman", 1.0))*/
    /*val res = insertRes.map { res => s"$res row inserted" }.recover {*/
    /*  case ex: Throwable => ex.getMessage*/
    /*}*/
    /*val insertRes1 = EmployeeRepo.insert(Employee(2, "Anuj", 2.0))*/
    /*val res1 = insertRes1.map { res1 => s"$res1 row inserted" }.recover {*/
    /*  case ex: Throwable => ex.getMessage*/
    /*}*/
    /*val insertRes2 = EmployeeRepo.insert(Employee(3, "Gitika", 5.0))*/
    /*val insertRes3 = EmployeeRepo.insert(Employee(4, "Jatin", 4.0))*/
    /*val insertRes4 = EmployeeRepo.insert(Employee(5, "Anmol", 2.0))*/
    /*val insertRes5 = EmployeeRepo.insert(Employee(6, "Simar", 1.0))*/
    /*res.map(println(_))*/
    /*res1.map(println(_))*/
    /*Thread.sleep(10000)*/

   /* ProjectRepo.create()
    Thread.sleep(10000)

    val insertRes6 = ProjectRepo.insert(Project(1, "FreeBird", 1, 5, "Prashant"))
    val insertRes7 = ProjectRepo.insert(Project(2, "BankOfAmerica", 6, 6, "Ayush"))

    val res3 = insertRes6.map { res3 => s"$res3 row inserted" }.recover {
      case ex: Throwable => ex.getMessage
    }

    val res4 = insertRes7.map { res4 => s"$res4 row inserted" }.recover {
      case ex: Throwable => ex.getMessage
    }

    res3.map(println(_))
    res4.map(println(_))
    Thread.sleep(10000)

    DependentRepo.create()
    Thread.sleep(10000)
    val insertRes9 = DependentRepo.insert(Dependent(1, 2, "Gaurav", "brother", Some(20)))
    val insertRes10 = DependentRepo.insert(Dependent(2, 3, "Jyoti", "sister", Some(26)))

    val res5 = insertRes9.map { res5 => s"$res5 row inserted" }.recover {
      case ex: Throwable => ex.getMessage
    }
    val insertRes11 = DependentRepo.insert(Dependent(3, 3, "Aman", "brother", None))
    val res6 = insertRes11.map { res6 => s"$res6 row inserted" }.recover {
      case ex: Throwable => ex.getMessage
    }
    res5.map(println(_))
    res6.map(println(_))
    Thread.sleep(10000)
*/

   /* val deletedRecord = EmployeeRepo.delete(4.0)
    val deleteResult = deletedRecord.map { deleteResult => s"$deleteResult row deleted" }.recover{
      case ex: Throwable => s"Deletion Failed ${ex.getMessage}"
    }
   Thread.sleep(10000)
    val updatedRecord = EmployeeRepo.updateName(6, "Akhil")
    val updateResult = updatedRecord.map { updateResult => s"$updateResult row updated" }.recover {
      case ex: Throwable => s"Update Failed ${ex.getMessage}"
    }*/
/*
    val upsertRecord = EmployeeRepo.upsert(Employee(7,"Akash",3.0))
    val upsertResult = upsertRecord.map { upsertResult => s"$upsertResult row updated/inserted" }.recover{
      case ex: Throwable => s"Upsert Failed ${ex.getMessage}"
    }
    Thread.sleep(10000)

    val updateTupleRecord = EmployeeRepo.updateTuple(3,("Amit",2.0))
    val updateTupleResult = updateTupleRecord.map { updateTupleResult => s"$updateTupleResult row updated" }.recover{
      case ex: Throwable => s"Update Tuple Failed ${ex.getMessage}"
    }

    val employeeList = EmployeeRepo.getAll
    val empListResult = employeeList.map { empListResult => s"$empListResult"}.recover{
      case ex: Throwable => s"Listing Failed ${ex.getMessage}"
    }
    println(Await.result(employeeList, Duration.Inf))
    Thread.sleep(1000)*/

    /*val updatedRecord1 = ProjectRepo.updateName(2, "RoyalCarribean")
    val updateResult1 = updatedRecord1.map { updateResult1 => s"$updateResult1 row updated" }.recover {
      case ex: Throwable => s"Update Failed ${ex.getMessage}"
    }
    Thread.sleep(10000)

    val updateTupleRecord1 = ProjectRepo.updateTuple(1,("EY",1,6,"Bhavya"))
    val updateTupleResult1 = updateTupleRecord1.map { updateTupleResult1 => s"$updateTupleResult1 row updated" }.recover{
      case ex: Throwable => s"Update Tuple Failed ${ex.getMessage}"
    }

    Thread.sleep(10000)*/
    /*val deletedRecord1 = ProjectRepo.delete(2)
    val deleteResult1= deletedRecord1.map { deleteResult1 => s"$deleteResult1 row deleted" }.recover{
      case ex: Throwable => s"Deletion Failed ${ex.getMessage}"
    }
    Thread.sleep(10000)
    val upsertRecord1 = ProjectRepo.upsert(Project(3,"3TL",2,6,"Himanshu"))
    val upsertResult1 = upsertRecord1.map { upsertResult1 => s"$upsertResult1 row updated/inserted" }.recover{
      case ex: Throwable => s"Upsert Failed ${ex.getMessage}"
    }
    Thread.sleep(10000)

    val projectList = ProjectRepo.getAll
    val projListResult = projectList.map { projListResult => s"$projListResult"}.recover{
      case ex: Throwable => s"Listing Failed ${ex.getMessage}"
    }
    println(Await.result(projectList, Duration.Inf))*/
   // Thread.sleep(10000)

   /* val updatedRecord2 = DependentRepo.updateName(2,"Anu")
    val updateResult2 = updatedRecord2.map { updateResult2 => s"$updateResult2 row updated" }.recover {
      case ex: Throwable => s"Update Failed ${ex.getMessage}"
    }
    Thread.sleep(10000)
    val updateTupleRecord2 = DependentRepo.updateTuple(4,("Piyush",1,"father",Some(60)))
    val updateTupleResult2 = updateTupleRecord2.map { updateTupleResult2 => s"$updateTupleResult2 row updated" }.recover{
      case ex: Throwable => s"Update Tuple Failed ${ex.getMessage}"
    }
    Thread.sleep(10000)*/
/*
    val deletedRecord2 = DependentRepo.delete(2)
    val deleteResult2= deletedRecord2.map { deleteResult2 => s"$deleteResult2 row deleted" }.recover{
      case ex: Throwable => s"Deletion Failed ${ex.getMessage}"
    }
    Thread.sleep(10000)

    val upsertRecord2 = DependentRepo.upsert(Dependent(5,4,"Poonam","wife",Some(26)))
    val upsertResult2 = upsertRecord2.map { upsertResult2 => s"$upsertResult2 row updated/inserted" }.recover{
      case ex: Throwable => s"Upsert Failed ${ex.getMessage}"
    }
    Thread.sleep(10000)
*/

/*
    val dependentList = DependentRepo.getAll
    val depListResult = dependentList.map { depListResult => s"$depListResult"}.recover{
      case ex: Throwable => s"Listing Failed ${ex.getMessage}"
    }
    println(Await.result(dependentList, Duration.Inf))

*/
    /*val depEmpList = DependentRepo.getDependentWithEmployee
    val depEmpListResult = depEmpList.map { depEmpListResult => s"$depEmpListResult"}.recover{
      case ex: Throwable => s"Listing Failed ${ex.getMessage}"
    }
    println(Await.result(depEmpList, Duration.Inf))

    val projEmpList = ProjectRepo.getProjectWithEmployee
    val projEmpListResult = projEmpList.map { projEmpListResult => s"$projEmpListResult"}.recover{
      case ex: Throwable => s"Listing Failed ${ex.getMessage}"
    }
    println(Await.result(projEmpList, Duration.Inf))
*/

}
