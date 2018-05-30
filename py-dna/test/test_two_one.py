import unittest

from ds.node import Node
from exercises.linked_lists import two_one as tester
from test.utils import node as nu

class TestTwoOne(unittest.TestCase):

    def test_remove(self):
        r = nu.to_linked_list("FOLLOWUP")
        actual = nu.to_str(tester.remove(r))
        self.assertTrue(actual == "FOLWUP")

    def test_bufferless_remove(self):
        r = nu.to_linked_list("FOLLOWUP")
        actual = nu.to_str(tester.bufferless_remove(r))
        self.assertTrue(actual == "FOLWUP")
