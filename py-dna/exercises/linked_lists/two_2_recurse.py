# https://gist.github.com/franklinchou/e33d51849195cbc2929752eac495c202

# Find the kth to last element of a singly linked list
from ds.node import Node


class State(object):
    n = 0
    found = ''

    def __init__(self, n=0, found=''):
        self.n = n
        self.found = found


def remove(head: Node, sought: int) -> str:

    s = State()

    def recurse_to_end(n: Node, count: int = 0):
        if n is None:
            s.n = count
            return s
        recurse_to_end(n.next, count + 1)

        if s.n - sought == count:
            s.found = n.record

    recurse_to_end(head)

    return s.found
