import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Heap_1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //입력 개수 받기
        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> qu = new PriorityQueue<>();

        //배열에 넣기
        for(int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            // 자연수가 0이면 
                if(num == 0) {
                    if (!qu.isEmpty()) {
                        //배열에 가장 작은 숫자 출력, 그 값을 배열에서 제거
                        System.out.println(qu.poll());
                        br.readLine();
                    } else {
                        //배열이 비어있는 경우 0을 출력
                        System.out.println(0);
                        br.readLine();
                    }
                    continue;
                }
                //큐에 있는 값 출력
            qu.add(num);
        }
    }
}
