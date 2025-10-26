import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class StringSinglyLinkedListDequeueTests extends AnyFunSuite with Matchers {

  private var stringDequeue: SinglyLinkedListDequeue[String] = _

  def beforeEach(): Unit = {
    stringDequeue = new SinglyLinkedListDequeue[String]()
  }

  def afterEach(): Unit = {
    stringDequeue = null
  }

  test("Инициализация пустого дека строк") {
    beforeEach()
    stringDequeue.isEmpty() shouldBe true
    stringDequeue.count() shouldBe 0
    afterEach()
  }

  test("pushFront и getFront для строк") {
    beforeEach()
    stringDequeue.pushFront("hello")
    stringDequeue.isEmpty() shouldBe false
    stringDequeue.count() shouldBe 1
    stringDequeue.getFront() shouldBe Some("hello")
    stringDequeue.getBack() shouldBe Some("hello")
    afterEach()
  }

  test("pushBack и getBack для строк") {
    beforeEach()
    stringDequeue.pushBack("world")
    stringDequeue.getBack() shouldBe Some("world")
    stringDequeue.getFront() shouldBe Some("world")
    afterEach()
  }

  test("pushFront и pushBack строковые комбинации") {
    beforeEach()
    stringDequeue.pushFront("a")
    stringDequeue.pushBack("b")
    stringDequeue.getFront() shouldBe Some("a")
    stringDequeue.getBack() shouldBe Some("b")
    stringDequeue.count() shouldBe 2
    afterEach()
  }

  test("popFront для строк") {
    beforeEach()
    stringDequeue.pushBack("first")
    stringDequeue.pushBack("second")
    stringDequeue.popFront() shouldBe Some("first")
    stringDequeue.popFront() shouldBe Some("second")
    stringDequeue.isEmpty() shouldBe true
    stringDequeue.popFront() shouldBe None
    afterEach()
  }

  test("popBack для строк") {
    beforeEach()
    stringDequeue.pushBack("third")
    stringDequeue.pushBack("fourth")
    stringDequeue.popBack() shouldBe Some("fourth")
    stringDequeue.popBack() shouldBe Some("third")
    stringDequeue.isEmpty() shouldBe true
    stringDequeue.popBack() shouldBe None
    afterEach()
  }

  test("clear очищает строковый дек") {
    beforeEach()
    stringDequeue.pushBack("x")
    stringDequeue.pushFront("y")
    stringDequeue.pushBack("z")
    stringDequeue.clear()
    stringDequeue.isEmpty() shouldBe true
    stringDequeue.count() shouldBe 0
    stringDequeue.getFront() shouldBe None
    stringDequeue.getBack() shouldBe None
    afterEach()
  }

  test("pushFront/popBack строковые комбинации") {
    beforeEach()
    stringDequeue.pushFront("one")
    stringDequeue.pushBack("two")
    stringDequeue.pushFront("zero")
    stringDequeue.getFront() shouldBe Some("zero")
    stringDequeue.getBack() shouldBe Some("two")

    stringDequeue.popBack() shouldBe Some("two")
    stringDequeue.getBack() shouldBe Some("one")
    stringDequeue.getFront() shouldBe Some("zero")
    afterEach()
  }

  test("Большое количество операций со строками") {
    beforeEach()
    for (i <- 1 to 50) stringDequeue.pushBack(s"Item $i")
    stringDequeue.count() shouldBe 50
    stringDequeue.getFront() shouldBe Some("Item 1")
    stringDequeue.getBack() shouldBe Some("Item 50")

    for (i <- 1 to 25) stringDequeue.popFront() shouldBe Some(s"Item $i")
    stringDequeue.count() shouldBe 25
    stringDequeue.getFront() shouldBe Some("Item 26")

    for (i <- 51 to 75) stringDequeue.pushFront(s"New Item $i")
    stringDequeue.count() shouldBe 50
    stringDequeue.getFront() shouldBe Some("New Item 75")
    stringDequeue.getBack() shouldBe Some("Item 50")

    stringDequeue.clear()
    stringDequeue.isEmpty() shouldBe true
    afterEach()
  }
}