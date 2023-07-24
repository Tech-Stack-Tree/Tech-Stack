import java.util.*;
//더맵게
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int answer = 0;
        for(int scv : scoville){
            //우선순위 큐에 제일 작은값이 먼저 나오도록 값들을 다 넣어줌
            pq.add(scv);
        }
        //큐에서 꺼낸 값이 K보다 크면 바로 0 리턴(섞지않아도 됨)
        if(pq.peek()>=K){
            return 0;
        }
        int tmp = 1;//큐에서 제일 작은 값 매칭

        //tmp가 K보다 커질때까지 반복
        while(tmp<K && pq.size()>=2){
            answer++;
            int scv1 = pq.poll();
            int scv2 = pq.poll();

            int newScv = scv1+(scv2*2);
            pq.add(newScv);
            tmp=pq.peek();
        }
        if(pq.size()<2){
            tmp=pq.peek();
        }
        if(tmp<K){
            answer=-1;
        }
        return answer;
    }
}