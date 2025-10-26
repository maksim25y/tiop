import org.scalatest.funsuite.AnyFunSuite

class CartesianPlane13Tests extends AnyFunSuite {

  val cartesianPlane = new CartesianPlane13(5, 10)

  val testData: Seq[(Double, Double, Boolean)] = Seq(
    // Классы эквивалентности
    (2, 1, false),
    (-3, 3, true),
    (-4, 4, false),
    (-2, -2, false),
    (2, -2, false),
    (7, -3.5, true),
    (9.5, -5, false),

    // Граничные значения
    (0, 0, true),
    (0, 4.999, true), (0, 5, true), (0, 5.001, false),
    (-3, 4, true),
    (-4.999, 0, true), (-5, 0, true), (-5.001, 0, false),
    (0, -4.999, false), (0, -5, true), (0, -7.5, true), (0, -10, true), (0, -10.001, false),
    (3, -4, true), (8, -6, true),
    (4.999, 0, false), (5, 0, true), (7.5, 0, true), (10, 0, true), (10.001, 0, false)
  )

  for (((x, y, expected), index) <- testData.zipWithIndex) {
    test(f"Test #${index + 1}: isBelongToZone($x%.3f, $y%.3f) should be $expected") {
      val result = cartesianPlane.isBelongToZone(x, y)
      assert(result == expected, s"Expected $expected but got $result for (x=$x, y=$y)")
    }
  }
}