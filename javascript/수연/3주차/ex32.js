var obj = {a:1, b:2, c:30, d:44, e:5};

var {a, c} = obj;
console.log(`a >>> ${a}`);  //a >>> 1
console.log(`c >>> ${c}`);  //c >>> 30

//기존 속성명의 값을 가져와서 새로운 변수명에 할당하여 정의할 수 있다.
//-> 구분자 ':'를 사이에 두고 왼쪽에 객체의 속성명을, 오른쪽에는 새로운 변수명을 넣으면 된다.
var {a:newA=10, f:newF=5} = obj;    //객체 a의 속성 값을 새로운 변수 newA에 할당하되, unfined로 값이 없는 경우 기본 값으로 10을 할당한다는 의미
console.log(`newA >>> ${newA}`);    //newA >>> 1
console.log(`newF >>> ${newF}`);    //newF >>> 5