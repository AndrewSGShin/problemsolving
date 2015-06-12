import scala.collection.mutable.MutableList

object VectorProduct extends App {
  
  val input = MutableList(List(1, 2, 3), List(4, 5), List(6, 7))
  val result : MutableList[String] = MutableList()
  vectorProduct(input, 0, "", result)
  println(result)
  
  def vectorProduct (lists: MutableList[List[Int]], level: Int, tuple: String, result: MutableList[String]) {
    var i = 0
    for (i <- lists(level)) {
      if (level == lists.length - 1) {
        result += tuple + i
      } else {
        vectorProduct(lists, level + 1, tuple + i + ' ', result)
      }
    }
  }
}