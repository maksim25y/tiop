import scala.math._

object NumericalIntegration {

  private val Epsilon = 0.0001

  /**
   * Численное интегрирование методом прямоугольников
   * @param f функция для интегрирования
   * @param a начало отрезка
   * @param b конец отрезка
   * @param FN шаг, на котором нужно вывести промежуточный результат (Debug)
   * @param LN шаг, на котором нужно вывести промежуточный результат (Trace)
   * @return (result, error)
   */
  def integrate(f: Double => Double, a: Double, b: Double, FN: Int, LN: Int): (Double, Double) = {
    var n = 1
    var h = (b - a) / n
    var integralN = rectangleMethod(f, a, b, n)
    var integral2N = 0.0
    var delta = Double.MaxValue
    var step = 0

    // используем обычный while вместо do-while
    while (delta > Epsilon) {
      step += 1
      n *= 2
      h = (b - a) / n
      integral2N = rectangleMethod(f, a, b, n)
      delta = abs(integral2N - integralN) / 3.0

      println(f"Шаг $step: n=$n, h=$h%.6f, integral_n=$integralN%.6f, integral_2n=$integral2N%.6f, delta=$delta%.8f")

      if (step == FN)
        println(s"FN шаг ($FN): Интеграл = $integralN")

      if (step == LN)
        println(s"LN шаг ($LN): Интеграл = $integralN")

      integralN = integral2N
    }

    (BigDecimal(integral2N).setScale(3, BigDecimal.RoundingMode.HALF_UP).toDouble, delta)
  }

  /** Метод прямоугольников */
  private def rectangleMethod(f: Double => Double, a: Double, b: Double, n: Int): Double = {
    var sum = 0.0
    val h = (b - a) / n

    for (i <- 0 until n) {
      val x = a + i * h
      assert(x >= a && x <= b, "Выход за границы диапазона интегрирования.")
      sum += f(x)
    }

    sum * h
  }
}
