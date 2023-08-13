class Product {
    //정적메소드 build 정의
    static build(name, price){
        const id = Math.floor(Math.random()*1000);
        return new Product(id, name, price);
    }

    //정적메소드 getTaxPrice 정의
    static getTaxPrice(product){
        return (product.price*0.1) + product.price;
    }
    //생성자함수 정의
    constructor(id, name, price){
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

//Product클래스를 상속하여, DeposableProduct 클래스 정의
class DeposableProduct extends Product {
    depose(){
        this.deposed = true;
    }
}

const gum = Product.build('껌', 1000);  //Product클래스의 build정적메소드를 호출
console.log(gum);   //Product { id: 965, name: '껌', price: 1000 }

const clothes = new DeposableProduct(1, '옷', 2000);    //DeposableProduct 인스턴스 생성
const taxPrice = DeposableProduct.getTaxPrice(clothes);
console.log(taxPrice);  //2200


