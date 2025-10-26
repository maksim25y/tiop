object ArithmeticProgression {

  /**
   * Вычисляет сумму арифметической прогрессии.
   * @param a1 первый член
   * @param d разность прогрессии
   * @param n количество членов
   * @throws ArithmeticException если происходит переполнение Int
   */
  def calculateArithmeticProgressionSum(a1: Int, d: Int, n: Int): Int = {
    var sum = 0

    for (i <- 0 until n) {
      var currentElement = 0

      try {
        // проверка переполнения при вычислении элемента
        currentElement = Math.addExact(a1, Math.multiplyExact(i, d))
      } catch {
        case _: ArithmeticException =>
          assert(assertion = false, "Арифметическое переполнение при вычислении члена последовательности.")
          throw new ArithmeticException("Переполнение при вычислении члена последовательности.")
      }

      try {
        // проверка переполнения при суммировании
        sum = Math.addExact(sum, currentElement)
      } catch {
        case _: ArithmeticException =>
          assert(assertion = false, "Арифметическое переполнение при вычислении суммы.")
          throw new ArithmeticException("Переполнение при вычислении суммы.")
      }
    }

    sum
  }
}
