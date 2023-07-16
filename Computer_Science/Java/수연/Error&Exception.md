# 오류(Error)&예외(Exception)
  
### Throwable  
getMessage()와 printStackTrace()라는 메서드로 구현됨  
-> 이를 상속받은 Error와 Exception에서 두 메서드를 사용  
-> 오류와 예외는 메시지를 담을 수 있고 어떤 원인에 의해 발생했는지를 연결해 출력해줄 수 있다.  
![throwable](img/img.png) 

##### Error
: 시스템이 종료되어야 할 수준의 상황과 같이 수습할 수 없는 심각한 문제, 개발자가 미리 예측하여 방지할 수 없음.  

![Error](img/error.gif)  

ex)  
- StackOverflowError : 호출의 깊이가 깊어지거나 재귀가 지속되어 stack overflow 발생 시 던져지는 오류  
- OutOfMemoryError : JVM이 할당된 메모리의 부족으로 더 이상 객체를 할당할 수 없을 때 던져지는 오류로, Garbage Collector에 의해 추가적인 메모리가 확보되지 못하는 상황이기도 함  

*** 개발자가 직접 방지할 수 없지만 간접적인 예방은 가능하다.  
StackOverflowError - 재귀를 사용할 때에 주의를 기울이고, 가시적인 loop를 사용  
OutOfMemoryError - 새는 메모리를 차단, heap의 크기를 늘려주는 방법을 사용  



##### Exception  
: 개발자가 구현한 로직에서 발생한 실수나 사용자의 영향에 의해 발생, 오류와 달리 개발자가 미리 예측하여 방지할 수 있기에 상황에 맞는 예외처리(Exception Handle)를 해야 한다.  

![Exception](img/exception.gif)   

ex)   
- NullPointerException : 객체가 필요한 경우, 응용프로그램이 null을 사용하려고 시도할 때 던져지는/던질 수 있는 예외  
- IllegalArgumentException : 메서드가 허가되지 않거나 부적절한 argument를 받았을 경우에 던져지는/던질 수 있는 예외  
  
응용 프로그램의 로직이 진행되다가 개발자가 임의로 예외를 던질 수 있다는 의미 => 예외 처리를 개발자가 할 수 있음  
