# 🔍 DP(Dynamic Programming, 동적계획법)  
  
  
  
### 🧾 동적계획법(Dynamic Programming)  
: 하나의 문제를 단 한 번만 풀도록 하는 알고리즘  
  
**ex) 피보나치 수열**  
- 특정한 숫자를 구하기 위해 그 앞에 있는 숫자와 두 칸 앞에 있는 숫자의 합을 구해야한다.  
- 점화식: D[i] = D[i-1] + D[i-2]  
=> 단순한 분할 정복 기법을 사용하면, 이미 해결한 문제를 다시 반복적으로 해결하여 비효율적!!💥  
=> 동적 프로그래밍 기법을 사용!!   

  
#### Dynamic Programming의 조건  
- 모든 작은 문제들은 한 번만 풀어야 한다. 따라서 정답을 구한 작은 문제를 어딘가에 메모해 놓는다.  
  다시 그보다 큰 문제를 풀어나갈 때 똑같은 작은 문제가 나타나면 앞서 메모한 작은 문제의 결과 값을 이용한다.  
  

#### Dynamic Programming의 방법  
- 작은 문제가 반복이 일어나는 경우  
- 같은 문제는 구할 때 마다 정답이 같다.    
  
  
#### "메모이제이션(Memoization)"  
: *계산한 결과는 배열에 저장함* 으로써, 나중에 동일한 계산을 해야할 때는 저장된 값을 단순히 반환하면 된다.  
  
**일반적인 재귀함수를 이용한 구현**  
``` java
public class fibonacci {
 
    public static int fibonacci(int n) {
        if (n <= 1)
            return n;
        else
            return fibonacci(n - 2) + fibonacci(n - 1);
    }
 
    public static void main(String[] args) {
        System.out.println(fibonacci(10));
    }
 
}
```
  
**메모이제이션(Memoization)을 이용한 피보나치(Fibonacci)수열의 구현**  
``` java 
public class Memoization_Fibonacci {
 
    static long[] memo;
    public static long fibonacci(int n) {
        if (n <= 1)
            return n;
        else if (memo[n] != 0)
            return memo[n];
        else
            return memo[n] = fibonacci(n - 1) + fibonacci(n - 2);
 
    }
    
    public static void main(String[] args) {
        memo = new long[101];
        System.out.println(fibonacci(100));
    }
}
```
  
  
*****
### ✅ Reference  
<https://blog.naver.com/ndb796/221233570962>  
  
### ✏ 연습 문제  
<https://www.acmicpc.net/workbook/view/1984>  
  
