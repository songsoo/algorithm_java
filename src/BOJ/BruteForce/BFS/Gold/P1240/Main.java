package BOJ.BruteForce.BFS.Gold.P1240;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<edge> arr[];
    public static void main(String[] args) throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a].add(new edge(b, c));
            arr[b].add(new edge(a, c));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(bfs(a, b)).append("\n");
        }

        System.out.println(sb.toString());

    }
    public static int bfs(int from, int to){
        Queue<edge> queue = new LinkedList<>();
        queue.add(new edge(from, 0));
        boolean visited[] = new boolean[N+1];
        visited[from] = true;
        while(!queue.isEmpty()){

            edge cur = queue.poll();

            if(cur.to == to){
                return cur.length;
            }

            for(edge next : arr[cur.to]){
                if(!visited[next.to]){
                    visited[next.to] = true;
                    queue.add(new edge(next.to, cur.length + next.length));
                }
            }

        }
        return -1;
    }
}
class edge{
    int to;
    int length;

    public edge(int to, int length) {
        this.to = to;
        this.length = length;
    }
}
