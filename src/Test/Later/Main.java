package Test.Later;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean[] avail;
    static int[] dp;
    static int[] pay = {10000, 25000, 37000};
    static int N,M;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        avail = new boolean[N+1];
        dp = new int[N+1];

        st = new StringTokenizer(bf.readLine());
        Arrays.fill(avail, true);
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < M; i++) {
            avail[Integer.parseInt(st.nextToken())] = false;
        }

        System.out.println(goNext(0, 0, 0));
    }

    public static int goNext(int curDay, int money, int couponCount){

        while(curDay<N &&!avail[curDay]){
            curDay++;
        }
        dp[curDay] = money;

        int min = Integer.MAX_VALUE;
        if(couponCount >= 3){
            if(dp[curDay+1]>money){
                min = Math.min(goNext(curDay+1, money, couponCount-3), min);
            }
        }else{
            if(dp[curDay+1]>money+10000){
                min = Math.min(goNext(curDay+1, money+10000, couponCount),min);
            }
        }
        if(dp[curDay+3]>money+25000){
            min = Math.min(goNext(curDay+3, money+25000, couponCount+1), min);
        }
        if(dp[curDay+5]>money+37000){
            min = Math.min(goNext(curDay+5, money+37000, couponCount+2), min);
        }
        return min;
    }
}
