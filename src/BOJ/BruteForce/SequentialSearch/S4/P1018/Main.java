package BOJ.BruteForce.SequentialSearch.S4.P1018;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int M,N;
    static int[][] board;
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("D:\\IntelliJ\\algorithm_java\\src\\BOJ\\S4\\P1018\\input.txt"));

        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        board = new int[M][N];

        for (int i = 0; i < M; i++) {
            String line = bf.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        // 딱 보자마자 들은 생각은 모든 8*8을 돌면서
        // 행렬로 봤을 때 행과 열의 합이 짝인 것들과 홀인 것들이 모두 같은 색상이어야 하기 때문에
        // 임의로 홀수를 B, 짝수를 W로 하여 잘못된 개수를 구하여 Math.abs(최대 - 잘못된 개수);를 한다.
        // WBWB로 정렬되었다면 모두가 잘못되었다고 나오고 여기서 잘못된 녀석이 있으면 전부 잘못된 것에서 하나만 제대로 되었다고 나올 것이다

        int min = 32;
        for (int i = 0; i < M-8+1; i++) {
            for (int j = 0; j < N-8+1; j++) {
                min = Math.min(min,checkWrongSmallBoard(i,j));
            }
        }
        System.out.println(min);
    }

    public static int checkWrongSmallBoard(int x, int y){
        int cnt = 0;
        for (int i = x; i < x+8; i++) {
            for (int j = y; j < y+8; j++) {
                // 짝수는 B가 맞고 홀수는 W가 맞는거로 한다.
                if((i+j)%2==0){
                    cnt = board[i][j]=='B' ? cnt : cnt+1;
                }else{
                    cnt = board[i][j]=='W' ? cnt : cnt+1;
                }
            }
        }
        // 잘못 된게 0개이거나 32개일 때 최소
        // 잘못된 녀석들밖에 없을 때 (32개 이상) 제대로 된 녀석이 하나라면 잘못된 녀석은 63개로 나온다
        // 근데 제대로 된 녀석을 잘못된 녀석으로 바꾸면 사실상 맞는 체스판이니까 64 - 63 = 1
        return cnt>=32? 64-cnt:cnt;
    }

}
