

**사용하는 경우**

- 매개변수가 **하나일** 경우 인자를 정의할 때 괄호 생략 가능
- 매개변수가 없거나 둘 이상일 경우 괄호 작성
- 화살표 함수 코드 블록을 지정하지 않고 한 문장으로 작성 시return 문을 사용하지 않아도 **화살표 오른쪽 표현식의 계산 결과값이** 반환
- 화살표 함수 코드 블록을 지정했을 경우 **반환하고자 하는 값에 return문을 작성** → 없으면 undefined가 반환

```jsx
const double = (x) => x + x;
console.log(double(2));

const add = (a, b) => a + b;
console.log(add(1, 2));

const printArguments = () => {
  console.log(arguments);
};

printArguments(1, 2, 3);

const sum = (...args) => {
  let total = 0;
  for (let i = 0; i < args.length; i++) {
    total += args[i];
  }
  return total;
};

console.log(sum(1, 2, 3));

setTimeout(() => {
  console.log("화살표 함수");
}, 10);
```

```jsx
[Running] node "c:\jsSource\047.js"
4
3
[Arguments] {
  '0': {},
  '1': [Function: require] {
    resolve: [Function: resolve] { paths: [Function: paths] },
    main: Module {
      id: '.',
      path: 'c:\\jsSource',
      exports: {},
      filename: 'c:\\jsSource\\047.js',
      loaded: false,
      children: [],
      paths: [Array]
    },
    extensions: [Object: null prototype] {
      '.js': [Function (anonymous)],
      '.json': [Function (anonymous)],
      '.node': [Function (anonymous)]
    },
    cache: [Object: null prototype] { 'c:\\jsSource\\047.js': [Module] }
  },
  '2': Module {
    id: '.',
    path: 'c:\\jsSource',
    exports: {},
    filename: 'c:\\jsSource\\047.js',
    loaded: false,
    children: [],
    paths: [ 'c:\\jsSource\\node_modules', 'c:\\node_modules' ]
  },
  '3': 'c:\\jsSource\\047.js',
  '4': 'c:\\jsSource'
}
6
화살표 함수
```

⇒ conosle에 출력

**객체지향 프로그래밍**

프로그램들을 `객체`들로 구성하고 객체들 간에 서로 상호작용하도록 작성하는 방법

`객체` : **특징적인 행동, 변경가능한 상태를 가진다.**

`메소드` : **특징적인 행동**

`분류(Classfication)` : 객체들을 공통적인 특성을 기준으로 객체를 묶어서 하나의 타입으로 정의하는 작업

### 생성자함수

객체를 생성하는 역할을 하는 함수

**new 키워드를 사용하지 않으면** 일반적인 함수와 동일하게 동작하며 새로

운 객체를 반환하지 않는다.

→ 새로운 타입을 정의하는데 사용한다.

```jsx
function teacher(name, age, subject) {
  this.name = name;
  this.age = age;
  this.subject = subject;
  this.teach = function (student) {
    console.log(student + "에게" + this.subject + "를 가르칩니다.");
  };
}

const jay = new teacher("jay", 30, "Javascript");
console.log(jay);
jay.teach("bb0");

console.log(jay.constructor);
console.log(jay instanceof teacher);

const jay2 = teacher("jay", 30, "javascript");
console.log(jay2);
console.log(age);
```

```
teacher {
  name: 'jay',
  age: 30,
  subject: 'Javascript',
  teach: [Function (anonymous)]
}
bb0에게Javascript를 가르칩니다.
[Function: teacher]
true
undefined
30
```

undefined → 새로운 객체를 반환하지 않아서 jay2는 **undefined**가 된다.

### 프로토타입 기반 상속 이해하기

생성자 함수의 **프로토타입 객체**를 상속한다.

모든 인스턴스는 **해당 생성자 함수의 프로토타입 객체의 속성과 메소드들을 사용**할 수 있다.

```jsx
function Storage() {
  this.dataStore = {};
}

Storage.prototype.put = function (key, data) {
  this.dataStore[key] = data;
};

Storage.prototype.getData = function (key) {
  return this.dataStore[key];
};

const productStorage = new Storage();
productStorage.put("id0001", { name: "키보드", price: 2000 });
console.log(productStorage.getData("id0001"));

function RemovableStorage() {
  Storage.call(this);
}

RemovableStorage.prototype = Object.create(Storage.prototype);
RemovableStorage.prototype.removeAll = function () {
  this.dataStore = {};
};

const productStorage2 = new RemovableStorage();
productStorage2.put("id0001", { name: "키보드", price: 2000 });
productStorage2.removeAll();
const item2 = productStorage2.getData("id0001");

console.log(item2);
```

1) Storage() 생성자 함수 정의

→ 내부 속성 dataSource를 가지고 빈 객체를 할당

2) **put 메소드** 추가

3) **getData 메소드** 추가

4) Storage() 인스턴스는 해당 생성자 함수의 프로토타입을 상속

5) **RemovableStorage 생성자** 함수 정의

6) Storage 함수를 호출하면서 this 전달

7) **Object.create 메소드 → 주어진 인자를 *proto*에 연결한 새로운 객체를 반환한다.** 

→ Removable Storage 생성자 함수에 의해 만들어지는 인스턴스들은 내부에 없는 메소드를 RemovableStorage 생성자 함수의 프로토타입에서 먼저 찾고, 없으면, Storage 생성자 함수의 프로토타입에서 찾는다. → Object.prototype에서까지 찾음

`프로토타입체인` 이라고 한다.

### this이해하기

this는 함수가 어떻게 호출되는지에 따라 동적으로 결정된다.

→ 여러 목적으로 재사용하기 위해 존재

호출되는 방식에 따라 **동적으로 결정된다.**

```jsx
this.valueA = "a";
console.log(valueA);
valueB = "b";
console.log(this.valueB);

function checkThis() {
  console.log(this);
}
function checkThis2() {
  "use strict";
  console.log(this);
}

checkThis();
checkThis2();

function Product(name, price) {
  this.name = name;
  this.price = price;
}
const product1 = Product("가방", 2000);
console.log(window.name);
console.log(window.price);

const product2 = {
  name: "가방2",
  price: 3000,
  getVAT() {
    return this.price / 10;
  },
};

const valueOfProduct2 = product2.getVAT();
console.log(valueOfProduct2);

const calVAT = product2.getVAT;
const VAT2 = calVAT();
console.log(VAT2);

const newCalVAT = calVAT.bind(product2);
const VAT3 = newCalVAT();
console.log(VAT3);

const counter1 = {
  count: 0,
  addAfter1Sec() {
    setTimeout(function () {
      this.count += 1;
      console.log(this.count);
    }, 1000);
  },
};

counter1.addAfter1Sec();

const counter2 = {
  count: 0,
  addAfter1Sec() {
    setTimeout(() => {
      this.count += 1;
      console.log(this.count);
    }, 1000);
  },
};

counter2.addAfter1Sec();
```

1) 브라우저 환경에서 `this`를 **전역에서** 사용하면 전역 객체인 **Window** 객체를 가르킨다. valueA는 **window.valueA**로 해석

console.log(valueA) → console.log(window.valueA)로 해석

2) 함수에서 this사용 → this는 전역객체인 Window를 가리킨다.

함수 내의 코드를 엄격한 모드(자바스크립트 코드를 좀 더 안전하고 엄격하게 작성) this→ undefined가 된다.

3) Product 함수는 **생성자함수로 작성되었다.**

new 키워드 없이 호출되면 → this는 window를 가리킨다.

new 키워드와 함께 호출해야만 **this는 프로토타입 객체와 연결된** 객체가 반환

4) 객체 내에 정의된 함수인 메소드 안에서 this를 사용하고 객체를 통해 메소드를 호출하면 this는 그 객체를 가리킨다.

5) 메소드 안에서 this를 정의했지만 메소드를 다른 변수에 저장하고 그 변수를 통해 호출하면 일반적인 함수 호출이 되어 this는 전역 객체를 가리킨다. 

6) this는 **bind메소드를 통해** 전달한 인자값으로 변경  call과 apply 메소드 또한 this가 가리키는 값으로 변경
