import unittest

from ds.priority_queue import PriorityQueue
from ds.heap import Stack

class TestPriorityQueue(unittest.TestCase):

    def test_stack(self):
        s = Stack()
        all_items = [ \
            (1, 'linda'), \
            (2, 'bob'), \
            (3, 'louis'), \
            (6, 'gene'), \
            (9, 'tina') \
        ]

        for k, v in all_items:
            s.push(k, v)

        self.assertEqual(s.is_empty(), False)

        i = len(all_items) - 1
        while not self.is_empty():
            p = s.pull()
            self.assertEqual(all_items[i][0], p[0])
            self.assertEqual(all_items[i][1], p[1])
            i -= 1
        self.assertEqual(s.is_empty(), True)

    def test_prirority_queue(self):
        input = dict()
        for i in range(100):
            input[i] = ''
        pq = PriorityQueue(input)
        self.assertEqual(pq, PriorityQueue({}))

