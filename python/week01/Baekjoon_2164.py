# 22.06.28 minsung
# 백준 2164번 - 카드2

from collections import deque
import sys

deq = deque()
input = sys.stdin.readline

n = int(input())

for i in range(n):
    deq.append(i+1)

while len(deq) != 1:
    deq.popleft()
    deq.append(deq.popleft())

print(deq[0])