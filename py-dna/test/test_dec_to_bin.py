import unittest

from ds.stack import Stack
from exercises.stacks import dec_to_bin as tester

class TestDecToBin(unittest.TestCase):
    
    def test_dec_to_bin1(self):
        input = 233
        expected = '11101001'
        self.assertEqual(tester.dec_to_bin(input), expected)

    def test_dec_to_bin2(self):
        input = 9876
        expected = '10011010010100'
        self.assertEqual(tester.dec_to_bin(input), expected)