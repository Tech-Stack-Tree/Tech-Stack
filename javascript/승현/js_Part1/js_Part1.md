# 📓JS 자료형

**자바 스크립트의 타입**

- `원시 타입`
    
    : 값이 변수에 할당될 때 메모리 상에 고정된 크기로 저장
    
    해당 변수가 직접 값을 보관한다. 
    
    변경 불가능한 값, 불변값인 특징
    
    ex) 숫자형, 불린형, 문자형, 심볼형, null, undefined
    
- `참조타입`
    
    : 원시 타입과 달리 변수에 고정된 크기를 저장하지 않고, 값의 메모리 주소를 참조한다.
    
    객체는 속성들의 집합**,** 집합 내부에는 순서도 크기도 고정되어 있지 않다.
    
    - 객체 : {}안에 키:값 형태로 이루어진 속성들의 모음이다. 키는 문자형이어야한다.
 
# 반복문

특정 코드를 반복하는 흐름을 제어

```jsx
for(초기값; 조건식;어떤 간격으로) {
		실행할 문장
}
```

```jsx
for (var i = 0; i < 10; i++) {
  console.log(i + "번째 반복 문장입니다.");
}
```


- **For문을 이용한 다양한 활용**
    
    continue : 지시자가 놓인 지점 다음의 문장들은 무시되고 다음 반복으로 넘어가게 한다.
    
    break:  break가 있는 지점까지만 실행되고 반복문을 종료한다.


```jsx
for (var i = 0; i < hometown.length; i++) {
  var h = hometown[i];
  if (!h || !h.city) continue;

  console.log(i + "번째 실행입니다.");

  if (h.name === "호석") {
    console.log(
      h.name + "의 고향은 " + h.city + " " + h.place + " " + "입니다."
    );
    break;
  }
}
```

![js2](https://github.com/Tech-Stack-Tree/Tech-Stack/assets/79103761/b8e4e3b9-af48-459c-86fa-7832f4f82639)

- **For-in 반복문**

in 키워드를 사용한다. 오른쪽에는 **반복할 대상 변수들**, 왼쪽에는 **속성명 작성**

```jsx
for(속성명 in 반복할 대상) {

}

```

```jsx
var store = { snack: 1000, flower: 5000, beverage: 2000 };

for (var item in store) {
  if (!store.hasOwnProperty(item)) continue;

  console.log(item + "(은)는 가격이 " + store[item] + "입니다.");
}
```

hasOwnProperty() : store 객체에 item 키 정보가 있는지 확인, 없으면 continue를 통해 실행하지 않는다.

→ 내장 속성, 내장 속성은 별도로 정의하지 않고도 언제든지 사용할 수 있다.

![js3](https://github.com/Tech-Stack-Tree/Tech-Stack/assets/79103761/1989a6d2-02d4-4353-ac0b-9fb3b893a699)


## While문


while() ⇒ 조건식의 결과값은 true, false만 가능하다.

- do-while 반복문

→ 조건 결과와 상관없이 무조건 문장을 실행한다. 

```jsx

do {
	반복하게 될 문장
}while(조건식)
```

```jsx
var hometown = [
  { name: "진", city: "과천" },
  { name: "남준", place: "일산", city: "고양" },
  { name: "호석", place: "광주", city: "전라도" },
  { name: "지민", place: "부산", city: "경상도" },
];

var isHometown = function (h, name) {
  //인자 값을 받는 h와 name을 받는 isHometown() 선언한다.
  console.log(`함수가 실행되었습니다. ${h.city} 도시에서 ${name} 을 찾습니다.`);

  if (h.name === name) {
    console.log(`${h.name}의 고향은 ${h.city} ${h.place} 입니다.`);
    return true; //값이 동일하면 true반환
  }

  return false; //아니면 false 반환
};

var h;
while (h == hometown.shift()) {
  if (!h.name || !h.place || !h.city) continue;

  var result = isHometown(h, "호석");
  if (result) break;
}

var i = 0;
var names = ["남준", "정국", "윤기", "호섭"];
var cities = ["경기", "부산", "대구", "광주"];
do {
  hometown[i] = { name: names[i], city: cities[i] };
  i++;
} while (i < 4);

console.log(hometown);
```
