# Given a string (linked list of chars) of parentheses determine whether
# the string is balanced or not.

from ds.node import Node
from ds.stack import Stack

def is_balanced(head: Node) -> bool:
    n = head
    s = Stack()
    balanced = True
    while (n != None and balanced):
        if n.record == "(":
            s.push(n.record)
        else:
            if (s.isEmpty()):
                balanced = False
            else:
                s.pop()
        n = n.next
        

    if balanced and s.isEmpty():
        return True
    else:
        return False