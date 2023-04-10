package BOJ.BruteForce.SequentialSearch.G4.P14500;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14500 {
    static int N,M,MAX;
    static int[][] arr;
    static int[][] moveX={{-1,1,-1,1,-1,1,0},{0,0,1,1,2,2,3},{1}}
            ,moveY={{0,0,1,1,2,2,3},{-1,1,-1,1,-1,1,0},{1}};
    static int[][] curveMoveX={{0,0,1,1},{0,0,1,1},{0,1,1,2},{0,1,1,2}}
            ,curveMoveY={{0,1,1,2},{1,2,0,1},{0,0,1,1},{1,1,0,0}};
    static int[] checkX={0,2,1},checkY={2,0,1};

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("E:\\ssafy\\intelliJWorkSpace\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        MAX = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        goCheck(0,0);
        System.out.println(MAX);

    }

    public static void goCheck(int x, int y){
        if(x==N){
            return;
        }
        for (int i = 0; i < checkX.length; i++) {
            int sum = 0;
            if (check(x + checkX[i], y + checkY[i])) {

                for (int j = 0; j <= checkX[i]; j++) {
                    sum += arr[x + j][y];
                }
                for (int j = 1; j <= checkY[i]; j++) {
                    sum += arr[x][y + j];
                }

                for (int j = 0; j < moveX[i].length; j++) {
                    int nextX = x + moveX[i][j];
                    int nextY = y + moveY[i][j];
                    if (check(nextX, nextY)) {
                        int temp = sum;
                        temp += arr[nextX][nextY];
                        MAX = Math.max(temp, MAX);
                    }
                }
            }
        }
        checkCurve(x,y);
        y++;
        if(y==M){
            y = 0;
            x++;
        }
        goCheck(x,y);
    }

    public static void checkCurve(int x, int y){
        for (int i = 0; i < 4; i++) {
            int sum = 0 ;
            for (int j = 0; j < 4; j++) {
                int nextX = x + curveMoveX[i][j];
                int nextY = y + curveMoveY[i][j];
                if(check(nextX,nextY))sum += arr[nextX][nextY];
            }
            MAX = Math.max(sum,MAX);
        }
    }

    public static boolean check(int x, int y){
        if(x>=0 && x< N && y>=0 && y<M){
            return true;
        }return false;
    }
}
