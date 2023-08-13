//version 이름으로 상수 정의-> export키워드로 내보내기 
export const version = 'v1.0';

//personA 이름으로 정의된 변수에 객체를 할당 -> export키워드로 내보내기 
export var personA = {
    name : 'a'
};

//add 함수를 선언 -> export키워드로 내보내기
export function add(a,b) {
    return a+b;
}

//Person 클래스를 선언 -> export키워드로 내보내기
export class Person {
    constructor(name){
        this.name = name;
    }
}