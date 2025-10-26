import scala.io.StdIn.readLine

object LR1_2 {

  def sum(x: Array[Int], N: Int): Int = {                   //31
    var s = 0                                                //32
    for (i <- 0 until N)                                     //33
      s += x(i)                                              //34
    s                                                        //35
  }                                                          //36

  def ReadInt(prompt: String): Int = {                       //37
    print(prompt)                                            //38
    val x = readLine().toInt                                 //39
    x                                                        //40
  }                                                          //41

  def main(args: Array[String]): Unit = {                    //0
    val N = 10                                               //1
    val a = Array(1, 3, -5, 0, 4, 6, -1, 9, 3, 2)            //2
    var m = a(0)                                             //3
    for (i <- 1 until N)                                     //4
      if (m < a(i))                                          //5
        m = a(i)                                             //6
    println(m)                                               //7

    var s = 0                                                //8
    s = sum(a, N)                                            //9
    println(s)                                               //10

    val z = s / m                                            //11
    var k = 0                                                //12
    for (i <- 0 until N)                                     //13
      if (a(i) > z)                                          //14
        k += a(i)                                            //15
      else                                                   //16
        k -= a(i)                                            //17
    println(k)                                               //18

    var x = 0                                                //19
    var y = 0                                                //19
    x = ReadInt("")                                          //20
    y = ReadInt("")                                          //21
    s = 0                                                    //22
    while ((x != 0) && (x != 0)) {                           //23
      x -= 1                                                 //25
      y -= 1                                                 //26
      s += x + y                                             //27
    }                                                        //28
    println(s)                                               //29
  }                                                          //30
}
