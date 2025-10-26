object Convertator {

  def convert2to16(binNumber: String): String = {

    def convertNumberTo16(number: Int): String = {
      if (number < 10) number.toString
      else number match {
        case 10 => "A"
        case 11 => "B"
        case 12 => "C"
        case 13 => "D"
        case 14 => "E"
        case 15 => "F"
        case _  => "?" // на случай неожиданных значений
      }
    }

    def convert2to10(binNumber: String): Option[Int] = {
      val binNumberLen = binNumber.length
      var decimalNumber = 0

      for (i <- 0 until binNumberLen) {
        val char = binNumber.charAt(i)

        // проверяем, что символ 0 или 1
        if (char != '0' && char != '1') {
          return None
        }

        val digit = char.asDigit
        val exponent = binNumberLen - 1 - i
        val powerOfTwo = 1 << exponent

        // проверка на переполнение (аналог subtractingReportingOverflow)
        val temp = decimalNumber + digit * powerOfTwo
        if (temp < 0) return None

        decimalNumber = temp
      }

      Some(decimalNumber)
    }

    // конвертация 2 → 10
    val decimalNumberOpt = convert2to10(binNumber)
    if (decimalNumberOpt.isEmpty) return "nil"

    var decimalNumber = decimalNumberOpt.get
    if (decimalNumber == 0) return "0"

    // конвертация 10 → 16
    var hexNumber = ""
    while (decimalNumber > 0) {
      val remainder = decimalNumber % 16
      hexNumber = convertNumberTo16(remainder) + hexNumber
      decimalNumber /= 16
    }

    hexNumber
  }
}