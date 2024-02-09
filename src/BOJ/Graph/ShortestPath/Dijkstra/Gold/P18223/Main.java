package BOJ.Graph.ShortestPath.Dijkstra.Gold.P18223;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static ArrayList<edge>[] arr;
    static int V,E,P;
    static int[] dist;
    static boolean[] visited;
    static boolean saved;
    static final int INF = 50000001;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        arr = new ArrayList[V+1];


        for (int i = 0; i < V+1; i++) {
            arr[i] = new ArrayList<>();
        }

        arr[0].add(new edge(1,0));
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            arr[from].add(new edge(to, length));
            arr[to].add(new edge(from, length));
        }
        int fullDist = dijkstra(1,V);
        int firstDist = dijkstra(1,P);
        int secondDist = dijkstra(P,V);
        if(fullDist < INF && fullDist == firstDist + secondDist){
            System.out.println("SAVE HIM");
        }else{
            System.out.println("GOOD BYE");
        }

    }
    public static int dijkstra(int start, int end){
        int dist[] = new int[V+1];
        visited = new boolean[V+1];
        Arrays.fill(dist, INF);
        PriorityQueue<edge> pq = new PriorityQueue<>();
        pq.add(new edge(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            edge cur = pq.poll();
            if(visited[cur.index]){
                continue;
            }
            visited[cur.index] = true;

            for(edge next : arr[cur.index]){
                int len = dist[cur.index] + next.length;
                if(dist[next.index] >= len){
                    pq.add(new edge(next.index, len));
                    dist[next.index] = len;

                }
            }
        }
        return dist[end];
    }


}
class edge implements Comparable<edge>{
    int index;
    int length;


    public edge(int index, int length) {
        this.index = index;
        this.length = length;
    }

    @Override
    public int compareTo(edge o){
        return this.length - o.length;
    }
}
