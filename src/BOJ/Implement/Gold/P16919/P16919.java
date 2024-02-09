package BOJ.Implement.Gold.P16919;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P16919 {
    static int R,C,N;
    static char[][][] arr;
    static int[] moveX={0,-1,0,1,0}, moveY={0,0,-1,0,1};
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("E:\\ssafy\\intelliJWorkSpace\\src\\Test\\input.txt"));
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        //0: 기본, 1: 모두 설치, 2: 초기 폭파 3: 2차 폭파
        arr = new char[4][R][C];

        for (int i = 0; i < R; i++) {
            arr[0][i] = bf.readLine().toCharArray();
            Arrays.fill(arr[1][i],'O');

        }
        arr[2] = bomb(arr[0]);
        arr[3] = bomb(arr[2]);

        if(N%2==0){
            printArr(arr[1]);
        }else{
            if(N==1){
                printArr(arr[0]);
            }else if((N/2)%2==0){
                printArr(arr[3]);
            }else if((N/2)%2==1){
                printArr(arr[2]);

            }
        }

    }
    public static void printArr(char[][] arr){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }

    public static char[][] bomb(char[][] originArr){

        char[][] arr = new char[R][C];
        for (int i = 0; i < R; i++) {
            Arrays.fill(arr[i],'O');
        }

        for (int i = 0; i < R; i++) {
            loop:
            for (int j = 0; j < C; j++) {
                for (int k = 0; k < 5; k++) {
                    int nextX = i+moveX[k];
                    int nextY = j+moveY[k];
                    if(nextX>=0 && nextX<R && nextY>=0 && nextY<C){
                        if(originArr[nextX][nextY]=='O'){
                            arr[i][j] = '.';
                            continue loop;
                        }
                    }
                }
            }
        }

        return arr;
    }

}
