## Immutable Object
 - 불변 객체
 - 객체 생성 이후 내부의 상태가 변하지 않는 객체
 - ready-only 메소드만 제공하며, 방어적 복사를 통해제공
 - 불변성이 보장된 객체라면 내부를 보지 않아 시간을 절감할 수 있다.
 ```java
 String name = "Old"
 name.toCharArray()[0] = 'E';
 ```

## Immutable Object 를 사용하는 이유
1. Thread-Safe하여 병렬 프로그래밍에 유용하며, 동기화를 고려하지 않아도됨.
2. 실패 원자적인 메소드를 만들 수 있음.
3. Cache나 Map 또는 Set 등의 요소로 활용하기에 더욱 적합함.
4. 부수 효과를 피해 오류가능성을 최소화
5. 다른 사람이 작성한 함수를 예측 가능하며 안전하게 사용
6. 가비지 컬렉션의 성능을 높임
 - 자바 바이트 코드는 운영체제(OS)에 독립적이며 모든 JVM은 규격에 정의된 대로 자바 바이트 코드를 실행
 - 자바 애플리케이션을 클래스 로더를 통해 읽어 JAVA API와 함께 실행

## Immutable Object 만드는 법
1. 맴버변수를 final로 설정
```java
  public final class ImmutableClass {
    private final int age;
    private final String name;
    private final List<String> list;
```
2. setter 메서드를 구현해야함
3. class를 상속하지 못하도록 선언
## Mutable Object 객체

<br/>

## Mutable Object
- 가변 객체
- heap영역에 생선된 객체 변경 가능
- List, ArrayList, HashMap,StringBuilder,StringBuffer
- 동기화 처리 필요 
