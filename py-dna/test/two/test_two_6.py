import unittest

from ds.node import Node

from exercises.linked_lists import two_6_iter as tester


class TestTwoSix(unittest.TestCase):

    def setUp(self):
        self.a = Node('a')
        self.b = Node('b')
        self.c = Node('c')
        self.d = Node('d')
        self.e = Node('e')

    def test_find_cycle(self):
        self.a.set_next(self.b)
        self.b.set_next(self.c)
        self.c.set_next(self.d)
        self.d.set_next(self.e)
        self.e.set_next(self.c)

        head = self.a
        cycle = self.c
        self.assertEqual(tester.find_cycle(head), cycle)

    def test_no_cycle(self):
        self.a.set_next(self.b)
        self.b.set_next(self.c)
        self.c.set_next(self.d)
        self.d.set_next(self.e)
        self.assertEqual(tester.find_cycle(self.a), None)