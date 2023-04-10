package BOJ.Graph.ShortestPath.Dijkstra.G5.P1916;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1916 {
    static int N,M,S,E,sum;
    static ArrayList<edge2>[] graph;
    static boolean visited[];
    static long[] dist;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("E:\\ssafy\\intelliJWorkSpace\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());
        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        dist = new long[N+1];
        sum = 0;
        for (int i = 0; i < N+1; i++) {
            Arrays.fill(dist,Integer.MAX_VALUE);
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long value = Long.parseLong(st.nextToken());
            graph[a].add(new edge2(b,value));
        }

        StringTokenizer st = new StringTokenizer(bf.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        PriorityQueue<edge2> pq = new PriorityQueue<>();
        pq.add(new edge2(S,0));
        dist[S] = 0;
        while(!pq.isEmpty()){
            edge2 cur = pq.poll();
            if(visited[cur.to]){
               continue;
            }
            visited[cur.to] = true;
            int idx = cur.to;

            for(edge2 next : graph[idx]){
                dist[next.to] = Math.min(dist[next.to], dist[idx]+next.value);
                pq.add(new edge2(next.to,dist[next.to]));
            }
        }
        System.out.println(dist[E]);
    }
    public static class edge2 implements Comparable<edge2>{
        int to;
        long value;

        public edge2(int to, long value) {
            this.to = to;
            this.value = value;
        }
        @Override
        public int compareTo(edge2 o) {
            return Long.compare(value , o.value);
        }
    }
}
