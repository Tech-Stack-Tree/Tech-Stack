import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
				//FIFO 먼저들어온 것 먼저 나가는 큐 선언
        Queue<Integer> qu = new LinkedList<Integer>();
        for(int i=0; i< progresses.length; i++) {
						
						//큐에 넣어주기(반올림해서)
            qu.add((int)Math.ceil((100.0-progresses[i])/speeds[i]));
        }
        
				//ArrayList 선언
        ArrayList<Integer> result = new ArrayList<Integer>();
        
				//큐가 empty가 될 때까지 반복하기
        while(!qu.isEmpty()) {
						
						//날짜
            int day = qu.poll();
						//1일부터시작
            int cnt = 1;
            
            while(!qu.isEmpty() && day >= qu.peek()) {
                cnt++;
                qu.poll();
            }
            result.add(cnt);
        }
        
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size();i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}
