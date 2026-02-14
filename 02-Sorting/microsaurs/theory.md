# 정렬 알고리즘

정렬 알고리즘은 **데이터를 특정 기준(오름차순, 내림차순 등)에 따라 재배열하는 알고리즘**  
탐색 효율 향상, 데이터 가독성 개선, 후속 알고리즘 최적화를 위해 사용됨

## 1. 정렬 알고리즘 분류

### ✔ 시간복잡도 기준

| 알고리즘       | 평균       | 최악       | 특징                  |
| -------------- | ---------- | ---------- | --------------------- |
| Bubble Sort    | O(n²)      | O(n²)      | 구현 단순             |
| Selection Sort | O(n²)      | O(n²)      | 교환 횟수 적음        |
| Insertion Sort | O(n²)      | O(n²)      | 거의 정렬된 경우 빠름 |
| Merge Sort     | O(n log n) | O(n log n) | 안정 정렬             |
| Quick Sort     | O(n log n) | O(n²)      | 평균 가장 빠름        |
| Heap Sort      | O(n log n) | O(n log n) | 메모리 효율           |

### ✔ 내부 정렬 vs 외부 정렬

- **내부 정렬** → 메모리 안에서 수행  
  예: Quick, Merge, Heap

- **외부 정렬** → 데이터가 메모리보다 클 때  
  예: 파일 정렬, DB 정렬

### ✔ 안정 정렬 vs 불안정 정렬

**안정 정렬**

- 같은 값의 순서 유지
- Merge Sort
- Insertion Sort
- Bubble Sort

**불안정 정렬**

- Quick Sort
- Heap Sort
- Selection Sort

## 2. 주요 정렬 알고리즘

### Bubble Sort

인접한 두 값을 비교하며 교환

- 시간복잡도: O(n²)
- 특징: 구현 쉬움, 실무 사용 ❌

```java
for (int i=0; i<n; i++) {
    for (int j=0; j<n-i-1; j++) {
        if (arr[j] > arr[j+1]) swap(arr, j, j+1);
    }
}
```

### Selection Sort

최솟값을 찾아 앞에 배치

- 시간복잡도: O(n²)
- 특징: 교환 횟수 적음

### Insertion Sort

정렬된 부분에 값을 삽입

- 시간복잡도: O(n²)
- Best Case: O(n)
- 특징: 거의 정렬된 데이터에서 빠름

TimSort 일부에서 사용됨

### Merge Sort

Divide & Conquer 방식

1. 배열 분할
2. 각각 정렬
3. 병합

- 시간복잡도: O(n log n)
- 안정 정렬
- 추가 메모리 필요

대용량 데이터 처리에 강함

### ⚡ Quick Sort

Pivot 기준 분할 정렬

- 평균: O(n log n)
- 최악: O(n²)
- 특징: 실제 가장 많이 사용

캐시 효율 좋아서 빠름

### Heap Sort

Heap 자료구조 기반 정렬

- 시간복잡도: O(n log n)
- 추가 메모리 거의 없음
- 안정 정렬 아님

우선순위 큐 기반

## 3. 실무에서 사용하는 정렬

Java

- `Arrays.sort()` → Dual Pivot Quick Sort + TimSort

Python

- `sorted()` → TimSort

DB

- Quick + Merge Hybrid 방식

## 4. 면접 단골 질문

### ✔ Quick Sort vs Merge Sort

| 항목   | Quick     | Merge            |
| ------ | --------- | ---------------- |
| 메모리 | in-place  | 추가 메모리 필요 |
| 안정성 | 불안정    | 안정             |
| 속도   | 평균 빠름 | 일정             |

### ✔ 거의 정렬된 배열?

Insertion Sort

### ✔ 안정 정렬이 필요한 경우?

로그 정렬, DB 정렬

### ✔ n log n보다 빠른 정렬?

Counting Sort / Radix Sort  
(특정 조건에서만 가능)

## 5. 언제 어떤 정렬을 사용할까?

데이터 작음 → Insertion Sort  
일반 상황 → Quick Sort / TimSort  
안정 정렬 필요 → Merge Sort  
메모리 제한 → Heap Sort

## 6. 핵심 요약

✔ 정렬 알고리즘은  
**데이터 특성 + 메모리 + 안정성 요구**에 따라 선택

✔ 실무에서는 대부분  
Quick Sort 기반 Hybrid 정렬 사용
