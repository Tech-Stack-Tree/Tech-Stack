# 🕸️WEB MVC 요청 처리 과정(DispatcherServlet)

### MVC 패턴의 한계

**1) forward 중복**

**2) 사용하지 않는 코드**

**3) 공통 처리의 어려움.**

→ [수연 정리 부분도 참고](https://github.com/Tech-Stack-Tree/Tech-Stack/blob/main/Computer_Science/Java/%EC%88%98%EC%97%B0/MVC%20%ED%8C%A8%ED%84%B4.md)

### Front Controller의 등장

: 기존 MVC 패턴이 지니고 있던 단점들을 극복하기 위해 발전된 구조

모든 클라이언트의 요청이 단일 진입점인 **FrontController**로 집중된다.
![frontController](https://github.com/Tech-Stack-Tree/Tech-Stack/assets/79103761/48eb58c4-06a8-402d-8592-e1e6cd37161c)

→ 해당 작업을 처리한 뒤 요청에 맞는 `컨트롤러에` 전달해주는 역할

**1)Front Controller 생성**


```java
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/*")
public class FrontController extends HttpServlet {
    private Map<String, Controller> controllerMap;

    public FrontController() {
        controllerMap = new HashMap<>();
        // URL과 컨트롤러 매핑
        controllerMap.put("/home", new HomeController());
        controllerMap.put("/user", new UserController());
        // 추가적인 URL과 컨트롤러 매핑
        // ...
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String uri = request.getRequestURI();
    String contextPath = request.getContextPath();
    String command = uri.substring(contextPath.length());

    Controller controller = controllerMap.get(command);
    
    if (controller != null) {
        String view = controller.handleRequest(request, response);
        if (view != null) {
            // 결과에 따른 .jsp 파일로 넘어가기
            request.getRequestDispatcher(view).forward(request, response);
        }![frontController](https://github.com/Tech-Stack-Tree/Tech-Stack/assets/79103761/08a65096-7886-447f-a309-22922746565f)
![DispatcherServlet](https://github.com/Tech-Stack-Tree/Tech-Stack/assets/79103761/575c7573-0da5-4a95-9bd8-6f445c8f8454)

    } else {
        // 해당 URL에 맞는 컨트롤러가 없는 경우, 기본 처리
        controller = new DefaultController();
        String view = controller.handleRequest(request, response);
        if (view != null) {
            // 결과에 따른 .jsp 파일로 넘어가기
            request.getRequestDispatcher(view).forward(request, response);
        }
    }
}
}
```

### 2) 컨트롤러,인터페이스와 구현

```java
// Controller interface
public interface Controller {
    String handleRequest(HttpServletRequest request, HttpServletResponse response);
}

// Home controller
public class HomeController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        // Home page logic
        // ...
        
        // Return the view path
        return "/home.jsp";
    }
}

// User controller
public class UserController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        // User-related logic
        // ...
        
        // view path 반환
        return "/user.jsp";
    }
}
```

### DispatcherServlet이란?

웹 어플리케이션에서 `Front Controller` 패턴을 구현하는 방식 중 하나이다.

![DispatcherServlet](https://github.com/Tech-Stack-Tree/Tech-Stack/assets/79103761/4509ae1e-3b90-4d59-bc31-6d96aad3739f)

### 요청 처리 단계

1. 클라이언트로붵 HTTP 요청이 도착 → 서블릿 컨테이너는 **DispatcherServlet**에 해당 요청을 전달

```java
public class DispatcherServlet extends HttpServlet {
    private HandlerMapping handlerMapping;
    private HandlerAdapter handlerAdapter;
    private ViewResolver viewResolver;

    @Override
    public void init() throws ServletException {

        // DispatcherServlet 초기화 작업
        handlerMapping = new HandlerMapping();
        handlerAdapter = new HandlerAdapter();
        viewResolver = new ViewResolver();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 클라이언트 요청 처리
        try {
            // 요청의 URL을 기반으로 핸들러(Controller)를 찾음
            Controller controller = handlerMapping.getHandler(request);
            // 핸들러 실행 및 처리 결과 얻기
            ModelAndView modelAndView = handlerAdapter.handle(request, response, controller);
            // ViewResolver를 통해 뷰를 찾고, 응답으로 반환
            viewResolver.resolveView(modelAndView, request, response);
        } catch (Exception e) {
            // 예외 처리
            // ...
        }
    }
    
    // ...
}
```

1. DispatcherServlet은 **HandlerMapping을 사용하여 요청을 처리할 핸들러(컨트롤러)를 결정**

`HandlerMapping` : 요청을 적절한 핸들러(컨트롤러)에 매핑하는 역할 담당

```java
public class HandlerMapping {
    private Map<String, Controller> handlerMap;

    public HandlerMapping() {
        handlerMap = new HashMap<>();
        // URL과 컨트롤러 매핑
        handlerMap.put("/user/list", new UserController());
        // 추가적인 URL과 컨트롤러 매핑
        // ...
    }

    public Controller getHandler(HttpServletRequest request) {
        String url = request.getRequestURI();
        return handlerMap.get(url);
    }
}
```

1. DispatcherServlet은 **HandlerAdapter**을 사용하여 결정된 핸들러를 실행

`HandlerAdapter` ********:******** 핸들러(컨트롤러)를 실행하고 **요청을 처리하는 역할**을 수행

```java
public class HandlerAdapter {
    public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Controller controller) {
        try {
            // 컨트롤러 실행
            String view = controller.handleRequest(request, response);
            // 처리 결과를 ModelAndView에 저장
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName(view);
            // 추가적인 처리
            // ...
            return modelAndView;
        } catch (Exception e) {
            // 예외 처리
            // ...
        }
        return null;
    }
}
```

1. DispatcherServlet은 **ViewResolver**를 사용하여 처리 결과를 적절한 **뷰**로 전환

`ViewResolver` : 요청 처리 결과를 **뷰**로 변환하여 응답으로 보내는 역할을 담당

```java
public class ViewResolver {
    public void resolveView(ModelAndView modelAndView, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewName = modelAndView.getViewName();
        // viewName에 해당하는 뷰 찾기
        String viewPath = getViewPath(viewName);
        // .jsp 파일로 forward
        request.getRequestDispatcher(viewPath).forward(request, response);
    }

    private String getViewPath(String viewName) {
        // viewName을 기반으로 실제 .jsp 파일의 경로를 결정하여 반환
        // 예: viewName이 "userList"일 경우 "/WEB-INF/views/userList.jsp"를 반환
        return "/WEB-INF/views/" + viewName + ".jsp";
    }
}
```

1. DispatcherServlet은 변환된 뷰를 사용하여 클라이언트에게 응답을 생성



### Reference

https://jwdeveloper.tistory.com/291

https://traeper.tistory.com/198

https://github.com/devSquad-study/2023-CS-Study/blob/main/Spring/spring_DispatcherServlet.md
