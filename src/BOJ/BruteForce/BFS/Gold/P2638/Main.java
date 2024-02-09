package BOJ.BruteForce.BFS.Gold.P2638;

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
        System.setIn(new FileInputStream("E:\\SSAFY9\\intelliJ_workspace\\algorithm_java\\src\\BOJ\\BruteForce\\BFS\\G3\\P2638\\input.txt"));
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map= new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;
        while(true){
            visited = new int[R][C];
            if(bfs()==0){
                System.out.println(count);
                break;
            }
            count++;
        }
    }

    public static int bfs(){
        int result = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});

        while(!queue.isEmpty()){

            int[] cur = queue.poll();
            if(map[cur[0]][cur[1]]<=0 && visited[cur[0]][cur[1]]>0)continue;

            visited[cur[0]][cur[1]]++;

            for (int i = 0; i < 4; i++) {

                int nextX = cur[0]+moveX[i];
                int nextY = cur[1]+moveY[i];

                if(check(nextX, nextY)){
                    if(map[nextX][nextY]<=0 && visited[nextX][nextY]==0){
                        queue.add(new int[] {nextX, nextY});
                    }else if(map[nextX][nextY]==1){
                        visited[nextX][nextY]++;
                        if(visited[nextX][nextY]==2){
                            map[nextX][nextY] = 0;
                            result++;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static boolean check(int x, int y){
        if(x>=R || x<0 || y>=C || y<0){
            return false;
        }else{
            return true;
        }
    }
}
