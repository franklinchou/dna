import unittest

from exercises.linked_lists import two_1 as tester
from test.utils import node as nu


class TestTwoOne(unittest.TestCase):

    def test_remove_duplicates(self):
        r = nu.to_linked_list("FOLLOWUP")
        actual = nu.to_str(tester.remove_duplicates(r))
        self.assertTrue(actual == "FOLWUP")

    def test_bufferless_remove(self):
        r = nu.to_linked_list("FOLLOWUP")
        actual = nu.to_str(tester.remove_duplicates_bufferless(r))
        self.assertTrue(actual == "FOLWUP")
