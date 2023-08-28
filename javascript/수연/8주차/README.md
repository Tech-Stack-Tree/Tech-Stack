### 1. 배열 요소를 분할/변환하기(from)  
**from()**: 대입된 문자열 값을 구분자 없이 분할한다.  
- 분할된 문자는 배열 요소 각각에 대입되어, 결과값으로 배열을 반환한다.  
(형식) Array.from(배열로 변환될 값, 반환될 배열 내부 요소에 대한 callback 함수);  

```js
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
```  
  
</br>

### 2. 문자열을 특정 구분자에 의해 배열로 나누기(split)  
**split()**: 문자열을 배열로 변환하여 반환한다.  
- split 인자로 받은 구분자로 문자열을 분리한 후, 각각을 배열 요소에 넣는다.  
(형식) split(구분자)      
     
```js
const capitals = `Prague,Czech Republic
Copenhagen,Denmark
Paris,France
Madrid,Spain
Rome,Italy`

capitals.split('\n').forEach(s=> {
    const capitals = s.split(',')[0];
    const country = s.split(',')[1];
    console.log(`${capitals} is in ${country}`);
})

/*
Prague is in Czech Republic
Copenhagen is in Denmark
Paris is in France
Madrid is in Spain
Rome is in Italy
*/
```  
  
</br>
  
### 3. 배열 뒤에 요소 추가하기(push)  
**push()**: 배열 뒤에서 요소를 추가한다.  
- 자바스크립트 배열 자료형은 Linked List 자료구조 형태-> 배열 앞과 뒤에서 요소를 추가할 수 있다.  

```js
const festa = ['mang'];
festa.push('chimmy');
festa.push('tata');
festa.push('cooky');
festa.push('shooky');
festa.push('koya');
festa.push('rj');

festa.forEach(name => {
    console.log(name);
})

/*
mang
chimmy
tata
cooky
shooky
koya
rj
*/
```  
  
</br>

### 4. 배열 앞에 요소 추가하기(unshift)  
**unshift()**: 배열 맨 앞에 요소를 추가하는 함수   
  
(형식) '배열'.unshift(문자열);  
  
``` js
const festa = ['mang'];
festa.unshift('chimmy');
festa.unshift('tata');
festa.unshift('cooky');
festa.unshift('shooky');
festa.unshift('koya');
festa.unshift('rj');

festa.forEach(name => {
    console.log(name);
})

/*
rj
koya
shooky
cooky
tata
chimmy
mang
*/
```  

</br>
  
### 5. 배열 길이 구하기(length)  
**length()**: 배열 길이를 확인한다.  
  
  
``` js 
const ship = {
    max: 4,
    passengers: [],
    onBoard: function(name){
        if( this.passengers.length === 4 ){
            console.log(`This ship is full. ${name} can not board this ship.`);
        } else{
            this.passengers.push(name);
            console.log(`${name} boarded.`);
        }
    }
}

ship.onBoard('chloe');
ship.onBoard('jay');
ship.onBoard('david');
ship.onBoard('asher');
ship.onBoard('daniel');
console.log(ship.passengers);

/*
chloe boarded.
jay boarded.
david boarded.
asher boarded.
This ship is full. daniel can not board this ship.
[ 'chloe', 'jay', 'david', 'asher' ]
*/
```  
  
</br>
  
### 6. 배열 합치기(concat)  

``` js
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
```  
  
</br>

### 7. 배열에 특정 구분자 넣어 문자형으로 변환하기(join)   
**join()**: 각 배열 요소를 병합하여 하나의 문자열로 변환한다.  

``` js
const dialogue = [
    'Fear is the path to the dark side',
    'Fear leads to anger',
    'Anger leads to hate',
    'Hate leads to suffering',
    'I sense much fear in you.'
];

console.log(dialogue.join('. '));
/*
Fear is the path to the dark side. Fear leads to anger. Anger leads to hate. Hate leads to suffering. I sense much fear in you.
*/
console.log(dialogue.join('.\n'));
/*
Fear is the path to the dark side.
Fear leads to anger.
Anger leads to hate.
Hate leads to suffering.
I sense much fear in you.
*/
```  
  
</br>


### 8. 배열 마지막 요소 추출하기(pop)   

``` js
const arr = [1, 2, 3];
console.log(arr.pop()); //3
console.log(arr.pop()); //2
console.log(arr.pop()); //1 
console.log(arr.pop()); //undefined
```  
  
</br>
  
  
### 9. 배열 맨 앞 요소 추출하기(shift)   

``` js
const arr = [1, 2, 3];
console.log(arr.shift()); //1
console.log(arr.shift()); //2
console.log(arr.shift()); //3 
console.log(arr.shift()); //undefined
```  
  
</br>
  
  
### 10. 배열 특정 위치의 요소 추출하기(slice)   
**slice()**: 인덱스의 시작과 끝을 지정하여 배열 요소를 추출한다.  
- 끝 인덱스에 있는 요소는 제외하고 그 이전까지의 요소들을 추출한다.
   
(형식) 배열.slice(시작 인덱스, 끝 인덱스);  
  
``` js
const arr = ['melon', 'lemon', 'source', 'apple', 'juice'];
console.log(`과일이 아닌 요소는 ${arr.slice(2,3)}와 ${arr.slice(4,5)} 입니다.`); 
console.log(arr.slice(0, 10));
/*
과일이 아닌 요소는 source와 juice 입니다.
[ 'melon', 'lemon', 'source', 'apple', 'juice' ]
*/
```
  
</br>

    
### 11. 배열 인덱스로 특정 요소 수정하기(splice)   
**splice()**: 특정 위치의 요소를 삭제하거나 수정할 수 있다.    
   
(형식) 배열.splice(시작 인덱스, 삭제할 요소의 개수, 추가될 요소들 ...);     
  
``` js
const fruits = ['melon', 'lemon', 'source', 'apple', 'juice'];

fruits.splice(4, 1);
fruits.splice(4, 0, 'grape');
fruits.splice(2, 0, 'mandarin', 'strawberry', 'watermelon');

console.log(fruits);

/*
[
  'melon',
  'lemon',
  'mandarin',
  'strawberry',
  'watermelon',
  'source',
  'apple',
  'grape'
]
*/
```
  
</br>

    
### 12. 배열의 특정 요소 위치 확인하기(indexOf)   
**indexOf()**: 대입된 값(첫 번째 인자)을 배열 내부에서 검색한다. 값이 일치하는 경우 해당 인덱스를 반환한다.  
   
(형식) 배열.indexOf(검색할 값, 시작 인덱스);     
  
``` js
const arr = ['spring', 'summer', 'fall', 'winter', 'is', 'down'];

console.log(`"winter" is in this index ${arr.indexOf('winter')}`);  //"winter" is in this index 3
console.log(`"winter" is not in here, look this value ${arr.indexOf('winter', 4)}`);    //"winter" is not in here, look this value -1
```
  
</br>

    
### 13. 배열 순환하기(forEach)   
**forEach()**: 배열 내부 요소를 순환하며, 각 요소에 대해 callback 함수를 실행한다.  
   
(형식) 배열.forEach(callback 함수);     
  
``` js
const arr = [
    {id: 0, name: '혜림', age: 6},
    {id: 1, name: '현일', age: 3},
    {id: 2, name: '현아', age: 5},
    {id: 3, name: '우림', age: 2},
];

arr.forEach((e1) =>{
    console.log(e1.name);
})

/*
혜림
현일
현아
우림
*/
```
  
</br>

    
### 14. 배열 정렬하기(sort)   
**sort()**: 배열 내부 요소를 순환하며, 각 요소에 대해 callback 함수를 실행한다.  
  
(형식)   
``` js
배열.sort(function(a,b){
    return 바교값;
});
```  
  
``` js
const numArr1 = [2, 0, 3, 4, 1];
const numArr2 = [2, 0, 3, 4, 1];

const objArr = [
    {id: 2, name: 'Leo'},
    {id: 0, name: 'Daniel'},
    {id: 3, name: 'Asher'},
    {id: 4, name: 'Chloe'},
    {id: 1, name: 'Chloe'}
];

numArr1.sort(function(a, b) { return a-b; });
numArr2.sort(function(a, b) { return b-a; });
objArr.sort(function(a, b) {
    if (a.name > b.name) return 1;
    else if (b.name > a.name) return -1;
    else return 0;
});

console.log(`오름차순 : ${numArr1}`);   //오름차순 : 0,1,2,3,4
console.log(`내림차순 : ${numArr2}`);   //내림차순 : 4,3,2,1,0
console.log(objArr);
/*
[
  { id: 3, name: 'Asher' },
  { id: 4, name: 'Chloe' },
  { id: 1, name: 'Chloe' },
  { id: 0, name: 'Daniel' },
  { id: 2, name: 'Leo' }
]
*/

```
  
</br>
  
      
### 15. 배열의 순서를 반대로 나열하기(reverse)   
**reverse()**: 배열 순서를 반대로 나열한다.  
    
``` js
const str = 'abcdefghijklmnopopqrstuvwxyz';
const arr = str.split('');
arr.reverse();

console.log(arr.join(''));  //zyxwvutsrqpoponmlkjihgfedcba
```
   
</br>


### 16. 배열 요소가 특정 조건을 만족하는지 확인하기(some)   
**some()**: callback 함수의 return 값이 true를 반환할 때까지만 배열 요소를 순환한다.  
- 만일, 마지막 요소까지 순환해도 true를 끝내 반환하지 않으면 false를 반환한다.  
    
``` js
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
```
   
  
