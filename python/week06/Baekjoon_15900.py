# 22.07.28 minsung
# 백준 15900 - 나무 탈출

import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**5)

n = int(input())
tree = [[] for i in range(n+1)]
visited = [False for i in range(n+1)]
distance = [0 for i in range(n+1)]
answer = 0

for i in range(n-1):
    a,b = map(int, input().split())
    tree[a].append(b)
    tree[b].append(a)

def dfs(x):
    visited[x] = True
    for i in tree[x]:
        if visited[i] == False:
            distance[i] = distance[x] + 1
            dfs(i)

dfs(1)

for i in range(2, n+1):
    if len(tree[i]) == 1:
        answer += distance[i]

if answer%2 == 0:
    print("No")
else:
    print("Yes")

