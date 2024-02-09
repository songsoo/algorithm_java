package BOJ.Graph.TopologySort.Gold.P1516;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] indegree;
    static boolean[] visited;
    static int[] time, totalTime;
    static ArrayList<ArrayList<Integer>> next;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\SSAFY\\IdeaProjects\\algorithm_java\\src\\BOJ\\Graph\\TopologySort\\G3\\P1516\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        indegree = new int[N+1];
        time = new int[N+1];
        totalTime = new int[N+1];
        next = new ArrayList<>();
        visited = new boolean[N+1];
        for (int i = 0; i < N+1; i++) {
            next.add(new ArrayList<>());
        }
        for (int i = 1; i < N+1; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            time[i] = a;
            while (true) {
                a = Integer.parseInt(st.nextToken());
                if (a == -1) {
                    break;
                }
                next.get(a).add(i);
                indegree[i]++;
            }
        }
        topology();
    }
    public static void topology(){

        Queue<Integer> cand = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if(indegree[i]==0){
                visited[i] = true;
                cand.add(i);
            }
        }
        while(!cand.isEmpty()){
            int cur = cand.poll();
            for(int nextNode : next.get(cur)){
                indegree[nextNode]--;
                if(visited[nextNode]){
                    totalTime[nextNode] = Math.max(totalTime[nextNode],time[cur]+totalTime[cur]);
                }else {
                    visited[nextNode] = true;
                    totalTime[nextNode] = time[cur]+totalTime[cur];
                }
                if(indegree[nextNode]==0){
                    cand.add(nextNode);
                }
            }
        }

        for (int i = 1; i <= N ; i++) {
            System.out.println(time[i]+totalTime[i]);
        }

    }
}
