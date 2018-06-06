# Basic stack implementation


# Don't use the standard data structure node here.
# A stack `head` node can be empty but a linked list
# with an empty `head` node simply does not exist.
class _Node(object):
    def __init__(self):
        self.record = None
        self.next = None


class Stack(object):

    def __init__(self):
        self.head = _Node()
        self.size = 0

    def push(self, item):
        old = self.head
        self.head = _Node()
        self.head.record = item
        self.head.next = old
        self.size += 1

    # Return value of the record sought
    def pop(self):
        item = self.head.record
        self.head = self.head.next
        self.size -= 1
        return item

    def size(self) -> int:
        return self.size

    def peek(self):
        return self.head.record

    def isEmpty(self) -> bool:
        return self.size == 0
