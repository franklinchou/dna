from ds.stack import Stack

def dec_to_bin(input: int) -> str:
    if input == 0:
        return "0"
    else:
        return __divide_by_two(input)

def __divide_by_two(input: int) -> str:
    s = Stack()
    while (input > 0):
        rem = input % 2
        s.push(rem)
        input = input // 2 # floor division

    # compose string
    acc = ""
    while (not s.isEmpty()):
        acc = acc + str(s.pop())
    
    return acc
