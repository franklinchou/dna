from typing import Dict, Tuple, Optional

class Node(object):

    def __init__(self, priority: int, record: str):
        self.priority = priority
        self.record = record
        self.next = None

    def set_next(self, n: Node):
        self.next = n

class Stack(object):

    def __init__(self):
        self.size = 0
        self.head = None

    def is_empty(self) -> int:
        return self.size

    def push(self, priority: int, record: str):
        n = Node(priority, record)
        if self.head is None:
            self.head = n
        else:
            ptr = self.head
            self.head = n
            self.head.next = ptr
        self.size += 1

    def pull(self) -> Optional[Tuple[int, str]]:
        if self.size == 0:
            return None
        r = (self.head.priority, self.head.record)
        n = self.head.next
        self.head = n
        self.size -= 1

class Heap(object):

    def __init__(self, d: Dict[int, str]):
        self.size = 0
        self.stack = Stack()
        for k in d:
            stack.push(k, d[k])
        self._heapify()

    def size(self) -> int:
        return self.size

    def is_empty(self) -> bool:
        return self.size == 0

    def peek(self):
        pass

    def pull(self):
        pass

    def insert(self, priority: int, record: str):
        self.stack.push(priority, record)
        self._heapify()
        pass

    def _heapify(self):
        # while !stack.is_empty:
        if self.stack.is_empty:
            return
        pass
