console.log(Number.isInteger(0));           //true
console.log(Number.isInteger(-1));          //true
console.log(Number.isInteger(777777777777777777777777777777)); //true
console.log(Number.isInteger(null));        //false
console.log(Number.isInteger(0/0));         //false
console.log(Number.isInteger('Infinity'));  //false  
console.log(Number.isInteger(true));        //false 
console.log(Number.isInteger({}));          //false