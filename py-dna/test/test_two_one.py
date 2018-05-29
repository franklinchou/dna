import unittest

from ds.node import Node
from exercises.linked_lists import two_one as tester


def to_linked_list(s: str) -> Node:
    head = Node(s[0])
    tail = s[1:]
    p = head
    for c in tail:
        current = Node(c)
        p.next = current
        p = current
    return head

def to_str(h: Node) -> str:
    acc = []
    while (h != None):
        acc.append(h.record)
        h = h.next
    return ''.join(acc)

class TestTwoOne(unittest.TestCase):


    def test_remove(self):
        r = to_linked_list("FOLLOWUP")
        actual = to_str(tester.remove(r))
        self.assertTrue(actual == "FOLWUP")

    def test_bufferless_remove(self):
        r = to_linked_list("FOLLOWUP")
        actual = to_str(tester.bufferless_remove(r))
        self.assertTrue(actual == "FOLWUP")
