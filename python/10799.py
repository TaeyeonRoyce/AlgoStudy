import sys
input = sys.stdin.readline
n = input().strip()

stack = []
cnt = 0

for i in range(len(n)):
    if n[i] == '(':
        stack.append(i)
    if n[i] == ')':
        if stack[-1] + 1 == i:
            stack.pop()
            cnt += len(stack)
        else:
            stack.pop()
            cnt += 1
print(cnt)

# for i in range(len(n)):
#     if n[i] == '(':
#         stack.append(i)
#     if n[i] == ')':
#         if stack[-1] + 1 == i:
#             stack.pop()
#             cnt += len(stack)
#         else:
#             stack.pop()
#             cnt += 1
#     print(stack, cnt)
