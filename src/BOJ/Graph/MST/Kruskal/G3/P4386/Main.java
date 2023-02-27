package BOJ.Graph.MST.Kruskal.G3.P4386;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static double result=0.0;
    static double[] Xs,Ys;
    static int parent[];
    static boolean visited[][];
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("E:\\SSAFY9\\intelliJ_workspace\\algorithm_java\\src\\BOJ\\BruteForce\\BackTracking\\G3\\P4386\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        Xs = new double[N];
        Ys = new double[N];
        parent = new int[N];

        PriorityQueue<edge> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            Xs[i] = Double.parseDouble(st.nextToken());
            Ys[i] = Double.parseDouble(st.nextToken());
            parent[i] = i;
        }

        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                pq.add(new edge(i,j,getDist(Xs[i],Xs[j],Ys[i],Ys[j])));
            }
        }
        int count=0;
        while(count<N-1 && !pq.isEmpty()){
            edge cur = pq.poll();
            if(find(cur.x)!=find(cur.y)){
                union(cur.x,cur.y);
                result+=cur.value;
            }
        }

        System.out.println(result);

    }

    public static double getDist(double x1, double x2, double y1, double y2){
        return Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
    }

    public static int find(int x){
        if(x==parent[x]){
            return x;
        }else{
            return parent[x] = find(parent[x]);
        }
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x!=y){
            parent[Math.max(x,y)]=Math.min(x,y);
        }
    }


}
class edge implements Comparable<edge>{
    int x;
    int y;
    double value;
    edge(int x, int y , double value){
        this.x = Math.min(x,y);
        this.y = Math.max(x,y);
        this.value = value;
    }

    @Override
    public int compareTo(edge o) {
        return Double.compare(this.value,o.value);
    }
}
