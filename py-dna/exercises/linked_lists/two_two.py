from ds.node import Node


def size(head: Node) -> int:
    n = head
    count = 1
    while (n != None):
        if(n.next != None):
            count = count + 1
        n = n.next
    return count

# trivial case of finding from head
def find_from_head(head: Node, index: int) -> str:
    n = head
    count = 0
    while (n != None):
        if (count == index):
            return n.record
        count = count + 1
        n = n.next


# find the kth element from the end
# the 0 to last element = last
# the 1st to last element = last - 1
def find_from_last(head: Node, index: int) -> str:
    # two while loops gives this algorithm O(2n) time complexity
    last = size(head)
    p = head
    count = 0
    sought = last - (index + 1)
    while (p != None):
        if (count == sought):
            return p.record
        count = count + 1
        p = p.next

