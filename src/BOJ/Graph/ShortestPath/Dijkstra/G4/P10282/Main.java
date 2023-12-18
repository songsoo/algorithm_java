package BOJ.Graph.ShortestPath.Dijkstra.G4.P10282;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n,d,c,resultNum, resultLength;
    static ArrayList<node>[] arr;
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\BOJ\\Graph\\ShortestPath\\Dijkstra\\G4\\P10282\\input.txt"));

        StringBuilder sb = new StringBuilder();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            arr = new ArrayList[n+1];
            for (int j = 0; j < n+1; j++) {
                arr[j] = new ArrayList<>();
            }

            for (int j = 0; j < d; j++) {
                st = new StringTokenizer(bf.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                arr[b].add(new node(a,s));
            }
            dijkstra();
            sb.append(resultNum+" "+resultLength+"\n");

        }

        System.out.println(sb.toString());

    }
    public static void dijkstra(){
        PriorityQueue<node> pq = new PriorityQueue<>();

        pq.add(new node(c,0));
        int INF = Integer.MAX_VALUE;
        int[] dist = new int[n+1];
        Arrays.fill(dist,INF);
        dist[c] = 0;

        boolean[] visited = new boolean[n+1];

        while(!pq.isEmpty()){

            node cur = pq.poll();

            if(visited[cur.index]) continue;
            visited[cur.index] = true;

            for (node next: arr[cur.index]) {
                if(dist[next.index] > dist[cur.index]+next.length){
                    dist[next.index] = dist[cur.index]+next.length;
                    pq.add(new node(next.index, dist[next.index]));
                }
            }
        }
        resultLength = 0;
        resultNum = 0;
        for (int i = 1; i < n+1; i++) {
            if(dist[i] == INF) continue;
            resultLength = Math.max(resultLength, dist[i]);
            resultNum++;
        }

    }
}
class node implements Comparable<node>{
    int index;
    int length;
    node(int index, int length){
        this.index = index;
        this.length = length;
    }

    @Override
    public int compareTo(node o) {
        return length-o.length;
    }
}
