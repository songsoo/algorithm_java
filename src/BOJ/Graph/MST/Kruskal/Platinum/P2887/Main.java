package BOJ.Graph.MST.Kruskal.Platinum.P2887;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\SSAFY\\IdeaProjects\\algorithm_java\\src\\BOJ\\Graph\\MST\\Kruskal\\P5\\P2887\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ArrayList<planet> planets = new ArrayList<>();
        parent = new int[N+1];

        for (int i = 0; i < N; i++) {
            parent[i] = i;
            StringTokenizer st = new StringTokenizer(br.readLine());
            planets.add(new planet(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        PriorityQueue<edge> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            planet cur = planets.get(i);
            for (int j = i+1; j < N; j++) {
                if(pq.size()>N){
                    if(pq.peek().value>cur.getDist(planets.get(j))){
                        pq.poll();
                        pq.add(new edge(i,j,cur.getDist(planets.get(j))));
                    }
                }else{
                    pq.add(new edge(i,j,cur.getDist(planets.get(j))));
                }
            }
        }
        PriorityQueue<edge> newpq = new PriorityQueue<>((o1, o2) -> {
             return o1.value - o2.value;
        });

        while(!pq.isEmpty()){
            newpq.add(pq.poll());
        }

        int count = 0;
        int result = 0;
        while(!newpq.isEmpty() && count<N-1){
            edge cur = newpq.poll();
            if(find(cur.from)!=find(cur.to)){
                union(cur.from,cur.to);
                result += cur.value;
                count++;
            }
        }
        System.out.println(result);
    }
    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x!=y){
            parent[Math.max(x,y)] = Math.min(x,y);
        }
    }
    public static int find(int x){
        if(x==parent[x]){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}
class edge implements Comparable<edge>{
    int from;
    int to;
    int value;

    public edge(int from, int to, int value) {
        this.from = from;
        this.to = to;
        this.value = value;
    }

    @Override
    public int compareTo(edge o){
        return Integer.compare(o.value,this.value);
    }

}
class planet{
    int x;
    int y;
    int z;

    public planet(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getDist(planet o){
        int dist = Math.min(Math.abs(this.x-o.x), Math.abs(this.y-o.y));
        dist = Math.min(dist,Math.abs(this.z-o.z));
        return dist;
    }
}
