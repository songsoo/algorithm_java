package Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P20010 {
    static int N, K;
    static ArrayList<edge>[] graph;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        PriorityQueue<edge> queueS= new PriorityQueue<>();

        graph = new ArrayList[N];


        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new edge(b,c));
            graph[b].add(new edge(a,c));


        }




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
    public int compareTo(edge o) {
        return value - o.value;
    }
}