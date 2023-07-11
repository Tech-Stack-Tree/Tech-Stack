##### 1. 값(value), 변수(variable)  
변수 : 값을 넣는 공간  
암시적선언 : 별도의 키워드 없이 변수를 할당하는 방법  
ex) foo = "bar"  
-> 키워드 사용해 변수 선언을 권장함, 변수 선언 범위(scope) 때문  
ex) var name = "Peter"  
  
##### 2. 주석(comment)
// : 한문장 처리  
/* */ : 블록 단위 주석 처리
  
##### 3. 자료형, 타입(type)

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
  
원시 타입(Primitive Data Type): 변수에 값이 할당될 때 메모리 상에 고정된 크기로 저장된다.  
ex) Number, Boolean, String, Symbol, null, undefined  
참조 타입(Reference Data Type) : 변수에 고정된 크기를 저장하지 않고, 값의 메모리 주소를 참조  
ex) Object  

##### 4.콘솔(console)
콘솔(console) : 자바스크립트의 내장 객체  
  
**log 메소드**  
console.log(메시지) : 일반적인 로그 메시지로 출력  
```js
console.debug('log와 동일한 로그 메시지를 출력합니다.');
console.error('에러 메시지를 출력합니다.');
console.info('정보성 메시지를 출력합니다.');
console.warn('경고성 메시지를 출력합니다.');
```  
-> 출력메시지로 메시지의 레벨을 설정하면, 브라우저 웹 콘솔에서 원하는 레벨의 메시지들만 필터링 검색하여 출력 결과를 볼 수 있다.  

##### 5.조건문 if
```js
//형식
if(표현식) 
  명령문

if(표현식1){
  명령문1
} else if(표현식2) {
  명령문2
} else if(표현식3) {
  명령문3
} else {
  명령문4
}
```

##### 6.조건문 switch
```js
//형식
switch(표현식) 
  명령문

if(표현식1){
  case 값1 :
      명령문1
      break;
  case 값2 :
      명령문2
      break;
  default:
      명령문3
}
```

##### 7.반복문 for
```js
//형식
//조건식에 만족할 때까지 반복
for(초기값; 조건식; 어떤 간격으로){
  실행할 문장
}

for(속성명 in 반복할 대상){

}

//ex1
var store = {snack: 1000, flower: 5000, beverage: 2000};

for(var item in store){
  if(!store.hasOwnProperty(item)) continue;

  console.log(item+'는 가격이 '+store[item]+' 입니다.')
}

//결과
/*
snack은 가격이 1000 입니다.
flower는 가격이 5000 입니다.
beverage는 가격이 2000 입니다.
*/
```

