from ds.node import Node


def access_next(n: Node):
    if n is None:
        return None
    else:
        return n.next


def recurse(n: Node, visited=list()):
    if n is None:
        print("No cycle found")
        return

    if visited.__contains__(n):
        print('Found cycle at {}'.format(n.record))
        return

    if n is not None:
        visited.append(n)

    recurse(access_next(n), visited)


# Test cycle
print("Testing cycle...")
repeated = Node('c')
e = Node('e')
e.set_next(repeated)
d = Node('d')
d.set_next(e)
repeated.set_next(d)
b = Node('b')
b.set_next(repeated)
a = Node('a')
a.set_next(b)
recurse(a)

# Test no cycle
print("Testing no cycle...")
c = Node('c')
b = Node('b')
b.set_next(c)
a = Node('a')
a.set_next(b)
recurse(a)
