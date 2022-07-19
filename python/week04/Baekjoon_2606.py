# 22.07.18 minsung
# 백준 2606 - 바이러스

n = int(input())
m = int(input())
edge = [[] for i in range(n+1)]
check = [True for i in range(n+1)]

for i in range(m):
    a,b = map(int, input().split())
    edge[a].append(b)
    edge[b].append(a)

for i in range(1,n+1):
    edge[i].sort()

def dfs(n):
    cnt = 0
    check[n] = False
    
    for i in edge[n]:
        if check[i] == True:
            cnt += 1
            cnt += dfs(i)
    return cnt

print(dfs(1))