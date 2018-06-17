from ds.node import Node


def remove(head: Node, to_remove: Node) -> Node:
    """
    Remove a node from the middle of a list given only the pointer to that node

    "Absorb" the next node into the node to be removed. Then simply skip
    the next node.
    """
    temp: Node = to_remove.next
    to_remove.record = temp.record
    to_remove.set_next(temp.next)
    return head
