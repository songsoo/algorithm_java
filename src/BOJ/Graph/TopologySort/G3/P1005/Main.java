package BOJ.Graph.TopologySort.G3.P1005;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int T, N, K;
    static int[] indegree, time, result;
    static ArrayList<Integer>[] order;
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            order = new ArrayList[N+1];
            indegree = new int[N+1];
            time = new int[N+1];
            result = new int[N+1];

            st = new StringTokenizer(bf.readLine());
            for (int j = 1; j < N+1; j++) {
                order[j] = new ArrayList<>();
                time[j] = Integer.parseInt(st.nextToken());
                result[j] = time[j];
            }

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(bf.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                indegree[b]++;
                order[a].add(b);
            }
            Queue<Integer> queue = new LinkedList<>();
            for (int j = 1; j < N+1; j++) {
                if(indegree[j]==0){
                    queue.add(j);
                }
            }

            while(!queue.isEmpty()){
                int cur = queue.poll();

                for(int next: order[cur]){
                    indegree[next]--;
                    result[next] = Math.max(result[next], result[cur]+time[next]);
                    if(indegree[next]==0){
                        queue.add(next);
                    }
                }
            }

            System.out.println(result[Integer.parseInt(bf.readLine())]);

        }
    }
}

