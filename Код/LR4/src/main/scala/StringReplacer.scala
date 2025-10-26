// Вариант 13
class StringReplacer {

  def replace(originalString: String, searchString: String, replacementString: String): String = {
    // 1: Проверяем, что строка поиска не пуста
    if (searchString.isEmpty) return originalString // 2

    val result = new StringBuilder                 // 3
    var currentIndex = 0                           // 4

    // 5: Пока не дошли до конца строки
    while (currentIndex < originalString.length) {

      val remainingLength = originalString.length - currentIndex // 9
      var matchFound = false                                     // 6

      if (remainingLength >= searchString.length) {              // 10
        // 12: Посимвольное сравнение без break
        var tempSearchIndex = 0
        var allMatch = true
        while (tempSearchIndex < searchString.length && allMatch) {
          if (originalString.charAt(currentIndex + tempSearchIndex) != searchString.charAt(tempSearchIndex)) {
            allMatch = false
          }
          tempSearchIndex += 1
        }
        matchFound = allMatch
      }

      if (matchFound) {                            // 18
        result.append(replacementString)           // 19
        currentIndex += searchString.length        // 20
      } else {
        result.append(originalString.charAt(currentIndex)) // 21
        currentIndex += 1                          // 22
      }
    }

    result.toString                                // 23
  }
}