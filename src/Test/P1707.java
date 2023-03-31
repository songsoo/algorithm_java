package Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1707 {
    static int K, V, E;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(bf.readLine());

        for (int test_case = 0; test_case < K; test_case++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            V= Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(bf.readLine());
                int a1 = Integer.parseInt(st.nextToken());
                int a2 = Integer.parseInt(st.nextToken());
            }

        }
    }
}
