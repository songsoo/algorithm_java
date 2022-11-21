package SDS.Answer;

import java.io.*;
import java.util.*;

public class P2252 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] in = new int[N+1];
        ArrayList<Integer>[] adj = new ArrayList[N+1];
        for(int i = 0; i < N+1; i++) {
            adj[i] = new ArrayList();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adj[from].add(to);
            in[to]++;
        }
        Queue<Integer> q = new LinkedList();
        for(int i = 1; i < N+1; i++) {
            if(in[i] == 0) {
                q.add(i);
            }
        }
        while(!q.isEmpty()) {
            int now = q.poll();
            sb.append(now).append(" ");
            for(int next: adj[now]) {
                in[next]--;
                if(in[next] == 0) {
                    q.add(next);
                }
            }
        }
        System.out.println(sb);
    }
}