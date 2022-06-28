## Baekjoon_10773 - 제로

https://www.acmicpc.net/problem/10773

#### 해결 방법

- 스택에 k 개의 정수를 순서대로 입력받는다.
  - 그 때의 정수가 0일때는 `stack.pop()`
  - 0이 아닐때는 `stack.append()` 

> 파이썬에는 스택이 따로 구현되어있지 않아 `list`를 사용한다.