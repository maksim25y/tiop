import org.scalatest.funsuite.AnyFunSuite

class ConvertatorTests extends AnyFunSuite {

  var testData: Seq[(String, String)] = Seq.empty

  def beforeEach(): Unit = {
    testData = Seq.empty
  }

  def afterEach(): Unit = {
    testData = Seq.empty
  }

  test("simple numbers") {
    beforeEach()
    testData = Seq(
      ("1001", "9"),
      ("1010", "A"),
      ("1011", "B"),
      ("1100", "C"),
      ("1101", "D"),
      ("1110", "E"),
      ("1111", "F")
    )

    for ((bin, expectedHex) <- testData) {
      assert(Convertator.convert2to16(bin) == expectedHex, s"Ожидалось $expectedHex для $bin")
    }
    afterEach()
  }

  test("single complex number") {
    beforeEach()
    val binNum = "110111101"
    val hexNum = Convertator.convert2to16(binNum)
    assert(hexNum == "1BD", s"Ожидалось 1BD для $binNum, но получено $hexNum")
    afterEach()
  }

  test("non-existent number (contains invalid characters)") {
    beforeEach()
    val binNum = "101010i01010"
    val hexNum = Convertator.convert2to16(binNum)
    assert(hexNum == "nil", s"Ожидалось nil для $binNum, но получено $hexNum")
    afterEach()
  }

  test("number overflow") {
    beforeEach()
    val binNum = "111111111111111111111111111111111111111111111111111111111111111111"
    val hexNum = Convertator.convert2to16(binNum)
    assert(hexNum == "nil", s"Ожидалось nil для $binNum (переполнение), но получено $hexNum")
    afterEach()
  }
}
