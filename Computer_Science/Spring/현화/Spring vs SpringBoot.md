## Spring Framework
스프링 프레임워크는 자바 플랫폼을 위한 오픈소스 어플리케이션 프레임워크로서 간단히 스프링(Spring)이라고도 불린다. 동적인 웹 사이트를 개발하기 위한 여러가지 서비스를 제공하고 있다. 대한민국 공공기관의 웹 서비스 개발시 사용을 권장하고 있는 전자정부 표준 프레임워크의 기반 기술로서 쓰이고 있다.
> 장점
> 
> 경량 컨테이너
> 
> Ioc(Invertion of Control : 제어 역행)
>
> DI(Dependency Injection : 의존성 주입)
> 
> AOP(Aspect-Oriented Programming : 관점지향 프로그래밍)

## Spring Boot
스프링 프레임워크는 기능이 많은 만큼 환경설정이 복잡한 편이다. 이에 어려움을 느끼는 사용자들을 위해 나온 것이 바로 스프링 부트다.
스프링 부트는 스프링 프레임워크를 사용하기 위한 설정의 많은 부분을 자동화하여 사용자가 정말 편하게 스프링을 활용할 수 있도록 돕는다.
스프링 부트 starter 디펜던시만 추가해주면 바로 API를 정의하고, 내장된 톰캣이나 제티로 웹 어플리케이션 서버를 실행할 수 있다.
실행환경이나 의존성 관리등의 인프라 관련을 신경 쓸 필요없이 바로 코딩을 시작하면 된다.

#### 차이점
1) Embeded Tomcat(Spring boot 내부에 내장된 톰캣)을 사용하기 때문에 Tomcat을 설치하거나 매번 버전을 관리해 주어야하는 수고로움을 덜어준다.
2) starter를 통한 dependency 자동화
3) xml 설정을 하지않아도 됨
4) jar file을 이용해 자바 옵션만으로 손쉽게 배포가 가능하다.

### Spring Boot starter란?
starter는 마치 npm처럼 간편하게 dependency를 제공해주는데, 만약 우리가 JPA가 필요하다면 pom.xml 또는 build.gradle에 'spring-boot-starter-data-jpa'만 추가해주면 spring boot가 그에 필요한 라이브러리들을 알아서 받아온다.
> spring-boot-starter-*

 \* 부분에 원하는 스타터명을 명시하면 원하는 라이브러리를 import 할 수 있다.
