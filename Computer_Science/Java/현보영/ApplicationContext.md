## 스프링 컨테이너 Application context
- ApplicationContext를 스프링 컨테이너라고 부름.
- ApplicationContext는 `.BeanFactory` 인터페이스의 하위 인터페이스이다. 즉, ApplicationContext는 BeanFactory에 부가기능을 추가한 것
- BeanFactory는 스프링 컨테이너의 최상위 인터페이스이다. 스프링 빈을 관리하고 조회하는 역할을 함
- ApplicationContext는 BeanFactory + 부가 기능(국제화 기능, 환경 변수 관련 처리, 애플리케이션 이벤트, 리소스 조회)을 가짐

![image](https://github.com/Tech-Stack-Tree/Tech-Stack/assets/49936027/56483023-fa61-4699-b635-59e846add01c)

- - ApplicationContext의 구현체가 여러가지 있는데, 구현체에 따라 스프링 컨테이너를 XML을 기반으로 만들 수도 있고, 자바 클래스로 만들 수도 있다. 이게 가능한 이유는 빈 등록을 BeanDefinition으로 추상화해서 생성 하기 때문이다. XML로 하든, 자바로 하든 BeanDefinition이 생성된다.
- - 스프링 컨테이너 내부에는 빈 저장소가 존재한다. 빈 저장소는 key로 빈 이름을 가지고 있으며, value로 실제 빈 객체를 가지고 있다.
- - 스프링 컨테이너는 기본적으로 빈을 싱글톤으로 관리해준다. 따라서 싱글톤 컨테이너라고 불리기도 한다.
- - 스프링 컨테이너가 빈을 싱글톤으로 관리해주면서 기존 싱글턴 패턴의 문제점(싱글톤 패턴 구현을 위한 코드가 추가되어야함, 구체 클래스에 의존, 유연성이 떨어짐 etc)은 없어지고, 싱글톤의 장점(매번 인스턴스를 생성할 필요없이 단 하나만 생성해서 비용을 줄일 수 있다.)만 가져갈 수 있다.

- [ 애플리케이션 컨텍스트(Application Context)의 장점 ]

### 스프링컨테이너의 장점
- 클라이언트는 `.@Configuration` 이 붙은 구체적인 팩토리 클래스를 알 필요가 없다.
- 애플리케이션 컨텍스트는 종합 IoC 서비스를 제공해준다.
- 애플리케이션 컨텍스트를 통해 다양한 빈 검색 방법을 제공할 수 있다.

### 자바 설정 클래스로 스프링 컨테이너 생성하기
```java
아래는 어노테이션 기반의 자바 클래스로 스프링 컨테이너를 만든 예시이다.

@Configuration
public class AppConfig {

    @Bean
    public StationService stationService() {
        return new StationServiceImpl(stationRepository());
    }
    
    @Bean
    public StationRepository stationRepository() {
        return new MemoryStationRepository();
    }
    
    @Bean
    // ...

}
```
