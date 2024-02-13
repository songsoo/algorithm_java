package BOJ.Implement.Gold.P14499;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, x, y, K;
    // 위, 오, 앞, 왼, 뒤, 밑
    static int[] dice = {0,0,0,0,0,0};
    static int[][] map;
    static int[] moveX={0,0,0,-1,1},moveY={0,1,-1,0,0};
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < K; i++) {
            int op = Integer.parseInt(st.nextToken());
            if(check(x+moveX[op], y+moveY[op])){
                x = x+moveX[op];
                y = y+moveY[op];
                roll(op);
                checkBottom(x, y);
                sb.append(dice[0]+"\n");
            }
        }
        System.out.println(sb.toString());

    }
    public static boolean check(int x, int y){
        return x>=0 && x<N && y>=0 && y<M;
    }
    public static void checkBottom(int x, int y){
        if(map[x][y] == 0){
            map[x][y] = dice[5];
        }else{
            dice[5] = map[x][y];
            map[x][y] = 0;
        }
    }
    public static void roll(int i){
        // 동
        if(i==1) {
            int temp = dice[0];
            dice[0] = dice[3];
            dice[3] = dice[5];
            dice[5] = dice[1];
            dice[1] = temp;
        }
        // 서
        else if(i==2) {
            int temp = dice[1];
            dice[1] = dice[5];
            dice[5] = dice[3];
            dice[3] = dice[0];
            dice[0] = temp;
        }
        // 북
        else if(i==3) {
            int temp = dice[4];
            dice[4] = dice[0];
            dice[0] = dice[2];
            dice[2] = dice[5];
            dice[5] = temp;
        }
        // 남
        else if(i==4) {
            int temp = dice[0];
            dice[0] = dice[4];
            dice[4] = dice[5];
            dice[5] = dice[2];
            dice[2] = temp;
        }
    }
    public static void printDice(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.print("위: "+dice[0]);
        System.out.print(" 오: "+dice[1]);
        System.out.print(" 앞: "+dice[2]);
        System.out.print(" 왼: "+dice[3]);
        System.out.print(" 뒤: "+dice[4]);
        System.out.println(" 밑: "+dice[5]);
    }
}
