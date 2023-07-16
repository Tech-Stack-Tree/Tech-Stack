# 🤖객체 이해하기

자바스크립트의 객체(Object)

여러 개의 값을 한번에 접근 할 수 있도록 자바스크립트는 **객체**를 제공

객체 : **값들을 그룹으로 묶은 데이터 모음**

→ 키(Key)와 값(Value)을 한쌍으로 정의하며 이를 **속성(Properties)**라 한다.

***JSON(JavaScript Object Notation)**

자바스크립트의 객체와 매우 유사한 구조를 지닌 **데이터 교환 형식(format)**

키 : 값 쌍의 모음들로 이루어져 있음.

{”key” : Value}

```jsx
var family = {
  address: "seoul",
  members: {},
  addFamily: function (age, name, role) {
    this.members[role] = {
      age: age,
      name: name,
    };
  },

  getHeadcount: function () {
    return Object.keys(this.members).length;
  },
};

family.addFamily(30, "chloe", "aunt");
family.addFamily(3, "lyn", "niece");
family.addFamily(10, "lee", "dog");
console.log(family.getHeadcount());
```

→ 3이 출력된다.

1) ‘address’에 ‘seoul’인 속성을 객체에 추가

2) addFamily() 함수 표현식으로 키 값으로 함수를 할당한다.

3) this 키워드를 통해 family **객체 내부 속성에 접근**

4) getHeadcount에 함수 리터럴을 할당하고 이 함수의 member의 key들을 모아 배영ㄹ로 반환 → family 객체의 사이즈를 알 수 있다.

5) family.addFamily함수를 호출하여 member을 추가한다.

6) getHeadCount() → member에 추가된 개수를 출력한다.

*Family 객체 내부에 잇는 특정 **속성에 바로 접근**하고, 새로운 속성을 **추가/삭제**

```jsx
var family = {
  address: "seoul",
  members: {},
  addFamily: function (age, name, role) {
    this.members[role] = {
      age: age,
      name: name,
    };
  },

  getHeadcount: function () {
    return Object.keys(this.members).length;
  },
};

family.addFamily(30, "chloe", "aunt");
family.addFamily(3, "lyn", "niece");
family.addFamily(10, "lee", "dog");
// console.log(family.getHeadcount());

var printMembers = function () {
  var members = family.members;

  for (role in members) {
    console.log(
      "role => " +
        role +
        ", name =>" +
        members[role].name +
        ", age => " +
        members[role].age
    );
  }
};

printMembers();

var members = family.members;
members["nephew"] = { age: 3, name: "hyun" };
members.niece = { age: 5, name: "kim" };
delete members.aunt;
delete members["dog"];

printMembers();
```

키워드 delete를 앞에 두고 특정 객체의 속성을 뒤에 작성하면, members 객체에 콤바로 접근한 aunt 속성이 삭제된다.

members.aunt, members[”dog”]

→ 콤마와 대괄호 모드 가능

삭제된 값을 확인하기 위해 printMembers() 다시 출력해서 확인
