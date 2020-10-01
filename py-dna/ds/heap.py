from typing import Dict, Tuple, Optional

class Node(object):
    def __init__(self, priority: int, record: str):
        self.priority = priority
        self.record = record

class Stack(object):
    def __init__(self):
        self.size = 0

    def is_empty(self) -> int:
        return self.size

    def push(self, priority: int, record: str):
        pass

    def pull(self) -> Optional[Tuple[int, str]]:
        if self.size == 0:
            return None
        pass

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
