package BOJ.BruteForce.BackTracking.Gold.P10159;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] indegree, outdegree;
    static ArrayList<Integer>[] arrNext, arrPrev;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        indegree = new int[N+1];
        outdegree = new int[N+1];
        arrNext = new ArrayList[N+1];
        arrPrev = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            arrNext[i] = new ArrayList<>();
            arrPrev[i] = new ArrayList<>();
            indegree[i] = 0;
            outdegree[i] = 0;
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arrNext[b].add(a);
            arrPrev[a].add(b);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N+1; i++) {
            int sum = 0;

            visited = new boolean[N+1];

            sum += goNext(i);
            sum += goPrev(i);

            sb.append(N-sum+1).append("\n");
        }
        System.out.println(sb.toString());
    }
    public static int goNext(int cur){
        int cnt = 1;
        visited[cur] = true;
        for(int next : arrNext[cur]){
            if(visited[next]){
                cnt += 0;
            }else{
                cnt += goNext(next);
            }
        }
        return cnt;
    }

    public static int goPrev(int cur){
        int cnt = 1;
        visited[cur] = true;
        for(int prev : arrPrev[cur]){
            if(visited[prev]){
                cnt += 0;
            }else{
                cnt += goPrev(prev);
            }
        }
        return cnt;
    }

}
