# 22.07.18 minsung
# 백준 1260 - DFS와 BFS

from collections import deque


n, m, v = map(int, input().split())

edge = [ [] for i in range(n+1)]
check = [True] * (n+1)

for i in range(m):
    a,b = map(int,input().split())
    edge[a].append(b)
    edge[b].append(a)

for i in range(1, n+1):
    edge[i].sort()



def dfs(v):
    check[v] = False

    print(v, end= ' ')

    for i in edge[v]:
        if check[i] == True:
            dfs(i)

def bfs(v):
    d = deque()
    d.append(v)
    
    check[v] = True

    while d:
        v = d.popleft()
        print(v, end=' ')
        for i in edge[v]:
            if check[i] == False:
                d.append(i)
                check[i] = True

dfs(v)
print()
bfs(v)