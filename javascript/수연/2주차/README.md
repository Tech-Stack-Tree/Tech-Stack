### 1. 자료형 변환 이해하기

```js
console.log("5" + 1);          //51 '+'는 숫자형,문자형따라 
console.log("5" - 1);          //4 '-,*,/'은 무조건 숫자형 반환
console.log("5" * 2);          //10
console.log("There is " + 5);  //There is 5
console.log("Five" * 2);       //NaN

console.log("- 연산자를 활용한 자료형 변환");
var str = 5 + "1";
console.log(str);              //51
console.log(typeof str);       //string

var num = +str;
console.log(num);              //51
console.log(typeof num);       //number

console.log("- 함수를 활용한 자료형 변환");
str = String(num);
console.log(str);               //51  
console.log(typeof str);        //string

num = Number(str);
console.log(num);              //51
console.log(typeof num);       //number
```

### 2. 배열 이해하기
```js
var arr = [1, 2, 3, 4, 5];
console.log(arr.length);    //5
console.log(arr[0]);        //1
console.log(arr[2]);        //3
console.log(arr[8]);        //undefined
```


### 3. 객체 이해하기
여러 개의 값을 한번에 접근할 수 있도록, 객체(object) 제공  

*객체(Object)*  
: 값들을 그룹으로 묶은 데이터 모음  
- 키(Key)와 값(Value)을 쌍으로 정의하며, 이를 속성(Properties)라 함.  
- 하나의 키에는 하나의 값이 매핑

예제1)  
```js
var family = {
  'address':'Seoul',
  members : {},
  addFamily: function(age, name, role) {
    this.members[role] = {
      age: age,
      name: name
    };
  },
  getHeadcount : function() {
    return Object.keys(this.members).length;
  }
};

family.addFamily(30, 'chloe', 'aunt');
family.addFamily(3, 'lyn', 'niece');
family.addFamily(10, 'dangdangi', 'dog');
console.log(family.getHeadcount());        //3
```

예제2)  
```js
var family = {
  'address':'Seoul',
  members : {},
  addFamily: function(age, name, role) {
    this.members[role] = {
      age: age,
      name: name
    };
  },
  getHeadcount : function() {
    return Object.keys(this.members).length;
  }
};

family.addFamily(30, 'chloe', 'aunt');
family.addFamily(3, 'lyn', 'niece');
family.addFamily(10, 'dangdangi', 'dog');

var printMembers = function() {
  var members = family.members;
  for (role in members){
    console.log('role => '+ role + ', name => '+ members[role].name + ', age => ' +members[role].age);
  }
};
printMembers();

var members = family.members;
members['nephew'] = {age:3, name:'nephew'};
members.niece = {age: 5, name: 'lyn'};
delete members.aunt;
delete members['dog'];
printMembers();

//결과
//role => aunt, name => chloe, age => 30
//role => niece, name => lyn, age => 3
//role => dog, name => dangdangi, age => 10

//role => niece, name => lyn, age => 5
//role => nephew, name => nephew, age => 3
```
  
