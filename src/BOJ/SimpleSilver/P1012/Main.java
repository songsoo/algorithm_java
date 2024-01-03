package BOJ.SimpleSilver.P1012;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int T, M, N, K;
    static boolean visited[][];
    static int arr[][];
    static int[] moveX = {-1,0,1,0}, moveY={0,-1,0,1};
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());
        sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            visited = new boolean[M][N];
            arr = new int[M][N];

            Queue<int[]> queue = new LinkedList<>();

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(bf.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                queue.add(new int[]{x,y});
                arr[x][y] = 1;
            }
            int result = 0;
            while(!queue.isEmpty()){
                int[] cur = queue.poll();
                if(!visited[cur[0]][cur[1]]){
                    result++;
                    bfs(cur[0], cur[1]);
                }
            }

            sb.append(result+"\n");

        }
        System.out.println(sb.toString());
    }

    public static void bfs(int x, int y){

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        while(!queue.isEmpty()){

            int[] cur = queue.poll();
            if(visited[cur[0]][cur[1]]){
                continue;
            }

            visited[cur[0]][cur[1]] = true;

            for (int i = 0; i < 4; i++) {
                int nextX = cur[0]+moveX[i];
                int nextY = cur[1]+moveY[i];
                if(poss(nextX,nextY)){
                    queue.add(new int[]{nextX,nextY});
                }
            }

        }

    }

    public static boolean poss(int x, int y){
        if(x<0 || x>=M || y<0 || y>=N || visited[x][y] || arr[x][y]==0){
            return false;
        }
        return true;
    }
}
