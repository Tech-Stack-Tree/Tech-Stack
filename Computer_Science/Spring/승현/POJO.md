## 💡POJO(Plain Old Java Object)

**자바 오브젝트로** 다른 환경에 종속되지 않고, 필요에 따라 재사용이 가능한 자바오브젝트이다.

`po` : 순수 자바로 생성하는 객체

`Jo` : 객체와 객체가 관계를 맺을 수 밖에 없는 객체지향 프로그래밍이다.

**EJB(Enterprise Java Base)**

스프링이 탄생하기 전에  EJB가 존재 엔터프라이즈 개발을 단순화하기 위해 Sun 사에서 만들어 낸 JAVA 스펙

→ 변수, 예외처리, 상속까지 EJB에 의존적

 **POJO가 필요한 이유**

- 특정 기술에 종속적이지 않고, 재사용이 가능, 유연한 확장
- 코드의 간결성, 디버깅이 쉬어짐, 테스트가 단순해짐
- 객체지향적인 설계를 제한없이 적용할 수 있다.

![POJO](https://github.com/Tech-Stack-Tree/Tech-Stack/assets/79103761/8a54f53f-5aec-42b3-a37e-eb798149c6eb)

## IOC(Inversion of Control)/DI(Dependency Injection)

### IOC(제어의 역전)

`Framework`와 `Library`는 개발자에게 필요한 기능을 제공하는 것은 동일

`Library`는 개발자가 애플리케이션의 흐름을 주도하고 

`Framework`는 애플리케이션이 에플리케이션을 주도

→ 주도권이 뒤바뀐 것을 IoC라고 한다.

**EJB**는 **메서드나 객체의 호출 작업등에 대한 제어를 코드에 침투적**으로 반영

**Spring**은 제어와 비지니스 로직을 분리 할 수 있게 함

이전까지는main()메서드의 시작부터 마지막까지 다른 메서드를 호출 하지만 웹 서버는 항상 열려있고 실행 주이기 때문에 별도의 main() 메서드가 존재하지 않고 웹 어플리케이션 자체가 흐름을 제어

**DI(Dependency Injection)**

IoC 개념을 조금 더 구체화 시킴

→ 의존성 주입

ex) A 클래스가 B클래스의 메서드를 사용한다. → A클래스는 B클래스에 의존한다.

외부에서 의존을 주입받으면 **DI**

의존이 개발자가 아닌 프레임워크에서 관리를 하면 **IoC**

**의존성 주입 방법**

### Field Injection

가장 흔히 볼 수 있는 Injection방법입니다

```java
@Service
public class A {

		@Autowired
		private B b;

		public A() {}

}
```

### Setter Injection

선택적인 의존성을 주입할 경우 유용합니다.

```java
@Service
public class A
		private B b;

		public A() {}

		@Autowired
		public void setA(B b){
				this.b = b;
		}
}
```

### Constructer Injection

```java
@Service
public class A {
		private final B b;

		public A(B b) {
				this.b = b;
		}
}
```

### AOP(Aspect Oriented Programming)

**관점 지향 프로그래밍**

→ 객체 지향 프로그래밍의 단점을 보완

개발을 할 때 애플리케이션에 핵심적인 기능도 있고 핵심적이지는 않지만 전반적으로 필요한 공통적으로 적용되는 공통기능이 있다.

**AOP는 애플리케이션의 핵심 업무 로직에서 공통 관 시항을 분리하는 작업**

**ex)**  데이터베이스에 데이터를 저장하는 과정을 할때 데이터베이스 연결에 필요한 객체들을 어느 데이터를 얼만큼 저장하느냐와 상관없이 동일한 열고 닫기를 명령해야 한다.

→ 이러한 열고 닫기와 같은 공통된 작업을 생략하게 함으로써 비즈니스 로직에 집중할 수 있게 해준다.

**장점**

- 코드의 간결성 유지
- 객체 지향 설계 원칙에 맞는 코드 구현
- 코드의 재사용

### PSA(Portable Service Abstraction)

객체지향 프로그래밍 언어인 자바에서 코드로 추상화를 표현할 수 있는 대표적인 방법이 `추상 클래스`와 `인터페이스` 이다.

→ 추상화 된 클래스를 일관되게 바라보며 하위 클래스의 기능을 사용하는 것이 **일관된 서비스 추상화(PSA)**의 기본개념

어떤 서비스를 이용하기 위한 접근 방식을 일관된 방식으로 유지함으로써 애플리케이션에서 사용하는 기술이 변경되더라도 **최소한의 변경만으로 변경된 요구 사항을 반영하기** 위함이다.

**Spring에 대표적으로 제공하는 PSA**

- **Spring Web MVC**
    
    Spring안에 Servlet을 통해 개발 할 수 있게 많은 기능을 제공
    
    Servlet을 통해 프로그램을 실행하려면 클래스에 HttpServlet을 상속받고 ,doGet(), doPost()를 구현하는 등의 작업을 직접해야한다.
    
    하지만 Spring에서는 `@Controller`, `@GetMapping` , `@PostMapping`
    
- **Spring Transaction**
    
    트랜잭션 처리를 쉽게 도와준다.
    
    JDBC를 사용하는 DatasourceTransactionManager, JPA를 사용하는 JpaTransactionManager, Hibernate를 사용하는 HibernateTransactionManager를 유연하게 바꿔서 사용할수 있다.
    
- **Spring Cache**
    
    Cache도 Transaction과 동일하게 JCacheManager, ConcurrentMapCacheMannager, EhCacheCacheManager와 같은 구현제를 사용할수 있다.
    
    사용자는 @Cacheable 에노테이션을 붙여줌으로써 구현재를 크게 신경쓰지 않아도 필요에 따라 바꿔 쓸수 있다.

### Reference

https://github.com/devSquad-study/2023-CS-Study/blob/main/Spring/spring_psa_ioc_aop_pojo.md

[https://velog.io/@ds02168/33일차](https://velog.io/@ds02168/33%EC%9D%BC%EC%B0%A8)
