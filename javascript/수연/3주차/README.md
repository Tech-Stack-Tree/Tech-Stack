### 1. ES6의 향상된 객체 문법 알아보기 - 단축 속성명  
  
**{변수명}**  
  
```js
var address = 'Seoul';
var members = {};
var addFamily = function(age, name, role){
    this.members[role] = {age, name};
};
var getHeadCount = function(){
    return Object.keys(this.members).length;
};

//family 객체 속성을 변수로 작성, 키 이름을 변수명으로 정의하고 값을 해당 변수에 할당  
var family = {address, members, addFamily, getHeadCount};

family.addFamily(30, 'chleo', 'aunt');
family.addFamily(3, 'lyn', 'niece');
family.addFamily(10, 'dangdangi', 'dog');
console.log(family.getHeadCount()); //3
```

### 2. ES6의 향상된 객체 문법 알아보기 - 속성 계산명   
: 속성 이름을 정의하는 다른 방법으로, 대괄호 [] 안에 식을 넣거나 변수를 대입하여 동적으로 객체 속성들을 생성할 수 있다.    
```js
var obj = {};
for(var i=0; i<4; i++){
    obj['key'+i] = i;
}
console.log(obj);   //{ key0: 0, key1: 1, key2: 2, key3: 3 }

var profile = 'chloe:30';
//객체리터럴 정의
//profile 변수를 [] 안에 넣으면, 해당 변수 값이 속성명으로 정의된다.
var person = {
    [profile] : true,
    [profile.split(':')[0]]: profile.split(':')[1]
};
console.log(person); //{ 'chloe:30': true, chloe: '30' }
```


### 3. ES6의 향상된 객체 문법 알아보기 - 비구조화 할당
배열이나 객체의 값을 새로운 변수에 쉽게 할당  
- ES6 이전에는 변수 하나에 값 하나를 일일이 했어야 했지만, 비구조화 할당을 통해 손쉽게 값을 할당할 수 있다.  

예제1)   
```js
var obj = {a:1, b:2, c:30, d:44, e:5};

var {a, c} = obj;
console.log(`a >>> ${a}`);  //a >>> 1
console.log(`c >>> ${c}`);  //c >>> 30

//기존 속성명의 값을 가져와서 새로운 변수명에 할당하여 정의할 수 있다.
//-> 구분자 ':'를 사이에 두고 왼쪽에 객체의 속성명을, 오른쪽에는 새로운 변수명을 넣으면 된다.
var {a:newA=10, f:newF=5} = obj;    //객체 a의 속성 값을 새로운 변수 newA에 할당하되, unfined로 값이 없는 경우 기본 값으로 10을 할당한다는 의미
console.log(`newA >>> ${newA}`);    //newA >>> 1
console.log(`newF >>> ${newF}`);    //newF >>> 5
```

예제2)    
```js
var arr = [1,2,30,44,5];

var [b, c, ... rest] = arr;
console.log(`0) b >>> ${b}`);       //0) b >>> 1
console.log(`0) c >>> ${c}`);       //0) c >>> 2
console.log(`0) rest >>> ${rest}`); //0) rest >>> 30,44,5

var [a=10, f=9] = [1];
console.log(`1) a >>> ${a}`);       //1) a >>> 1  
console.log(`1) f >>> ${f}`);       //1) f >>> 9

[a,f]=[f,a];
console.log(`2) a >>> ${a}`);       //2) a >>> 9
console.log(`2) f >>> ${f}`);       //2) f >>> 1

function getArr(){
    return [1,2,3,4,5,6];
}

[a,,,,,f] = getArr();
console.log(`3) a >>> ${a}`);       //3) a >>> 1
console.log(`3) f >>> ${f}`);       //3) f >>> 6
```

### 4. 심볼형 이해하기
``` js
const symbol = Symbol();
const hello = Symbol('hello');

console.log(Number(3)===Number(3));                 //true
console.log(Symbol('symbol')===Symbol('symbol'));   //false -> symbol은 늘 고유한 값을 반환
console.log(Symbol()===Symbol());                   //false
console.log(typeof Symbol());                       //symbol

const nationility = Symbol('nationility');
const user = {
    name: 'jay'
};
user[nationility] ='korean';                        //symbol은 객체 키로 사용가능하다.
console.log(user[nationility]);                     //korean

for(let key in user){
    console.log(key);                               //name
}
//심볼이 객체키로 사용되면 for-in을 통해 심볼키를 가져올 수 없다.
console.log(Object.keys(user));                     //[ 'name' ]
console.log(Object.getOwnPropertyNames(user));      //[ 'name' ]
console.log(JSON.stringify(user));                  //{"name":"jay"}

const symbolProperties = Object.getOwnPropertySymbols(user);  // Object.getOwnPropertySymbols()메소드를 통해 심볼키 가져올 수 있다.
console.log(symbolProperties);                      //[ Symbol(nationility) ]
console.log(user[symbolProperties[0]]);             //korean
```

### 5. 함수 이해하기
``` js
//함수 표현식으로 함수를 만든다. 함수를 정의하면서 동시에 변수 greeting_expression에 바로 할당한다.
//greeting_expression 변수에 함수 리터럴을 할당한다.
var greeting_expression = function(name){
    console.log('Hi, '+name);
}

//일반적인 함수 선언문
function greeting_declaration(name){
    console.log('Hi, '+name);
}

greeting_expression('Chloe');   //Hi, Chloe
greeting_declaration('Chloe');  //Hi, Chloe
```

### 6. 예외 처리하기
예제1)  
``` js
function checkNumber(val){
    if(typeof val != 'number') throw '유효하지 않은 값입니다.';
    console.log('숫자형 값으로 확인되었습니다.');
}

checkNumber(100);           //숫자형 값으로 확인되었습니다.
checkNumber('Wrong type');  //if(typeof val != 'number') throw '유효하지 않은 값입니다.';
console.log('완료');        //출력 안됨
```

예제2)  
``` js
function checkNumber(val){
    if(typeof val != 'number') throw '유효하지 않은 값입니다.';
    console.log('숫자형 값으로 확인되었습니다.');
}


try{
    checkNumber(100);                             //숫자형 값으로 확인되었습니다.
    checkNumber('Wrong type');
}catch (e){
    console.log(`에러가 발생했습니다 >>> ${e}`);  //에러가 발생했습니다 >>> 유효하지 않은 값입니다.
}finally{
    console.log('완료');                          //완료

}
```

### 7. arguments 객체 이해하기  
전달인자(argument): 자바스크립트 함수에서의 매개변수로, 함수가 호출될 때 전달되는 값(함수 선언 시 작성되지 않는다.)  
``` js
function sum(){
    var total = 0;
    for(var i=0; i<arguments.length; i++){
        total += arguments[i];
    }
    console.log(arguments instanceof Array);  //false -> argument 객체는 배열이 아니다.
    return total;
}

var sumOf1to3 = sum(1,2,3);
console.log(sumOf1to3);    //6

function testArg(){
    var newArr = Array.prototype.slice.call(arguments);    //배열로 변경
    console.log(newArr);                    //["a","b"]
    console.log(newArr.indexOf('b'));       //1
    console.log(arguments.indexOf('b'));    //TypeError
}

testArg('a', 'b');
```
  
### 8. 함수 기본 매개변수 처리하기  
*기본 매개변수*: 매개변수를 정의할 때 기본으로 할당될 인자값과 함께 작성하는 매개변수  
값을 할당하는 연산자인 '='를 사용하여 정의  
  
``` js
function drawChart(width=200, height=400){
    console.log(`${width} X ${height} 차트를 그립니다.`);
}
drawChart(100);     //100 X 400 차트를 그립니다.
drawChart();        //200 X 400 차트를 그립니다.

function drawChart2(width=200, height=width/2){
    console.log(`${width} X ${height} 차트를 그립니다.`);
}
drawChart2(300);    //300 X 150 차트를 그립니다.
drawChart2();       //200 X 100 차트를 그립니다.
```

### 9. 함수 나머지 매개변수 이해하기
*나머지 매개변수*: 매개변수를 정의할 때 정해지지 않은 매개변수들을 정의할 수 있게 한다.  
- arguements객체와 유사하나, argument객체는 함수에 전달되는 모든 전달인자를 포함  
- but, 나머지 매개변수는 정해지지않은 나머지를 의미
- 매개변수 작성하는 곳에서 작성하고, 다른 매개 변수와의 차이점을 두기 위해 ... 연산자와 함께 작성

``` js
function(parameter, ....restParameter){
  //arguments 객체는 나머지 매개변수와 다르게 함수 몸통에서만 사용한다.
```
  
``` js
function sum(...args){
    var total = 0;
    for(var i=0; i<args.length; i++){
        total += args[i];
    }
    console.log(args.indexOf(1));  //0 -> 값 1이 들어있는 index는 0
    return total;
}
console.log(sum(1,2,3));           //6

function sum2(a, b, ...others){
    var total = a+b;

    for(var i=0; i<others.length; i++){
        total += others[i];
    }

    return total;
}

console.log(sum2(1,2));             //3
console.log(sum2(1,2,3,4));         //10
```
