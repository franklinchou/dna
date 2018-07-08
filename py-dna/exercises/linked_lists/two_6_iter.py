from ds.node import Node


def find_cycle(n: Node) -> Node:
    slow = n
    fast = n
    while fast is not None and fast.next is not None:
        slow = slow.next
        fast = fast.next.next
        if fast == slow:
            # A collision has occurred
            break

    # If there is no collision, there is no cycle
    if fast.next is None:
        return None

    # Send slow back to head
    slow = n
    while slow != fast:
        slow = slow.next
        fast = fast.next

    return slow
