package BOJ.BruteForce.BFS.Gold.P15591;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,Q;
    static ArrayList<node>[] arr;
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N+1];

        for (int i = 0; i < N+1; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a].add(new node(b, c));
            arr[b].add(new node(a, c));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(bfs(b,a)+"\n");
        }

        System.out.println(sb.toString());

    }

    public static int bfs(int idx, int val){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(idx);
        boolean[] visited = new boolean[N+1];
        visited[idx] = true;
        int cnt = 0;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            cnt++;
            for(node next: arr[cur]){
                if(!visited[next.to] && next.length >= val){
                    visited[next.to] = true;
                    queue.add(next.to);
                }
            }
        }
        return cnt-1;
    }
}
class node {
    int to;
    int length;

    public node(int to, int length) {
        this.to = to;
        this.length = length;
    }
}