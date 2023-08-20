### 1. 문자열을 숫자형 정수로 변환하기(parseInt)  
- **parseInt()**: 문자열 자료형을 숫자로 변환할 수 있다.  
- 어떤 내장함수 객체에도 속하지 않은, 전역에서 사용할 수 있는 내장 함수   
(형식) parseInt(값, 진수);  

ex65.js   
```js
console.log(parseInt('15'));        //15
console.log(parseInt('15', 10));    //15
console.log(parseInt('15', 2));     //1 문자15를 2진수 숫자로 변환
console.log(parseInt(5.15));        //5
console.log(parseInt('5.15'));      //5
```

</br>

### 2. 실수형 숫자로 변환하기(parseFloat)  
- **parseFloat()**: 대입된 값을 부동 소수점 숫자로 변환한다.  
- 값에 기호가 아닌 다른 값이 들어오는 경우는 생략된다.  
(형식) parseFloat(값)      
   
ex66.js   
```js
console.log(parseFloat(5.55));                  //5.55
console.log(parseFloat('5.55'));                //5.55
console.log(parseFloat('5.55 숫자의 결과값'));   //5.55 - 5.55 이외의 다른 문자 또는 공백은 생략
```

  

