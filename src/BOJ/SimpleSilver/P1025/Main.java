package BOJ.SimpleSilver.P1025;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int arr[][];
    static int N,M,max;
    public static void main(String[] args) throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        max = -1;

        for (int i = 0; i < N; i++) {
            String cur = bf.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = cur.charAt(j)-48;
                if(isPow(arr[i][j])){
                    max = Math.max(arr[i][j], max);
                }
            }
        }

        // 시작 지점
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 등차 수열
                for (int k = -N; k < N; k++) {
                    for (int l = -M; l < M; l++) {
                        if(k==0 && l==0)continue;
                        checkPow(i,j,k,l);
                    }
                }


            }
        }

        System.out.println(max);

    }

    public static void checkPow(int i, int j, int k, int l){

        int num = 0;
        int index = 1;
        while(true){
            int cur = arr[i][j];
            num += cur * index;

            if(isPow(num)){
                max = Math.max(max, num);
            }

            i += k;
            j += l;

            if(!check(i,j))break;
            index *= 10;
        }
    }

    public static boolean check(int i, int j){
        if(i<0 || i>=N || j<0 || j>=M){
            return false;
        }
        return true;
    }

    public static boolean isPow(int n){
        return Math.sqrt(n) == (int)Math.sqrt(n);
    }
}
