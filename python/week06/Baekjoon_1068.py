# 22.08.01 minsung
# 백준 1068 - 트리

import sys
input = sys.stdin.readline

def dfs(delNode, parents):
    parents[delNode] = -2
    for i in range(len(parents)):
        if delNode == parents[i]:
            dfs(i, parents)

n = int(input())
parents = list(map(int, input().split()))
delNode = int(input())
cnt = 0

dfs(delNode, parents)
for i in range(len(parents)):
    if parents[i] != -2 and i not in parents:
        cnt += 1

print(cnt)