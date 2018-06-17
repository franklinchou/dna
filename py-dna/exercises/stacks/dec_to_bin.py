from ds.stack import Stack


def dec_to_bin(dec: int) -> str:
    """
    Converts decimal number to binary

    :param dec: decimal input to convert
    :return:
    """
    s = Stack()
    if dec == 0:
        s.push(0)
    else:
        while dec > 0:
            rem = dec % 2
            s.push(rem)
            dec = dec // 2  # floor division

    return __construct(s)


def __construct(s: Stack) -> str:
    # compose string
    acc = ""
    while not s.isEmpty():
        acc = acc + str(s.pop())
    return acc
