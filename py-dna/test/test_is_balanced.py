import unittest

from exercises.stacks import is_balanced as tester
from test.utils import node as nu


class TestIsBalanced(unittest.TestCase):

    # should be balanced (true)
    def test_balanced(self):
        r = nu.to_linked_list('(())(((())()))')
        self.assertTrue(tester.is_balanced(r))

    # should not be balanced (false)
    def test_not_balanced(self):
        r = nu.to_linked_list("(()")
        self.assertFalse(tester.is_balanced(r))
