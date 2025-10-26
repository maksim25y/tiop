import scala.math._
import java.util.logging.{Logger, Level, ConsoleHandler, SimpleFormatter}

object Main {

  private val FN = 3
  private val LN = 5
  private val logger: Logger = Logger.getLogger(Main.getClass.getName)

  private def setupLogger(): Unit = {
    logger.setUseParentHandlers(false)
    val handler = new ConsoleHandler()
    handler.setLevel(Level.ALL)
    handler.setFormatter(new SimpleFormatter())
    logger.addHandler(handler)
    logger.setLevel(Level.ALL)
  }

  def main(args: Array[String]): Unit = {

    setupLogger()

    logger.info("Начало выполнения программы")
    logger.info("---------------------------------------------")

    // === Задание 1 ===
    try {
      val f: Double => Double = x => exp(-x * x + 0.38) / (2 + sin(1 / (1.5 + x * x)))

      val a = 0.4
      val b = 1.0

      logger.info(s"[Интегрирование] от $a до $b")
      logger.info("Начало трассировки интегрирования...")

      val (result, error) = NumericalIntegration.integrate(f, a, b, FN, LN)

      logger.info(f"Результат интеграла: $result%.6f, Погрешность: $error%.8f")
      logger.info("Конец трассировки интегрирования")
    } catch {
      case ex: Exception =>
        logger.log(Level.SEVERE, "Ошибка при интегрировании", ex)
    }

    logger.info("---------------------------------------------")

    // === Задание 2 ===
    try {
      val a1 = 1
      val d = 5
      val n = 100

      val sum = ArithmeticProgression.calculateArithmeticProgressionSum(a1, d, n)

      logger.info(s"Сумма арифметической прогрессии: $sum")
    } catch {
      case ex: ArithmeticException =>
        logger.log(Level.SEVERE, "Ошибка арифметического переполнения", ex)
    }

    logger.info("---------------------------------------------")
    logger.info("Программа завершена.")
  }
}
