import unittest

from ds.stack import Stack
from exercises.stacks import dec_to_n as tester

class TestDecToN(unittest.TestCase):

    # naive case, for starters test dec conversion
    def test_dec_to_dec(self):
        input = 233
        expected = '233'
        self.assertEqual(tester.dec_to_n(input, 10), expected)

    def test_dec_to_hex1(self):
        input = 965432
        expected = 'EBB38'
        self.assertEqual(tester.dec_to_n(input, 16), expected)

    def test_dec_to_hex2(self):
        input = 3427895234
        expected = 'CC5187C2'
        self.assertEqual(tester.dec_to_n(input, 16), expected)

    def test_dec_to_oct1(self):
        input = 3427895234
        expected = '31424303702'
        self.assertEqual(tester.dec_to_n(input, 8), expected)
    
    def test_dec_to_oct2(self):
        input = 9
        expected = '11'
        self.assertEqual(tester.dec_to_n(input, 8), expected)

    def test_dec_to_13(self):
        input = 13
        expected = '10'
        self.assertEqual(tester.dec_to_n(input, 13), expected)
