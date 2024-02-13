package BOJ.BruteForce.DFS.Silver.P10819;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, max;
    static int arr[];
    static boolean visited[];
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        max = 0;
        arr = new int[N];
        visited = new boolean[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            visited[i] = true;
            dfs(0,arr[i],0);
            visited[i] = false;
        }
        System.out.println(max);
    }
    public static void dfs(int index,int prev, int sum){
        if(index == N-1){
            max = Math.max(max, sum);
            return;
        }
        for (int i = 0; i < N; i++) {
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            dfs(index+1, arr[i], sum + Math.abs(prev-arr[i]));
            visited[i] = false;
        }
    }
}
