function teacher(name, age, subject) {
  this.name = name;
  this.age = age;
  this.subject = subject;
  this.teach = function (student) {
    console.log(student + "에게" + this.subject + "를 가르칩니다.");
  };
}

const jay = new teacher("jay", 30, "Javascript");
console.log(jay);
jay.teach("bb0");

console.log(jay.constructor);
console.log(jay instanceof teacher);

const jay2 = teacher("jay", 30, "javascript");
console.log(jay2);
console.log(age);
