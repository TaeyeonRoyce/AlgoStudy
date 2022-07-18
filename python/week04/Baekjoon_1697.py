# 22.07.18 minsung
# 백준 1697 - 숨바꼭질

from collections import deque

n,k = map(int, input().split())
check = [0 for i in range(100001)]

def bfs():
    d = deque()
    d.append(n)

    while d:
        x = d.popleft()
        if x == k:
            return check[x]
        for i in (x-1, x+1, 2*x):
            if 0 <= i <= 100000 and not check[i]:
                check[i] = check[x] + 1
                d.append(i)

print(bfs())




