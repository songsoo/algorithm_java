package BOJ.BruteForce.SequentialSearch.S3.P3085;

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

        System.setIn(new FileInputStream("D:\\IntelliJ\\algorithm_java\\src\\BOJ\\S3\\P3085\\input.txt"));


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

        //행마다
        for (int i = 0; i < N; i++) {
            //열마다
            for (int j = 0; j < N; j++) {
                // 사방으로 옮기는 것을 가정
                // 최소로 옮기는 방법은 오른쪽과 아래쪽으로 이동하는 것만 고려하면 되는데 이럴경우 Counting이 어려워진다.
                // CCPPPPCP일 경우 제일 오른쪽 C를 오른쪽으로 옮기면
                // 한 줄을 다 읽으면서 C카운트하다가 P카운트했다가 새로운 C가 나오면 또 새로운 C를 카운트할 방법도 필요하고...
                // 하지만 사방으로 이동하면 현재 자신의 위치에 있는 문자가 이동했을 때 바뀐 위치에서 시작하여
                // 사방으로의 최대 길이만 count하면 되기 때문에 편하다.

                //하.. i와 j가 아니라 x와 y로 대입해서 0, 0을 계속 swap하고 있었다
                for (int k = 0; k < 4; k++) {
                    int nextX = i+moveX[k];
                    int nextY = j+moveY[k];
                    if(nextX>=0 && nextX<N && nextY>=0 && nextY<N){
                        swapBoard(i,j,nextX,nextY);
                        max = Math.max(max, locMax(nextX,nextY));
                        swapBoard(i,j,nextX,nextY);

                    }
                }
            }
        }
    }

    public static void swapBoard(int x, int y, int nextX, int nextY){
        char tmp = board[x][y];
        board[x][y] = board[nextX][nextY];
        board[nextX][nextY] = tmp;
    }

    public static int locMax(int x, int y){
        // x,y 위치가 2번 들어가니까 cntX를 -1로 초기화
        int cntX = -1;
        int cntY = -1;
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
