import java.util.*;
//게임맵 최단거리
class Solution {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int width;
    static int height;
    static boolean[][] visited;
    public int solution(int[][] maps) {
        width=maps.length;
        height=maps[0].length;

        //int answer = 0;
        visited = new boolean[maps.length][maps[0].length];
        int answer = bfs(new Node(0,0,0), maps);
        return answer;
    }

    static int bfs(Node node, int[][] maps){
        Queue<Node> q = new LinkedList<>();

        q.offer(node);
        int count = 0;
        while(!q.isEmpty()){
            Node popNode = q.poll();//q에서 노드꺼냄
            int nowX = popNode.x;
            int nowY = popNode.y;
            int nowCnt = popNode.cnt;

            if(nowX==width-1 && nowY==height-1){
                return nowCnt+1;
            }

            //상하좌우로 돌면서 위치 찾음
            for(int i=0;i<4;i++){
                int newX = nowX+dx[i];
                int newY = nowY+dy[i];

                if(!isSuitable(newX, newY)){    //조건에 맞지 않으면 continue
                    continue;
                }

                if(!visited[newX][newY] && maps[newX][newY]==1){
                    //방문도 안했고 조건에 맞으면 이동
                    visited[newX][newY]=true;
                    q.offer(new Node(newX,newY,nowCnt+1));
                }


            }

        }
        return -1;

    }

    static class Node{
        int x;
        int y;
        int cnt;
        public Node(int x, int y, int cnt){
            this.x=x;
            this.y=y;
            this.cnt=cnt;
        }
    }

    static boolean isSuitable(int x, int y){
        if(x>=width||x<0||y>=height||y<0){
            return false;
        }else{
            return true;
        }

    }
}