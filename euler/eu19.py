# How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?


# A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
def is_leap(yr) -> bool:
    if yr % 4 == 0 or (yr % 100 == 0 and yr % 400 == 0):
        return True
    return False


# 1 Jan 1900 = Monday
month = 1
day = 1
year = 1900

sundays = 0

short_months = {9, 4, 6, 11}
long_months = {1, 3, 5, 7, 8, 10, 12}


if __name__ == "__main__":
    while year != 2000:

        leap = is_leap(year)
        end = 366 if leap else 365
        iday = 0

        if month > 12:
            month = 1

        if month in long_months:
            month_end = 31
        elif month in short_months:
            month_end = 30
        else:
            month_end = 29 if is_leap else 28

        while iday != month_end:
            if iday == 1 and day % 7 == 0:
                sundays += 1
            iday += 1
            day += 1

        month += 1

        if month == 12:
            year += 1

    print(sundays) # 171