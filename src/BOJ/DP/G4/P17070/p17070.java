package BOJ.DP.G4.P17070;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p17070 {
    static int T;
    static int map[][], dp[][][];
    static int[][] checkX={{1},{1,1,0},{0}}, checkY={{0},{0,1,1},{1}};
    static int[] moveX={1,1,0}, moveY={0,1,1};
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("E:\\SooHyeon\\intelliJWorkSpace\\algorithm_java\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());
        map = new int[T][T];
        dp = new int[T][T][3];
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < T; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[i][j],-1);
            }
        }
        dp[0][1][2] = 0;
        dp[T-1][T-1][0] = 1;
        dp[T-1][T-1][1] = 1;
        dp[T-1][T-1][2] = 1;

        // 0 : 세로 1: 대각선 2: 가로
        System.out.println(dfs(new movePipe(0,1,2)));


    }

    public static int dfs(movePipe pip){

        if(pip.x == T-1 && pip.y==T-1){
            return 1;
        }

        loop:
        for (int i = 0; i < 3; i++) {
            if((pip.status==0 && i==2) || (pip.status==2 && i==0)){
                continue;
            }

            for (int j = 0; j < checkX[i].length; j++) {
                int nextX = pip.x + checkX[i][j];
                int nextY = pip.y + checkY[i][j];
                if(!check(nextX, nextY)){
                    continue loop;
                }
            }
            int nextX = pip.x+moveX[i];
            int nextY = pip.y+moveY[i];
            if(dp[nextX][nextY][i]!=-1){
                dp[pip.x][pip.y][pip.status] += dp[nextX][nextY][i];
            }else{
                dp[nextX][nextY][i] = 0;
                dp[pip.x][pip.y][pip.status] += dfs(new movePipe(pip.x+moveX[i], pip.y+moveY[i],i));
            }
        }
        return dp[pip.x][pip.y][pip.status];
    }


    public static boolean check(int x, int y){
        if(x>=0 && x<T && y>=0 && y<T && map[x][y]!=1){
            return true;
        }
        return false;
    }


}
class movePipe{
    int x;
    int y;
    int status;
    public movePipe(int x, int y, int status) {
        this.x = x;
        this.y = y;
        this.status = status;
    }
}
