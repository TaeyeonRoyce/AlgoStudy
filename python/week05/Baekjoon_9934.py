# 22.07.25 minsung
# 백준 9934 - 완전 이진 트리

import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int,input().split()))

def result(arr):
    result = []
    while arr:
        result.append(arr[0::2])

        for i in arr[0::2]:
            arr.remove(i)
    result.reverse()
    return result

for i in result(arr):
    for j in i:
        print(j, end=' ')
    print()