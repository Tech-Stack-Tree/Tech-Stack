import java.util.Scanner;
//백준 n-queen
// 풀이 : https://iseunghan.tistory.com/251
public class Main {
    static boolean[][] visit;
    static int[][] arr;
    static int N;
    static int result = 0;

    public static void dfs(int n) {
        if (n == N) {
            result++;
            return;
        }

        for (int j = 0; j < N; j++) {
            if (!visit[n][j]) {
                visit[n][j] = true;
                arr[n][j] = 1;

                /* 퀸의 공격방향 체크 */
                check_queen_Atack(n, j);

                dfs(n + 1);

                /* 이전 상태로 돌아가기 */
                arr[n][j] = 0;	// 퀸을 빼고,
                init_visit();	// 초기화를 시킨뒤

                /* 이전에 두었던 퀸의 위치 복원 */
                for (int i = 0; i < N; i++) {
                    for (int p = 0; p < N; p++) {
                        if (arr[i][p] == 1)
                            check_queen_Atack(i, p);
                    }
                }
            }
        }
    }

    /* 퀸의 공격 방향 표시하는 메소드 */
    public static void check_queen_Atack(int a, int b) {
        /* 아래 방향 */
        for (int i = a; i < N; i++) {
            visit[i][b] = true;
        }
        /* 왼쪽 대각선 */
        int c = a;
        int d = b;
        while (0 <= d && d < N & 0 <= c & c < N) {
            visit[c++][d--] = true;
        }
        /* 오른쪽 대각선 */
        while ((0 <= a && a < N & (0 <= b && b < N))) {
            visit[a++][b++] = true;
        }
    }

    /* 체스판 초기화 시키는 메소드 */
    public static void init_visit() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visit[i][j] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        visit = new boolean[N][N];
        arr = new int[N][N];
        dfs(0);
        System.out.println(result);
    }
}