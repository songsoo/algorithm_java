package BOJ.Graph.ShortestPath.Dijkstra.G4.P4485;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, INF;
    static int[] dist;
    static boolean[] visited;
    static ArrayList<ArrayList<Node>> graph;
    static int[] moveX = {-1,0,1,0}, moveY={0,-1,0,1};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\SSAFY\\IdeaProjects\\algorithm_java\\src\\BOJ\\Graph\\ShortestPath\\Dijkstra\\G4\\P4485\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        INF = Integer.MAX_VALUE;
        int test_case = 0;
        while(true) {
            N = Integer.parseInt(bf.readLine());

            if(N==0){
                break;
            }

            graph = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    graph.add(new ArrayList<>());
                }
            }
            dist = new int[N * N];
            visited = new boolean[N * N];
            Arrays.fill(dist,INF);

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < N; j++) {
                    int cost = Integer.parseInt(st.nextToken());
                    if (i == 0 && j == 0) {
                        dist[0] = cost;
                    }
                    for (int k = 0; k < 4; k++) {
                        int prevX = i + moveX[k];
                        int prevY = j + moveY[k];
                        int index = prevX * N + prevY;
                        if (prevX<N && prevX >= 0 && prevY<N && prevY >= 0) {
                            graph.get(index).add(new Node(i * N + j, cost));
                        }
                    }
                }
            }

            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(0, dist[0]));
            while (!pq.isEmpty()) {
                int cur = pq.poll().index;
                if (!visited[cur]) {
                    visited[cur] = true;
                    for (Node next : graph.get(cur)) {
                        if (dist[next.index] > dist[cur] + next.cost) {
                            dist[next.index] = dist[cur] + next.cost;
                            pq.add(new Node(next.index, dist[next.index]));
                        }
                    }
                }
            }

            System.out.println("Problem " + ++test_case +": "+ dist[N * N - 1]);
        }

    }
}
class Node implements Comparable<Node>{
    int index;
    int cost;

    public Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }


    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}