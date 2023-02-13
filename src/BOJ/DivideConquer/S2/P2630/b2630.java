package BOJ.DivideConquer.S2.P2630;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2630 {
    static int[][] arr;
    static int cnt0 = 0;
    static int cnt1 = 0;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("E:\\SSAFY9\\intelliJ_workspace\\algorithm_java\\src\\BOJ\\S2\\P2630\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st=  new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, n);

        System.out.println(cnt0);
        System.out.print(cnt1);
    }

    public static void dfs(int x, int y, int p) {
        if (p == 1) {
            if (arr[y][x] == 1) {
                cnt1++;
            }
            else cnt0++;
            return;
        }


        int sum = 0;
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < p; j++) {
                sum += arr[y + i][x + j];
            }
        }
        if (sum == ((int)Math.pow(p,2))) {
            cnt1++;
            return;
        }
        else if (sum == 0) {
            cnt0++;
            return;
        }



        dfs(x, y, p/2);
        dfs(x + p/2, y, p/2);
        dfs(x, y + p/2, p/2);
        dfs(x + p/2, y + p/2, p/2);
    }
}
