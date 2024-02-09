package BOJ.BruteForce.BackTracking.Silver.P1182;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, S;
    static boolean[] visited;
    static int[] arr;
    static int sum,count;
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("E:\\SSAFY9\\intelliJ_workspace\\algorithm_java\\src\\BOJ\\S2\\P1182\\input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];
        
        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sum = 0;
        count = 0;
        dfs(-1);
        System.out.println(count);

    }
    public static void dfs(int i){
        for (int j = i+1; j < N; j++) {
            sum += arr[j];
            if(sum==S){
                count++;
            }
            dfs(j);
            sum -= arr[j];
        }
    }
}
