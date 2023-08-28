const arr = [
    {id: 0, name: '혜림', age: 6},
    {id: 1, name: '현일', age: 3},
    {id: 2, name: '현아', age: 5},
    {id: 3, name: '우림', age: 2}
];

const isHyunAHere = arr.some(e1 => e1.name == '현아');
const olderThanSix = arr.some(e1 => e1.age > 6);

console.log(isHyunAHere);   //true
console.log(olderThanSix);  //false