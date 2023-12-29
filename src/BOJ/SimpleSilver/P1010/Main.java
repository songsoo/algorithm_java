package BOJ.SimpleSilver.P1010;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            System.out.println(p(N,M));

        }

    }
    public static long p(int n, int m){
        long sum = 1;
        n = Math.min(n,m-n);
        for (int i = m; i > m-n; i--) {
            sum *= i;
        }
        for (int i = n; i > 1; i--) {
            sum /= i;
        }
        return sum;
    }
}
