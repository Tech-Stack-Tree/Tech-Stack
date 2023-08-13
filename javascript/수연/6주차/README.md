### 1. 모듈 이해하기  
- 모듈 : 파일이나 코드의 묶음 단위로, 애플리케이션 하나의 구성요소  
- 모듈로 정의하면, 모듈 단위로 코드를 재사용할 수 있다.    
- 하나의 애플리케이션이라는 큰 기능을 작은 기능 단위로 잘게 분리하여 관리할 수 있다.  
ex) 베이스볼 게임(애플리케이션) : 문제 생성 모듈, 플레이어 관리 모듈, 정답 채점 모듈 등..  
  
#### 네임스페이스 패턴을 통해 모듈 정의하기(- ECMAScript5.x 버전까지 사용)
- C# 언어에서 제공하는 기능으로, 코드를 그룹화하고 이름 충돌을 방지하게 도와준다.  
- js에서는 직접적으로 지원하지 않는다. -> 함수를 정의함과 동시에 실행하는 즉각 호출 패턴을 통해 네임스페이스를 유사하게 구현할 수 있다.  
- 기본적으로 함수와 변수를 선언하면, 전역으로 정의되어 다른 라이브러리나 타인의 코드에서 정의된 이름과 충돌 날 수도 있기 때문  
  
```js
//즉각호출패턴인 (function(){//코드}();를 통하여 namespaceA의 변수에 함수에서 반환된 변수를 할당한다.
var namespaceA = (function(){
    var privateVariable = '비공개 변수';  //함수 안에 선언된 변수는 함수 내부에서만 접근가능 - 비공개 영역
    return {
        publicApi : function(){
            console.log(privateVariable + '를 접근할 수 있습니다.');
        }
    }
})();

namespaceA.publicApi(); //비공개 변수를 접근할 수 있습니다.
```


### 2. 모듈 시스템 이해하기  
- ES6의 모듈은 자바스크립트 코드를 담고 있는 하나의 파일  
- 하나의 파일 = 하나의 모듈  
- ES6의 모듈은 엄격한 모드의 코드이고, import와 export키워드를 사용한다.  
  - import 키워드: export한 코드들을 가지고 올 수 있다.  
  - export 키워드 : 모듈 내의 특정 코드를 외부에서 사용할 수 있다.    

예제1)   
ex56.js  
```js
//hello함수를 정의하고 이 함수를 export 키워드를 이용하여 외부에서 가져올 수 있게 내보낸다.
export function hello(name){
    console.log(`hello ${name}`);
}
```

ex56-1.js  
```js
//ex56.js의 hello 함수를 import키워드를 이용해 가지고 온다.
import {hello} from './ex56.js';

hello('es6 module'); //hello es6 module
```

=> 하나의 모듈이 다른 모듈에서 내보낸(export) 코드를 가져오면(import) 두 모듈은 서로 의존하게 되어 의존 관계가 형성되고,  
여러 모듈들은 의존 관계를 맺어 의존 관계 그래프가 형성되게 된다.  


**ES6의 모듈 분류** : 정의된 파일을 실행하는 방법에 따라  
1. 런타임 로딩(Runtime Loading): 의존 관계가 형성된 모듈들을 애플리케이션이 구동 시점에 비동기 HTTP 요청으로 불러오고 실행된다.  
   - 모듈 로더가 필요함 (system.js 나 require.js를 이용할 수 있다.)  
2. 번들링(Bundling): 의존 관계가 형성된 모듈들을 하나의 파일로 묶어준다. 그리고 애플리케이션이 구동할 때 묶어진 이 파일을 로드한다.  
   - 개발 시점에 이루어짐  
   - 브라우저 x, 대체로 node.js 환경에서 이루어진다.
   - 대표적인 모듈 번들러: 웹팩(Webpack)
=> 크롬 61버전부터, <script type=modile>을 지원하면서, 별도의 로더 없이 ES6 모듈을 사용할 수 있다.   

``` html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Module Sample</title>
    <script type="module" src="ex56-1.js"></script>
</head>
<body>
</body>
</html>
```


### 3. 모듈 기본값 정의하고 가져오기
**ES6 모듈 시스템**
: default 키워드를 사용하여 모듈에서 기본으로 내보내는 값을 정의할 수 있다.   
- 숫자, 문자, 불리언과 같은 기본형의 값과 객체, 함수, 클래스와 같은 참조형 값 모두 올 수 있다.
- default 키워드는 하나의 모듈에서 한 번만 사용할 수 있다.  
- 즉, 한 파일에서는 하나의 값만 default로 정의할 수 있다.  
  
hello.js  
``` js
/*
export default 'hello';

export default function hello(name){
    console.log('hello '+name);
};
*/
export default class Hello {
    constructor(greeting){
        this.greeting = greeting;
    }

    hi(name){
        console.log(`${this.greeting} ${name}`);
    }
}
```
  
ex57.js  
``` js
import hello from "./hello.js";

const koreanHi = new hello('안녕하세요');
koreanHi.hi('하린');    //안녕하세요 하린
```


### 4. 모듈의 여러 이름으로 내보내고 가져오기  
- 이름있는 변수나 함수 혹은 클래스를 export 키워드를 사용하여 내보낼 수 있다.  
- 기본값(default)와는 다르게 이름이 있음-> 중복되지 않는 한 여러 이름들을 내보낼 수 있다.  
  
ex58.js  
``` js
//version 이름으로 상수 정의-> export키워드로 내보내기 
export const version = 'v1.0';

//personA 이름으로 정의된 변수에 객체를 할당 -> export키워드로 내보내기 
export var personA = {
    name : 'a'
};

//add 함수를 선언 -> export키워드로 내보내기
export function add(a,b) {
    return a+b;
}

//Person 클래스를 선언 -> export키워드로 내보내기
export class Person {
    constructor(name){
        this.name = name;
    }
}
```

ex58-1.js  
``` js
import {add, Person, version} from './ex58.js';

const result = add(1,2);
const harin = new Person('하린');

console.log(result);        //3
console.log(harin.name);    //하린
console.log(version);       //v1.0
```

**다른 모듈에서 가져온 이름은 오직 읽기만 가능(다른 값 할당 불가)**
``` js
import {personA} from './hello.js'
personA ='v2'; //오류 발생
```


### 5. 모듈을 다양한 방식으로 사용하기  
#### 예제1)  
version.js  
``` js
export const version = 'v1.0';
```

app.js  
``` js  
//version.js 모듈로부터 version이름으로 내보낸 상수 값을 가져오는데, 
//이 때, as키워드를 사용하면 현재 모듈에서 다른 이름으로 사용할 수 있다.
import {version as moduleVersion} from './version.js';

const version = 'v0';
console.log(moduleVersion); //v1.0
```

**as 키워드**
: export할 때도 사용할 수 있다. 먼저 선언된 이름들을 마지막에 export할 때 다음과 같이 사용가능하다.  
```
const version = 'v1.0';
export {version as ver};
```
=> 가져올 때 ver 이름으로 가져온다.  

#### 예제2)  
add.js  
``` js
export default function add(a,b){
    return a+b;
}
export const version = 'v1.0';
```
  
sideeffect.js  
``` js
console.log('hello!');
window.hello = function hello(name){
    console.log('hello '+name);
}
```
  
ex59.js  
``` js
import * as add from './add.js';
import './sideeffect.js';   //hello!

console.log(add.version);   //v.1.0
const added = add.default(1,2);
console.log(added); //3

hello('harin'); //hello harin
```


### 6. 표준 내장 객체 이해하기  
**표준 내장 객체(Standard Built-in Object)**  
: 전역 스코프(scope)안에 있는 객체들을 참조  
**내장 함수 객체(Built-in Function Object)**: 표준 내장 객체이지만, 함수처럼 호출할 수 있다.  
-> new 지시자를 사용하여 함수 형태로 호출, 생성자(constructor)를 생성한다.  

``` js
//표준 내장객체에 new를 이용하여 생성자를 만들고 변수에 선언한다.
const str = new String('자바스크립트');
const num = new Number(200);
const bool = new Boolean(true);
const date = new Date();
const map = new Map();
const set = new Set();

//어떤 객체는 선언없이 객체의 메소드와 속성을 바로 가져다 사용가능하다.
console.log(Math.PI);                   //3.141592653589793
console.log(Date.parse('2019-01-01'));  //1546300800000
console.log(JSON.parse('{}'));          //{}
```

``` js
//자바스크립트에서는 원시 자료형이 각 성격에 맞게 표준 내장 객체로 자동으로 매핑된다.
//즉, 문자열로 작성된 값이 String 객체로 래핑된다는 의미
const str1 = '자바스크립트 200제';  
const str2 = new String('자바스크립트 200제');

//typeof: 변수에 할당된 값에 대한 자료형 정보를 문자열로 반환한다.
console.log(typeof str1);   //string
console.log(typeof str2);   //object

console.log(str1 === '자바스크립트 200제');             //true
console.log(str2 === new String('자바스크립트 200제')); //false

console.log(str1.valueOf());    //자바스크립트 200제
console.log(str2.valueOf());    //자바스크립트 200제
```  
  
#### 표준 내장 객체의 종류
- Object: 다른 표준 내장 객체의 기본이 되는 일반 객체  
- Number: 숫자형을 감싼 객체로, 숫자형과 관련된 함수와 속성을 갖고 있다.  
- String: 문자형을 감싼 객체로, 문자형을 조작하거나 특정 문자열을 찾고 추출하는 등의 메소드와 속성을 활용할 수 있다.  
- Array: 모든 배열은 Array.prototype을 상속받는다. Array 객체는 리스트처럼 배열 역할을 지니며, 배열요소를 추가/삭제하거나,  
          배열 자체를 순회/변형하는 다양한 메소드와 속성을 지니고 있다.  
- Math: 수리 연산을 하기 위한 속성과 메소드를 지닌 내장 객체이다. 다른 내장 객체와 달리 *Math객체는 new를 통해 인스턴스를 생성하지 않는다.*  
        static으로 정의된 속성과 메소드를 직접 호출해야 한다.  
- Date: 시간과 관련된 객체로, 현재 시간을 비롯하여, 국제 표준시에 따른 시간 변환 계산도 할 수 있다.  
- JSON: JavaScript Object Notation(JSON)을 의미, 이를 다른 자료형으로 변환하거나 다시 JSON으로 변환하는 등의 메소드를 제공하고 있다.  
- RegExp: 정규표현식은 특정 문자열 처리를 위해 사용하는 문자열 패턴 정의를 의미, 적용가능한 문자열 탐색, 비교 등의 문자열 처리메소드를 지원한다.  
- Map: ES6부터 표준으로 추가된 Map 객체는 키 : 값 데이터 구조를 지닌 데이터 집합체(Collection)  
    - 키의 중복성 허용x  
    - 관련 속성, 메소드들을 가지고 있다.  
    - Iterator를 통해 Map 데이터를 순회한다는 특징이 있다.  
- Set: ES6 부터 표준으로 추가된 객체형, 오직 값으로 이루어진 데이터 집합체  
    - 배열과 내부 속성, 메소드 구성이 다름  
    - Iterator로 순회 가능  
    - 값의 중복성을 허용하지 않는다.  


### 7. 자료형 확인하기(typeof, instanceof)
**typeof**: 특정 원시 자료형을 확인하거나, 원시자료형과 객체형을 구분하기 위해 활용하는 것이 좋다.  
**instanceof**: 원시 타입을 확인하는데 적합하지x, 어떤 객체인지 구분하는데 용이하다. 

``` js
const str = 'JavaScript';
const strObj = new String('JavaScript');
const num = 200;
const numObj = new Number(200);
const bool = true;
const boolObj = new Boolean(true);
const func = function(){};
const arr = [10, 200, 4000];
const obj = {a1: 'test'};
const empty = null;
const notCalled = undefined;

console.log(typeof str === 'string');       //true
console.log(typeof strObj === 'object');    //true
console.log(typeof num === 'number');       //true
console.log(typeof numObj === 'object');    //true
console.log(typeof bool === 'boolean');     //true
console.log(typeof boolObj === 'object');   //true
console.log(typeof func === 'function');    //true
console.log(typeof arr === 'object');       //true
console.log(typeof obj === 'object');       //true
console.log(typeof empty === 'object');     //true
console.log(typeof notCalled === 'undefined');  //true

console.log('---------------------------');  
console.log(str instanceof String);         //false
console.log(strObj instanceof String);      //true
console.log(num instanceof Number);         //false
console.log(numObj instanceof Number);      //true
console.log(bool instanceof Boolean);       //false
console.log(boolObj instanceof Boolean);    //true
console.log(func instanceof Function);      //true
console.log(arr instanceof Array);          //true
console.log(arr instanceof Object);         //true
console.log(obj instanceof Object);         //true
console.log(empty instanceof Object);       //false
console.log(notCalled instanceof undefined);  //error!
```


### 8. NaN 값 확인하기(Number.isNaN)
Number 객체의 isNaN 메소드는 NaN을 구별  
- NaN이면 true, 아니면 false 반환  
**NaN**: 전역 객체의 속성으로 Not a Number(숫자가 아님)의 줄임말
  
``` js
console.log(Number.isNaN(NaN));             //true
console.log(Number.isNaN(undefined));       //false
console.log(Number.isNaN('Is it Number?')); //false
console.log(Number.isNaN(0));               //false
console.log(Number.isNaN(null));            //false

console.log(Number.isNaN(-1));              //false  - 음수는 숫자 자료형          
console.log(Number.isNaN(0/0));             //true - 0을 0으로 나누는 것은 정의되지 않은 의미없는 연산
console.log(Number.isNaN(new Date()));      //false - 시간이 long 자료형으로 반환(숫자형)
console.log(Number.isNaN(new Date().toString));//false - 문자형으로 반환
console.log(Number.isNaN('Infinity'));      //false - 무한대(숫자형)
```
  
``` js
function verifyNumber(n){
    if(Number.isNaN(n) || !n) return 0;

    return n;
}

const num1 = verifyNumber(15);          //15
const num2 = verifyNumber(undefined);   //0
const num3 = verifyNumber(null);        //0
const num4 = verifyNumber(NaN);         //0
console.log(num1+num2+num3+num4);       //15
```


### 9. 정수 확인하기(isInteger)

``` js
console.log(Number.isInteger(0));           //true
console.log(Number.isInteger(-1));          //true
console.log(Number.isInteger(777777777777777777777777777777)); //true
console.log(Number.isInteger(null));        //false
console.log(Number.isInteger(0/0));         //false
console.log(Number.isInteger('Infinity'));  //false  
console.log(Number.isInteger(true));        //false 
console.log(Number.isInteger({}));          //false
```
  
``` js
function verifyNumber(n){
    if(!Number.isInteger(n)) return 0;

    return n;
}

const num1 = verifyNumber(15);
const num2 = verifyNumber(Infinity);
const num3 = verifyNumber(0.05);

console.log(num1, num2, num3);  //15 0 0
```
  

### 10. 배열 자료형 확인하기(isArray)
**isArray**: 배열자료형 여부를 true/false로 반환  
  
``` js
function callRoll(students){
    if(!Array.isArray(students)) return;

    students.forEach((student)=> {
        console.log(`Are you here, ${student}`);
    });
}

const students = ['Jun', 'Ali', 'Murry', 'Toby'];
callRoll(students);

/*
Are you here, Jun
Are you here, Ali
Are you here, Murry
Are you here, Toby
*/
```
