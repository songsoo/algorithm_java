package BOJ.Implement.B3.P20053;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaIN3 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int test_case = 0; test_case < T; test_case++) {
            int N = Integer.parseInt(bf.readLine());
            int min = 1000000, max = -1000000;
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < N; i++) {
                int cur = Integer.parseInt(st.nextToken());
                min = Math.min(min, cur);
                max = Math.max(max, cur);
            }
            sb.append(min+" "+max+"\n");
        }
        System.out.println(sb.toString());
    }
}
