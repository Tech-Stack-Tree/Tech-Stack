# 🔍 스택(Stack)&큐(Queue)
![스택&큐](../img/스택큐.PNG)  


### 🧪 스택(Stack)
: 마지막에 저장한 데이터를 먼저 꺼내는 구조, LIFO(Last In First Out)  
ex) 비커🧪처럼, 액체를 넣은 다음 다시 따르면 마지막에 넣은 액체가 먼저 빠져나가는 구조(들어오는 곳 = 나가는 곳)  
=> 배열 기반의 ArrayList로 구현하는 것이 좋다.  
=> 실제로 자바에서, Stack 클래스는 ArrayList의 구버전이라 할 수 있는 Vector 클래스를 상속받아 만들어졌다.  
  
#### Stack 메소드
- boolean empty() : Stack이 비어있는지 알려준다.  
- Object peek() : Stack의 맨 위에 저장된 객체를 반환, pop()과 달리 객체를 반환 후 삭제하지 않는다.  
                  (비어있으면, EmptyStackException 발생)  
- Object pop() : Stack의 맨 위에 저장된 객체를 반환하고 삭제(비어있으면, EmptyStackException 발생)  
- Object push(Object obj) : Stack에 객체(Obj)를 저장한다.  
- int search(Object obj) : Stack에서 주어진 객체(Obj)를 찾아서 그 위치를 반환한다. 못찾으면 -1을 반환
                           (배열과 달리, 위치는 0이 아닌 1에서 시작)  

``` java  
Stack st = new Stack();
st.push("0");
st.push("1");
st.push("2");

while(!st.empty()){
  System.out.println(st.pop());
}

//결과
2
1
0
```  

  
***** 
### 💉 큐(Queue)
: 처음에 저장한 데이터를 먼저 꺼내는 구조, FIFO(First In First Out)  
주사기💉처럼, 액체를 넣고 누르면 먼저 넣은 액체가 먼저 빠져나가는 구조(들어오는 곳 != 나가는 곳)  
=> 데이터를 꺼낼 때 항상 첫번째 데이터를 삭제하기 때문에, LinkedList로 구현하는 것이 좋다. 
=> 실제로 자바에서, Queue는 인터페이스이고 구현체는 LinkedList이다.   

#### Queue 메소드
- boolean add(Object obj) : 지정된 객체를 Queue에 추가한다. 성공하면 true를 반환  
                            (저장공간이 부족하면 IllegalStateException 발생)  
- Object remove() : Queue에서 객체를 꺼내 반환 (비어있으면, NoSuchElementException 발생)    
- Object element() : 삭제없이 요소를 읽어 온다. peek와 달리 Queue가 비었을 때 NoSuchElementException 발생  
- Object offer(Object obj) : Queue에 객체(Obj)를 저장한다. 성공하면 true, 실패하면 false를 반환  
- Object poll() : Queue에서 객체를 꺼내서 반환, 비어있으면 null을 반환  
- Object peak() : 삭제없이 요소를 읽어온다. Queue가 비어있으면 null을 반환  
    
``` java
Queue que = new LinkedList(); //Queue의 인터페이스 구현체 LinkedList 사용
que.offer("0");
que.offer("1");
que.offer("2");

while(!que.isEmpty()){
  System.out.println(que.poll());
}

//결과
0
1
2
```

#### ⭐ 스택(Stack)과 큐(Queue)의 활용
- 스택(Stack) : 수식검사, 수식괄호검사, 워드프로세서의 undo/redo, 웹브라우저의 뒤로/앞으로
- 큐(Queue) : 최근사용문서, 인쇄작업 대기목록, 버퍼(Buffer)


*****
### 💡 덱(Deque, Double-Ended Queue)
: Queue의 변형으로, 양쪽 끝에 추가/삭제가 가능하며 Deque의 조상은 Queue이다. 
![스택&큐](../img/디큐.PNG)  



*****
### ✅ Reference
<https://staticclass.tistory.com/96>

