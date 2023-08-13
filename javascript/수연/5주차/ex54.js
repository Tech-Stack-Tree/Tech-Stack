//this를 전역에서 사용 -> 전역객체인 Window객체를 가리킨다.
this.valueA = 'a';
//console.log(valueA);      //a
this.valueB = 'b';
console.log(this.valueB);   //b

//함수 내에서 this를 사용하고 함수를 호출하면 this는 전역 객체인 Window를 가리킨다.
function checkThis(){
    console.log(this);
}

//함수 내의 코드를 엄격한 모드로 실행하게 되면 this는 undefined가 된다.
//엄격한 모드: 자바스크립트 코드를 좀 더 안전하고 엄격하게 작성하도록 돕는다. 전역이나 함수단위로 지정
function checkThis2(){
    "use strict"
    console.log(this);
}

checkThis();    //Window 
checkThis2();   //undefined

function Product(name, price){
    this.name = name;
    this.price = price;
}

//new 키워드 없이 호출, this는 전역 객체인 Window 객체를 가리킨다.
const product1 = Product('가방', 2000);
console.log(window.name);   //가방
console.log(window.price);  //2000

//객체 내에서 정의된 함수 메소드 안에서 this를 사용하고 객체를 통해 호출하면,
//this는 그 객체를 가리킨다.
const product2 = {
    name : '가방2',
    price : 3000,
    getVAT() {
        return this.price / 10;
    }
}

const valueOfProduct2 = product2.getVAT();
console.log(valueOfProduct2);   //300

//calVAT 함수를 정의 = getVAT함수와 동일하게
const calVAT = product2.getVAT;
const VAT2 = calVAT();  //this.price를 실행하지만 전역에서 발생
console.log(VAT2);  //200

//bind메소드를 통해 전달한 인자값으로 변경할 수 있다.
//this외에 call과 apply메소드 또한 this가 가리키는 값을 변경할 수 있다.
const newCalVAT = calVAT.bind(product2);    
const VAT3 = newCalVAT();
console.log(VAT3);  //300

//Window.count로 해석되어 undefined에 1을 더하려 함
const counter1 = {
    count : 0,
    addAfter1Sec() {
        setTimeout(function(){
            this.count += 1;
            console.log(this.count);
        }, 1000)
    }
};

counter1.addAfter1Sec();    //NaN

//화살표 함수에서 this를 사용하면, this는 부모환경의 this를 가리킨다.
const counter2 = {
    count : 0,
    addAfter1Sec() {
        setTimeout(() => {
            this.count += 1 ;
            console.log(this.count);
        }, 1000)
    }
};

counter2.addAfter1Sec();    //1