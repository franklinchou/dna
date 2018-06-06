import unittest

from exercises.linked_lists import two_3 as t
from test.utils import node as nu

class TestTwoThree(unittest.TestCase):

    def test_remove(self):
        r = nu.to_linked_list("pointer")
        remove_i = r.next.next
        actual = nu.to_str(t.remove(r, remove_i))
        expected = "ponter"
        self.assertEqual(expected, actual)
