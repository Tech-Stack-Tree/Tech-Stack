const str = 'JavaScript';
const strObj = new String('JavaScript');
const num = 200;
const numObj = new Number(200);
const bool = true;
const boolObj = new Boolean(true);
const func = function(){};
const arr = [10, 200, 4000];
const obj = {a1: 'test'};
const empty = null;
const notCalled = undefined;

console.log(typeof str === 'string');       //true
console.log(typeof strObj === 'object');    //true
console.log(typeof num === 'number');       //true
console.log(typeof numObj === 'object');    //true
console.log(typeof bool === 'boolean');     //true
console.log(typeof boolObj === 'object');   //true
console.log(typeof func === 'function');    //true
console.log(typeof arr === 'object');       //true
console.log(typeof obj === 'object');       //true
console.log(typeof empty === 'object');     //true
console.log(typeof notCalled === 'undefined');  //true

console.log('---------------------------');  
console.log(str instanceof String);         //false
console.log(strObj instanceof String);      //true
console.log(num instanceof Number);         //false
console.log(numObj instanceof Number);      //true
console.log(bool instanceof Boolean);       //false
console.log(boolObj instanceof Boolean);    //true
console.log(func instanceof Function);      //true
console.log(arr instanceof Array);          //true
console.log(arr instanceof Object);         //true
console.log(obj instanceof Object);         //true
console.log(empty instanceof Object);       //false
console.log(notCalled instanceof undefined);  //error!