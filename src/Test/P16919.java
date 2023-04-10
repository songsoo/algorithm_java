package Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P16919 {
    static int R,C,N;
    static char[][] arr, bombedArr, noneArr;
    static int[] moveX={0,-1,0,1,0}, moveY={0,0,-1,0,1};
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("E:\\ssafy\\intelliJWorkSpace\\src\\Test\\input.txt"));
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        bombedArr = new char[R][C];
        noneArr = new char[R][C];

        for (int i = 0; i < R; i++) {
            arr[i] = bf.readLine().toCharArray();
            Arrays.fill(bombedArr[i],'O');
            Arrays.fill(noneArr[i],'O');
        }

        // N이 홀수인 경우엔 모두 O
        if(N%2==0){
            printArr(noneArr);
        }else if((N/2)%2==0){
            printArr(arr);
        }else if((N/2)%2==1){
            for (int i = 0; i < R; i++) {
                loop:
                for (int j = 0; j < C; j++) {
                    for (int k = 0; k < 4; k++) {
                        int nextX = i+moveX[k];
                        int nextY = j+moveY[k];
                        if(nextX>=0 && nextX<R && nextY>=0 && nextY<C){
                            if(arr[nextX][nextY]=='O'){
                                bombedArr[i][j] = '.';
                                continue loop;
                            }
                        }
                    }
                }
            }
            printArr(bombedArr);
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

}
