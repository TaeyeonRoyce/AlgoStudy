# 22.07.22 minsung
# 프로그래머스 - 거리두기 확인하기

from collections import deque


# def getPlace(arr):
#     place = [[] for i in range(5)]
#     for i in range(5):
#         place.append(list(arr[i]))
#     return place

def isSafePlace(x,y,place):
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    visited = [[False for i in range(5)] for j in range(5)]

    dq = deque()
    dq.append((x,y))
    visited[x][y] = True

    while dq:
        a,b = dq.popleft()
        for i in range(4):
            nx = a + dx[i]
            ny = b + dy[i]

            if nx < 0 or nx >= 5 or ny < 0 or ny >= 5:
                continue

            if visited[nx][ny] or place[nx][ny] == 'X':
                continue

            if abs(x-nx) + abs(y-ny) > 2:
                continue

            if place[nx][ny] == 'P':
                return False
            
            visited[nx][ny] = True
            dq.append((nx,ny))

    return True

def checkDistance(place):
    for i in range(5):
        for j in range(5):
            if place[i][j] == 'P':
                if not isSafePlace(i,j,place):
                    return 0
    return 1

def solution(places):
    answer = []
    for i in range(5):
        answer.append(checkDistance(places[i]))
    return answer

