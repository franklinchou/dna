from ds.node import Node

# remove a node from the middle of a list given only the pointer to that node
def remove(head: Node, to_remove: Node) -> Node:
    temp: Node = to_remove.next
    to_remove.record = temp.record
    to_remove.set_next(temp.next)
    return head
