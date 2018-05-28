import unittest
from ds.hash_table import HashTable

class TestHashMap(unittest.TestCase):

    def setUp(self):
        test_size = 10
        self.hash_table = HashTable(test_size)

    def test_insert(self):
        self.hash_table.insert(0, 'zebra')

        result = self.hash_table.access(0)
        self.assertTrue(result == ['zebra'])

    def test_multiple_insert(self):
        self.hash_table.insert(0, 'zebra')
        self.hash_table.insert(0, 'dog')
        r = self.hash_table.access(0)
        self.assertTrue(r == ['zebra', 'dog'])
