### 배열 요소를 분할/변환(from)

Array 내장객체의 메소드 `form()` 

: 대입된 문자열 값을 **구분자 없이 분할**

`Array.from(배열로 변환될 값, 반환될 배열 내부 요소에 대한 callback 함수)`

```jsx
const str = "12345678";

const distributedArr = Array.from(str);
console.log(distributedArr);

const modifiedArr = Array.from(distributedArr, (e1) => e1 * 2);
console.log(modifiedArr);
```

**결과값**

```jsx
[
  '1', '2', '3',
  '4', '5', '6',
  '7', '8'
]
[
   2,  4,  6,  8,
  10, 12, 14, 16
]
```

### 문자열을 특정 구붅에 의해 배열로 나누기(split)

`split` : 문자열을 분리한 후  각각을 배열 요소에 넣는다.const c

```jsx
const capitals = `Pragu ,Czech ,Republic 
Copenhagen, Denmark 
Paris, France 
Madird, Spain 
Rome, Italy`;

capitals.split("\n").forEach((s) => {
  const capital = s.split(",")[0];
  const country = s.split(",")[1];
  console.log(`${capital} is in ${country}`);
});

```

**결과값** 

```jsx
Pragu  is in Czech 
Copenhagen is in  Denmark 
Paris is in  France 
Madird is in  Spain 
Rome is in  Italy
```

### 배열 뒤에 요소 추가하기(push)

자바스크립트 배열 자료형은 `Linked List` 자료구조 형태

앞과 뒤에서 요소를 추가하는 것이 가능

Array 내장객체 메소드 **push 배열 뒤에서 요소 추가**

```jsx
const festa = ["mang"];
festa.push("chimmy");
festa.push("tata");
festa.push("cooky");
festa.push("shooky");
festa.push("koya");
festa.push("rj");

festa.forEach((name) => {
  console.log(name);
});
```

`unshift` : 배열 맨 앞에 요소를 추가하는 함수

`length` : 배열 길이 구하기

`concat` : 배열 합치기

`join` : 배열 요소를 병합하여 하나의 문자열로 변환

```jsx
const dialogue = [

`Fear is the path to the dark side`,
`Fear leads to anger`,
`Anger leads to hate`,
`Hate leads to suffering`,
`I sense much fear in you.`
];

console.log(dialogue.join('.'));
console.log(dialogue.join('.\n'));
```

**결과값**

```jsx
const dialogue = [
  `Fear is the path to the dark side`,
  `Fear leads to anger`,
  `Anger leads to hate`,
  `Hate leads to suffering`,
  `I sense much fear in you.`,
];

console.log(dialogue.join("."));
console.log(dialogue.join(".\n"));
```

`pop()` : 배열 마지막 요소 추출

`slice` : 인덱스의 시작과 끝을 지정하여 배열 요소를 추출

→ `배열.slice(시작 인덱스, 끝 인덱스)`

`splice` : 특정 요소를 삭제하거나 수정

→ `배열.splice(시작 인덱스, 삭제할 요소 개수, 추가될 요소들...)`

- **시작 인덱스**

→ 배열 요소가 변경될 시작 지점

- **삭제할 요소 개수**

→ 시작 인덱스의 위치부터 삭제하고자 하는 개수만큼 요소를 제거

- 추가될 요소들

→ 시작 인덱스부터 해당 요소들이 추가된다.

`indexOf` : 배열의 **특정 요소 위치** 확인하기

→ `배열.indxOf(검색할 값, 시작인덱스)`

`배열.forEach(callback함수)` 

→ **forEach 메소드는 배열 내부 요소를 순환하며, 각 요소에 대해 callback함수 실행**

`배열.sort(function(a,b)` {

return 비교값;

}

sort 메소드는 인자로 **비교 함수를** 대입하여 배열 요소들을 정렬

```jsx
numArr1.sort(function(a,b) { return a-b}); //오름차순
numArr1.sort(function(a,b) { return b-a}); //내림차순
```

`reverse()` : 배열의 순서를 반대로 나열하기

→ 함수 호출 시 **원본 배열을 변형**하기 때문에 주의

`some`:  callback 함수의 return 값이 true를 반환할 때까지만 배열 요소를 순환한다.

true를 반환 → 다음 요소들에 대해서는 더 이상 처리하지 않는다.
