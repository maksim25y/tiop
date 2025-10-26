import org.scalatest.funsuite.AnyFunSuite

class StringReplacerTests extends AnyFunSuite {

  var replacer: StringReplacer = _

  // Аналог setUp
  def beforeEach(): Unit = {
    replacer = new StringReplacer()
  }

  // Аналог tearDown
  def afterEach(): Unit = {
    replacer = null
  }

  // MARK: - Граничные случаи и обработка ошибок

  test("replace — with empty search string") {
    beforeEach()
    val original = "Hello"
    val search = ""
    val replacement = "World"
    val result = replacer.replace(original, search, replacement)
    assert(result == original, "Должно возвращать оригинальную строку, если строка поиска пуста")
    afterEach()
  }

  test("replace — empty original string") {
    beforeEach()
    val original = ""
    val search = "abc"
    val replacement = "xyz"
    val result = replacer.replace(original, search, replacement)
    assert(result == "", "Должно возвращать пустую строку, если исходная строка пуста")
    afterEach()
  }

  // MARK: - Основные пути выполнения (покрытие веток)

  test("replace — no match") {
    beforeEach()
    val original = "abcdef"
    val search = "xyz"
    val replacement = "123"
    val result = replacer.replace(original, search, replacement)
    assert(result == original, "Должно возвращать оригинальную строку, если совпадений нет")
    afterEach()
  }

  test("replace — single match at beginning") {
    beforeEach()
    val original = "abcde"
    val search = "ab"
    val replacement = "XX"
    val result = replacer.replace(original, search, replacement)
    assert(result == "XXcde", "Должно заменить подстроку в начале")
    afterEach()
  }

  test("replace — single match in middle") {
    beforeEach()
    val original = "axbyc"
    val search = "xb"
    val replacement = "YY"
    val result = replacer.replace(original, search, replacement)
    assert(result == "aYYyc", "Должно заменить подстроку в середине")
    afterEach()
  }

  test("replace — single match at end") {
    beforeEach()
    val original = "abcd"
    val search = "cd"
    val replacement = "XY"
    val result = replacer.replace(original, search, replacement)
    assert(result == "abXY", "Должно заменить подстроку в конце")
    afterEach()
  }

  test("replace — multiple non-overlapping matches") {
    beforeEach()
    val original = "banana"
    val search = "an"
    val replacement = "!!"
    val result = replacer.replace(original, search, replacement)
    assert(result == "b!!!!a", "Должно заменить все непересекающиеся вхождения")
    afterEach()
  }

  test("replace — with empty replacement string (deletion)") {
    beforeEach()
    val original = "applepineapple"
    val search = "apple"
    val replacement = ""
    val result = replacer.replace(original, search, replacement)
    assert(result == "pine", "Должно удалять подстроку")
    afterEach()
  }
}
