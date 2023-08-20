### 💡문자열 변환

1) 문자열을 **숫자형 정수로** 변환

`parseInt()` : 내장함수 객체에도 속하지 않은, 전역에서 사용할 수 있는 내장 함수이다.

문자열 자료형 → `숫자형`으로 변환

```jsx
console.log(parseInt('15'));
```

2) **실수형 숫자로** 변환하기

`pareFloat(값)` : 대입된 값을 부동 소수점 숫자로 변환한다.

만일 값에 숫자, 소수점, 지수, 기호가 아닌 다른 값이 들어오는 경우는 생략한다.

### 문자열 양 끝의 공백 없애기(trim)

`trim` : 문자열 양 끝의 공백, 탭, 줄바꿈을 제거한다.

```jsx
const sentences = [
  ` ABC abc`,
  `ABC abc      `,
  ` first second third 
forth
sentence
`,
];

const filterSentence = (sentences) => {
  const filtered = [];
  sentences.forEach((s) => {
    filtered.push(s.trim());
  });
  return filtered;
};

console.log(filterSentence(sentences));
```

→ filterSentece 함수는 매개변수로 전달된 배열을 **forEach로 순환하여 각 요소에 접근**

trim()을 적용하여 공백, 탭, 줄바꿈을 삭제하고 필터링된 값들을 배열로 다시 반환

`결과`

```jsx
[ 'ABC abc', 'ABC abc', 'first second third \nforth\nsentence' ]
```

***문자열 자르기(slice)**

`문자열.slice(시작 인덱스, 종료 인덱스)`

두 번째 인자인 종료 인덱스는 선택 사항 → 필수값은 아니다.

```jsx
const sentence = `The sun wil shine on us again`;
console.log(sentence.slice(13));
```

→ shine on us again 출력

slice 메소드는 `음수`도 가능하다. ⇒ 뒤에서부터 시작하여 인덱스를 셈 하면 된다.

***substring()**

slice와 다른 결과 값을 반환한다.

→ 음수를 넣으면 정상적으로 수행하지 않는다.

문자열 길이를 뛰어넘는 숫자를 넣으면 `빈 값`을 반환한다.

***substr()**

`문자열.substr(시작 인덱스, 길이)`

추출하고자 하는 **문자열의 길이를** 정확히 알고 있는 경우 substr메소드를 활용

***toString()**

**값을 문자열을 반환하는 방법**

***concat()**

두 개의 문자열을 하나로 합치기

```jsx
const str1 = `Good afternoon`;
const str2 = `, Good evening`;
const str3 = ', and Good night';
const str4 = `- the Truman show, 1998`;
console.log(str1.concat(str2, str3, str4));
```

### 특정 위치의 문자 반환하기

***charAt()**

문자열에서 인덱스를 가리키고 해당 위치의 문자를 반환한다.

### 특정 문자열 위치 확인하기

***indexOf()**

문자열에서 특정 문자열이 있는지 확인 할 수 있다.

```jsx
const str = "Carpe diem, seize the day";
console.log(`"e"는 ${str.indexOf("e")} 번째 인덱스에 있습니다.`);
console.log(`대문자 "C"는 ${str.indexOf("C")} 번째 인덱스에 있습니다.`);
console.log(`"소문자 "c"는 ${str.indexOf("c")} 번째 인덱스에 있습니다.`);
console.log(`문자열 ",se"는 ${str.indexOf(", se")} 번째 인덱스에 있습니다.`);

const arr = ["Carpe", "diem", "seize", "the", "day"];

const howManyHasE = (arr) => {
  let count = 0;
  arr.forEach((str) => {
    if (str.indexOf("e") > -1) count++;
  });

  return count;
};

console.log(`${arr}에 "e"가 있는 요소는 모두 ${howManyHasE(arr)} 개 입니다.`);
```

```jsx
"e"는 4 번째 인덱스에 있습니다.
대문자 "C"는 0 번째 인덱스에 있습니다.
"소문자 "c"는 -1 번째 인덱스에 있습니다.
문자열 ",se"는 10 번째 인덱스에 있습니다.
Carpe,diem,seize,the,day에 "e"가 있는 요소는 모두 4 개 입니다.
```

***lastIndexOf()**

: 특정 문자열 위치 확인하기

→ 문자열의 **뒤에서부터 일치여부를** 확인

### 특정 문자열 포함 여부 확인

***includes()**

: 일치하는 문자열이 있는 경우 true, 없으면 false

`문자열.includes(문자열, 인덱스`

### 문자열 대소문자 변환하기

toLowerCase()

: 해당 문자열을 **소문자로** 변환하여 반환

toUpperCase()

: 해당 문자열을 **대문자로** 변환하여 반환
