const str = '12345678';

const distributedArr = Array.from(str);
console.log(distributedArr);
/*
[
  '1', '2', '3',
  '4', '5', '6',
  '7', '8'
]
*/

const modifiedArr = Array.from(distributedArr, e1 => e1*2);
console.log(modifiedArr);
/* 
[
   2,  4,  6,  8,
  10, 12, 14, 16
]
*/