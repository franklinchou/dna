class HashTable:

    # Create list of lists
    def __init__(self, size: str):
        self.table = [ [] for _ in range(size) ]

    def hash(x: int):
        return x % 10

    def insert(self, key, record):
        h = hash(key)
        self.table[h].append(record)

    def access(self, key):
        h = hash(key)
        return self.table[key]
