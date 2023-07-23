# 💡ES6 향상된 객체 문법

ES6(ECMAScript 6)는 ECMAScript 표준의 가장 최신 버전이다.

현대적인 코드를 사용하면, 코드가 간결해지고 생산성이 향상된다. 이것이 ES6를 사용해야 하는 이유다.

### 속성계산명

속성 이름을 정의하는 다른 방법

대괄호[] 안에 식을 넣거나 변수를 대입하여 동적으로 객체 속성들을 생성

```jsx
var obj = {};
for (var i = 0; i < 4; i++) {
  obj["key" + i] = i;
}

console.log(obj);

var profile = "chlole:30";
var person = {
  [profile]: true,
  [profile.split(":")[0]]: profile.split(":")[1],
};

console.log(person);
```

→ profile 문자열을 키값으로 하는 속성을 정의

속성 접근자 구문과 동일한 **대괄호[]**를 사용하고 그 안에 profile 변수를 그대로 넣으면 

해당 변수값이 **속성명으로 정의**

**결과**

```
{ key0: 0, key1: 1, key2: 2, key3: 3 }
{ 'chlole:30': true, chlole: '30' }
```

### 비구조화 할당(Destructuring Assignment)

배열이나 객체읙 ㅏㅄ을 새로운 변수에 쉽게 할당한다.

```jsx
var {a : newA =10, f:new5=5} = obj;
```

a:newA = 10은 객체의 a 속성값을 새로운 변수 newA로 다시 할당하되 , undefined로 값이 없는 경우에는 기본값 **‘10’**을 할당한다.

### 심볼형

Symbol()은 늘 고유한 값을 반환한다.

typeOf() 연산자를 통해 심볼형을 확인할 수 있다.
