## 🖥️JVM 개념

**Java Virtual Machine은 자바 프로그램 실행환경을 만들어주는 소프트웨어**

→ Java를 OS(Operationg System)에 독립적으로 실행 할 수 있게 하는 주체.

*os : 운영체제로 컴퓨터를 효율적으로 관리하고 제어하며 작동하기 위해 만들어진 소프트웨어. 

1) JAVA 코드를 컴파일 →  **.class 바이트 코드**로 → 코드가 JVM에서 실행

- JAVA Compiler(javaC)는 ‘해석기’라는 의미로 인간이 사용하는 고언어를 → 기계어로 해석해주는 번역프로그램
![JVM](https://github.com/Tech-Stack-Tree/Tech-Stack/assets/79103761/76e6565c-ef82-4ad3-89b0-38a9b76eaa29)

2) **ClassLoader**를 통해 JVM Runtime Data Area로 로딩

→ 자바는 클래스 파일을 동적으로 읽어온다.

- **ClassLoaer**는 클래스들을 동적으로 메모리에 로딩하는 역할을 담당한다.

3) 로딩된 .class들은 **Execution Engine**을 통해 해석

- Execution Engine(실행엔진)는 Load된 바이트코드를 실행하는 Runtime Module이다.
- 두가지 방식 존재
    - Interpreter 방식
        
        바이트코드를 한 줄씩 해석, 속도가 느림
        
    - JIT(Just In Time) 컴파일 방식 또는 동적 번역(Dynamic Translation)
        
        각 OS에 맞는 Native Code로 변환하여 실행속도 개선, Interpreter 일정 기준이 넘어가면 JIT 컴파일 방식으로 명령어 실행
        

4) 해석된 바이트 코드는 Runtime Data Area의 각 영역에 배치되면서 수행하며 **GC의 작동과 스레드 동기화**가 이루어진다.

- **Garbage Collector는** 더는 사용하지 않는 메모리를 자동으로 회수한다.
- Heap 메모리 영역에 생성된 객체들 중에 참조되지 않은 객체들을 탐색 후 제거하는 역할을한다.  GC 역할을 수행하는 스레드를 제외한 나머지 모든 스레드는 일시 정지 상태이다.


**References**

https://coding-factory.tistory.com/828

https://m.blog.naver.com/ksw6169/221647376178

https://hbase.tistory.com/174

https://kingofbackend.tistory.com/123
