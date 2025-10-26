// Узел односвязного списка
class Node[T](var value: T, var next: Option[Node[T]] = None)

trait Dequeue[T] {
  def pushFront(value: T): Unit
  def pushBack(value: T): Unit
  def popFront(): Option[T]
  def popBack(): Option[T]
  def getFront(): Option[T]
  def getBack(): Option[T]
  def isEmpty(): Boolean
  def count(): Int
  def clear(): Unit
}

// Реализация на односвязном списке
class SinglyLinkedListDequeue[T] extends Dequeue[T] {
  private var head: Option[Node[T]] = None
  private var tail: Option[Node[T]] = None
  private var currentCount: Int = 0

  override def pushFront(value: T): Unit = {
    val newNode = new Node[T](value, head)
    head = Some(newNode)
    if (tail.isEmpty) {
      tail = Some(newNode)
    }
    currentCount += 1
  }

  override def pushBack(value: T): Unit = {
    val newNode = new Node[T](value, None)
    tail match {
      case Some(currentTail) => currentTail.next = Some(newNode)
      case None => head = Some(newNode)
    }
    tail = Some(newNode)
    currentCount += 1
  }

  override def popFront(): Option[T] = {
    head match {
      case Some(oldHead) =>
        head = oldHead.next
        if (head.isEmpty) tail = None
        currentCount -= 1
        Some(oldHead.value)
      case None => None
    }
  }

  override def popBack(): Option[T] = {
    head match {
      case None => None
      case Some(single) if single.next.isEmpty =>
        head = None
        tail = None
        currentCount -= 1
        Some(single.value)
      case Some(_) =>
        var currentNode = head.get
        var previousNode: Option[Node[T]] = None
        while (currentNode.next.nonEmpty) {
          previousNode = Some(currentNode)
          currentNode = currentNode.next.get
        }
        previousNode.foreach(_.next = None)
        tail = previousNode
        currentCount -= 1
        Some(currentNode.value)
    }
  }

  override def getFront(): Option[T] = head.map(_.value)

  override def getBack(): Option[T] = tail.map(_.value)

  override def isEmpty(): Boolean = head.isEmpty

  override def count(): Int = currentCount

  override def clear(): Unit = {
    head = None
    tail = None
    currentCount = 0
  }
}
