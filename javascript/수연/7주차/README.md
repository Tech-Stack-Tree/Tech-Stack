### 1. 문자열을 숫자형 정수로 변환하기(parseInt)  
**parseInt()**: 문자열 자료형을 숫자로 변환할 수 있다.  
- 어떤 내장함수 객체에도 속하지 않은, 전역에서 사용할 수 있는 내장 함수   
(형식) parseInt(값, 진수);  

```js
console.log(parseInt('15'));        //15
console.log(parseInt('15', 10));    //15
console.log(parseInt('15', 2));     //1 문자15를 2진수 숫자로 변환
console.log(parseInt(5.15));        //5
console.log(parseInt('5.15'));      //5
```  
  
</br>

### 2. 실수형 숫자로 변환하기(parseFloat)  
**parseFloat()**: 대입된 값을 부동 소수점 숫자로 변환한다.  
- 값에 기호가 아닌 다른 값이 들어오는 경우는 생략된다.  
(형식) parseFloat(값)      
     
```js
console.log(parseFloat(5.55));                  //5.55
console.log(parseFloat('5.55'));                //5.55
console.log(parseFloat('5.55 숫자의 결과값'));   //5.55 - 5.55 이외의 다른 문자 또는 공백은 생략
```  
  
</br>
  
### 3. 문자열 양 끝의 공백 없애기(trim)  
**trim()**: 문자열 양 끝의 공백, 탭, 줄바꿈을 제거한다.  
- 함수가 적용된 문자열 원본 값에는 영향을 끼치지 않기 때문에, 별도로 값을 저장해야 한다.  

```js
const sentences = ['    ABC abc', 'ABC abc  ', `  first
second third
        forth
sentence

`];

const filterSentence = (sentences) => {
    const filtered = [];
    sentences.forEach(s => {
        filtered.push(s.trim());
    });
    return filtered;
}

console.log(filterSentence(sentences));

/*
[
  'ABC abc',
  'ABC abc',
  'first\nsecond third\n        forth\nsentence'
]
*/
```  
  
</br>

### 4. 문자열 자르기(slice)  
**slice()**: 문자열에서 특정 문자열만 잘라낸다.  
- 인자로 시작 지점의 인덱스와 종료 지점의 인덱스를 받는다.  
- 두번째 인자는 선택사항, 필수 값 x  
- 지정한 범위의 인덱스 문자열을 반환하지만, 기존 문자열에 영향을 주지 않는다.
(형식) '문자열'.slice(시작 인덱스, 종료 인덱스)  
  
``` js
const sentence = 'The sun will shine on us again';
console.log(sentence.slice(13));        //shine on us again
console.log(sentence.slice(13, 24));    //shine on us
console.log(sentence.slice(0));         //The sun will shine on us again
console.log(sentence.slice(0, -23));    //The sun
console.log(sentence.slice(50));        //문자열 길이를 뛰어넘는 숫자-> 빈 값
console.log(sentence.slice(7,2));       //첫번째 인자>두번째인자 -> 정상적으로 수행x
```  

</br>
  
### 5. 문자열 자르기(substring)  
**substring()**: 문자열에서 특정 문자열만 잘라낸다.   
- 인자로 시작 지점의 인덱스와 종료 지점의 인덱스를 받는다.  
- 두번 째 인자인 종료 인덱스는 선택사항, 필수 값 x  
- 실행 결과 값은 새로운 문자열을 반환하며 기존 문자열은 변경되지 않는다.
(형식) '문자열'.substring(시작 인덱스, 종료 인덱스)
  
``` js 
const sentence = 'This will be the end of Wakanda';
console.log(sentence.substring(13));        //the end of Wakanda
console.log(sentence.substring(13, 20));    //the end
console.log(sentence.substring(0));         //This will be the end of Wakanda
console.log(sentence.substring(0, -20));    //음수를 넣으면 정상적으로 실행되지 않는다.
console.log(sentence.substring(50));        //문자열 길이를 뛰어넘는 숫자-> 빈 값
//첫번째 인자> 두번째인자 -> 두 개의 인수를 교환하여 실행한다. sentence.substring(13, 20)
console.log(sentence.substring(20,13));     //the end
```  
  
</br>
  
### 6. 문자열 자르기(substr)  
**substr()**: 문자열에서 특정 문자열만 잘라낸다.   
- 인자로 시작 지점의 인덱스와 길이를 받는다.  
-  두번 째 인자인 종료 인덱스는 선택사항, 필수 값 x
-  지정된 인덱스부터 시작해서 지정된 문자 수 또는 길이만큼의 새 문자열을 반환한다.
(형식) '문자열'.substr(시작 인덱스, 길이)

``` js
const sentence = 'Wakanda Forever!!!';
console.log(sentence.substr(8));        //Forever!!!
console.log(sentence.substr(8, 7));     //Forever
console.log(sentence.substr(0));        //Wakanda Forever!!!
console.log(sentence.substr(-10));      //Forever!!!
console.log(sentence.substr(0, -3));    //두번 째 인자 음수 -> 정상적 실행x
console.log(sentence.substr(30));       //첫번 째 인자에 문자열 길이보다 큰 수를 대입 => 빈 값 반환
console.log(sentence.substr(0, 30));    //Wakanda Forever!!! (두번째 인자는 더 커도 상관x)
```  
  
</br>

### 7. 문자열 길이 구하기(length)    
