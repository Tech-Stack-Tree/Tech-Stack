import * as add from './add.js';
import './sideeffect.js';   //hello!

console.log(add.version);   //v.1.0
const added = add.default(1,2);
console.log(added); //3

hello('harin'); //hello harin