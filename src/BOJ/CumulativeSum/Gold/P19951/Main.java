package BOJ.CumulativeSum.Gold.P19951;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr, dig;
    public static void main(String[] args) throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+2];
        dig = new int[N+2];
        st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int depth = Integer.parseInt(st.nextToken());
            dig[from] += depth;
            dig[to+1] -= depth;
        }

        int cur = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            cur += dig[i];
            arr[i] += cur;
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb.toString());
    }
}
