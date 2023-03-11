package BOJ.DP.S1.P11660;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\SSAFY\\IdeaProjects\\algorithm_java\\src\\Test\\Input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                int cur = Integer.parseInt(st.nextToken());
                int prev = 0;
                if(i!=0){
                    prev = arr[i-1][j];
                }
                arr[i][j] = cur + sum + prev;
                sum += cur;
            }
        }


        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(bf.readLine());

            int sum = 0;

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            sum += arr[x2][y2];
            sum -= arr[x1-1][y2];
            sum -= arr[x2][y1-1];
            sum += arr[x1-1][y1-1];

            sb.append(sum+"\n");
        }
        System.out.println(sb.toString());
    }
}
