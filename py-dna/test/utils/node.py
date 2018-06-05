from ds.node import Node

# utilities for operating on "node" based data structures

# convert a string into a linked list of characters (string of size 1)
def to_linked_list(s: str) -> Node:
    head = Node(s[0])
    tail = s[1:]
    p = head
    for c in tail:
        current = Node(c)
        p.next = current
        p = current
    return head

# convert a linked list of char back to a string
def to_str(h: Node) -> str:
    acc = []
    while (h != None):
        acc.append(h.record)
        h = h.next
    return ''.join(acc)

