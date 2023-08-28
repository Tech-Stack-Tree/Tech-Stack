const str = "12345678";

const distributedArr = Array.from(str);
console.log(distributedArr);

const modifiedArr = Array.from(distributedArr, (e1) => e1 * 2);
console.log(modifiedArr);
