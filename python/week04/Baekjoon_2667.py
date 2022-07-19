# 22.07.19 minsung
# 백준 2667 - 단지 번호 붙이기

from collections import deque

n = int(input())
graph = []
result = []

for i in range(n):
    graph.append(list(map(int,input())))

def bfs(x,y):
    cnt = 1
    dx = [-1,1,0,0]
    dy = [0,0,-1,1]

    dq = deque()
    dq.append((x,y))
    graph[x][y] = 0

    while dq:
        x,y = dq.popleft()

        for i in range(4):
            
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= n or ny < 0 or ny >= n:
                continue

            if graph[nx][ny] == 0:
                continue

            if graph[nx][ny] == 1:
                dq.append((nx,ny))
                graph[nx][ny] = 0
                cnt += 1
    return cnt

for i in range(n):
    for j in range(n):
        if graph[i][j] == 1:
            result.append(bfs(i,j))

result.sort()

print(len(result))

for i in range(len(result)):
    print(result[i])

        


