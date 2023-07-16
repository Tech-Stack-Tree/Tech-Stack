# 오류(Error)&예외(Exception)
------------
  
### Throwable
getMessage()와 printStackTrace()라는 메서드로 구현됨
-> 이를 상속받은 Error와 Exception에서 두 메서드를 사용
-> 오류와 예외는 메시지를 담을 수 있고 어떤 원인에 의해 발생했는지를 연결해 출력해줄 수 있다.
![throwable](./image/img.png)

##### Error
: 시스템이 종료되어야 할 수준의 상황과 같이 수습할 수 없는 심각한 문제, 개발자가 미리 예측하여 방지할 수 없음.
![throwable](./image/error.gif)

##### Exception
: 개발자가 구현한 로직에서 발생한 실수나 사용자의 영향에 의해 발생, 오류와 달리 개발자가 미리 예측하여 방지할 수 있기에 상황에 맞는 예외처리(Exception Handle)를 해야 한다.

![throwable](./image/exception.gif)
