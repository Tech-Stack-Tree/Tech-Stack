# 💡 자바스트림(stream)
  
### stream 
- Java8부터 지원  
- 컬렉션에 저장되어 있는 엘리먼트들을 하나씩 순회하면서 처리할 수 있는 코드 패턴  
- 람다식과 함께 사용 -> 데이터에 대한 처리를 매우 간결한 표현으로 작성 가능  
- 내부 반복자 사용 -> 병렬처리가 쉽다.  
  
Java6 까지는 Iterator 객체를 사용함  
``` java
ArrayList<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c"));

Iterator<String> iterator = list.iterator();

while(iterator.hasNext()) {
    String value = iterator.next();

        if (StringUtils.equals(value, "b") {
        System.out.println("값 : " + value);
    }
}
```

Java8 - stream 사용 시  
``` java
ArrayList<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c"));
list.stream()
    .filter("b"::equals)    
    .forEach(System.out::println);
```
  
     
  
### ✏️ stream 사용법
  
#### 1. 스트림 객체 생성하기  
     
1-1. 컬렉션 - stream() 메소드 호출  
``` java
List<String> list = Arrays.asList("a", "b", "c");
Stream<String> stream = list.stream();
```

1-2. 배열 - 정적메소드 이용  
``` java
String[] array = new String[]{"a", "b", "c"};
Stream<String> stream1 = Arrays.stream(array);
Stream<String> stream2 = Arrays.stream(array, 1, 3); // 인덱스 1포함, 3제외 ("b", "c")
```

1-3. 빌더(builder)  
: 배열이나 컬렉션을 통해서 생성하는게 아닌 직접 값을 입력해서 스트림 객체를 생성  
``` java
String<String> stream = Stream<String> builder()
                          .add("Apple")
                          .add("Banana")
                          .add("Melon")
                          .build();
```

1-4. Generator   
: 데이터를 생성하는 람다식을 이용해서 스트림 생성  
``` java
public static<T> Stream<T> generate(Supplier<T> s) { ... }
```
Supplier에 해당하는 람다식이 데이터를 생성하는 람다식이다.  

``` java
Stream<String> stream = Stream.generate(() -> "Hello").limit(5);
```
generate() 메소드 인자로 "Hello"를 찍어주는 람다식을 주면,
"Hello" 라는 데이터를 무한대로 생성하는 스트림이 만들어진다.
여기에 limit() 메소드에 매개변수 5를 줌으로서, "Hello" 문자열을 5개만 찍어내도록 제한을 걸어줬다.

1-5. Iterator  
:iterate() 메소드로 수열 형태의 데이터를 생성할 수 있다.  
``` java
// (100, 110, 120, 130, 140)
Stream<String> stream = Stream.iterate(100, n -> n + 10).limit(5);
```

1-6. Empty 스트림  
:늑수한 스트림, '빈 스트림(Empty Stream)'을 사용할 수 있다.   
stream 객체를 참조하는 변수가 null이라면 NullPointExceiption이 발생할 수 있다.  
``` java
Stream<String> stream = Stream.empty();
```
  
1-7. 기본 타입(Primitive Type)  
``` java
//auto boxing X 
IntStream intStream = IntStream.range(1, 10); // 1 ~ 9
LongStream longStream = LngStream.range(1, 10000); // 1 ~ 9999

//제너릭을 이용한 클래스(ex. Integer)로 사용하려면 boxing을 해서 사용해야한다.
Stream<Integer> stream = IntStream.range(1, 10).boxed();

//정해진 값이 아니라 랜덤 값을 스트림으로 뽑아내려면 Random() 클래스를 사용
DoubleStream stream = new Random().double(3); // double 형 랜덤 숫자 3개 생성
```

1-8. 문자열 스트림  
``` java  
//문자열을 구성하는 문자의 ASCII 코드값을 스트림 형태로 뽑아줌
IntStream stream = "Hello,World".chars(); //(72, 101, 108, 108, 111, 44, 87, 111, 114, 108, 100)

//특정 구분자(delimiter)를 이용해 문자열을 split한 다음 각각 스트림으로 뽑아낼 수도 있다.
Stream<String> stream = Pattern.compile(",").splitAsStream("Apple,Banana,Melon");
```

1-9. 파일  
: 텍스트 파일로 읽어서 라인단위로 처리  
``` java
//데이터는 'utf-8'로 디코딩해서 읽어온다.
Stream<String> stream = Files.lines(Paths.get("test.txt"), Charset.forName("UTF-8"));
```

#### 2. 스트림 데이터 가공

2-1. 스트림 연결  
: 두 개의 스트림을 연결해서 하나의 새로운 스트림을 만든다.  
``` java
Stream<String> stream1 = Stream.of("Apple", "Banana", "Melon");
Stream<String> stream2 = Stream.of("Kim", "Lee", "Park");

Stream<String> stream3 = Stream.concat(stream1, stream2);
// "Apple", "Banana", "Melon", "Kim", "Lee", "Park"
```

2-2. Filter  
: 스트림에서 뽑아져 나오는 데이터에서 특정 데이터들만 골라내는 역할  
``` java
//filter
Stream<T> filter(Predicate<? super T> predicate);

//1~9까지 데이터 중 짝수를 선별
Stream<Integer> stream = IntStream.range(1, 10).boxed();
stream.filter(v -> ((v % 2) == 0))
            .forEach(System.out::println);
// 2, 4, 6, 8
```

2-3. Map    
: 스트림에서 뽑아져 나오는 데이터에 변경을 가함  
```java
//Map
//값을 변환해주는 람다식을 인자로 받는다.
//스트림 데이터에 map() 메소드의 인자로 받은 람다식을 적용해 새로운 데이터를 만든다.
<R> Stream<R> map(Function<? super T, ? extends R> mapper);

//1~9까지 숫자 중, filter()로 짝수만 뽑아낸 다음, 곱하기 10을 해서 10배에 해당하는 숫자를 생성
Stream<Integer> stream = IntStream.range(1, 10).boxed();
stream.filter(v -> ((v % 2) == 0))
            .map(v -> v * 10)
            .forEach(System.out::println);
// 20, 40, 60, 80
```

2-4. flatMap  
: map과 비슷한 역할  
```java
//flatMap
//중첩된 스트림 구조를 한단계 적은 단일 컬렉션에 대한 스트림으로 만들어 주는 역할, 플랫트닝(flattening)
<R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);

//이중 구조 리스트
List<List<String>> list = Arrays.asLists(Arrays.asList("A", "B", "C"),
                                         Arrays.asList("a", "b", "c"));
// [["A", "B", "C"], ["a", "b", "c"]]

List<String> flatList = list.stream()
                            .flatMap(Collection::stream)
                            .collect(Collectors.toList());
// ["A", "B", "C", "a", "b", "c"]
```

2-5. Sorted()  
: 데이터 정렬  
``` java
Stream<T> sorted();  //오름차순 정렬
Stream<T> sorted(Comparator<? super T> comparator); //두 값을 비교하는 별도의 로직 작성
```

2-6. Peek  
: map()처럼 연산을 수행하지만, 새로운 스트림 생성x, 인자로 받은 람다를 적용하기만 함  
``` java
Stream<T> peek(Consumer<? super T> action);

//중간에 로깅 같은 것 할 때 사용
int sum = IntStream.range(1, 10)
  .peek(System.out::println)
  .sum();
```

#### 3. 스트림 결과 생성  
가공한 스트림을 가지고 내가 사용할 결과값으로 만들어내는 단계  

3-1. Calculating
: 스트림 API 는 다양한 종료 작업을 제공
-> 최소, 최대, 합, 평균 등 기본형 타입으로 결과를 만들어낼 수 있다.
``` java
//스트림이 비어 있는 경우
//count 와 sum: 0을 출력
// 평균, 최소, 최대의 경우 : Optional 을 이용해 리턴
long count = IntStream.of(1, 3, 5, 7, 9).count();
long sum = LongStream.of(1, 3, 5, 7, 9).sum();

OptionalInt min = IntStream.of(1, 3, 5, 7, 9).min();
OptionalInt max = IntStream.of(1, 3, 5, 7, 9).max();

//스트림에서 바로 ifPresent 메소드를 이용해서 Optional 을 처리할 수 있다.
DoubleStream.of(1.1, 2.2, 3.3, 4.4, 5.5)
  .average()
  .ifPresent(System.out::println);
```

3-2. Reduction  
: reduce 라는 메소드를 이용해서 결과를 만든다.  

* 세가 지 파라미터
- accumulator : 각 요소를 처리하는 계산 로직. 각 요소가 올 때마다 중간 결과를 생성하는 로직.
- identity : 계산을 위한 초기값으로 스트림이 비어서 계산할 내용이 없더라도 이 값은 리턴.
- combiner : 병렬(parallel) 스트림에서 나눠 계산한 결과를 하나로 합치는 동작하는 로직.

``` java
// 1개 (accumulator)
Optional<T> reduce(BinaryOperator<T> accumulator);

//ex
OptionalInt reduced = 
  IntStream.range(1, 4) // [1, 2, 3]
  .reduce((a, b) -> {
    return Integer.sum(a, b);
  });
//result
6


// 2개 (identity)
T reduce(T identity, BinaryOperator<T> accumulator);

//ex
int reducedTwoParams = 
  IntStream.range(1, 4) // [1, 2, 3]
  .reduce(10, Integer::sum); // method reference
//result
16 (초기값 10)


// 3개 (combiner)
<U> U reduce(U identity,
  BiFunction<U, ? super T, U> accumulator,
  BinaryOperator<U> combiner);

//ex
Integer reducedParams = Stream.of(1, 2, 3)
  .reduce(10, // identity
          Integer::sum, // accumulator
          (a, b) -> {
            System.out.println("combiner was called");
            return a + b;
          });
//result
combiner was called
combiner was called
36

//먼저 accumulator 는 총 세 번 동작한다.
//초기값 10에 각 스트림 값을 더한 세 개의 값(10 + 1 = 11, 10 + 2 = 12, 10 + 3 = 13)을 계산
//Combiner 는 identity 와 accumulator 를 가지고 여러 쓰레드에서 나눠 계산한 결과를 합치는 역할
// 12 + 13 = 25, 25 + 11 = 36 이렇게 두 번 호출
```

3-3. Collecting  
: Collector 타입의 인자를 받아서 처리, 자주 사용하는 작업은 Collectors 객체에서 제공  
``` java
//Product 객체: 수량(amout), 이름(name)으로 구성
List<Product> productList = 
  Arrays.asList(new Product(23, "potatoes"),
                new Product(14, "orange"),
                new Product(13, "lemon"),
                new Product(23, "bread"),
                new Product(13, "sugar"));

//Collectors.toList()
//스트림에서 작업한 결과를 담은 리스트로 반환
List<String> collectorCollection =
  productList.stream()
    .map(Product::getName)
    .collect(Collectors.toList());
// [potatoes, orange, lemon, bread, sugar]

//Collectors.joining()
스트림에서 작업한 결과를 하나의 스트링으로 이어 붙일 수 있다.
String listToString = 
 productList.stream()
  .map(Product::getName)
  .collect(Collectors.joining());
// potatoesorangelemonbreadsugar

//Collectors.joining 은 세 개의 인자를 받을 수 있다.
//delimiter : 각 요소 중간에 들어가 요소를 구분시켜주는 구분자
//prefix : 결과 맨 앞에 붙는 문자
//suffix : 결과 맨 뒤에 붙는 문자
String listToString = 
 productList.stream()
  .map(Product::getName)
  .collect(Collectors.joining(", ", "<", ">"));
// <potatoes, orange, lemon, bread, sugar>

//Collectors.averageingInt()
//숫자 값(Integer value)의 평균(arithmetic mean)
Double averageAmount = 
 productList.stream()
  .collect(Collectors.averagingInt(Product::getAmount));
// 17.2

//Collectors.summingInt()
//숫자값의 합(sum)
Integer summingAmount = 
 productList.stream()
  .collect(Collectors.summingInt(Product::getAmount));
// 86

//IntStream 으로 바꿔주는 mapToInt 메소드를 사용해서 좀 더 간단하게 가능
Integer summingAmount = 
  productList.stream()
  .mapToInt(Product::getAmount)
  .sum(); // 86

//Collectors.summarizingInt()
//만약 합계와 평균 모두 필요하다면 한번에 얻을 수 있다.
IntSummaryStatistics statistics = 
 productList.stream()
  .collect(Collectors.summarizingInt(Product::getAmount));

//IntSummaryStatistics {count=5, sum=86, min=13, average=17.200000, max=23}
/*
메소드 사용하면, 바로 요약 정보를 가지고 올 수 있다.
개수 getCount()
합계 getSum()
평균 getAverage()
최소 getMin()
최대 getMax()
*/

//Collectors.groupingBy()
//특정 조건으로 요소들을 그룹지을 수 있다.
Map<Integer, List<Product>> collectorMapOfLists =
 productList.stream()
  .collect(Collectors.groupingBy(Product::getAmount));

{23=[Product{amount=23, name='potatoes'}, 
     Product{amount=23, name='bread'}], 
 13=[Product{amount=13, name='lemon'}, 
     Product{amount=13, name='sugar'}], 
 14=[Product{amount=14, name='orange'}]}

//Collectors.partitioningBy()
//partitioningBy 은 함수형 인터페이스 Predicate 를 받는다. Predicate 는 인자를 받아서 boolean 값을 리턴
Map<Boolean, List<Product>> mapPartitioned = 
  productList.stream()
  .collect(Collectors.partitioningBy(el -> el.getAmount() > 15));

{false=[Product{amount=14, name='orange'}, 
        Product{amount=13, name='lemon'}, 
        Product{amount=13, name='sugar'}], 
 true=[Product{amount=23, name='potatoes'}, 
       Product{amount=23, name='bread'}]}

//Collectors.collectingAndThen()
//collect 한 이후에 추가 작업이 필요한 경우에 사용
public static<T,A,R,RR> Collector<T,A,RR> collectingAndThen(
  Collector<T,A,R> downstream,
  Function<R,RR> finisher) { ... }


//ex
//Collectors.toSet 을 이용해서 결과를 Set 으로 collect 한 후 수정불가한 Set 으로 변환하는 작업을 추가로 실행
Set<Product> unmodifiableSet = 
 productList.stream()
  .collect(Collectors.collectingAndThen(Collectors.toSet(),
                                        Collections::unmodifiableSet));
```

3-4. Matching  
: 조건식 람다 Predicate 를 받아서 해당 조건을 만족하는 요소가 있는지 체크한 결과를 리턴    

* 세 가지 메소드 지원  
- 하나라도 조건을 만족하는 요소가 있는지(anyMatch)  
- 모두 조건을 만족하는지(allMatch)  
- 모두 조건을 만족하지 않는지(noneMatch)

``` java
boolean anyMatch(Predicate<? super T> predicate);
boolean allMatch(Predicate<? super T> predicate);
boolean noneMatch(Predicate<? super T> predicate);

List<String> names = Arrays.asList("Eric", "Elena", "Java");

boolean anyMatch = names.stream()
  .anyMatch(name -> name.contains("a")); //true
boolean allMatch = names.stream()
  .allMatch(name -> name.length() > 3); //true
boolean noneMatch = names.stream()
  .noneMatch(name -> name.endsWith("s")); //true
```

3-5. Iterating  
foreach: 요소를 돌면서 실행되는 최종 작업  
``` java
names.stream().forEach(System.out::println);
```
    
### ✔️ Reference
<https://futurecreator.github.io/2018/08/26/java-8-streams/>
