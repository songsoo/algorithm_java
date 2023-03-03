package BOJ.Graph.ShortestPath.Dijkstra.G4.P1261;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, INF;
    static int[][] arr;
    static boolean[][] visited;
    static int[][] dist;
    static int[] moveX= {-1,1,0,0},moveY= {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\SSAFY\\IdeaProjects\\algorithm_java\\src\\BOJ\\Graph\\ShortestPath\\Dijkstra\\G4\\P1261\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        INF = Integer.MAX_VALUE;

        arr = new int[N][M];
        visited = new boolean[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = bf.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(str.charAt(j)+"");
                dist[i][j] = INF;
            }
        }

        PriorityQueue<edge> pq = new PriorityQueue<>();
        dist[0][0] = arr[0][0];
        pq.add(new edge(new int[]{0,0},0));
        while(!pq.isEmpty()){
            edge cur = pq.poll();
            if(visited[cur.w[0]][cur.w[1]]){
                return;
            }
            visited[cur.w[0]][cur.w[1]]=true;
            for (int i = 0; i < 4; i++) {
                int nextX = cur.w[0] + moveX[i];
                int nextY = cur.w[1] + moveY[i];
                if(check(nextX, nextY)){
                    if(dist[nextX][nextY]>dist[cur.w[0]][cur.w[1]]+arr[nextX][nextY]){
                        dist[nextX][nextY] = dist[cur.w[0]][cur.w[1]]+arr[nextX][nextY];
                        pq.add(new edge(new int[]{nextX,nextY}, dist[nextX][nextY]));
                    }
                }
            }
        }
        System.out.println(dist[N-1][M-1]);
    }

    public static boolean check(int x, int y){
        if(x>=0 && x<N && y>=0 && y<M){
            return true;
        }
        return false;
    }
}
class edge implements Comparable<edge> {
    int w[];
    int cost;
    edge(int[] w, int cost){
        this.w = new int[2];
        this.w[0] = w[0];
        this.w[1] = w[1];
        this.cost = cost;
    }

    @Override
    public int compareTo(edge o) {
        return Integer.compare(this.cost , o.cost);
    }
}