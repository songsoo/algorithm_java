package BOJ.Implement.Gold.P15961;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15961 {

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N, D, K, C, count, max=0;
        int[] visited;
        int[] arr;
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        count = 0;
        visited = new int[D+1];
        arr = new int[N];
        visited[C]++;
        count++;
        for (int i = 0; i < K; i++) {
            int a = Integer.parseInt(bf.readLine());
            visited[a]++;
            if(visited[a]==1){
                count++;
            }
            arr[i]=a;
        }
        max = Math.max(count,max);
        for (int i = K; i < N; i++) {
            visited[arr[i-K]]--;
            if(visited[arr[i-K]]==0){
                count--;
            }
            int a = Integer.parseInt(bf.readLine());
            visited[a]++;
            arr[i] = a;
            if(visited[a]==1){
                count++;
            }
            max = Math.max(count,max);
        }

        for (int i = 0; i < K; i++) {
            if(--visited[arr[N-K+i]]==0){
                count--;
            }
            int a = arr[i];
            if(++visited[a]==1){
                count++;
            }
            max = Math.max(count,max);
        }

        System.out.println(max);

    }
}
