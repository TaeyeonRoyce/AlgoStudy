# 22.08.01 minsung
# 백준 14426 - 접두사 찾기

import sys
input = sys.stdin.readline

cnt = 0
n,m = map(int, input().split())
set = set()

for i in range(n):
    word = input()
    for j in range(1,len(word)+1):
        set.add(word[0:j])

for i in range(m):
    pre = input().strip()
    if pre in set:
        cnt += 1

print(cnt)