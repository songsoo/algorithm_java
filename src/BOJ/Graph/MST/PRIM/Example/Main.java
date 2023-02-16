package BOJ.Graph.MST.PRIM.Example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
    int w;
    int cost;

    Edge(int  w, int cost){
        this.w = w;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

public class Main {
    static List<Edge>[] graph;

    public static void prim(int start, int n) {
        boolean[] visit = new boolean[n + 1];

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        int total = 0;
        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            int v = edge.w;
            int cost = edge.cost;

            if(visit[v]) continue;

            visit[v] = true;
            total += cost;

            for(Edge e : graph[v]) {
                if(!visit[e.w]) {
                    pq.add(e);
                }
            }
        }
        System.out.println(total);
    }


    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("E:\\SSAFY9\\intelliJ_workspace\\algorithm_java\\src\\BOJ\\Graph\\MST\\G4\\PRIM\\Example\\input.txt"));
        // 그래프 입력, 저장
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());

        // 그래프 선언, 간선 리스트로 표현
        graph = new ArrayList[n + 1];
        for (int i = 0; i < graph.length; i++) graph[i] = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[v].add(new Edge(w, cost));
            graph[w].add(new Edge(v, cost));
        }

        // 프림 알고리즘 수행
        prim(1, n);
    }
}