## 0️⃣Level0 단계부터 10개씩

**1.두 수 의 나눗셈**

두 수를 나눗셈해서 1000을 곱한 후 정수부분 출력

→ **형변환**을 해야하는 문제

```java
class Solution {
    public int solution(int num1, int num2) {
        double result = (double) num1/num2 * 1000;
        return (int) result;
    }
}
```

1. **각도기**

```java
class Solution {
    public int solution(int angle) {
        int answer = 0;
        
        if(0 < angle && angle < 90) {
            answer = 1;
        }else if(angle == 90) {
            answer = 2;
        }else if(90 < angle && angle < 180 ) {
            answer = 3;
        }else if(angle == 180){
            answer = 4;
        }
        return answer;
    }
}
```

***삼항연산자를** 사용하여 더 간결하게 풀 수 있다.

```java
class Solution {
    public int solution(int angle) {
        return angle == 180 ? 4 : angle < 90 ? 1 : angle == 90 ? 2 : angle > 90 ? 3 : 0;
    }
}
```

**3.짝수의 합**

```java
class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i=0; i<=n; i++) {
            if(i % 2 == 0) {
                answer += i;
            }
        }
        
        return answer;
    }
}
```

***다른 사람의 풀이**

→ i 를 2부터 시작해서 2씩 더하기

```java
class Solution {
    public int solution(int n) {
        int answer = 0;

        for(int i=2; i<=n; i+=2){
            answer+=i;
        }

        return answer;
    }
}
```

**4.배열의 평균값**

```java
class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        double sum = 0;
        
        for(int i=0; i<numbers.length; i++) {
            sum += numbers[i];
            answer = sum / numbers.length;
        }
        
        return answer;
    }
}
```

***다른사람 풀이**

```java
import java.util.Arrays;

class Solution {
    public double solution(int[] numbers) {
        return Arrays.stream(numbers).average().orElse(0);
    }
}
```

→ `Arrays.stream()` : **컬렉션을 순회하여 값들을 출력하라**

sum(), count(), average(), max(), min()사용할 수 있음

.orElse(0) -> 주어진 값이 null이 아닌 경우 주어진 값을 되돌려주고 null인 경우 인수(0)을 돌려줌

**5.양꼬치**

```java
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        int a = 0;
        if(n >= 10) {
            a = n / 10;
            k = k-a;
        }
        
        answer = (n*12000) + (k*2000);
        
        return answer;
    }
}
```

**6.편지**

string의 길이⇒ string.length()

```java
class Solution {
    public int solution(String message) {
        
        return message.length() * 2;
    }
}
```

**7.배열 원소의 길이**

```java
class Solution {
    public int[] solution(String[] strlist) {
        int[] answer = new int[strlist.length];

        for(int i= 0; i<strlist.length; i++) {
           answer[i] = strlist[i].length();
        }
        
        return answer;
    }
}
```

**8.배열 자르기**

```java
class Solution {
    public int[] solution(int[] numbers, int num1, int num2) {
        int[] answer = new int[num2-num1+1];
        
        int index = 0;
        for(int i=num1; i<=num2; i++) {
            answer[index++] = numbers[i];
        }
        
        return answer;
    }
}
```

```java
import java.util.*;

class Solution {
    public int[] solution(int[] numbers, int num1, int num2) {
        return Arrays.copyOfRange(numbers, num1, num2 + 1);
    }
}
```

**→Arrays.copyOfRange() 사용해서 쉽게 풀 수 있다.**

1. **점의 위치 구하기**

```java
class Solution {
    public int solution(int[] dot) {
        int answer = 0;
        
        if(dot[0] > 0 && dot[1] >0) {

answer = 1;
        }else if( dot[0]> 0 && dot[1]< 0) {
answer = 4; }else if(
        dot[0] < 0 && dot[1]> 0
        ) {
answer = 2;
        }else if(dot[0]< 0 && dot[1]< 0) {
answer = 3;
}
        
        
        return answer;
    }
}
```

1. **피자나눠먹기(1)**

```java
class Solution {
    public int solution(int n) {
        int answer = 0;
     
 if(n>7) {
if(n%7 !=0) {
answer = n / 7 + 1 ;
}else {
 answer = n/7;
}
 } else {
 answer = 1;
}
        
        return answer;
    }
}
```
