# 22.07.01 minsung
# 백준 11663번 - 선분 위의 점

import sys

input = sys.stdin.readline

n,m = map(int, input().split())
point = list(map(int, input().split()))
point.sort()

def find_min(findNum):
    left = 0
    right = n-1

    while left <= right:
        mid = (left + right) // 2
        if point[mid] < findNum:
            left = mid + 1
        else:
            right = mid - 1
    return left

def find_max(findNum):
    left = 0
    right = n-1

    while left <= right:
        mid = (left + right) // 2
        if point[mid] > findNum:
            right = mid -1
        else:
            left = mid + 1
    return right

for i in range(m):
    lineL, lineR = map(int, input().split())
    print(find_max(lineR) - find_min(lineL) + 1)

# def findPointNum(findNum):
#     left = 0
#     right = n - 1
    
#     while left <= right:
#         mid = (left + right) // 2
#         if point[mid] < findNum:
#             left = mid + 1
#         else:
#             right = mid - 1
#     return right

# for i in range(m):
#     lineL, lineR = map(int, input().split())
#     print(findPointNum(lineR) - findPointNum(lineL)+1)