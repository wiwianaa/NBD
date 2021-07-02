object Zad2 extends App {
  // zad1
  println("Zad 1")
  def workingDays(x: String): String = x match {
    case "Mon" | "Tue" | "Wed" | "Thu" | "Friday" => "Work"
    case "Sat" | "San" => "Weekend"
    case _ => "There is no such day"
  }
  println(workingDays("San"))
  println(workingDays("Mon"))
  println(workingDays("Pon"))
  println()

  //zad 2
  println("Zad 2")
  class BankAccount (val initialBalance: Double) {
    //zero arguments
    def this() = {
      this(0.0)
    }
    private var balance = initialBalance
    def withdraw(x: Double): Unit = balance -= x
    def deposit(x: Double): Unit = balance += x
    def current = balance
    override def toString = s"Your balance is: $current"


  }
  val myAccount = new BankAccount(3.2)
  println(new BankAccount())
  println(myAccount)
  myAccount.withdraw(1.0)
  println(myAccount)
  myAccount.deposit(100)
  println(myAccount)
  println()

  //zad3
  println("Zad 3")
  class Person(val firstName: String, val surname: String) {
    def greeting(x: Int = 1): String = x match {
      case 1 => s"Hello $firstName"
      case 2 => s"Good morning $firstName $surname"
      case 3 => s"Nice to see you $firstName"
      case _ => "Hi there"
    }
  }

  val p1 = new Person("Jan", "Nowak")
  val p2 = new Person ("Kate", "M")
  val p3 = new Person("Harry", "Potter")
  println(p1.greeting())
  println(p2.greeting(4))
  println(p3.greeting(2))
  println()

  //zad 4
  println("Zad 4")

  def intFun(x: Int):Int = {7*x}
  val intFun2 = (x: Int) => x * 3
  def HOPFun(y: Int, f: (Int) => Int):Int = {
    f(f(f(y)))
  }
  val HOPFun2 = (y: Int, f: (Int) => Int) => f(f(f(y)))

  println(HOPFun(2,intFun))
  println(HOPFun(2,intFun2))
  println(HOPFun2(2,intFun2))
  println(HOPFun2(2,intFun))
  println()

  //zad 5
  println("Zad 5")

  class People(n: String, s: String) {
    var name: String = n
    var surname: String = s
    private var tax: Double = 15
    def set_tax(x: Double){
      tax = x
    }
    def get_tax(): Double = {
      return tax
    }

  }

  trait Student extends People {
    set_tax(0)
  }

  trait Worker extends People {
    private var salary: Double = 50
    def set_salary(x: Double){
      salary = x
    }
    def get_salary(): Double = {
      return salary
    }
    set_tax(20)
  }
  trait Teacher extends Worker {
    set_tax(10)
  }

  val obj_person = new People("A", "B")
  val obj_student = new People("Mr", "Student") with Student;
  val obj_teacher = new People("Mrs", "Teacher") with Teacher;
  val obj_worker = new People("a", "Worker") with Worker;
  val obj_stupra = new People("Stu", "Prac") with Student with Worker;
  val obj_prastu = new People("Prac", "Stu") with Worker with Student;

  obj_teacher.set_salary(1000)
  obj_worker.set_salary(2000)

  println("Salaries:")
  println(obj_worker.name + "'s salary:" +obj_worker.get_salary())
  println(obj_teacher.name + "'s salary:" +obj_teacher.get_salary())

  println("Taxes:")
  println(obj_person.name + "'s tax:" + obj_person.get_tax())
  println(obj_student.name + "'s tax:" +obj_student.get_tax)
  println(obj_teacher.name + "'s tax:" + obj_teacher.get_tax)
  println(obj_worker.name + "'s tax:" +obj_worker.get_tax())

  println(obj_prastu.name + obj_prastu.surname + "'s tax:" + obj_prastu.get_tax)
  println(obj_stupra.name + obj_stupra.surname + "'s tax:" +obj_stupra.get_tax)

}
