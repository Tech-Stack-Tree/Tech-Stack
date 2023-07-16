import java.util.*;
//프로세스
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int[] loc = new int[priorities.length];

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        //3,2,2,1

        for(int n : priorities){
            pq.offer(n);
        }

        int count=0;
        while(!pq.isEmpty()){
            for(int i=0;i<priorities.length;i++){
                if(!pq.isEmpty() && priorities[i]==pq.peek()){
                    count++;
                    loc[i] = count;
                    pq.poll();
                }
            }
        }
        answer = loc[location];
        return answer;
    }
}