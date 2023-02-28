package BOJ.Graph.MST.PRIM.G4.P1922;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static ArrayList<edge>[] edges;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\SSAFY\\IdeaProjects\\algorithm_java\\src\\BOJ\\Graph\\MST\\PRIM\\G4\\P1922\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());
        edges = new ArrayList[N+1];
        visited = new boolean[N+1];
        for (int i = 0; i < N+1; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            edges[from].add(new edge(to,value));
            edges[to].add(new edge(from,value));
        }

        PriorityQueue<edge> pq = new PriorityQueue<>();
        pq.add(new edge(1,0));

        int count=0;
        int result=0;
        while(!pq.isEmpty() && count<N){
            edge cur = pq.poll();
            if(!visited[cur.to]){
                visited[cur.to]=true;
                for (edge a : edges[cur.to]) {
                    pq.add(a);
                }
                count++;
                result+=cur.value;
            }
        }
        System.out.println(result);
    }
}
class edge implements Comparable<edge>{
    int to;
    int value;
    edge(int to, int value){
        this.to = to;
        this.value = value;
    }

    @Override
    public int compareTo(edge o){
        return this.value - o.value;
    }


}
