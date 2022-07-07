# 22.07.07 minsung
# 백준 2841번 - 외계인의 기타 연주

import sys

input = sys.stdin.readline

n, p = map(int, input().split())

stringNum = [[] for i in range(7)]
result = 0

def findMovementNum(stringNum, a, b):
    cnt = 0
    if  len(stringNum[a]) == 0:
        stringNum[a].append(b)
        cnt += 1
        return cnt
    else:
        if stringNum[a][-1] < b:
            stringNum[a].append(b)
            cnt += 1
            return cnt
        elif stringNum[a][-1] > b:
            stringNum[a].pop()
            cnt += 1
            cnt += findMovementNum(stringNum, a, b)
    return cnt

for i in range(n):
    a, b = map(int, input().split())
    result += findMovementNum(stringNum, a, b)

print(result)