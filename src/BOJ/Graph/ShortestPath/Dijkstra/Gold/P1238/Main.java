package BOJ.Graph.ShortestPath.Dijkstra.Gold.P1238;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N,M,X;
    static ArrayList<edge>[] edgeFromList,edgeToList;
    static int[] fromDist, toDist;
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        edgeFromList = new ArrayList[N+1];
        edgeToList = new ArrayList[N+1];
        fromDist = new int[N+1];
        toDist = new int[N+1];

        for (int i = 0; i < N+1; i++) {
            edgeFromList[i] = new ArrayList<>();
            edgeToList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            edgeFromList[from].add(new edge(to, length));
            edgeToList[to].add(new edge(from, length));
        }

        fromDijkstra();
        toDijkstra();

        int max = 0;
        for (int i = 1; i < N+1; i++) {
            if(i==X)continue;
            max = Math.max(max,fromDist[i]+toDist[i]);
        }
        System.out.println(max);
    }
    public static void fromDijkstra(){
        Arrays.fill(fromDist, 100000);
        boolean[] visited = new boolean[N+1];
        fromDist[X] = 0;
        PriorityQueue<edge> pq = new PriorityQueue();
        pq.add(new edge(X,0));
        while(!pq.isEmpty()){
            edge cur = pq.poll();
            if(visited[cur.index]) continue;
            for(edge ed : edgeFromList[cur.index]){
                fromDist[ed.index] = Math.min(fromDist[ed.index], fromDist[cur.index]+ed.length);
                pq.add(new edge(ed.index, fromDist[ed.index]));
            }
            visited[cur.index] = true;
        }
    }
    public static void toDijkstra(){
        Arrays.fill(toDist, 100000);
        boolean[] visited = new boolean[N+1];
        toDist[X] = 0;
        PriorityQueue<edge> pq = new PriorityQueue();
        pq.add(new edge(X,0));
        while(!pq.isEmpty()){
            edge cur = pq.poll();
            if(visited[cur.index]) continue;
            for(edge ed : edgeToList[cur.index]){
                toDist[ed.index] = Math.min(toDist[ed.index], toDist[cur.index] + ed.length);
                pq.add(new edge(ed.index, toDist[ed.index]));
            }
            visited[cur.index] = true;
        }
    }
}
class edge implements Comparable<edge> {
    int index;
    int length;
    edge(int index, int length){
        this.index = index;
        this.length = length;
    }

    @Override
    public int compareTo(edge o) {
        return length-o.length;
    }
}
