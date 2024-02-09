package BOJ.BruteForce.BFS.Gold.P14502;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P14502 {
    static int N,M,total;
    static int[][] map;
    static boolean[][] visited;
    static int[] chose, moveX={-1,0,1,0},moveY={0,-1,0,1};
    static ArrayList<int[]> startPoints;

    static int max;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("E:\\SooHyeon\\intelliJWorkSpace\\algorithm_java\\src\\Test\\input.txt"));
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        total = N*M;
        map = new int[N][M];
        chose = new int[3];
        startPoints = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2){
                    startPoints.add(new int[]{i,j});
                    total--;
                }else if(map[i][j]==1){
                    total--;
                }
            }
        }
        total = total-3;
        max = 0;
        perm(0,0);
        System.out.println(max);

    }
    public static void perm(int index, int start){
        if(index==3){
            visited = new boolean[N][M];
            bfs();
            return;
        }
        for (int i = start; i < N*M; i++) {
            if(map[i/M][i%M]==0){
                map[i/M][i%M] = 1;
                perm(index+1, i+1);
                map[i/M][i%M] = 0;
            }
        }
    }

    public static void bfs(){
        int count = total;
        for(int[] startPoint: startPoints){
            Queue<int[]> queue = new LinkedList<>();
            queue.add(startPoint);
            while(!queue.isEmpty()){
                int[] cur = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int nextX = cur[0] + moveX[i];
                    int nextY = cur[1] + moveY[i];
                    if(check(nextX,nextY)){
                        visited[nextX][nextY] = true;
                        queue.add(new int[]{nextX,nextY});
                        count--;
                    }
                }
            }
        }
        max = Math.max(max,count);
    }

    public static boolean check(int x, int y){
        if(x>=0 && x<N && y>=0 && y<M && map[x][y]==0 && visited[x][y]==false){
            return true;
        }return false;
    }

    public static void printArr(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println();

    }
}
