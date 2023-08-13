function verifyNumber(n){
    if(!Number.isInteger(n)) return 0;

    return n;
}

const num1 = verifyNumber(15);
const num2 = verifyNumber(Infinity);
const num3 = verifyNumber(0.05);

console.log(num1, num2, num3);  //15 0 0