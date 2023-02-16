package BOJ.BruteForce.BFS.G3.P2638;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int R,C;
    static int[][] map;
    static int[][] visited;
    static int[] moveX={-1,0,1,0},moveY={0,-1,0,1};
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(""));
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while(true){

            visited = new int[R][C];
            bfs();
        }

    }

    public static int bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();



        }
        return 1;
    }
}
