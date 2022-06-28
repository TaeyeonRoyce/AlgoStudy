# 22.06.28 minsung
# 백준 10773번 - 제로

import sys

input = sys.stdin.readline

k = int(input())
arr = []

for i in range(k):
    a = int(input())
    if a == 0:
        arr.pop()
    else:
        arr.append(a)

print(sum(arr))