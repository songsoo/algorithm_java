package SOFTEER.P6249;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M, min;
    static char[][] arr, superArr;
    public static void main(String[] args) throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        min = N;

        arr = new char[N][M];
        superArr = new char[N][M];

        for(int i=0; i<N; i++){
            arr[i] = bf.readLine().toCharArray();
            Arrays.fill(superArr[i],'.');
        }

        goNext(0,0);
        System.out.println(min);

    }

    public static void goNext(int idx, int cnt){
        if(cnt>=min){
            return;
        }
        if(idx==N){
            min = Math.min(min, cnt);
            return;
        }

        char[] prev = new char[M];
        // 기존에 있던 것과 비교 및 추가
        loop:
        for(int i=0; i<cnt; i++){
            prev = Arrays.copyOf(superArr[i], M);
            for(int j=0; j<M; j++){
                if(superArr[i][j]=='.'){
                    superArr[i][j] = arr[idx][j];
                }else if(arr[idx][j]=='.'){

                }
                // 다른거 나오면 복구 시킴
                else if(superArr[i][j]!=arr[idx][j]){
                    superArr[i] = Arrays.copyOf(prev, M);
                    continue loop;
                }
            }
            // 변경 후 보내고
            goNext(idx+1, cnt);
            // 다시 복구 시킴
            superArr[i] = Arrays.copyOf(prev, M);
        }
        // 새롭게 추가
        superArr[cnt] = Arrays.copyOf(arr[idx], M);
        goNext(idx+1, cnt+1);
    }
}