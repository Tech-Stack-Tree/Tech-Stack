### 1. 화살표 함수 이해하기
- ES6에서 추가된 기능
- function 키워드를 사용하지 x, 연산자 '=>'를 사용하여 정의

#### 화살표 함수 정의 규칙
- 매개변수가 하나일 경우에는 인자를 정의할 때 괄호를 생략할 수 있다.
- 매개변수가 없거나 둘 이상일 경우 괄호를 작성해야 한다.
- 화살표 함수 코드 블록을 지정하지 않고 한 문장으로 작성 시 return 문을 사용하지 않아도 화살표 오른쪽 표현식의 계산 결과값이 반환된다.
- 화살표 함수 코드 블록을 지정했을 경우 반환하고자 하는 값에 return 문을 작성해야 한다. return 문이 없을 시 undefined가 반환된다.
  
```js
const double = x => x+x;
console.log(double(2)); //4

const add = (a,b) => a+b;
console.log(add(1,2));  //3

const printArguments = () => {
    console.log(arguments);
}
printArguments(1,2,3);  //Uncaught ReferenceError: arguments is not defined
//매개변수를 정의 하지 않아, arguments 객체가 만들어지지 않음 -> error

const sum = (...args) => {
    let total = 0;
    for(let i=0; i<args.length; i++){
        total += args[i];
    }
    return total;
}
console.log(sum(1,2,3));    //6

setTimeout(()=> {
    console.log('화살표 함수!');
}, 10);
//화살표 함수!
```


### 2. 자바스크립트 객체지향 프로그래밍 이해하기
객체지향 프로그래밍 : 프로그램을 객체들로 구성하고 객체들 간에 서로 상호작용하도록 작성하는 방법  

예제1)   
```js
const teacherJay = {
    name : '제이',
    age : 30,
    teachJavascript : function(student){
        student.gainExp();
    }
}

const studentBbo = {
    name : '뽀',
    age : 20,
    exp : 0,
    gainExp : function(){
        this.exp++;
    }
}

console.log(studentBbo.exp);    //0
teacherJay.teachJavascript(studentBbo);
console.log(studentBbo.exp);    //1
```
    
**분류(classification)** : 객체지향에서 무수히 많은 객체들을 공통적인 특성을 기준으로 객체를 묶어서 하나의 타입으로 정의    
js는 **프로토타입 기반** 객체지향 프로그래밍을 지원  
-> 프로토타입으로 객체에 공통 사항을 적용할 수 있다.  
-> 모든 객체는 다른 객체의 **원형(Prototype)** 이 될 수 있다.  
 
``` js
//학생의 경험치를 얻는 행위를 gainExp 메소드로 작성한 원형(prototype) 객체를 정의한다.
const studentProto = {
    gainExp : function(){
        this.exp++;
    }
}

//harin 객체 정의: __proto__ 속성으로 원형 객체를 정의할 수 있다.
//모든 자바스크립트 객체는 __proto__ 속성을 가짐 (default : Object.prototype)
const harin = {
    name : '하린',
    age : 10,
    exp : 0,
    __proto__ : studentProto
};

const bbo = {
    name : "뽀",
    age : 20,
    exp : 10,
    __proto__ : studentProto
};

bbo.gainExp();
harin.gainExp();
harin.gainExp();
console.log(harin); //{ name: '하린', age: 10, exp: 2 }
console.log(bbo);   //{ name: '뽀', age: 20, exp: 11 }
```


### 3. 생성자 함수 이해하기
**생성자 함수**  
- 자바스크립트 함수를 객체를 생성하기 위한 방법으로 사용  
- new 키워드를 사용하여 함수를 호출하면, return 문이 없어도 새로운 객체가 반환  
- 함수 바디에서 this 키워드를 사용하여 반환되는 객체의 초기 상태와 행위를 정의  
- new 키워드를 사용하지 않으면 일반함수와 동일하게 동작하며 새로운 객체를 반환하지 않는다.  
  -> 함수명을 **대문자**로 시작! 
  
``` js
//Teacher 생성자 함수 정의
function Teacher(name, age, subject){
    this.name = name;
    this.age = age;
    this.subject = subject;
    this.teach = function(student){
        console.log(student+'에게 '+this.subject+'를 가르칩니다.');
    };
}

//new 키워드와 함께 생성자함수를 호출하면 생성자 함수 블록이 실행 
//별도의 return문 없어도 새로운 객체가 반환된다.
const jay = new Teacher('jay', 30, 'JavaScript');
console.log(jay);
/*
Teacher {
  name: 'jay',
  age: 30,
  subject: 'JavaScript',
  teach: [Function (anonymous)]
}
*/
jay.teach('bbo');   //bbo에게 JavaScript를 가르칩니다.

//모든 객체는 constructor 속성을 가진다. -> 객체를 만든 생성자 함수를 가르킨다.
console.log(jay.constructor);   //[Function: Teacher]
//instanceof 연산자를 이용하여 jay 객체가 Teacher 생성자 함수의 인스턴스임을 확인.
console.log(jay instanceof Teacher);    //true

const jay2 = Teacher('jay', 30, 'JavaScript');
console.log(jay2);  //undefined
console.log(age);   //30
```


### 4. 프로토타입 기반 상속 이해하기
: 생성자 함수로부터 만들어진 객체는 그 생성자 함수의 프로토타입(prototype) 객체를 상속한다.  
-> 모든 인스턴스는 해당 생성자 함수의 프로토타입 객체의 속성과 메소드 사용 가능  

``` js
//Storage 생성자 함수 정의, 내부 속성으로 dataStore를 가지고 빈 객체를 할당한다.
function Storage() {
    this.dataStore = {};
}
//Storage 생성자 함수의 프로토타입 객체에 put메소드를 추가, put메소드는 주어진 키에 해당하는 값을 dataStore속성에 할당한다.
Storage.prototype.put = function(key, data){
    this.dataStore[key] = data;
}
//Storage 생성자 함수의 프로토타입 객체에 getData메소드를 추가, 매개변수 값을 키로 dataStore속성에서 찾아 반환한다.
Storage.prototype.getData = function(key){
    return this.dataStore[key];
}

const productStorage = new  Storage();  //Storage 타입의 인스턴스 생성 -> put, getData 메소드 사용가능
productStorage.put('id001', {name:'키보드', price: 2000});
console.log(productStorage.getData('id001'));   //{name:'키보드', price: 2000}

//RemovableStorage 생성자 함수 정의
//Storage 생성자 함수가 호출되면서 RemovableStorage 생성자 함수 this에 Storage생성자 함수에서 정의한대로 dataStore가 속성으로 추가된다.
function RemovableStorage(){
    Storage.call(this);
}

//Object.create 메소드 : 주어진 인자를 __proto__에 연결한 새로운 객체를 반환 => 간단히 상속관계를 정의
//Storage 함수 프로토타입 객체가 RemovableStorage 함수의 프로토타입 객체의 __proto__에 할당된다.
RemovableStorage.prototype = Object.create(Storage.prototype);

//RemovableStorage 생성자 함수의 프로토타입 객체에 removeAll 메소드를 추가한다.
RemovableStorage.prototype.removeAll = function() {
    this.dataStore = {}
}

const productStorage2 = new RemovableStorage(); //RemovableStorage 타입의 인스턴스 생성
productStorage2.put('id001', {name: '키보드', price : 2000});
productStorage2.removeAll();
const item2 = productStorage2.getData('id001');
console.log(item2); //undefined
```


### 5. 클래스 정의하기
ES6부터 class 키워드를 통해 클래스를 정의할 수 있다.  
**클래스** : 별도 타입의 객체를 생성하는 설계 도면  
ex) 붕어빵 틀: 클래스/ 붕어빵: 객체  
-> 클래스를 통해 객체가 가져야 할 상태와 행위들을 속성과 메소드로 정의할 수 있다.  
**인스턴스** : 특정 클래스를 통해 만들어진 객체를 해당 클래스의 인스턴스라고 한다.  
  
``` js
//Cart 클래스 정의 -> 클래스 이름의 첫 글자는 대문자
class Cart {
    //생성자 함수
    constructor() {
        this.store = {};
    }

    //메소드 정의
    addProduct(product){
        this.store[product.id] = product;
    }

    getProduct(id) {
        return this.store[id];
    }
}

const cart1 = new Cart();

cart1.addProduct({id: 1, name:'노트북'})   
console.log(cart1.store);   //{'1', {id: 1, name:'노트북'}}

const p = cart1.getProduct(1);
console.log(p);     //{id: 1, name:'노트북'}
```


### 6. 클래스 상속 이해하기
``` js
class Chart {
    constructor(width, height){
        this.width = width;
        this.height = height;
    }

    drawLine(){
        console.log('draw line');
    }
}

class BarChart extends Chart {
    constructor(width, height){
        super(width, height);
    }

    draw() {
        this.drawLine();
        console.log(`draw ${this.width} X ${this.height} barChart`);
    }
}

const barChart1 = new BarChart(100, 100);
barChart1.draw();
/*
draw line
draw 100 X 100 barChart
*/
```


### 7. 클래스 정적 메소드와 속성 정의하기

``` js
```

