package BOJ.DP.G1.P1509;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N;
    static char[] arr;
    static int[] dp;
    static boolean[][] palindrome;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));

        Scanner sc = new Scanner(System.in);
        arr = sc.nextLine().toCharArray();
        N = arr.length;
        dp = new int[N+1];
        palindrome = new boolean[N+1][N+1];

        for (int i = 1; i < N+1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        checkPalindrome();
        getPalindrome();

        System.out.println(dp[N]);
    }

    public static void checkPalindrome(){
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                int s = i-1;
                int e = j-1;
                boolean flag = true;
                while(s<e){
                    if(arr[s++]!=arr[e--]){
                        flag = false;
                        break;
                    }
                }
                palindrome[i][j] = flag;
            }
        }
    }

    public static void getPalindrome(){
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j <= i; j++) {
                if(palindrome[j][i]){
                    dp[i] = Math.min(dp[i],dp[j-1]+1);
                }
            }
        }
    }

}
