# 22.07.22 minsung
# 백준 11725 - 트리의 부모 찾기

import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

n = int(input())
tree = [[] for i in range(n+1)]
parents = [-1 for i in range(n+1)]

for i in range(n-1):
    a,b = map(int,input().split())
    tree[a].append(b)
    tree[b].append(a)

def dfs(x):
    for i in tree[x]:
        if parents[i] == -1:
            parents[i] = x
            dfs(i)

dfs(1)
for i in range(2, n+1):
    print(parents[i])