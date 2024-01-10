package BOJ.SimpleSilver.P1080;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, result;
    static int[][] arr1, arr2;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = Integer.MAX_VALUE;
        arr1 = new int[N][M];
        arr2 = new int[N][M];

        for (int i = 0; i < N; i++) {
            char[] str = bf.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                arr1[i][j] = str[j]-48;
            }
        }

        for (int i = 0; i < N; i++) {
            char[] str = bf.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                arr2[i][j] = str[j]-48;
            }
        }

        int count = 0;
        for (int i = 1; i < N-1; i++) {
            for (int j = 1; j < M-1; j++) {
                if(arr1[i-1][j-1]!=arr2[i-1][j-1]){
                    flip(i,j);
                    count++;
                }
            }
        }
        if(isSame()){
            System.out.println(count);
        }else{
            System.out.println(-1);
        }

    }

    public static void flip(int x, int y){
        for (int i = x-1; i <= x+1; i++) {
            for (int j = y-1; j <= y+1 ; j++) {
                arr1[i][j] = (arr1[i][j]+1)%2;
            }
        }
    }

    public static boolean isSame(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(arr1[i][j]!=arr2[i][j]){
                    return false;
                }
            }
        }
        return true;
    }


}
