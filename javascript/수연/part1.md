1. 값(value), 변수(variable)
변수 : 값을 넣는 공간
암시적선언 : 별도의 키워드 없이 변수를 할당하는 방법
ex) foo = "bar"
-> 키워드 사용해 변수 선언을 권장함, 변수 선언 범위(scope) 때문
ex) var name = "Peter"

2. 주석(comment)
// : 한문장 처리
/* */ : 블록 단위 주석 처리

3. 자료형, 타입(type)

```js
var x = 5; //숫자형(number)
var y = 'five'; //문자형(String)
var isTrue = true; //불린형(Boolean)
var empty = null; //null
var nothing //undefined
var sym = Symbol('me') //Symbol

var item - {
  price : 5000,
  count : 10
}; //객체(Object)

var fruits = ['apple', 'orange', 'kiwi']; //배열(Array)
var addFruits = function(fruit) {
  fruits.push(fruit);
} //함수(Function)
addFruit('watermelon');
console.log(fruits);
```

