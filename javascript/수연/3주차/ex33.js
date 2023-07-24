const symbol = Symbol();
const hello = Symbol('hello');

console.log(Number(3)===Number(3));                 //true
console.log(Symbol('symbol')===Symbol('symbol'));   //false
console.log(Symbol()===Symbol());                   //false
console.log(typeof Symbol());                       //symbol

const nationility = Symbol('nationility');
const user = {
    name: 'jay'
};
user[nationility] ='korean';
console.log(user[nationility]);                     //korean

for(let key in user){
    console.log(key);                               //name
}
console.log(Object.keys(user));                     //[ 'name' ]
console.log(Object.getOwnPropertyNames(user));      //[ 'name' ]
console.log(JSON.stringify(user));                  //{"name":"jay"}

const symbolProperties = Object.getOwnPropertySymbols(user);
console.log(symbolProperties);                      //[ Symbol(nationility) ]
console.log(user[symbolProperties[0]]);             //korean