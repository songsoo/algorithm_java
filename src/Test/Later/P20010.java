package Test.Later;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P20010 {
    static int N, K;
    static ArrayList<edge>[] childList;
    static boolean[] visited;
    static node[] nodes;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        childList = new ArrayList[N];
        visited = new boolean[N];
        nodes = new node[N];
        for (int i = 0; i < N; i++) {
           childList[i] = new ArrayList<>();
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            childList[a].add(new edge(a,b,c));
            childList[b].add(new edge(b,a,c));
        }

        PriorityQueue<edge> pq = new PriorityQueue<>();
        visited[0] = true;
        pq.add(new edge(0,0,0));
        while(!pq.isEmpty()){
            edge cur = pq.poll();
            visited[cur.to] = true;
            nodes[cur.to] = new node(cur.value);
            nodes[Math.min(cur.from,cur.to)].childs.add(nodes[Math.max(cur.from,cur.to)]);
            for(edge next : childList[cur.to]){
                if(!visited[next.to]){
                    pq.add(next);
                }
            }
        }

    }

}
class node{
    boolean haveParent;
    int value;
    ArrayList<node> childs = new ArrayList<>();
    node(int value){
        this.value = value;
    }
}
class edge implements Comparable<edge>{
    int from;
    int to;
    int value;
    edge(int from, int to, int value){
        this.to = to;
        this.value = value;
    }
    @Override
    public int compareTo(edge o) {
        return value - o.value;
    }
}