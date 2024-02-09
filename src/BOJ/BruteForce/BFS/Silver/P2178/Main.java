package BOJ.BruteForce.BFS.Silver.P2178;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static char arr[][];
    static int[][] visited;
    static Queue<int[]> queue;
    static int[] moveX={0,0,-1,1},moveY={1,-1,0,0};
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("E:\\SSAFY9\\intelliJ_workspace\\algorithm_java\\src\\BOJ\\S1\\P2178\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        visited = new int[N][M];
        queue = new LinkedList();
        for (int i = 0; i < N; i++) {
            st  = new StringTokenizer(bf.readLine());
            arr[i] = st.nextToken().toCharArray();
        }
        bfs();
    }

    public static void bfs(){
        visited[0][0] =1;
        queue.offer(new int[] {0,0});
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if(cur[0]==N-1 && cur[1]==M-1){
                System.out.println(visited[cur[0]][cur[1]]);
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nextX = cur[0]+moveX[i];
                int nextY = cur[1]+moveY[i];
                if(nextX>=0&&nextX<N&&nextY>=0&&nextY<M&&visited[nextX][nextY]==0&&arr[nextX][nextY]=='1'){
                    visited[nextX][nextY] = visited[cur[0]][cur[1]]+1;
                    queue.offer(new int[] {nextX, nextY});
                }
            }
        }
    }
}



















