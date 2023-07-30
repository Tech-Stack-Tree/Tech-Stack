## 🌻JSP란?

HTML코드에 JAVA 코드를 넣어 동적 웹페이지를 생성하는 웹 어플리케이션 도구이다.

JSP가 실행 ⇒ 자바 **서블릿(Servlet)으로 변환 웹 어플리케이션 서버에서 동작되면서 필요한 기능 수행**

`<% 소스코드  %>` 또는 `<%= 소스코드 =%>`

**ex) 여러가지 JSP 태그**

- `<%@ ... %>`: 지시자
    - 페이지 속성 설정
- `<%-- ... --%>`: 주석
    - 주석 처리
- `<%! ... %>`: 선언
    - 변수, 메서드 선언
- `<%= ... %>`: 표현식
    - 결과값 출력
- `<% ... %>`: 스크립트
    - Java 코드 삽입
- `<jsp:action>...</jsp:action>`: 액션
    - 페이지 삽입, 공유, 자바빈 사용 등

→ 생성된 데이터를 웹페이지와 함께 클라이언트로 응답

***JSP와 서블릿의 차이**

→ 서블릿은 자바코드 내에 HTML 코드가 있어서 읽고 쓰기가 굉장히 불편

JSP는 HTML내부에 JAVA 소스코드가 들어가 작성하기 간편하다.

**WAS(Web Application Server)**에 의하여 서블릿 클래스로 변환하여 사용

## JSP 동작원리

![JSP](https://github.com/Tech-Stack-Tree/Tech-Stack/assets/79103761/04a4daf9-195c-43cc-a653-52ef24e80646)

1) 웹 서버가 사용자로부터 서블릿에 대한 요청을 받으면 → `서블릿 컨테이너`에 요청을 넘긴다.

2) 요청을 받은 컨테이너는 HTTP request와 HTTP Response 객체를 만들어 → **doPost() 또는 doGet()** 중 하나를 호출한다.

JSP를 사용하여 `비즈니스 로직`과 `프레젠테이션 로직`을 분리

3) 만들어진 결과물은 사용자가 해당 페이지를 요청하면 컴파일이 되어 자바파일을 통해 `.class` 파일이 만들어지고 → 두 로직이 결합되어 클래스화 되는것을 확인



### Reference

https://javacpro.tistory.com/43

https://github.com/devFancy/2023-CS-Study/blob/main/Spring/spring_03_jsp.md
