class Node(object):

    # initialize single node with no links
    def __init__(self, record: str):
        self.record = record
        self.next = None

    def next(self):
        return self.next

    def set_next(self, next):
        self.next = next

    def record(self):
        return self.record
