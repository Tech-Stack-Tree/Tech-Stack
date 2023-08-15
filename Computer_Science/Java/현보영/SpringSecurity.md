## Spring Security
 - Spring Security는 Spring 기반의 애플리케이션의 보안(인증과 권한, 인가 등)을 담당하는 스프링 하위 프레임워크
 - '인증'과 '권한'에 대한 부분을 Filter 흐름에 따라 처리
 - Filter는 Dispatcher Servlet으로 가기 전에 적용되므로 가장 먼저 URL 요청을 받지만, Interceptor는 Dispatcher와 Controller사이에 위치한다는 점에서 적용 시기의 차이가 있다.
 -  Spring Security는 보안과 관련해서 체계적으로 많은 옵션을 제공해주기 때문에 개발자 입장에서는 일일이 보안관련 로직을 작성하지 않아도 된다는 장점이 있다.
 ![image](https://github.com/Tech-Stack-Tree/Tech-Stack/assets/49936027/35b7489d-e69c-49c4-a5d7-48d8b7323c32)

 
 ```java
 String name = "Old"
 name.toCharArray()[0] = 'E';
 ```

## 인증(Authentication)과 인가(Authorization)
- 인증(Authentication) : 해당 사용자가 본인이 맞는지 확인하는 과정
- 인가(Authorization) : 해당 사용자가 요청하는 자원을 실행할 수 있는 권한이 있는가를 확인하는 과정


## Spring Security의 인증 처리 과정
1. 사용자가 로그인 정보와 함께 인증 요청을 한다.(Http Request)
2. AuthenticationFilter가 요청을 가로채고, 가로챈 정보를 통해 UsernamePasswordAuthenticationToken의 인증용 객체를 생성한다.
3. AuthenticationManager의 구현체인 ProviderManager에게 생성한 UsernamePasswordToken 객체를 전달한다.
4. AuthenticationManager는 등록된 AuthenticationProvider(들)을 조회하여 인증을 요구한다.
5. 실제 DB에서 사용자 인증정보를 가져오는 UserDetailsService에 사용자 정보를 넘겨준다.
6. 넘겨받은 사용자 정보를 통해 DB에서 찾은 사용자 정보인 UserDetails 객체를 만든다.
7. AuthenticationProvider(들)은 UserDetails를 넘겨받고 사용자 정보를 비교한다.
8. 인증이 완료되면 권한 등의 사용자 정보를 담은 Authentication 객체를 반환한다.
9. 다시 최초의 AuthenticationFilter에 Authentication 객체가 반환된다.
10. Authenticaton 객체를 SecurityContext에 저장한다.


<br/>

## CurrentUser 정보
1. Bean 에서 사용자 정보 얻기
```java
Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
UserDetails userDetails = (UserDetails)principal;

String username = principal.getUsername();
String password = principal.getPassword();
```

2. Controller 에서 사용자 정보 얻기
```java
@Controller
public class SecurityController {

    @GetMapping("/username")
    @ResponseBody
    public String currentUserName(Principal principal) {
        return principal.getName();
    }
}
```

3.@AuthenticationPrincipal
```java
@Data
public class CustomUser implements UserDetails {
    // ...
}

@Service
public class UserSerivce implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomUser customUser = null;
        // ... DB 등을 통해 사용자 정보를 셋팅

        return customUser;
    }

@Controller
public class SecurityController {

    @GetMapping("/messages/inbox")
    public ModelAndView currentUserName(@AuthenticationPrincipal CustomUser customUser) {
        String username = customUser.getUsername();

        // .. find messages for this user and return them ...
    }
}
```
