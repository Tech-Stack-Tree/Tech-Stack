//Teacher 생성자 함수 정의
function Teacher(name, age, subject){
    this.name = name;
    this.age = age;
    this.subject = subject;
    this.teach = function(student){
        console.log(student+'에게 '+this.subject+'를 가르칩니다.');
    };
}

//new 키워드와 함께 생성자함수를 호출하면 생성자 함수 블록이 실행 
//별도의 return문 없어도 새로운 객체가 반환된다.
const jay = new Teacher('jay', 30, 'JavaScript');
console.log(jay);
/*
Teacher {
  name: 'jay',
  age: 30,
  subject: 'JavaScript',
  teach: [Function (anonymous)]
}
*/
jay.teach('bbo');   //bbo에게 JavaScript를 가르칩니다.

//모든 객체는 constructor 속성을 가진다. -> 객체를 만든 생성자 함수를 가르킨다.
console.log(jay.constructor);   //[Function: Teacher]
//instanceof 연산자를 이용하여 jay 객체가 Teacher 생성자 함수의 인스턴스임을 확인.
console.log(jay instanceof Teacher);    //true

const jay2 = Teacher('jay', 30, 'JavaScript');
console.log(jay2);  //undefined
console.log(age);   //30