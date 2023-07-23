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

```
  
