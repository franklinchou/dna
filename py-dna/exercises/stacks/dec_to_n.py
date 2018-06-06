from ds.stack import Stack

def __units(base: int) -> str:
    digits = "0123456789ABCDEF"
    base_index = base - 1
    return digits[0:base_index]

# Accept an integer as input and a "base" from 2 to 16
def dec_to_n(input: int, base: int): #-> str:
    s = Stack()
    if (base < 2 or base > 16):
        print("Error: Invalid base.")
        return
    else:
        units = __units(base)
        while(input > 0):
            rem = input % base
            transform_rem = rem
            if base > 10 :
                transform_rem = units[rem]
            s.push(transform_rem)
            input = input // base
    
    # compose string
    acc = []
    while (not s.isEmpty()):
        acc.append(s.pop())

    return ''.join(str(i) for i in acc)
