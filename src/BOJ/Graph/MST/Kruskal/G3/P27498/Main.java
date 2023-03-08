package BOJ.Graph.MST.Kruskal.G3.P27498;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int parent[];
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\SSAFY\\IdeaProjects\\algorithm_java\\src\\BOJ\\Graph\\MST\\Kruskal\\G3\\P27498\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];

        for (int i = 0; i < N+1; i++) {
            parent[i] = i;
        }

        int E = 0;
        int result = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            boolean isConnected = st.nextToken().charAt(0)=='0'?false:true;

            result += value;

            if(isConnected){
                if(find(a)!=find(b)){
                    union(a,b);
                    E++;
                    result -= value;
                }
            }else{
                pq.add(new Node(a,b,value));
            }
        }
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(find(cur.from)!=find(cur.target)){
                union(cur.from,cur.target);
                E++;
                result -= cur.value;
            }
        }
        System.out.println(result);

    }
    public static int find(int x) {
        if(x == parent[x]){
            return x;
        }return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x!=y){
            parent[Math.max(x,y)] = Math.min(x,y);
        }
    }
}
class Node implements Comparable<Node>{
    int from;
    int target;
    int value;

    public Node(int from, int target, int value) {
        this.from = from;
        this.target = target;
        this.value = value;
    }


    @Override
    public int compareTo(Node o) {
        return o.value - this.value;
    }
}