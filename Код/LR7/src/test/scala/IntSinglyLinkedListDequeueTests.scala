import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class IntSinglyLinkedListDequeueTests extends AnyFunSuite with Matchers {

  private var intDequeue: SinglyLinkedListDequeue[Int] = _

  def beforeEach(): Unit = {
    intDequeue = new SinglyLinkedListDequeue[Int]()
  }

  def afterEach(): Unit = {
    intDequeue = null
  }

  test("Дек должен быть пустым при инициализации") {
    beforeEach()
    intDequeue.isEmpty() shouldBe true
    intDequeue.count() shouldBe 0
    afterEach()
  }

  test("pushFront и getFront") {
    beforeEach()
    intDequeue.pushFront(10)
    intDequeue.isEmpty() shouldBe false
    intDequeue.count() shouldBe 1
    intDequeue.getFront() shouldBe Some(10)
    intDequeue.getBack() shouldBe Some(10)
    afterEach()
  }

  test("pushBack и getBack") {
    beforeEach()
    intDequeue.pushBack(20)
    intDequeue.isEmpty() shouldBe false
    intDequeue.count() shouldBe 1
    intDequeue.getBack() shouldBe Some(20)
    intDequeue.getFront() shouldBe Some(20)
    afterEach()
  }

  test("pushFront и pushBack комбинация") {
    beforeEach()
    intDequeue.pushFront(5)
    intDequeue.pushBack(15)
    intDequeue.getFront() shouldBe Some(5)
    intDequeue.getBack() shouldBe Some(15)
    intDequeue.count() shouldBe 2
    afterEach()
  }

  test("popFront работает корректно") {
    beforeEach()
    intDequeue.pushBack(10)
    intDequeue.pushBack(20)

    intDequeue.popFront() shouldBe Some(10)
    intDequeue.count() shouldBe 1
    intDequeue.getFront() shouldBe Some(20)
    intDequeue.getBack() shouldBe Some(20)
    intDequeue.isEmpty() shouldBe false

    intDequeue.popFront() shouldBe Some(20)
    intDequeue.isEmpty() shouldBe true
    intDequeue.count() shouldBe 0
    intDequeue.getFront() shouldBe None
    intDequeue.getBack() shouldBe None

    intDequeue.popFront() shouldBe None
    afterEach()
  }

  test("popBack работает корректно") {
    beforeEach()
    intDequeue.pushBack(30)
    intDequeue.pushBack(40)

    intDequeue.popBack() shouldBe Some(40)
    intDequeue.count() shouldBe 1
    intDequeue.getBack() shouldBe Some(30)
    intDequeue.getFront() shouldBe Some(30)

    intDequeue.popBack() shouldBe Some(30)
    intDequeue.isEmpty() shouldBe true
    intDequeue.count() shouldBe 0
    intDequeue.getFront() shouldBe None
    intDequeue.getBack() shouldBe None

    intDequeue.popBack() shouldBe None
    afterEach()
  }

  test("clear очищает дек") {
    beforeEach()
    intDequeue.pushBack(1)
    intDequeue.pushFront(2)
    intDequeue.pushBack(3)

    intDequeue.clear()
    intDequeue.isEmpty() shouldBe true
    intDequeue.count() shouldBe 0
    intDequeue.getFront() shouldBe None
    intDequeue.getBack() shouldBe None
    afterEach()
  }

  test("pushFront/popBack комбинации") {
    beforeEach()
    intDequeue.pushFront(1)
    intDequeue.pushBack(2)
    intDequeue.pushFront(0)
    intDequeue.count() shouldBe 3
    intDequeue.getFront() shouldBe Some(0)
    intDequeue.getBack() shouldBe Some(2)

    intDequeue.popBack() shouldBe Some(2)
    intDequeue.popBack() shouldBe Some(1)
    intDequeue.popBack() shouldBe Some(0)
    intDequeue.isEmpty() shouldBe true
    afterEach()
  }

  test("pushBack/popFront комбинации") {
    beforeEach()
    intDequeue.pushBack(1)
    intDequeue.pushFront(2)
    intDequeue.pushBack(3)
    intDequeue.popFront() shouldBe Some(2)
    intDequeue.popFront() shouldBe Some(1)
    intDequeue.popFront() shouldBe Some(3)
    intDequeue.isEmpty() shouldBe true
    afterEach()
  }

  test("Много операций push/pop") {
    beforeEach()
    for (i <- 1 to 100) intDequeue.pushBack(i)
    intDequeue.count() shouldBe 100
    intDequeue.getFront() shouldBe Some(1)
    intDequeue.getBack() shouldBe Some(100)

    for (i <- 1 to 50) intDequeue.popFront() shouldBe Some(i)
    intDequeue.count() shouldBe 50
    intDequeue.getFront() shouldBe Some(51)
    intDequeue.getBack() shouldBe Some(100)

    for (i <- 101 to 150) intDequeue.pushFront(i)
    intDequeue.count() shouldBe 100
    intDequeue.getFront() shouldBe Some(150)
    intDequeue.getBack() shouldBe Some(100)

    intDequeue.clear()
    intDequeue.isEmpty() shouldBe true
    afterEach()
  }
}
