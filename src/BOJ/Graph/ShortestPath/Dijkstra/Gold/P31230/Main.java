package BOJ.Graph.ShortestPath.Dijkstra.Gold.P31230;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M,A,B,min;
    static ArrayList<Edge>[] arr;
    static HashSet<Integer>[] routes;
    public static void main(String[] args) throws Exception {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;

        arr = new ArrayList[N+1];
        routes = new HashSet[N+1];
        for (int i = 0; i < N+1; i++) {
            arr[i] = new ArrayList<>();
            routes[i] = new HashSet<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a].add(new Edge(b, c));
            arr[b].add(new Edge(a, c));
        }

        long INF = 100000000000000000l;
        long length = INF;
        long[] dist = new long[N+1];
        Arrays.fill(dist, INF);

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        pq.add(new Edge(A,0));
        dist[A] = 0;
        routes[A] = new HashSet<>();
        boolean[] visited= new boolean[N+1];
        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            if(cur.length > length){
                break;
            }
            if(visited[cur.to]){
                continue;
            }
            visited[cur.to] = true;
            if(cur.to == B){
                length = cur.length;
                continue;
            }
            for(Edge next: arr[cur.to]){
                long nextLength = cur.length + next.length;
                if(nextLength < dist[next.to]){
                    pq.add(new Edge(next.to, nextLength));
                    dist[next.to] = nextLength;
                    routes[next.to] = new HashSet<>();
                    routes[next.to].add(cur.to);
                }else if(nextLength == dist[next.to]){
                    routes[next.to].add(cur.to);
                }
            }
        }
        ArrayList<Integer> routesArr = new ArrayList<>();
        visited = new boolean[N+1];
        Queue<Integer> queue = new LinkedList<>();
        routesArr.add(B);
        for (int next: routes[B]) {
            queue.add(next);
            visited[next] = true;
        }
        while(!queue.isEmpty()){
            int cur = queue.poll();
            routesArr.add(cur);
            for(int next: routes[cur]){
                if(!visited[next]){
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
        Collections.sort(routesArr);
        StringBuilder sb = new StringBuilder();
        sb.append(routesArr.size()).append("\n");
        for (int i = 0; i < routesArr.size(); i++) {
            sb.append(routesArr.get(i)).append(" ");
        }
        System.out.println(sb.toString());
    }
}
class Edge implements Comparable<Edge>{
    int to;
    long length;

    public Edge(int to, long length) {
        this.to = to;
        this.length = length;
    }

    @Override
    public int compareTo(Edge o) {
        return Long.compare(this.length, o.length);
    }
}
