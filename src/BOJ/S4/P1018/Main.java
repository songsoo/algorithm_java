package BOJ.S4.P1018;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 문제를 봤을 때 처음엔 모든 사탕을 다 움직일 수 있고 그 상태에서 최대 길이를 구하라는 줄 알고 난감했다
    // 사실 대부분의 경우 그렇게 하면 가장 많은 색깔을 선택하면 될 것 같기도 하다
    // 이 문제는 모든 사탕을 돌면서 상하좌우로 움직이는 좌표 이동 문제라고 생각된다.
    // 1. 각 사탕을 모두 상하좌우로 이동하고 해당 위치의 자신의 길이만 확인하면 될 것으로 판단된다

    // 처음엔 해당하는 라인의 같은 문자 개수를 다 구했는데
    // 연속적으로 이어지지 않는 경우도 catch를 한다거나 현재 위치가 아닌 다른 위치의 최대 길이를 구하는 경우가 생겨서 제외함
    static int N, max;
    static char[][] board;
    static int[] moveX = {1,-1,0,0}, moveY = {0,0,1,-1};
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("E:\\SSAFY9\\intelliJ_workspace\\algorithm_java\\src\\BOJ\\S4\\P1018\\input.txt"));


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        max = 0;
        board = new char[N][N];
        for (int i = 0; i < N; i++) {
            board[i] = bf.readLine().toCharArray();
        }

        checkBoard(0,0);

        System.out.println(max);

    }

    public static void checkBoard(int x, int y){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 4; k++) {
                    int nextX = i+moveX[k];
                    int nextY = j+moveY[k];
                    if(nextX>=0 && nextX<N && nextY>=0 && nextY<N){
                        max = Math.max(max, locMax(nextX,nextY));
                    }
                }
            }
        }
    }

    public static int locMax(int x, int y){
        // x,y 위치가 2번 들어가니까 cntX를 -1로 초기화
        int cntX = 0;
        int cntY = 0;
        for (int i = y; i < N; i++) {
            if(i==y){
                cntY++;
                continue;
            }
            if(!(board[x][y]==board[x][i])){
                break;
            }
            cntY++;

        }
        for (int i = y; i >=0; i--) {
            if(i==y){
                cntY++;
                continue;
            }
            if(!(board[x][y]==board[x][i])){
                break;
            }
            cntY++;
        }
        for (int i = x; i < N; i++) {
            if(i==x){
                cntX++;
                continue;
            }
            if(!(board[x][y]==board[i][y])){
                break;
            }
            cntX++;

        }
        for (int i = x; i >=0; i--) {
            if(i==x){
                cntX++;
                continue;
            }
            if(!(board[x][y]==board[i][y])){
                break;
            }
            cntX++;
        }
        return Math.max(cntX,cntY);
    }

}
