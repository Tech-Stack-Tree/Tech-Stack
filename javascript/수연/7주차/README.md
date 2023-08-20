### 1. 모듈 이해하기  
- 모듈 : 파일이나 코드의 묶음 단위로, 애플리케이션 하나의 구성요소  
- 모듈로 정의하면, 모듈 단위로 코드를 재사용할 수 있다.    
- 하나의 애플리케이션이라는 큰 기능을 작은 기능 단위로 잘게 분리하여 관리할 수 있다.  
ex) 베이스볼 게임(애플리케이션) : 문제 생성 모듈, 플레이어 관리 모듈, 정답 채점 모듈 등..  
  
#### 네임스페이스 패턴을 통해 모듈 정의하기(- ECMAScript5.x 버전까지 사용)
- C# 언어에서 제공하는 기능으로, 코드를 그룹화하고 이름 충돌을 방지하게 도와준다.  
- js에서는 직접적으로 지원하지 않는다. -> 함수를 정의함과 동시에 실행하는 즉각 호출 패턴을 통해 네임스페이스를 유사하게 구현할 수 있다.  
- 기본적으로 함수와 변수를 선언하면, 전역으로 정의되어 다른 라이브러리나 타인의 코드에서 정의된 이름과 충돌 날 수도 있기 때문  
  
```js
//즉각호출패턴인 (function(){//코드}();를 통하여 namespaceA의 변수에 함수에서 반환된 변수를 할당한다.
var namespaceA = (function(){
    var privateVariable = '비공개 변수';  //함수 안에 선언된 변수는 함수 내부에서만 접근가능 - 비공개 영역
    return {
        publicApi : function(){
            console.log(privateVariable + '를 접근할 수 있습니다.');
        }
    }
})();

namespaceA.publicApi(); //비공개 변수를 접근할 수 있습니다.
```


### 2. 모듈 시스템 이해하기  
- ES6의 모듈은 자바스크립트 코드를 담고 있는 하나의 파일  
- 하나의 파일 = 하나의 모듈  
- ES6의 모듈은 엄격한 모드의 코드이고, import와 export키워드를 사용한다.  
  - import 키워드: export한 코드들을 가지고 올 수 있다.  
  - export 키워드 : 모듈 내의 특정 코드를 외부에서 사용할 수 있다.    

예제1)   
ex56.js  
```js
//hello함수를 정의하고 이 함수를 export 키워드를 이용하여 외부에서 가져올 수 있게 내보낸다.
export function hello(name){
    console.log(`hello ${name}`);
}
```

ex56-1.js  
```js
//ex56.js의 hello 함수를 import키워드를 이용해 가지고 온다.
import {hello} from './ex56.js';

hello('es6 module'); //hello es6 module
```

=> 하나의 모듈이 다른 모듈에서 내보낸(export) 코드를 가져오면(import) 두 모듈은 서로 의존하게 되어 의존 관계가 형성되고,  
여러 모듈들은 의존 관계를 맺어 의존 관계 그래프가 형성되게 된다.  


**ES6의 모듈 분류** : 정의된 파일을 실행하는 방법에 따라  
1. 런타임 로딩(Runtime Loading): 의존 관계가 형성된 모듈들을 애플리케이션이 구동 시점에 비동기 HTTP 요청으로 불러오고 실행된다.  
   - 모듈 로더가 필요함 (system.js 나 require.js를 이용할 수 있다.)  
2. 번들링(Bundling): 의존 관계가 형성된 모듈들을 하나의 파일로 묶어준다. 그리고 애플리케이션이 구동할 때 묶어진 이 파일을 로드한다.  
   - 개발 시점에 이루어짐  
   - 브라우저 x, 대체로 node.js 환경에서 이루어진다.
   - 대표적인 모듈 번들러: 웹팩(Webpack)
=> 크롬 61버전부터, <script type=modile>을 지원하면서, 별도의 로더 없이 ES6 모듈을 사용할 수 있다.   

``` html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Module Sample</title>
    <script type="module" src="ex56-1.js"></script>
</head>
<body>
</body>
</html>
```
