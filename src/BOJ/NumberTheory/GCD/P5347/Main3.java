package BOJ.NumberTheory.GCD.P5347;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main3 {

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());


        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long gcd = gcd(a,b);

            long lcm = a * b / gcd;
            System.out.println(lcm);

        }

    }
    public static long gcd(long a, long b){
        long temp = Math.min(a,b);
        a = Math.max(a,b);
        b = temp;
        while(b!=0){
            temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
