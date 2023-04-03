package SWEA.D6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea1263 {
    static int T,N,INF = 999999;
    static int arr[][];
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("E:\\ssafy\\intelliJWorkSpace\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());
        for (int test_case = 1; test_case <= T ; test_case++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            N = Integer.parseInt(st.nextToken());
            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken())==1?1:INF;
                }
                arr[i][i] = 0;
            }

            for (int i = 0; i < N; i++) {
                FW(i);
            }
            int min = INF;
            for (int i = 0; i < N; i++) {
                int sum = 0;
                for (int j = 0; j < N; j++) {
                    if(arr[i][j]<INF){
                        sum += arr[i][j];
                    }
                }
                if(min>sum){
                    min = sum;
                }
            }
            System.out.println("#"+test_case+" "+min);

        }

    }

    public static void FW(int k){
        for (int i = 0; i < N; i++) {
            if(i==k)continue;
            for (int j = 0; j < N; j++) {
                if(i==j || j==k) continue;
                arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
            }
        }
    }
}
