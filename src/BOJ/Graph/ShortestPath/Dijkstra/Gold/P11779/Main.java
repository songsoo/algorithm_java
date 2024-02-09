package BOJ.Graph.ShortestPath.Dijkstra.Gold.P11779;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    final static int INF = 10000000;
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());

        ArrayList<Node> arr[] = new ArrayList[N+1];
        int route[] = new int[N+1];
        int dist[] = new int[N+1];
        boolean visited[] = new boolean[N+1];

        Arrays.fill(dist,INF);
        for (int i = 0; i < N+1; i++) {
            arr[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            arr[end].add(new Node(start,length));
        }

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int end = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;
        route[start] = -1;

        while(!pq.isEmpty()){

            Node cur = pq.poll();
            if(visited[cur.index]){
                continue;
            }
            visited[cur.index] = true;
            for(Node next: arr[cur.index]){
                if(dist[next.index] > dist[cur.index]+next.length){
                    dist[next.index] = dist[cur.index]+next.length;
                    route[next.index] = cur.index;
                }
                pq.add(new Node(next.index,  dist[next.index]));
            }

        }
        System.out.println(dist[end]);
        int prev = end;
        ArrayList<Integer> stk = new ArrayList<>();
        while(prev!=-1){
            stk.add(prev);
            prev = route[prev];
        }
        System.out.println(stk.size());
        for (int i = 0; i<stk.size() ; i++){
            System.out.print(stk.get(i)+" ");
        }
    }
}
class Node implements Comparable<Node>{
    int index;
    int length;

    public Node(int index, int length) {
        this.index = index;
        this.length = length;
    }



    @Override
    public int compareTo(Node o) {
        return this.length - o.length;
    }
}