package BOJ.Graph.MST.Kruskal.Gold.P1647;

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
        System.setIn(new FileInputStream("C:\\Users\\SSAFY\\IdeaProjects\\algorithm_java\\src\\BOJ\\Graph\\MST\\Kruskal\\G4\\P1647\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for (int i = 0; i < N+1; i++) {
            parent[i] = i;
        }
        PriorityQueue<edge> edges = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            edges.add(new edge(x,y,value));
        }

        int count = 0;
        int result = 0;
        while(!edges.isEmpty()&&count<N-2){
            edge cur = edges.poll();
            if(find(cur.x)!=find(cur.y)){
                union(cur.x, cur.y);
                result+=cur.value;
                count++;
            }
        }
        System.out.println(result);

    }
    public static int find(int x){
        if(x==parent[x]){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x!=y){
            parent[Math.min(x,y)] = Math.max(x,y);
        }
    }
}
class edge implements Comparable<edge>{
    int x;
    int y;
    int value;
    edge(int x, int y, int value){
        this.x = x;
        this.y = y;
        this.value = value;
    }

    @Override
    public int compareTo(edge o) {
        return this.value-o.value;
    }
}