package BOJ.Graph.MST.Kruskal.Gold.P16398;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] parent;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algorithm_java\\src\\BOJ\\Graph\\MST\\Kruskal\\G4\\P16398\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        PriorityQueue<edge> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < i+1; j++) {
                st.nextToken();
            }
            for (int j = i+1; j < N; j++) {
                pq.add(new edge(i,j,Integer.parseInt(st.nextToken())));
            }
        }
        int count = 0;
        long result = 0;
        while(count<N-1 && !pq.isEmpty()){
            edge cur = pq.poll();
            if(find(cur.x)!=find(cur.y)){
                union(cur.x, cur.y);
                count++;
                result += cur.value;
            }
        }

        System.out.println(result);

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
        return Integer.compare(value , o.value);
    }
}