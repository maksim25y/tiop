object SoftwareTestingLabsExamples01x01 {
  // Функция для вычисления квадрата числа
  def sqr(x: Int): Int = {
    val q = x * x
    q
  }

  def main(args: Array[String]): Unit = {
    val N = 10
    val a = Array(5, 2, 7, -9, 4, 8, -1, 0, 3, 6)

    // Найдем сумму квадратов положительных элементов массива
    var s = 0
    for (i <- 0 until N) {
      if (a(i) > 0) s += sqr(a(i))
    }

    println(s"Сумма квадратов равна: $s")
  }
}