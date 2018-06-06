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

def remove_duplicates(head: Node) -> Node:
    new_head = head
    addition = new_head
    e = Encountered()

    # the first item will never have been encountered
    n = head
    e.add(head.record)
    n = n.next

    # traverse the list
    while (n is not None):
        if (e.contains(n.record)):
            pass
        else:
            e.add(n.record)
            addition.set_next(n)
            addition = n
        n = n.next

    return new_head

# bufferless remove using only pointers
def remove_duplicates_bufferless(head: Node) -> Node:
    # preserve head so that it can be retrieved later on
    new_head = head
    addition = new_head

    n = head
    while (n is not None):
        runner = n
        while (runner.next is not None):
            if (n.record == runner.next.record):
                runner.set_next(runner.next.next)
            else:
                runner = runner.next
        n = n.next
        addition.set_next(n)
        addition = n # advance addition
    return new_head
