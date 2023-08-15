## 💡모듈이란?

파일이나 코드의 묶음 단위로 애플리케이션 하나의 구성요소로 볼 수 있다.

→ 재사용 가능

함수 안에서 선언된 변수는 함수 내부에만 접근이 가능하므로 `비공개 영역`이 된다.

***ES6의 모듈**

자바스크립트 코드를 담고 있는 하나의 파일이다.

하나의 파일이 하나의 모듈

`import`와 `export` 키워드를 사용

***import :** export한 코드를 가져온다.

```
import { hello } from "./hello.js";

hello(`es6 module`);
```

***export** : 모듈 내의 특정 코드를 외부에서 사용할 수 있다.

```jsx
export function hello(name) {
  console.log(`hello ${name}`);
}
```

→ 두 모듈은 `의존관계`를 형성한다. 

- ********************런타임 로딩 :******************** 의존관계가 형성된 모듈들을 애플리케이션이 구동 시점에 비동기 HTTP 요청으로 불러오고 실행됩니다.
- **번들링 :** 의존관계가 형성된 모듈들을 하나의 파일로 묶는다. 애플리케이션이 구동할 때 묶여진 파일을 로드한다. ex) 웹팩(Webpack) → js코드 외에 CSS,이미지, 폰트 등 다양한 자원들을 **모듈화시킴**

### default 키워드 사용

모듈에서 기본으로 내보내는 값을 정의

→ 객체, 함수, 클래스와 같은 참조형 값 모두 올 수 있다.

```jsx
export default "hello";

export default function hello(name) {
    console.log('hello' + name);
};

export default class Hello {
    constructor(greeting) {
        this.greeting = greeting;
    }

hi(name) {
 console.log(`${this.greeting} ${name}`);   
}
}
```

→ 하나의 모듈에서 `한 번만` 사용 가능

default 다음에는 var, let, const 사용 불가

### 모듈을 여러 이름으로 내보내고 가져오기

**기본값(default)**와는 다르게 이름이 있기 때문에 **중복되지** 않는 한 여러 이름있는 것들을 내보낼 수 있다.

```jsx
export const version = "v1.0";

export var personA = {
  name: "a",
};

export function add(a, b) {
  return a + b;
}

export class Person {
  constructor(name) {
    this.name = name;
  }
}
```

### 표준 내장 객체 이해하기

전역 스코프(scope) 안에 있는 객체들을 참조하고 있어 자바스크립트를 실행할 대 어떤 환경이라도 전역에서 사용 가능

→함수 몸통에 내장 함수 객체의 행위를 특징화 하는코드들이 구현

```jsx
const str = new String("자바스크립트");
const num = new Number(200);
const bool = new Boolean(true);
const date = new Date();
const map = new Map();
const set = new Set();

console.log(Math.PI);
console.log(Date.parse("2019-01-01"));
console.log(JSON.parse("{}"));
```

### 자료형 확인하기(typeOf, instanceof)

`typeof` : 특정 원시 자료형 확인, 원시 자료형과 객체형을 구분

`instanceof` : 객체를 확인하고 싶으면

*Number객체의 **isNaN** 메소드는 

NaN → true 반환/아니면 false

verifyNumber()을 통해 → NaN여부를 검증하여 모든 값이 정상 숫자임을 확인

```jsx
function verifyNumber(n) {
  if (Number.isNaN(n) || !n) return 0;
  return n;
}

const num1 = verifyNumber(15);

const num2 = verifyNumber(undefined);

const num3 = verifyNumber(null);

const num4 = verifyNumber(NaN);

console.log(num1 + num2 + num3 + num4);
```

`isInteger()` : **정수인지 아닌지** 확인

`isArray` : **배열 자료형** 여부를 true/false로 간단하게 구현

→ Arrays.isArray(배열)

```jsx
function callRoll(students) {
  if (!Array.isArray(students)) return;

  students.forEach((student) => {
    console.log(`Are u here, ${student}`);
  });
}

const students = ["LEE", "KIM", "PARK", "TOBY"];
callRoll(students);
```
