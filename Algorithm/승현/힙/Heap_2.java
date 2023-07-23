import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Heap_2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //입력 개수 받기
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> qu = new PriorityQueue<>(Collections.reverseOrder());

        //배열에 넣기
        for(int i = 0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());
            // 자연수가 0이면
            if(num == 0) {
                if (!qu.isEmpty()) {
                    //배열에 가장 큰 출력, 그 값을 배열에서 제거
                    sb.append(qu.poll()).append('\n');
                } else {
                    //배열이 비어있는 경우 0을 출력
                    sb.append(0).append('\n');
                }
            }
            //큐에 있는 값 출력
            qu.add(num);
        }
        System.out.println(sb.toString());
    }
}
