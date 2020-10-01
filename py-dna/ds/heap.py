from __future__ import annotations
from typing import Dict, Optional, Tuple, Type

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

    def is_empty(self) -> bool:
        return self.size == 0

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
        return r

class Heap(object):

    def __init__(self, d: Dict[int, str]):
        self._list = [(k, v) for k, v in d.items()]
        self.size = len(self._list)
        self._heapify()

    def size(self) -> int:
        return self.size

    def is_empty(self) -> bool:
        return self.size == 0

    def peek(self):
        return self._list[0]

    def pull(self) -> Optional[Tuple[int, str]]:
        if self.size == 0:
            return None
        result = self._list[0]
        self._list = self._list[1:]
        self._heapify()
        self.size -= 1
        return result

    def insert(self, priority: int, record: str):
        self._list.append((priority, record))
        self._heapify()
        self.size += 1

    def _heapify(self):
        half = int(len(self._list) / 2)
        for head_index in range(half):
            left_index = 2 * head_index + 1
            right_index = 2 * head_index + 2

            left_index_in_bound = left_index <= len(self._list) - 1
            right_index_in_bound = right_index <= len(self._list) - 1

            head = self._list[head_index]
            head_priority = head[0]

            if left_index_in_bound:
                left = self._list[left_index]
                left_priority = left[0]
                if left_priority >= head_priority:
                    self._list[left_index] = head
                    self._list[head_index] = left

            if right_index_in_bound:
                right = self._list[right_index]
                right_priority = right[0]
                if right_priority >= head_priority:
                    self._list[right_index] = head
                    self._list[head_index] = right
