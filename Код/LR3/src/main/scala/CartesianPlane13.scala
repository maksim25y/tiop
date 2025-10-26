import scala.math._

class CartesianPlane13(val R1: Double, val R2: Double) {

  def isBelongToZone(x: Double, y: Double): Boolean = {
    val distance = sqrt(x * x + y * y)

    (x <= 0 && y >= 0 && distance <= R1) ||
      (x >= 0 && y <= 0 && distance >= R1 && distance <= R2)
  }
}
