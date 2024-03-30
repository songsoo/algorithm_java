package BOJ.NumberTheory.Bronze.P21756;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int cnt = 0;
        while(N>1){
            N = N>>1;
            cnt++;
        }
        System.out.println((int)Math.pow(2, cnt));
    }
}
