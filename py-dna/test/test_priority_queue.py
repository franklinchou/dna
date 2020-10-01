import unittest
import random

from ds.priority_queue import PriorityQueue
from ds.heap import Stack

class TestPriorityQueue(unittest.TestCase):

    def test_prirority_queue(self):
        test_set = [random.randint(0, 50) for i in range(100)]
        test_set = {k : '' for k in test_set}
        pq = PriorityQueue(test_set)

        # ensure items pulled from the priority queue are monotonically
        # decreasing
        last = 0
        while not pq.is_empty():
            i = pq.pull()
            print(i)
            self.assertTrue(i >= last, 'Encountered priority out of order')
            i = last

    def test_stack(self):
        s = Stack()
        self.assertEqual(s.is_empty(), True)

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
        while not s.is_empty():
            p = s.pull()
            self.assertEqual(all_items[i][0], p[0])
            self.assertEqual(all_items[i][1], p[1])
            i -= 1
        self.assertEqual(s.is_empty(), True)

