# 22.07.18 minsung
# 백준 2178 - 미로탐색

from collections import deque


n,m = map(int,input().split())

graph = []

for i in range(n):
    graph.append(list(map(int,input())))

def bfs(x,y):
    dx = [-1,1,0,0]
    dy = [0,0,-1,1]

    dq = deque()
    dq.append((x,y))

    while dq:
        x,y = dq.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue

            if graph[nx][ny] == 0:
                continue
            
            if graph[nx][ny] == 1:
                graph[nx][ny] = graph[x][y] + 1
                dq.append((nx,ny))

    return graph[n-1][m-1]

print(bfs(0,0))

