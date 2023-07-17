//같은 숫자는 싫어!(level1)

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
    
			//스택 선언
        Stack<Integer> stack = new Stack<>();
        

			//향상된 for문
        for(int n : arr) {

			//스택이 비어있거나 들어오는 값과 같지 않으면
			//스택에 add(push)해줌
         if(stack.isEmpty() || stack.peek()!=n){
             stack.add(n);
         } 
        }

				//stack의 수만큼 answer배열 만듦
        int[] answer = new int[stack.size()];
        int index = 0;

				//들어오는 값, index값을 증가하여 배열 출력
        for(int n:stack) {
            answer[index++] = n;
        }
        return answer;
    }
}
