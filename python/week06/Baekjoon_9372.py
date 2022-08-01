# 22.08.01 minsung
# 백준 9372 - 상근이의 여행

from collections import deque
import sys
input = sys.stdin.readline

t = int(input())

def getGraph(n,m):
    graph = [[] for i in range(n+1)]
    for j in range(m):
        a,b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)
    return graph

def bfs(x, graph):
    cnt = 0
    length = len(graph)
    visited = [False for i in range(length + 1)]

    d = deque()
    d.append(x)

    visited[x] = True

    while d:
        x = d.popleft()
        for i in graph[x]:
            if visited[i] == False:
                d.append(i)
                cnt += 1
                visited[i] = True
    return cnt

for i in range(t):
    n,m = map(int,input().split())
    graph = getGraph(n,m)
    print(bfs(1, graph))