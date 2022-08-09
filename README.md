# Algorithm Study

> 참여자 : Royce, Minsung

## 스터디 규칙
- 주 단위로 진행되며, 매주 화요일에 PR과 스터디를 진행
- PR시 스터디 주차간 해결했던 문제와 풀이(링크) 첨부
- 최소 1문제에 대한 풀이는 존재해야함

## 스터디 진행 방식
1. 해당 레포지토리를 Clone하기
2. 주차와 이름으로 새로운 브랜치 생성 `Ex) royce/week01`
3. `src.Royce.{$week}` 내에 해결할 문제 번호로 `Class` 생성

   > #### Java
   >
   > 1. `naming` : 문제 출처 사이트 _ 문제 번호(이름) (Ex. `Boj_1010`, `Programmers_NumberInversion`)
   >
   > 2. Main 메소드로 추가하고 작성자와 날짜를 표기
   >
   >    ```java
   >    //2022.06.28 Royce
   >    //백준 1010번 - 다리 놓기
   >    public class Boj_1010 {
   >    	public static void main(String[] args) {
   >    		   
   >    	}
   >    }
   >    ```

   > #### Python
   >
   > 1. `naming` 및 작성자와 날짜 표기 동일
   >
   > ```python
   > # 22.06.28 minsung
   > # 백준 10773번 - 제로
   > 
   > import sys
   > 
   > input = sys.stdin.readline
   > 
   > k = int(input())
   > arr = []
   > 
   > for i in range(k):
   >     a = int(input())
   >     if a == 0:
   >         arr.pop()
   >     else:
   >         arr.append(a)
   > 
   > print(sum(arr))
   > ```

3. 문제 해결 하기
4. 한 문제 이상 가능하며, 주차별 최소 한 문제에 대한 풀이 작성
5. 화면 공유하며 코드와 함께 문제 및 풀이 설명
   1. 설명을 위해 주석을 추가하거나, 타 의견을 받아 코드 수정 가능
6. 최종 본 Pull Request
    1. PR시 문제 출처 첨부 (풀이가 있는 경우 링크 첨부)
    2. 상호 코드 리뷰에 대해 기록

## 스터디 진행

- 1주차 PR

  [Royce](https://github.com/TaeyeonRoyce/AlgoStudy/pull/2), [Minsung](https://github.com/TaeyeonRoyce/AlgoStudy/pull/3)

  주 내용 : 진행 방식 공유 및 OT


- 2주차 PR
  
   [Royce](https://github.com/TaeyeonRoyce/AlgoStudy/pull/5), [Minsung](https://github.com/TaeyeonRoyce/AlgoStudy/pull/4)


- 3주차 PR 

   [Royce](https://github.com/TaeyeonRoyce/AlgoStudy/pull/6), [Minsung](https://github.com/TaeyeonRoyce/AlgoStudy/pull/7)


- 4주차 PR

   [Royce](https://github.com/TaeyeonRoyce/AlgoStudy/pull/8), [Minsung](https://github.com/TaeyeonRoyce/AlgoStudy/pull/9)

- 5주차 PR

  [Royce](https://github.com/TaeyeonRoyce/AlgoStudy/pull/10), [Minsung](https://github.com/TaeyeonRoyce/AlgoStudy/pull/11)

- 4주차 PR

  [Royce](https://github.com/TaeyeonRoyce/AlgoStudy/pull/13), [Minsung](https://github.com/TaeyeonRoyce/AlgoStudy/pull/12)


