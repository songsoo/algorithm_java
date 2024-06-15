package BOJ.BruteForce.BFS.Gold.P2234;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, roomWidthMax, roomBreakWallWidthMax;
    static int[] moveX={0,-1,0,1}, moveY={-1,0,1,0};
    static boolean[][][] wallInfo;
    static boolean[][] visited;
    static int[][] roomNum;
    static ArrayList<Integer> roomWidthInfo;
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("D:\\IntelliJ_Repository\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        // (아래)(오른)(위)(왼)
        wallInfo = new boolean[N][M][4];
        visited = new boolean[N][M];
        roomNum = new int[N][M];
        roomWidthMax = 0;
        roomBreakWallWidthMax = 0;
        roomWidthInfo = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            Arrays.fill(roomNum[i],-1);
            for (int j = 0; j < M; j++) {
                int cur = Integer.parseInt(st.nextToken());
                for (int k = 0; k < 4; k++) {
                    wallInfo[i][j][k] = (cur & 1) == 1 ? true : false;
                    cur = cur>>1;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j]){
                    visited[i][j] = true;
                    bfs(i, j, cnt);
                    cnt++;
                }
            }
        }

        System.out.println(cnt+"\n"+roomWidthMax+"\n"+roomBreakWallWidthMax);
    }
    public static void bfs(int x, int y, int idx){
        int width = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        int neighborWidthMax = 0;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            roomNum[cur[0]][cur[1]] = idx;
            width++;
            for (int i = 0; i < 4; i++) {
                int nextX = cur[0] + moveX[i];
                int nextY = cur[1] + moveY[i];
                // 막혀있지 않고
                if(!wallInfo[cur[0]][cur[1]][i]){
                    // 방문하지 않았다면
                    if(check(nextX, nextY) && !visited[nextX][nextY]){
                        visited[nextX][nextY] = true;
                        queue.add(new int[]{nextX, nextY});
                    }
                }
                // 벽에 막혀있다면
                else{
                    // 이웃의 크기를 확인
                    if(check(nextX, nextY) && roomNum[nextX][nextY]!=-1 && roomNum[nextX][nextY]!=idx){
                        neighborWidthMax = Math.max(neighborWidthMax, roomWidthInfo.get(roomNum[nextX][nextY]));
                    }
                }
            }
        }
        roomBreakWallWidthMax = Math.max(roomBreakWallWidthMax, width+neighborWidthMax);
        roomWidthMax = Math.max(roomWidthMax, width);
        roomWidthInfo.add(width);
    }
    public static boolean check(int x, int y){
        return x>=0 && x<N && y>=0 && y<M;
    }
}
