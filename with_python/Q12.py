from typing import List
import random


def generate_10_numbers_from_0_until_100() -> List[int]:
    for i in range(10):
        x = random.randint(0, 99)
        List.append(x)
    return List


def print_list(numbers: List[int]):
    for x in numbers:
        print(x)
    print('\n')


def sort_in_ascending_order(numbers: List[int]) -> List[int]:
    sorted_list = sorted(numbers)
    return sorted_list


def remove_content_which_number_is_under_50(numbers: List[int]) -> List[int]:
    removed_List = [i for i in numbers if i < 51]
    return removed_List

if __name__ == '__main__':
    List = []

    # Q1.2.1
    print_list(generate_10_numbers_from_0_until_100())

    # Q1.2.2
    print_list(sort_in_ascending_order(List))

    # Q1.2.3
    print_list(remove_content_which_number_is_under_50(List))

