//Storage 생성자 함수 정의, 내부 속성으로 dataStore를 가지고 빈 객체를 할당한다.
function Storage() {
    this.dataStore = {};
}
//Storage 생성자 함수의 프로토타입 객체에 put메소드를 추가, put메소드는 주어진 키에 해당하는 값을 dataStore속성에 할당한다.
Storage.prototype.put = function(key, data){
    this.dataStore[key] = data;
}
//Storage 생성자 함수의 프로토타입 객체에 getData메소드를 추가, 매개변수 값을 키로 dataStore속성에서 찾아 반환한다.
Storage.prototype.getData = function(key){
    return this.dataStore[key];
}

const productStorage = new  Storage();  //Storage 타입의 인스턴스 생성 -> put, getData 메소드 사용가능
productStorage.put('id001', {name:'키보드', price: 2000});
console.log(productStorage.getData('id001'));   //{name:'키보드', price: 2000}

//RemovableStorage 생성자 함수 정의
//Storage 생성자 함수가 호출되면서 RemovableStorage 생성자 함수 this에 Storage생성자 함수에서 정의한대로 dataStore가 속성으로 추가된다.
function RemovableStorage(){
    Storage.call(this);
}

//Object.create 메소드 : 주어진 인자를 __proto__에 연결한 새로운 객체를 반환 => 간단히 상속관계를 정의
//Storage 함수 프로토타입 객체가 RemovableStorage 함수의 프로토타입 객체의 __proto__에 할당된다.
RemovableStorage.prototype = Object.create(Storage.prototype);

//RemovableStorage 생성자 함수의 프로토타입 객체에 removeAll 메소드를 추가한다.
RemovableStorage.prototype.removeAll = function() {
    this.dataStore = {}
}

const productStorage2 = new RemovableStorage(); //RemovableStorage 타입의 인스턴스 생성
productStorage2.put('id001', {name: '키보드', price : 2000});
productStorage2.removeAll();
const item2 = productStorage2.getData('id001');
console.log(item2); //undefined