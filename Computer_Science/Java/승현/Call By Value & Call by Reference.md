# 📞Call by Value vs Call by Reference

함수의 호출 방식을 call by value와 call by reference로 나눔

함수의 매개변수에서 **값을 복사** or **주소값을 참조**하느냐

# Call by Value(값에 의한 호출)

: 함수가 호출 될 때 메모리 공간에 함수를 위한 별도의 임시공간이 생성된다. 함수가 종료되면 해당공간은 사라진다.

**Stack Frame** : 함수 호출시 할당되는 메모리 블록(지역변수의 선언으로 할당되는 메모리)

지역변수 : 함수 호출할 떄 만들어져 함수가 종료되면 없어진다.('블록'내에서 선언되는 함수)

→ 함수 호출시 전달되는 변수의 값을 복사하여 함수의 인자로 전달한다.

복사된 인자는 함수안에서 지역적으로 사용되는 local value의 특성을 가진다.

(함수의 인자 값이 변경 되어도 외부의 변수 값은 변하지 않는다.)

# Call by Reference(참조에 의한 호출)

함수 호출시 인자로 전달되는 변수의 레퍼런스를 전달한다.(해당 변수를 가르킨다)

함수의 인자값이 변경되면 아규먼트로 전달된 객체의 값도 바뀐다.

***C언어**

포인터(*) 변수를 파라미터 받게 하고 함수를 호출할 때 주소연산자(&)를 이용해 주소값을 직접 넘겨 직접적인 메모리 참조가 가능하다.

***Java**의 경우 함수에 전달되는 인자의 데이터 타입에 따라서 (

원시자료형/참조자료형) 함수 호출 방식이 달라진다. 

- 원시 자료형

  call-by-value 로 동작 (int, short, long, float, double, char, boolean )

- 참조 자료형 (reference type): call-by-reference 로 동작 (Array, Class Instance)

(자바는 call by Reference를 사용하지x)

기본형 (int, double, boolean 등)은 **stack의 변수 안에 value** 저장

**참조형 (I**nteger, Obejct, Array, Map 등) 은 stack 변수 값에는 객체의 주소 값, 객체는 별도의 **Heap영역**에 저장

Java는 C와 달리 포인터를 철처하게 숨겨 개발자가 직접 메로리 주소에 접근하지 못하도록 했기 때문에 ‘Call by Reference’는 존재하지 않는다.

# Call by assignment

→ 파이썬의 경우 함수의 호출 방식이다.

파이썬에서는 모든 것이 객체이고 객체에는 2가지 종류 존재

1) Immutable Object

- int,float,str,tupe
- immutable객체가 함수의 arguments로 전달되면 처음에는 call by reference로 받지만, **변경되면 call by value로 동작**

→ formal parameter값이 바뀌어도, actual parameter에는 영향이 없다.

2) mutable object

- list, dict, set
- mutable 객체가 함수의 argument로 넘어가면 **call by reference로 동작한다.** 즉, obejct reference가 전달되어 actual parameter의 값에 영향을 미칠 수 있다.

### Reference

https://github.com/devFancy/2023-CS-Study/blob/main/java/java_call_by_value.md

https://wayhome25.github.io/cs/2017/04/11/cs-13/

[https://inpa.tistory.com/entry/JAVA-☕-자바는-Call-by-reference-개념이-없다-❓](https://inpa.tistory.com/entry/JAVA-%E2%98%95-%EC%9E%90%EB%B0%94%EB%8A%94-Call-by-reference-%EA%B0%9C%EB%85%90%EC%9D%B4-%EC%97%86%EB%8B%A4-%E2%9D%93)
