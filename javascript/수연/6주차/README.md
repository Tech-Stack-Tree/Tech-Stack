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
