import java.util.*;
import java.io.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static int n,m;
    static boolean[] visit;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visit = new boolean[n];
        asrr = new int[m];
        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int depth){
        if(depth == m){
            for(int val : arr){
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0;i<n;i++){
            //해당 노드를 방문하지 않았다면
            if(!visit[i]){
                visit[i]=true;
                arr[depth]=i+1;//해당 깊이를 index로 하여 i+1값 저장
                dfs(depth+1);
                visit[i]=false;//자식노드 방문이 끝나고 돌아오면 방문노드 방문하지 않은 상태로 변경
            }
        }
    }
}