//표준 내장객체에 new를 이용하여 생성자를 만들고 변수에 선언한다.
const str = new String('자바스크립트');
const num = new Number(200);
const bool = new Boolean(true);
const date = new Date();
const map = new Map();
const set = new Set();

//어떤 객체는 선언없이 객체의 메소드와 속성을 바로 가져다 사용가능하다.
console.log(Math.PI);                   //3.141592653589793
console.log(Date.parse('2019-01-01'));  //1546300800000
console.log(JSON.parse('{}'));          //{}