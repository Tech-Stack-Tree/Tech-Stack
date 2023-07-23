import java.util.*;

//이중 우선순위큐
class Solution {
    public int[] solution(String[] operations) {
        int count=0;//각 큐에 남아있는 개수를 체크하기 위해 선언

        PriorityQueue<Integer> Maxq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> Minq = new PriorityQueue<>();
        //이중 우선순위 큐 생성 : 하나는 reverseOrder 해서 큰 내림차 순으로 큐에 담도록

        for(String op : operations){
            String[] arr = op.split(" "); //띄어쓰기 기준으로 자름

            if(arr[0].equals("I")){
                int num = Integer.parseInt(arr[1]);
                Maxq.offer(num);
                Minq.offer(num);
                //두 큐에 모두 넣어줌
                count++;//삽입 연산이므로 count더해줌
            }else if(count>0 && arr[0].equals("D")){//큐가 비어있지 않다면 삭제로직 실행 : 비어있으면 무시
                if(arr[1].equals("1")){ //최대값 삭제 로직
                    int num = Maxq.peek();
                    Maxq.poll();
                    Minq.remove(num);
                }else if(arr[1].equals("-1")){  //최소값 삭제 로직
                    int num = Minq.peek();
                    Maxq.remove(num);
                    Minq.poll();
                }
                count--;//삭제연산이므로 count 빼줌
            }
        }

        int answer[] = new int[2];

        if(count<=0){//큐가 비어있다면 [0,0] 입력
            answer[0]=0;
            answer[1]=0;
        }else{//큐가 비어있지않다면 최소값 큐, 최대값 큐에서 하나씩 빼서 입력해줌
            int max = Maxq.poll();
            int min = Minq.poll();
            answer[0]=max;
            answer[1] = min;
        }

        return answer;
    }
}