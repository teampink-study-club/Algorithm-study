# 스택 알고리즘 정리

## 1. Stack 이란?

Stack은 **LIFO (Last In First Out)** 구조의 자료구조
마지막에 넣은 데이터가 먼저 나옴

ex.
push(1) → push(2) → push(3)  
pop() → 3 → 2 → 1


## 2. 기본 연산

| 연산 | 설명 |
|------|------|
| push | 데이터 삽입 |
| pop | 데이터 제거 |
| peek | 맨 위 값 조회 |
| isEmpty | 스택 비어있는지 확인 |

대부분의 연산 시간복잡도는 **O(1)**


## 3. 자바에서 Stack 사용

### ✔ 방법 1. Deque 사용 (권장)

```java
Deque<Integer> stack = new ArrayDeque<>();

stack.push(1);
stack.pop();
stack.peek();
```
Stack 클래스보다 성능 좋고 코테에서 일반적으로 사용

### ✔ 2. 직접 구현

```java
class Stack {
    int[] arr = new int[100];
    int top = -1;

    void push(int x){
        arr[++top] = x;
    }

    int pop(){
        return arr[top--];
    }
}
```

## 3. Stack이 사용되는 대표 알고리즘

- 괄호 검사
- DFS (깊이 우선 탐색)
- 수식 계산
- 단조 스택 (Next Greater Element, Daily Temperatures)
- 문자열 뒤집기

공통점: **최근 데이터를 다시 사용해야 하는 문제**

## 4. 시간복잡도

- push → O(1)
- pop → O(1)
- peek → O(1)

괄호 검사처럼 전체 한 번 순회 → **O(N)**


