package BOJ.Graph.MST.Kruskal.G3.P1774;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static ArrayList<point> points;
    static int[] parent;
    static ArrayList<int[]> connected;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\SSAFY\\IdeaProjects\\algorithm_java\\src\\BOJ\\Graph\\MST\\Kruskal\\G3\\P1774\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        points = new ArrayList<>();
        connected = new ArrayList<>();
        parent = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            long x = Integer.parseInt(st.nextToken());
            long y = Integer.parseInt(st.nextToken());
            points.add(new point(x,y));
            parent[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            long x = Integer.parseInt(st.nextToken());
            long y = Integer.parseInt(st.nextToken());
            connected.add(new int[]{Math.min((int)x-1,(int)y-1),Math.max((int)x-1,(int)y-1)});
        }

        PriorityQueue<edge> pq = new PriorityQueue<>();
        int count = 0;
        double result = 0.0;
        for (int i = 0; i < N; i++) {
            point cur = points.get(i);
            for (int j = i+1; j < N; j++) {
                point next = points.get(j);
                boolean gotcha=false;
                for (int k = 0; k < M; k++) {
                    if(connected.get(k)[0]==i && connected.get(k)[1]==j){
                        if(find(i)!=find(j)){
                            count++;
                            gotcha = true;
                            union(i,j);
                            break;
                        }
                    }
                }
                if(!gotcha){
                    pq.add(new edge(i,j,cur.getDist(next)));
                }
            }
        }

        while(count<N-1 && !pq.isEmpty()){
            edge cur = pq.poll();
            if(find(cur.x)!= find(cur.y)){
                union(cur.x, cur.y);
                result += cur.value;
                count++;
            }
        }
        System.out.printf("%.2f",result);

    }
    public static int find(long x){
        int newX = (int)x;
        if(x == parent[newX]){
            return newX;
        }return parent[newX] = find(parent[newX]);
    }
    public static void union(long x, long y){
        int newX = (int)x;
        int newY = (int)y;
        newX = find(newX);
        newY = find(newY);
        if(x!=y){
            parent[Math.max(newX,newY)] = Math.min(newX,newY);
        }
    }
}
class edge implements Comparable<edge>{
    long x;
    long y;
    double value;
    edge(long x, long y,double value){
        this.x = x;
        this.y =y;
        this.value = value;
    }
    @Override
    public int compareTo(edge o) {
        return Double.compare(this.value,o.value);
    }
}
class point{
    long x;
    long y;
    point(long x, long y){
        this.x = x;
        this.y = y;
    }
    public double getDist(point o){
        return Math.sqrt(Math.pow(this.x-o.x,2)+Math.pow(this.y-o.y,2));
    }
}