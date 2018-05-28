import unittest
from ds.node import Node

class TestNodes(unittest.TestCase):

    def test_node(self):
        # can be instantiated
        head = Node('head')
        self.assertTrue(head.next == None)
        self.assertTrue(head.record == 'head')

        # can set pointer to next
        next = Node('next')
        head.set_next(next)
        self.assertTrue(head.next == next)

    def test_linked_list(self):
        first = Node('first')
        second = Node('second')
        third = Node('third')

        first.next = second
        second.next = third

        self.assertTrue(first.next == second)
        self.assertTrue(second.next == third)


