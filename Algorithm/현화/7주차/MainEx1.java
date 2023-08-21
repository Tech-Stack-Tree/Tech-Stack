import java.util.*;
//전력망을 둘로 나누기
class Solution {
    static ArrayList<Integer>[] list;
    static boolean[] visited;

    public int solution(int n, int[][] wires) {

        list = new ArrayList[n+1];
        visited=new boolean[n+1];


        for(int i=1;i<=n;i++){
            list[i]=new ArrayList<>();
        }

        for(int i=0;i<wires.length;i++){
            int a=wires[i][0];
            int b=wires[i][1];

            list[a].add(b);
            list[b].add(a);
        }
        int answer=Integer.MAX_VALUE;
        for(int i=0;i<wires.length;i++){
            int w1 = wires[i][0];
            int w2 = wires[i][1];

            int n1 = bfs(w1,w2,n);
            int n2 = bfs(w2,w1,n);

            answer=Math.min(answer,Math.abs(n1-n2));
        }

        return answer;
    }

    public static int bfs(int a, int b,int cnt){
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[cnt+1];
        int count=0;
        q.add(a);
        visited[a] = true;
        while(!q.isEmpty()){
            int n1 = q.poll();
            count++;
            for(int next : list[n1]){
                if(next != b && !visited[next]){
                    q.add(next);
                    visited[next]=true;
                }
            }
        }
        return count;
    }
}