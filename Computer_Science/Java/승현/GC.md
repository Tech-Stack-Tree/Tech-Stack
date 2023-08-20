### 💣*GC란?

자바 애플리케이션에서 사용하지 않는 메모리를 자동으로 수거하는 역할

자바에서 GC를 이용하여 개발자들이 메모리 관리를 비교적 신경쓰지 않는다.

- GC의 대상이 되는 경우
    
    1) 객체가 NULL인 경우(ex.String str = null)
    
    2) 블럭 실행 종료 후 , 블럭 안에서 생성된 객체
    
    3) 부모 객체가 NULL인 경우, 포함하는 자식 객체

***JVM의 메모리 영역**

→ Class영역, Java Stack, Heap, Native Method Stack
- `Stack`영역
    
    : 지역변수, 파라미터, 리턴 값, 연산에 사용되는 임시 값 등이 생성되는 영역
    
- `PC 레지스터`
    
    : Thread가 생성될 때마다 생성되는 영역으로 프로그램 카운터, 즉 현재 스레드가 실행되는 부분의 주소와 명령을 저장하고 있는 영역이다.
    
- `Native Method Stack`
    
    : 자바 이외의 언어(C,C++, 어셈블리 등)로 작성된 네이티브 코드를 실행할 때 사용되는 메모리 영역으로 일반적인 c스택 사용
  
![GC](https://github.com/Tech-Stack-Tree/Tech-Stack/assets/79103761/2b50da0f-c7ec-4c21-90e4-ff3aa013c735)

이 **Heap영역은** 세 영역으로 나누어진다.

**1) Young 영역**

: 생성되지 얼마 되지 않은 객체들을 저장하는 장소

**2) Old 영역**

: 생성된지 오래된 객체를 저장하는 장소이다.

→ 시간이 지남에 따라 우선순위가 낮아지면 Old 영역으로 옮겨진다.

**3) Perm 영역**

: Class, Method 등의 코드가 저장되는 영역으로 JVM에 의해서 사용한다.

**[Young Generation]**

- Heap 영역에 객체가 생성되면 최초로 Eden 영역에 할당된다.
- 데이터가 어느정도 쌓이게 되면 참조 정도에 따라 Survivor의 빈 공간으로 이동하거나 회수된다.
- Young Gerneration 영역이 차게 되면 참조 정도에 따라 **Tenured Generation** 영역으로 이동되거나 회수된다.
- Young과 Tenured Generation 에서의 GC를 **Minor GC**라고 한다.

**[Tenured Generation]**

- Old 영역에 있는 모든 객체들을 검사하여 참조되지 않는 객체들을 한꺼번에 삭제하는 GC가 실행된다.
- 시간이 오래 걸리는 작업, 이때 GC를 실행하는 스레드를 제외한 모든 스레드는 작업을 멈추게 된다. → **Stop-the-World**
- Stop-the-World가 발생하고 Old 영역의 메모리를 회수하는 GC를 **Major GC** 라고 한다.
    


***Reference***

[https://dongwooklee96.github.io/post/2021/04/04/gcgarbage-collector-종류-및-내부-원리.html](https://dongwooklee96.github.io/post/2021/04/04/gcgarbage-collector-%EC%A2%85%EB%A5%98-%EB%B0%8F-%EB%82%B4%EB%B6%80-%EC%9B%90%EB%A6%AC.html)

https://github.com/devSquad-study/2023-CS-Study/blob/main/java/java_gc.md

https://jonny-cho.github.io/java/2021/06/01/garbage-collection/

[https://github.com/GimunLee/tech-refrigerator/blob/master/Language/JAVA/Garbage Collection.md#garbage-collection](https://github.com/GimunLee/tech-refrigerator/blob/master/Language/JAVA/Garbage%20Collection.md#garbage-collection)

https://github.com/devFancy/2023-CS-Study/blob/main/java/java_jvm_architecture.md
