import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Stack st = new Stack<>();
        
        for(int i=0; i<arr.length; i++){
            int num = arr[i];
  
            if(i!=0 && (int)st.peek() == num) continue;
            
            st.push(num);
        }
        
        Integer[] answer = new Integer[st.size()];
        int idx = 0;
        while(!st.empty()){
            answer[idx] = (int)st.pop() ;
            idx++;
        }
        
        List<Integer> list = Arrays.asList(answer);
        Collections.reverse(list);
        answer = list.toArray(answer);

        return Arrays.stream(answer).mapToInt(Integer::intValue).toArray();
    }
}
