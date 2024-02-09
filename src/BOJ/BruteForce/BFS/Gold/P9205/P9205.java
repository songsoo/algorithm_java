package BOJ.BruteForce.BFS.Gold.P9205;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P9205 {
    static int[][] loc;
    static boolean[][] dist;
    static boolean[] visited;
    static int T, N;
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("E:\\ssafy\\intelliJWorkSpace\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            N = Integer.parseInt(bf.readLine());

            loc = new int[N+2][2];
            dist = new boolean[N+2][N+2];
            visited = new boolean[N+2];
            StringTokenizer st= new StringTokenizer(bf.readLine());

            loc[0][0] = Integer.parseInt(st.nextToken());
            loc[0][1] = Integer.parseInt(st.nextToken());
            for (int i = 1; i <= N; i++) {
                st= new StringTokenizer(bf.readLine());
                loc[i][0] = Integer.parseInt(st.nextToken());
                loc[i][1] = Integer.parseInt(st.nextToken());
            }
            st= new StringTokenizer(bf.readLine());
            loc[N+1][0] = Integer.parseInt(st.nextToken());
            loc[N+1][1] = Integer.parseInt(st.nextToken());

            for (int i = 0; i <= N+1; i++) {
                for (int j = i+1; j <= N+1; j++) {
                    getDist(i,j);
                }
            }

            bfs();

        }

    }
    public static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean isHappy = false;
        visited[0] = true;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            if(cur==N+1){
                isHappy = true;
                break;
            }
            for (int i = 1; i <= N+1; i++) {
                if(!dist[cur][i]){
                    continue;
                }
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(i);

                }
            }
        }
        System.out.println(isHappy?"Happy":"Sad");
    }


    public static void getDist(int i, int j){
        int cal = Math.abs(loc[i][0] - loc[j][0])+ Math.abs(loc[i][1] - loc[j][1]);
        if(cal<=1000){
            dist[i][j] = true;
            dist[j][i] = true;
        }
    }
}
