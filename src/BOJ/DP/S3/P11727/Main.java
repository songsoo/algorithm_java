package BOJ.DP.S3.P11727;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] dp;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        dp = new int[N];
        goNext(0);
        System.out.println(dp[0]);
    }
    public static int goNext(int index){
        if(index>N){
            return 0;
        }
        if(index==N){
            return 1;
        }
        if(dp[index]!=0){
            return dp[index];
        }
        // 1자 스틱 더하기
        dp[index]+=goNext(index+1);
        // = 스틱 더하기
        dp[index] %= 10007;
        dp[index]+=goNext(index+2) * 2;
        dp[index] %= 10007;
        return dp[index];
    }
}
