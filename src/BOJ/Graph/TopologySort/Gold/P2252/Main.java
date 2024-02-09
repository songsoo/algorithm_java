package BOJ.Graph.TopologySort.Gold.P2252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] degree;
    static ArrayList<ArrayList<Integer>> next;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        degree = new int[N+1];
        next = new ArrayList<>();
        for (int i = 0; i < N+1; i++) {
            next.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            next.get(a).add(b);
            degree[b]++;

        }

        topologySort();

    }

    public static void topologySort(){
        Queue<Integer> cand = new LinkedList<>();
        Queue<Integer> result = new LinkedList<>();

        for (int i = 1; i < N+1; i++) {
            if(degree[i] == 0){
                cand.add(i);
            }
        }

        while(!cand.isEmpty()){
            int cur = cand.poll();
            for(int next : next.get(cur)){
                degree[next]--;

                if(degree[next]==0){
                    cand.add(next);
                }
            }
            result.add(cur);
        }

        while(!result.isEmpty()){
            System.out.print(result.poll()+" ");
        }
    }
}
