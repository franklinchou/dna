import unittest

from exercises.linked_lists import two_2 as tester
from exercises.linked_lists import two_2_recurse as recurse
from test.utils import node as nu


class TestTwoTwo(unittest.TestCase):
    def setUp(self):
        self.test_string = 'algorithms'

    def test_find_from_head(self):
        r = nu.to_linked_list(self.test_string)
        for k, v in enumerate(self.test_string):
            actual = tester.find_from_head(r, k)
            expected = v
            self.assertTrue(actual == expected)

    def test_find_from_last(self):
        reverse = self.test_string[::-1]
        r = nu.to_linked_list(self.test_string)
        for k, v in enumerate(reverse):
            actual = tester.find_from_last(r, k)
            expected = v
            self.assertTrue(actual == expected)

    def test_recurse_2(self):
        r = nu.to_linked_list(self.test_string)
        self.assertTrue(recurse.remove(r, 2) == 'm')

    def test_recurse_3(self):
        r = nu.to_linked_list(self.test_string)
        self.assertTrue(recurse.remove(r, 3) == 'h')
