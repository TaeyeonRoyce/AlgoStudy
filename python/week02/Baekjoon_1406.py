# 22.07.01 minsung
# 백준 1406번 - 에디터

import sys
input = sys.stdin.readline

left = list(input().strip())
right = []

def edit(inputValue, left, right):
    if inputValue == 'L':
        if len(left) != 0:
            right.append(left.pop())
    elif inputValue == 'D':
        if len(right) != 0:
            left.append(right.pop())
    elif inputValue == 'B':
        if len(left) != 0:
            left.pop()
    elif inputValue[0] == 'P':
        left.append(inputValue[2])

m = int(input())

for i in range(m):
    edit(input().strip(), left, right)

print("".join(left + right[::-1]))


