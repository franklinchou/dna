from .heap import Heap
from typing import Dict, Optional, Tuple

class PriorityQueue(object):

    def __init__(self, d: Dict[int, str]):
        self.h = Heap(d)

    def is_empty(self) -> bool:
        return self.h.size == 0

    def insert(self, value, priority):
        self.h.insert(value, priority)

    def pull(self) -> Optional[Tuple[int, str]]:
        self.h.pull()

