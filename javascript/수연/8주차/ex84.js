const prevList = [1, 2, 3];
const currentList = [4, 5, 6];
const nextList = [7, 8, 9];

console.log(prevList.concat(currentList));          //[ 1, 2, 3, 4, 5, 6 ]
console.log(prevList.concat(currentList, nextList));
/*
[
  1, 2, 3, 4, 5,
  6, 7, 8, 9
]
*/

console.log(['배열'.concat('합치기')]);                     //[ '배열합치기' ]
console.log(['배열'.concat('합치기', 'JavaScript200')]);    //[ '배열합치기JavaScript200' ]