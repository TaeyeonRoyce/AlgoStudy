# 22.07.25 minsung
# 프로그래머스 - k진수에서 소수 개수 구하기

import math

def isPrimeNum(n):
    if n<2:
        return False

    for i in range(2, int(math.sqrt(n))+1):
        if n%i == 0:
            return False
    return True

def decimalToKNumber(n,k):
    power = 0
    tmp = ''
    while n:
        tmp = str(n%k) + tmp
        n //= k
    return int(tmp)

def parsedByZero(n):
    a = str(n)
    arr = a.split('0')
    arr = [i for i in arr if i]
    return arr

def solution(n,k):
    kNum = decimalToKNumber(n,k)
    arr = parsedByZero(kNum)
    cnt = 0

    for i in range(len(arr)):
        if isPrimeNum(int(arr[i])):
            cnt += 1
    return cnt

print(solution(110011,10))