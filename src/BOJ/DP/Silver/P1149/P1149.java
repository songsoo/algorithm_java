package BOJ.DP.Silver.P1149;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1149 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int arr[][] = new int[n][3];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        arr[0][0] = Integer.parseInt(st.nextToken());
        arr[0][1] = Integer.parseInt(st.nextToken());
        arr[0][2] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()) + Math.min(arr[i-1][1],arr[i-1][2]);
            arr[i][1] = Integer.parseInt(st.nextToken()) + Math.min(arr[i-1][0],arr[i-1][2]);
            arr[i][2] = Integer.parseInt(st.nextToken()) + Math.min(arr[i-1][1],arr[i-1][0]);
        }

        System.out.println(Math.min(Math.min(arr[n-1][0],arr[n-1][1]),arr[n-1][2]));
    }
}
