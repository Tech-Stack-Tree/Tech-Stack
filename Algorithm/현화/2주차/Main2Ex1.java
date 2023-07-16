import java.util.*;
//기능개발
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Stack<Integer> works = new Stack<>();
        HashMap<Integer,Integer> hm = new HashMap<>();

        int MAXED = 100;
        int previous=0;

        for(int i=0;i<progresses.length;i++){
            int module = (MAXED-progresses[i])%speeds[i];
            int value = (MAXED-progresses[i])/speeds[i];//몇일째에 완료되는지
            if(module!=0){
                value++;
            }

            //앞의 작업이 얼마걸리는지
            if(previous==0){
                previous=value;
            }
            if(previous>value){
                //이전 작업이 현재보다 오래걸렸으면
                value=previous;
            }else if(previous<value){
                //현재 작업이 더 오래 걸렸으면
                previous=value;
            }
            hm.put(value,hm.getOrDefault(value,0)+1);//해당 일자에 완료된것이 없으면 플러스 1
            //System.out.println("value : "+value+" prev : "+previous);
        }
        int answer[] = new int[hm.size()];
        List<Integer> keySet = new ArrayList<>(hm.keySet());
        //키 값으로 오름차순 정렬
        Collections.sort(keySet);
        int i=0;
        for(int key:keySet){
            answer[i++]=hm.get(key);
        }
        return answer;
    }
}