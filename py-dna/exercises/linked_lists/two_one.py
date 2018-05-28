# Remove duplicates from an unsorted linked list

from ds.node import Node

class Encountered(object):
    def __init__(self):
        self.data = []
    def contains(self, s: str) -> bool:
        for _ in self.data:
            if (s == _):
                return True
        return
    def add(self, s: str):
        self.data.append(s)

def remove(head: Node) -> Node:
    new_head = head
    addition = new_head
    e = Encountered()

    # the first item will never have been encountered
    n = head
    e.add(head.record)
    n = n.next

    # traverse the list
    while (n != None):
        if (e.contains(n.record)):
            pass
        else:
            e.add(n.record)
            addition.set_next(n)
            addition = n
        n = n.next

    return new_head
