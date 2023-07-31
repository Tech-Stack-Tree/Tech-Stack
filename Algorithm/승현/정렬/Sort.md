## 💡정렬
1) 배열 정렬하기**

Arrays.sort()이용

→ 오름차순 정렬

arr[] = {};

`내림차순 정렬` : **Arrays.sort(arr, Collections.reverseOrder());**

→ Collections.reverseOrder()는 **Comperator의 객체이다**.

***Comperator** 사용

```java
Integer[] arr = {1, 26, 17, 25, 99, 44, 303};

Arrays.sort(arr, new Comparator<Integer>() {
    @Override
    public int compare(Integer i1, Integer i2) {
        return i2 - i1;
    }
});

System.out.println("Sorted arr[] : " + Arrays.toString(arr));
```

***람다 사용**

```java
Integer[] arr = {1, 26, 17, 25, 99, 44, 303};

Arrays.sort(arr, (i1, i2) -> i2 - i1);

System.out.println("Sorted arr[] : " + Arrays.toString(arr));
```

***배열의 일부분만 정렬**

**Arrays.sort(arr,0(firstIndex),4(LastIndex);**

***배열이 String일때 문자열 길이대로 정렬(Comperator사용)**

```java
String[] arr = {"Apple", "Kiwi", "Orange", "Banana", "Watermelon", "Cherry"};

Arrays.sort(arr, new Comparator<String>() {
    @Override
    public int compare(String s1, String s2) {
        return s1.length() - s2.length();
    }
});

System.out.println("Sorted arr[] : " + Arrays.toString(arr));
```

***람다식 사용**

```java
String[] arr = {"Apple", "Kiwi", "Orange", "Banana", "Watermelon", "Cherry"};

Arrays.sort(arr, (s1, s2) -> s1.length() - s2.length());

System.out.println("Sorted arr[] : " + Arrays.toString(arr));
```

***객체 정렬도 가능(CompareTo사용)**

```java
public static class Fruit implements Comparable<Fruit> {
    private String name;
    private int price;
    public Fruit(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "{name: " + name + ", price: " + price + "}";
    }

    @Override
    public int compareTo(@NotNull Fruit fruit) {
        return this.price - fruit.price;
    }
```

```java
Fruit[] arr = {
        new Fruit("Apple", 100),
        new Fruit("Kiwi", 500),
        new Fruit("Orange", 200),
        new Fruit("Banana", 50),
        new Fruit("Watermelon", 880),
        new Fruit("Cherry", 10)
};

Arrays.sort(arr);

System.out.println("Sorted arr[] : " + Arrays.toString(arr));
```

## 1번(K번째의 수)
**Arrays.copyOfRange(원본 배열, 복사 시작인덱스, 복사할 끝 인덱스)**

## 2번(가장 큰 수)

*풀이

```java
import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] stringNumbers = new String[numbers.length];
        //int형 배열 -> String으로 바꿈
        for(int i =0; i<numbers.length; i++) {
            stringNumbers[i]  = Integer.toString(numbers[i]);
        }
        
        //두 수를 번갈아가며 합친 수 중 큰 값을 앞으로 정렬(내림차순)
        Arrays.sort(stringNumbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        
        if(stringNumbers[0].equals("0")) return "0";
        
        //문자열을 delimiter("") 기준으로 합침
        return String.join("", stringNumbers);
    }
}
```

***new Comparator Override**를 사용하여 값을 비교한다.

`Comparator`는 Java에서 두 개 이상의 객체를 비교할 때 사용하는 인터페이스

`Comparator` 인터페이스를 구현하는 클래스에서는 `compare` 메서드를 **오버라이딩하여 두 객체를 비교합니다.**

보통 `Comparator`는 **정렬 알고리즘에**서 사용된다.

위 예시에서는 `Arrays.sort` 메서드를 사용하여 `String` 배열을 정렬할 때 `compare` 메서드를 구현한 `Comparator` 클래스를 인자로 넘겨준다.

`compare` 메서드에서는 두 문자열을 이어 붙인 결과를 비교하여 크기를 비교하고, 그 결과를 반환합니다. 이를 통해 두 개의 문자열을 비교하여 정렬할 수 있다.

***String.Join(seperator, value)**

→ `String.Join` 메소드를 사용하면 문자열 배열 내의 복수개의 요소들을 이어붙일 수 있다 (concatenate).

### Reference
https://codechacha.com/ko/java-sorting-array/
