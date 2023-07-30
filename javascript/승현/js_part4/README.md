## 💡자바 스크립트의 스코프(Scope)

: 유효 범위로써 변수와 매개변수가 어디까지 유효한지를 나타낸다.

→ **변수의 접근할 수 있는 범위**

**1) 2가지 타입**

`전역(global)`

전역에 선언되어 있어 언제든지 해당변수에 접근 할 수 있다. 

`지역(local)`

해당 지역에서만 접근 가능하다.

**2) 종류**

`렉시컬 스코프`

코드를 작성하는 시점에 스코프가 결정되어 진다.(정적 스코프)

→ 자바스크립트 대표적

함수 선언 위치에 따라 결정되는 상위 스코프

`다이나믹 스코프`

함수 호출 위치에 따라 결정되는 스코프

```jsx
var a = 10;
console.log(a);

function print() {
  var b = 20;
  if (true) {
    var c = 30;
  }

  console.log(c);
}

print();
console.log(b);
```

코드가 실행하기 전 변수선언/함수선언이 해당 스코프의 최상단으로 끌어 올려진 것 같은 현상을 말한다.

`함수 호이스팅`은 함수 선언이 해당 스코프의 최상단으로 끌어올려지는 현상을 말한다. 하지만 변수의 경우는 호이스팅되지 않고 `undefined` 값으로 초기화된다. 따라서 변수와 함수를 사용하기 전에 선언하는 것이 좋다. 

```jsx
hello();
function hello() {
    console.log("안녕하세요");
}
```

### let변수 선언하기

변수 선언 시 변수의 유효 범위를 블록 범위로 지정할 수 있다.

```jsx
let value = "바깥값";

if(true) {
    console.log(value);
    let value = "안쪽값";
}
```

if 블록 안에서 let 변수를 정의하였기 때문에 value는 if 블록문 안에 위쪽으로 호스팅되어 

실제 let으로 선언이 이루어지기 전까지 일시적으로 접근이 안 되는 영역을 만들고 그 안에서 접근을 하게 되면 에러가 발생한다.

### Const 상수 선언하기

→ let과의 차이점 : 재할당 불가

### 스코프 체인

전역 객체와 중첩된 함수의 스코프의 레퍼런스를 차례로 저장하고, 의미 그대로 각각의 스코프가 **어떻게 연결(chain)되고 있는지를 보여주는 것**

**1) `실행컨텍스트`**

실행 가능한 코드가 실행될 때 생성된다.

전역 코드와 함수 코드

eval과 모듈 코드

→ 전역 코드가 먼저 실행됨

전역 컨텍스트를 만들고 

전역 코드를 순차적 평가

함수 호출문 → 새로운 실행 컨텍스트가 만들어지면서 해당 함수 실행부의 코드를 순차적으로 평가

**Stack을 이용해 실행 컨텍스트를 관리**

**2) `렉시컬 환경`**

- 환경 레코드
- 외부 렉시컬 환경

```jsx
ExecutionContext = {
	LexicalEnvironment : {
	EnvironmentRecord : {
},
	OuterLexicalEnvironment : 참조
}
}
```

### 클로저

함수가 정의될 때의 **렉시컬 환경을 기억하는 함수**

```jsx
function createCounterClosure() {
  let count = 0;
  return {
    increase: function () {
      count++;
    },
    getCount: function () {
      return count;
    },
  };
}

const count1 = createCounterClosure();
const count2 = createCounterClosure();

count1.increase();
count1.increase();

console.log("counter1의 값 : " + count1.getCount());
count2.increase();
console.log("counter2의 값 : " + count2.getCount());
```

count1과 count2 메소드들이 다른 count에 접근하는 것은 **다른 렉시컬 환경의 환경 레코드에서**

count에 접근하는 것.

### 객체 속성 기술자

모든 객체 속성은 자기 자신에 대한 정보를 담고 있는 `속성 기술자`를 가지고 있다.

- **Object.getOwnPropertyDescriptor()**
- **Object.defineProperty() : 해당 속성을 정의**
- value : 값
- enumerable : for…in 루프나 Object.keys 메소드같이 속성을 나열할 때 나열 기능 여부를 정의한다. false일 경우 나열되지 않는다.
- writable : 값을 변경할 수 있는 여부를 정의한다. false일 경우 값이 변하지 않는다.
- configurable : 속성 기술자를 변경할 수 있는 여부를 정의한다. false일 경우 속성 기술자를 다시 변경할 수 없다.

```jsx
let user = {
  name: "lee",
};

let descriptor = Object.getOwnPropertyDescriptor(user, "name");
console.log(descriptor);

let user2 = {};
Object.defineProperty(user2, "name", {
  value: "lee",
  enumerable: true,
  configurable: true,
  writable: false,
});

console.log(user2.name);
user2.name = "bbo";
console.log(user2.name);
let user3 = {
  name: "lee",
  toString() {
    return this.name;
  },
};

Object.defineProperty(user3, "toString", {
  enumerable: false,
});

for (let key in user3) {
  console.log(key);
}

let user4 = {};
Object.defineProperty(user4, "name", {
  value: "lee",
  configurable: false,
});
delete user4.name;
console.log(user4);
Object.defineProperty(user4, "name", {
  writable: true,
});
```
