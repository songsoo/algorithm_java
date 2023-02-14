package SWEA.D4.P2819;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
    static int[][] arr;
    static HashSet<String> set;
    static int[] moveX ={-1,0,1,0},moveY={0,-1,0,1};
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("E:\\SSAFY9\\intelliJ_workspace\\algorithm_java\\src\\SWEA\\D4\\P2819\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T=Integer.parseInt(bf.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            arr = new int[4][4];
            set = new HashSet<>();

            for (int i = 0; i < 4; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < 4; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    goNext(i,j,"");
                }
            }

        }

    }

    public static void goNext(int x, int y, String str){

    }
}
