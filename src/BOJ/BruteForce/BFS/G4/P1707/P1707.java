package BOJ.BruteForce.BFS.G4.P1707;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1707 {
    static int K, V, E;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static boolean isRight;
    static int[] color;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("E:\\ssafy\\intelliJWorkSpace\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(bf.readLine());

        for (int test_case = 0; test_case < K; test_case++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            isRight = true;
            V= Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            list = new ArrayList[V+1];
            for (int i = 0; i < V+1; i++) {
                list[i] = new ArrayList<>();
            }
            visited = new boolean[V+1];
            color = new int[V+1];

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(bf.readLine());
                int a1 = Integer.parseInt(st.nextToken());
                int a2 = Integer.parseInt(st.nextToken());
                list[a1].add(a2);
                list[a2].add(a1);
            }
            for (int i = 1; i < V+1; i++) {
                if(!visited[i]){
                    if(!bfs(i)){
                        isRight = false;
                        break;
                    }
                }
            }
            System.out.println(isRight?"YES":"NO");
        }
    }

    public static boolean bfs(int i){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visited[i] = true;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int a : list[cur]){
                if(!visited[a]){
                    color[a] = (color[cur]%2)+1;
                    visited[a] = true;
                    queue.add(a);
                }else{
                    if(color[a] == color[cur]){
                        return false;
                    }
                }
            }
        }
        return true;

    }


}