import java.util.*;
//리코쳇 로봇
class Solution {
    static int row,col;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static boolean[][] visit;
    static char[][] gameBoard;

    public int solution(String[] board) {
        int answer = 0;

        row = board.length;
        col = board[0].length();

        visit = new boolean[row][col];
        gameBoard = new char[row][col];

        int startX = 0;
        int startY = 0;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                gameBoard[i][j] = board[i].charAt(j);
                if(gameBoard[i][j]=='R'){
                    startX = i;
                    startY = j;
                }
            }
        }
        answer = bfs(startX, startY);


        return answer;
    }

    static int bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y,0));

        int count=0;

        while(!q.isEmpty()){
            Node node = q.poll();
            if(gameBoard[node.x][node.y]=='G'){
                count=node.count;
                break;
            }
            visit[node.x][node.y]=true;

            for(int i=0;i<4;i++){
                int nx = node.x;
                int ny = node.y;

                while(true){
                    nx += dx[i];
                    ny += dy[i];

                    if(nx<0||ny<0||nx==row||ny==col){
                        nx-=dx[i];
                        ny-=dy[i];
                        break;
                    }

                    if(gameBoard[nx][ny]=='D'){
                        nx-=dx[i];
                        ny-=dy[i];
                        break;
                    }
                }
                if(visit[nx][ny])
                    continue;
                q.offer(new Node(nx,ny, node.count+1));
            }
        }
        return count == 0 ? -1 : count;
    }
    static class Node{
        int x;
        int y;
        int count;

        public Node(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }

    }
}