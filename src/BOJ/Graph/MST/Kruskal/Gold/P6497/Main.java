package BOJ.Graph.MST.Kruskal.Gold.P6497;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] parent;
    public static void main(String[] args) throws IOException {


        System.setIn(new FileInputStream("C:\\Users\\SSAFY\\IdeaProjects\\algorithm_java\\src\\BOJ\\Graph\\MST\\Kruskal\\G4\\P6497\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if(N==0 && M==0){
                break;
            }
            parent = new int[N];
            int sum = 0;
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }
            PriorityQueue<edge> pq = new PriorityQueue<>();
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                pq.add(new edge(x, y, value));
                sum += value;
            }

            int result = 0;
            int count = 0;
            while (!pq.isEmpty() && count < N - 1) {
                edge cur = pq.poll();
                if (find(cur.x) != find(cur.y)) {
                    union(cur.x, cur.y);
                    count++;
                    result += cur.value;
                }
            }
            System.out.println(sum - result);
        }
    }
    public static int find(int x){
        if(x == parent[x]){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x!=y){
            parent[Math.max(x,y)] = Math.min(x,y);
        }
    }
}
class edge implements Comparable<edge>{
    int x;
    int y;
    int value;

    public edge(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    @Override
    public int compareTo(edge o) {
        return this.value - o.value;
    }
}
