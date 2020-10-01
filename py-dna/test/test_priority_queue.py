import unittest

from ds.priority_queue import PriorityQueue

class TestPriorityQueue(unittest.TestCase):


    def test_prirority_queue(self):
        input = dict()
        for i in range(100):
            input[i] = ''
        pq = PriorityQueue(input)
        self.assertEqual(pq, PriorityQueue({}))

