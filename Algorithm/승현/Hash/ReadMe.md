## 🗒️해시(Hash)란? ##

**1) 해시**

→ 데이터를 다루는 기법 중 하나로, **검색과 저장이 아주 빠르게 하는 자료구조**

데이터를 저장할 땐 **key-value** 형태로 데이터가 존재, key값이 **배열의 인덱스**로 저장되기 때문에 검색과 저장이 빠르게 일어난다.

**2) 해시 함수**

→ Key값을 **고정된 길이의 hash로 변환**하는 역할을 한다.

Key값을 해싱 과정을 통해 **해시 값(hash value) 또는 해시 코드(hash code)**으로 변경하며, 해시 값이 저장 위치가 된다고 생각하면 된다.

※ 서로 다른 키(key)가 같은 해시(hash)가 되는 경우를 **해시 충돌(hash Collision)라고 하는데,** 해시 충돌을 일으키는 확률을 최대한 줄이는 함수를 만드는 것이 중요하다.

**3) 해싱**

→ Key값을 해시로 변환하는 과정

**4) 해시 테이블** 

→ **연관 배열구조**를 이용하여 데이터를 key와 Value로 저장하는 자료구조이다.

해시 함수를 사용하여 색인(index)을 **버킷(bucket)이나 슬롯(slot) 배열**로 계산 

- 연관 배열구조?
    
    : 자료구조의 하나로, 키 하나와 값 하나가 연간되어 있으며 키를 통해 연관되는 값을 얻을 수 있다.
    

**장점**

1) 중복 제거

2) 데이터 캐싱, 보안에 주로 사용된다.

3) 배열의 인덱스로 접근하기 때문에 삽입, 삭제 연산이 빠르다.

**단점**

1) 공간 복잡도가 커진다.

2) 충돌이 발생(O(n))에 가까워짐

3) 순서가 있는 배열에는 어울리지 않는다.

## 해시테이블(Hash Table)과 해시 맵(Hash Map)

→ 가장 큰 차이  : **동기화 지원 여부, Null 처리 여부**

|  | 해시 테이블 | 해시 맵 |
| --- | --- | --- |
| 동기화  | ㅇ | x |
| Null 허용 | x | o |

### References

[https://velog.io/@hanif/자료구조-해시](https://velog.io/@hanif/%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0-%ED%95%B4%EC%8B%9C)

## 📖프로그래머스 문제 level1 ##

🏃🏻‍♀️**완주하지 못한 선수**

해시를 사용하지 않고 간단하게 배열로 풀 수 있다.

```java
import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
    //간단하게 배열로 풀 수 있음
    Arrays.sort(participant);
    Arrays.sort(completion);
    
    for(int i=0; i<completion.length; i++) {
        if(participant[i].equals(completion[i])) {
            continue;
        }else {
            return participant[i];
        }
    }
        
return participant[participant.length-1];
    }
}
```

→ participant[i]랑 completion[i] 같은지 확인해서 같으면 continue(넘어감)

안같으면 participant[i] return 한다.

완주자 목록에 다른게 없다면 마지막 한 사람이므로 그 사람을 출력한다.

### Hash를 사용한다면?

```java
import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer ="";
        HashMap<String, Integer> hm = new HashMap<>();
        for(String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
        for(String player : completion) hm.put(player, hm.get(player) -1);
        for(String key : hm.keySet()) {
        	if(hm.get(key) != 0) {
        		answer = key;
        		System.out.println(answer);
        		break;
        	}
        }
        return answer;
    }
}
```

HashMap에 Participant의 참가자를 key 값으로, value는 +1을 넣어준다.

그리고 이 해시 맵을 이용 하여 Completion의 명단이 HashMap에 key 값에 존재하면 value에 -1 해 준다. 그러면 각 key값의 value값이 0이 아닌 경우 완주하지 못한 명단을 구할 수 있다.

**getOrDefault()란?**

`getOrDefault`는 자바의 `Map` 인터페이스에서 제공하는 메소드이다.

`Map`은 Key-Value 쌍으로 데이터를 저장하는 자료구조입니다. `getOrDefault` 메소드는 맵에서 주어진 키에 해당하는 값이 있으면 그 값을 반환하고, 그렇지 않으면 기본값을 반환

예를 들어, `Map<String, Integer> map = new HashMap<>()`이라는 맵이 있을 때, `map.getOrDefault("apple", 0)`을 호출하면, "apple"이라는 키에 해당하는 값이 없으면 0을 반환

이 메소드는 `NullPointerException`을 방지하기 위해 유용하게 사용될 수 있다.

 예를 들어, `Map`에서 특정 키에 대한 값을 가져올 때, 해당 키가 없으면 `null`이 반환되는데, 이 때 `getOrDefault`를 사용하면 `null` 대신 기본값을 반환할 수 있다.

### references

[https://junghn.tistory.com/entry/알고리즘-프로그래머스-완주하지-못한-선수-해시-1](https://junghn.tistory.com/entry/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%99%84%EC%A3%BC%ED%95%98%EC%A7%80-%EB%AA%BB%ED%95%9C-%EC%84%A0%EC%88%98-%ED%95%B4%EC%8B%9C-1)
