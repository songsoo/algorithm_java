package SWEA.D4.P4012;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int T,N,min;
    static int[][] arr;
    static boolean[] visited;
    static boolean[] comb;
    static ArrayList<Integer> taste1, taste2;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("E:\\SSAFY9\\intelliJ_workspace\\algorithm_java\\src\\SWEA\\D4\\P4012\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(bf.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(bf.readLine());
            min = Integer.MAX_VALUE;
            arr = new int[N][N];
            comb = new boolean[N];
            visited = new boolean[N];
            for (int k = 0; k < N; k++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < N; j++) {
                    arr[k][j] = Integer.parseInt(st.nextToken());
                }
            }
            divideIngred(0,0);
            sb.append("#"+(i+1)+" "+min+"\n");
        }
        System.out.println(sb.toString());

    }
    static void divideIngred(int index, int prev){
        //식재료 구하는 방법을 조합으로 나누고
        //조합에 맞게 각각 식재료들에 따라 시너지를 구하고
        //시너지끼리 비교하고 최소값을 찾아낸다.
        if(index==N/2){
            getTaste();
        }else{
            for (int i = prev; i < N; i++) {
                comb[i] = true;
                divideIngred(index+1,i+1);
                comb[i] = false;
            }
        }
    }

    static void getTaste(){

        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if(comb[i]&&comb[j]){
                    sum1+=(arr[i][j]+arr[j][i]);
                }else if(!comb[i]&&!comb[j]){
                    sum2+=(arr[i][j]+arr[j][i]);
                }
            }
        }
        min = Math.min(min,Math.abs(sum1-sum2));
    }
}
