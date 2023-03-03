package BOJ.Graph.ShortestPath.Dijkstra.G2.P9370;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T,N,M,L,S,G,H,INF, tmpDist;
    static ArrayList<ArrayList<Node>> graph;
    static boolean[] visited;
    static int[] dests;
    static int[] ans;
    static int[] dist, tmp;
    static ArrayList<Integer> result;
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("C:\\Users\\SSAFY\\IdeaProjects\\algorithm_java\\src\\BOJ\\Graph\\ShortestPath\\Dijkstra\\G2\\P9370\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());
        INF = Integer.MAX_VALUE;
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            result = new ArrayList<>();

            st = new StringTokenizer(bf.readLine());
            S = Integer.parseInt(st.nextToken());
            G = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            // 시작점에서 바로 다익스트라를 한 최종 위치 거리가
            // 거친 지점에서 다익스트라를 한 최종 위치 거리와 같으면 출력
            visited = new boolean[N+1];
            dist = new int[N+1];
            dests = new int[L];
            ans = new int[L];
            tmp = new int[2];
            Arrays.fill(dist,INF);
            // N개만큼 교차루 개수
            // 처음 m개만큼 거리 개수
            graph = new ArrayList<>();
            for (int i = 0; i < N+1; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(bf.readLine());
                int x1 = Integer.parseInt(st.nextToken());
                int x2 = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                graph.get(x1).add(new Node(x2,cost));
                graph.get(x2).add(new Node(x1,cost));
                if(x1==G && x2==H || x1==H & x2==G){
                    tmpDist = cost;
                }
            }
            for (int i = 0; i < L; i++) {
                dests[i] = Integer.parseInt(bf.readLine());
            }

            //단순 최단거리 미리 구하고
            dijkstra(S,0);

            // 정답 저장하고
            for (int i = 0; i < L; i++) {
                ans[i] = dist[dests[i]];
            }

            int destination;
            if(dist[G]<dist[H]){
                destination = H;
                tmp[0] = dist[G] + tmpDist;
                tmp[1] = dist[H] + tmpDist;
            }else{
                destination = G;
                tmp[0] = dist[H] + tmpDist;
                tmp[1] = dist[G] + tmpDist;
            }

            visited = new boolean[N+1];
            dist = new int[N+1];
            Arrays.fill(dist,INF);
            dijkstra(destination,tmp[0]);

            for (int i = 0; i < L; i++) {
                if(dist[dests[i]]==ans[i]){
                    result.add(dests[i]);
                }
            }

            if(destination==H){
                destination = G;
            }else{
                destination = H;
            }

            visited = new boolean[N+1];
            dist = new int[N+1];
            Arrays.fill(dist,INF);
            dijkstra(destination,tmp[1]);

            for (int i = 0; i < L; i++) {
                if(dist[dests[i]]==ans[i]){
                    result.add(dests[i]);
                }
            }


            Collections.sort(result);
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i)+" ");
            }
            System.out.println();

        }

    }
    public static void dijkstra(int start, int startDist){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,startDist));
        dist[start] = startDist;
        while(!pq.isEmpty()){
            int cur = pq.poll().w;
            if(!visited[cur]) {
                visited[cur] = true;
                for (Node next : graph.get(cur)) {
                    if(dist[next.w]>dist[cur]+next.cost){
                        dist[next.w] = dist[cur] + next.cost;
                        pq.add(next);
                    }
                }
            }
        }
    }
}
class Node implements Comparable<Node>{
    int w;
    int cost;

    public Node(int w, int cost) {
        this.w = w;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}