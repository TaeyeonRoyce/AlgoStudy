# 22.07.09 minsung
# 백준 1874번 - 스택 수열

import sys

input = sys.stdin.readline

stack = []
intArr = []
result = []

n = int(input())
for i in range(n):
    intArr.append(int(input()))

intArr.reverse()

for i in range(1,n+1):
    stack.append(i)
    result.append('+')
    
    while intArr and stack and intArr[-1] == stack[-1]:
        result.append('-')
        intArr.pop()
        stack.pop()
    
    if intArr and stack and intArr[-1] < stack[-1]:
        print('NO')
        break
else:
    print('\n'.join(result))
