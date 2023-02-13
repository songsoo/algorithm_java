package BOJ.S3.P2606;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M,count;
    static ArrayList<Integer>[] Connected;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("E:\\SSAFY9\\intelliJ_workspace\\algorithm_java\\src\\BOJ\\S3\\P2606\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());
        count = 0;
        Connected = new ArrayList[N+1];
        visited = new boolean[N+1];
        for (int i = 0; i < N+1; i++) {
            Connected[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Connected[a].add(b);
            Connected[b].add(a);
        }

        bfs();
    }

    public static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        visited[1] = true;
        queue.offer(1);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int next : Connected[cur]){
                if(!visited[next]){
                    count++;
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
        System.out.println(count);
    }
}
