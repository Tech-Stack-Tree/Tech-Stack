## 🦛힙(Heap)
완전이진트리의 일종
우선순위 큐를 위하여 만들어진 자료구조
→ 최대값이나 최소값을 빠르게 찾아내도록 만들어진 자료구조이다.
## 힙의 종류
1) 최대 힙(max heap)
부모 노드의 키 값 ≥ 자식 노드의 키 값보다 크거나 같은 완전 이진 트리
2) 최소 힙(min heap)
부모 노드의 키 값 ≤ 자식 노드의 키 값보다 작거나 같은 완전 이진트리

![힙 인덱스](https://github.com/Tech-Stack-Tree/Tech-Stack/assets/79103761/106f56e6-b455-4f0e-af49-ccde2cbe40ff)

## 힙의 구현
1) 힙을 저장하는 표준적인 자료구조는 배열이다. 
2) 구현을 쉽게 하기 위해서 배열의 첫 번째 인덱스인 0은 사용되지 않는다.
3) 특정 위치의 노드 번호는 새로운 노드가 추가되어도 변하지 않는다.
4) 힙에서의 부모노드와 자식노드의 관계 
왼쪽 자식의 인덱스 = (부모의 인덱스) * 2
오른쪽 자식의 인덱스 = (부모의 인덱스) * 2 + 1
부모의 인덱스 = (자식의 인덱스) / 2

## 힙의 삽입
힙의 새로운 요소가 들어오면, 새로운 노드를 힙의 마지막 노드에 이어서 삽입.
새로운 노드를 부모 노드들과 교환해서 힙의 성질을 만족시킨다.
## 힙의 삭제
최대 힙에서 최대값은 루트 노드
→ 루트 노드 삭제
삭제된 루트 노드에는 힙의 마지막 노드를 가져온다.
힙을 재구성

### reference
https://gmlwjd9405.github.io/2018/05/10/data-structure-heap.html


### 최소 힙 구하기 코드
import java.io.*;
import java.util.*;

```java
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //입력 개수 받기
        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> qu = new PriorityQueue<>();

        //배열에 넣기
        for(int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            // 자연수가 0이면 
                if(num == 0) {
                    if (!qu.isEmpty()) {
                        //배열에 가장 작은 숫자 출력, 그 값을 배열에서 제거
                        System.out.println(qu.poll());
                    } else {
                        //배열이 비어있는 경우 0을 출력
                        System.out.println(0);
                    }
                    continue;
                }
                //큐에 있는 값 출력
            qu.add(num);
        }
    }
}
```
​
### 최대 힙 구하기

```java
import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Heap_2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //입력 개수 받기
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> qu = new PriorityQueue<>(Collections.reverseOrder());

        //배열에 넣기
        for(int i = 0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());
            // 자연수가 0이면
            if(num == 0) {
                if (!qu.isEmpty()) {
                    //배열에 가장 큰 출력, 그 값을 배열에서 제거
                    sb.append(qu.poll()).append('\n');
                } else {
                    //배열이 비어있는 경우 0을 출력
                    sb.append(0).append('\n');
                }
            }
            //큐에 있는 값 출력
            qu.add(num);
        }
        System.out.println(sb.toString());
    }
}
```
