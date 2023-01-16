package SWEA.D2.P1959;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int N,M,T;
    static int[] arrA, arrB;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/SWEA/D2/P1959/input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {

            st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if(N<M){
                arrA = new int[N];
                arrB = new int[M];

                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < N; j++) {
                    arrA[j] = Integer.parseInt(st.nextToken());
                }
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < M; j++) {
                    arrB[j] = Integer.parseInt(st.nextToken());
                }

            }else{
                int tmp = N;
                N = M;
                M = tmp;
                arrA = new int[N];
                arrB = new int[M];

                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < M; j++) {
                    arrB[j] = Integer.parseInt(st.nextToken());
                }
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < N; j++) {
                    arrA[j] = Integer.parseInt(st.nextToken());
                }

            }

            int max = Integer.MIN_VALUE;
            // 이동 횟수
            for (int j = 0; j < M-N+1; j++) {
                // 계산하기
                int sum = 0;
                for (int k = 0; k < N; k++) {
                    sum += arrA[k]*arrB[j+k];
                }
                if(sum>max){
                    max = sum;
                }
            }
            System.out.println("#"+(i+1)+" "+max);




        }


    }

}
