import scala.annotation.tailrec

object Zadania extends App {

  // zad1
  val days: List[String] = List("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "San")
  println(days)

  //a)
  val daysString: String = {
    var temp = ""
    for (d <- days) {
      temp = temp + d + ","
    }
    temp.dropRight(1)
  }
  println("Zad 1")
  println("a)")
  println(daysString)
  println()

  //b)
  val daysStartT: String = {
    var temp = ""
    for (d <- days) {
      if (d.startsWith("T") ) {
        temp = temp + d + ","
      }
    }
    temp.dropRight(1)
  }
  println("b)")
  println("Note: As my list of days of week was in English, I have change a letter to T," +
    "so it does return 2 days as it would in case of P in Polish")
  println(daysStartT)
  println()

  //c)
  val daysWhile = {
    var i = 0
    var temp = ""
    while (i < days.length) {
      temp = temp + days(i) + ","
      i = i+1
    }
    temp.dropRight(1)
  }
  println("c)")
  println(daysWhile)
  println()

  //zad2
  //a)
  def daysRec(n: Int): String =
    if (n < 1) days(n)
    else daysRec(n-1) + "," + days(n)

  println("Zad 2")
  println("a)")
  println(daysRec(6))
  println()

  def daysRecRev(n: Int): String =
    if (n < 1) days(n)
    else days(n) + "," + daysRecRev(n-1)

  println("b)")
  println(daysRecRev(6))
  println()

  //zad3
  def daysTailRec(n: Int): String = {
    @tailrec def daysTailRecAcc(acc: String, n: Int): String = {
      if (n < 1) acc
      else daysTailRecAcc( days(n-1)  + "," + acc , n-1)
    }
    daysTailRecAcc("", n+1).dropRight(1)
  }

  println("Zad 3")
  println(daysTailRec(6))
  println()

  //zad4
  //a)
  val daysLeft = days.foldLeft("")(_ + "," + _).substring(1)

  println("Zad 4")
  println("a)")
  println(daysLeft)
  println()

  //b)
  val daysRight = days.foldRight("")(_ + "," + _).dropRight(1)

  println("b)")
  println(daysRight)
  println()

  //c)
  val daysLeftCon = days.filter(_.startsWith("T")).foldLeft("")(_ + "," + _).substring(1)

  println("c)")
  println(daysLeftCon)
  println()

  //zad5
  val products: Map[String, Double] = Map("butter" -> 2, "chess" -> 5, "milk" -> 6)
  val makeSale: ((String, Double)) => (String, Double) = {
    case (key, value) =>
      val newValue = value * 0.9
      key -> newValue
  }
  val prodSale = products.map(makeSale)

  println("Zad 5")
  println(products)
  println(prodSale)
  println()

  //zad 6
  def genTuple(x:Int, y:String, z:Double) = {
    val myTuple = (x, y, z): Tuple3[Int, String, Double]
    println(myTuple._1)
    println(myTuple._2)
    println(myTuple._3)
    myTuple
  }

  println("Zad 6")
  println(genTuple(1, "Text", 2.3))
  println()

  //zad 7
  println("Zad 7")
  println(products.get("butter"))
  println(products.get("sugar"))

  println(checking(products.get("butter")))
  println(checking(products.get("sugar")))
  println()

  def checking(z: Option[Double]) = z match
  {
    case Some(s) => s
    case None => "key not found"
  }

  //zad 8
  println("Zad 8")
  val listOfNum: List[Int] = List(1, 3, 0, 9, 94, 13, 0)
  val listNoZero: List[Int] = listOfNum.filter(_ != 0)
  println(listOfNum)
  println(listNoZero)


  @tailrec def RemoveZeros(listIn: List[Int], listOut: List[Int] = List()): List[Int] = {
    if (listIn == List()) listOut
    else if (listIn.head != 0) RemoveZeros(listIn.tail, listOut ++ List(listIn.head))
    else RemoveZeros(listIn.tail, listOut)
  }

  println(RemoveZeros(listIn = listOfNum))
  println()

  //zad 9
  def addValToList(lst: List[Int], n:Int): List[Int] = {
    lst.map(x => x+n)
  }
  println("Zad 9")
  println(addValToList(listOfNum, 3))
  println()

  //zad 10
  val newList = List(-1, 55.5, -4.2, -10, 3, 0, 3, -2)
  def changelist(lst: List[Double],a: Double, b:Double): List[Double] = {
    lst.filter(_ > a).filter(_ < b).map(z => z.abs)
  }
  println("Zad 10")
  println(changelist(newList, -5, 12))

}
