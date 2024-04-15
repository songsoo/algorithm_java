package BOJ.Graph.MST.Kruskal.Gold.P10021;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, C;
    static ArrayList<int[]> arr;
    static int[] parent;
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();

        PriorityQueue<edge> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr.add(new int[]{x, y});
        }

        for (int i = 0; i < N; i++) {
            int[] a = arr.get(i);
            for (int j = i+1; j < N; j++) {
                int[] b = arr.get(j);
                int length = (int)(Math.pow(a[0]-b[0], 2)+Math.pow(a[1]-b[1], 2));
                pq.add(new edge(i, j, length));
            }
        }

        int cnt = 0;
        int res = 0;
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        while(!pq.isEmpty() && cnt < N-1){
            edge cur = pq.poll();
            if(cur.length >=C && find(cur.from) != find(cur.to)){
                union(cur.from, cur.to);
                cnt++;
                res += cur.length;
            }
        }
        if(cnt == N-1){
            System.out.println(res);
        }else{
            System.out.println(-1);
        }

    }

    public static int find(int i){
        if(i==parent[i]){
            return i;
        }
        return parent[i] = find(parent[i]);
    }

    public static void union(int i, int j){
        i = find(i);
        j = find(j);
        if(i!=j){
            parent[Math.min(i, j)] = Math.max(i,j);
        }
    }

}
class edge implements Comparable<edge>{
    int from;
    int to;
    int length;

    public edge(int from, int to, int length) {
        this.from = Math.min(from, to);
        this.to = Math.max(from, to);
        this.length = length;
    }

    @Override
    public int compareTo(edge o){
        return this.length - o.length;
    }
}
