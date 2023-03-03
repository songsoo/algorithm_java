package BOJ.Graph.ShortestPath.Dijkstra.G4.P1753;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int V,E, INF;
    static boolean[] visited;
    static int[] dist;
    static ArrayList<ArrayList<Node>> graph;
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("C:\\Users\\SSAFY\\IdeaProjects\\algorithm_java\\src\\BOJ\\Graph\\ShortestPath\\Dijkstra\\G4\\P1753\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        INF = Integer.MAX_VALUE;
        visited = new boolean[V+1];
        dist = new int[V+1];
        Arrays.fill(dist, INF);

        int start = Integer.parseInt(bf.readLine());

        graph = new ArrayList<>();

        for (int i = 0; i < V+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(x).add(new Node(y,cost));
            //graph.get(y).add(new Node(x,cost));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            int cur = pq.poll().index;
            if(!visited[cur]){
                visited[cur] = true;

                for(Node next : graph.get(cur)){
                    if(dist[next.index] > dist[cur] + next.cost){
                        dist[next.index] = dist[cur]+next.cost;
                        pq.add(new Node(next.index, dist[next.index]));
                    }
                }

            }
        }

        for (int i = 1; i < V+1; i++) {
            System.out.println(dist[i]==INF?"INF":dist[i]);
        }



    }
}
class Node implements Comparable<Node>{
    int index;
    int cost;
    Node(int index, int cost){
        this.index = index;
        this.cost= cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}