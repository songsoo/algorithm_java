package Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C, idx;
    static int[][] map;
    static boolean[][] visited;
    static int[] moveX = {-1, 0 , 1 ,0}, moveY={0 ,-1 ,0, 1};
    static LinkedList<int[]> checkList;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ_Repository\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        idx = 0;
        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            char[] curStr = bf.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                map[i][j] = curStr[j]=='.'?-1:0;
            }
        }

        paintColor();
        printMap();

        int n = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            System.out.println(i+1+" 번째 시도!");
            int cur = Integer.parseInt(st.nextToken());
            hit(R-cur, i%2==0);
            idx++;
        }

        printMap();

    }

    public static void hit(int height, boolean isLeft){
        if(isLeft){
            for (int i = 0; i < C; i++) {
                if(map[height][i]!=-1){
                    map[height][i] = -1;
                    for (int j = 0; j < 4; j++) {
                        int nextX = height + moveX[j];
                        int nextY = i + moveY[j];
                        if(!check(nextX,nextY))continue;
                        checkList = new LinkedList<>();
                        int min = isFloatBFS(nextX, nextY);
                        System.out.println(min);
                        if(check(nextX, nextY) && min>0){
                            for(int[] cur : checkList){
                                map[cur[0]][cur[1]] = -1;
                            }
                            for(int[] cur : checkList){
                                map[cur[0]+min][cur[1]] = idx;
                            }
                            printMap();
                            break;
                        }
                    }
                    break;
                }
            }
        }else{
            for (int i = C-1; i >= 0; i--) {
                if(map[height][i]!=-1){
                    map[height][i] = -1;
                    for (int j = 0; j < 4; j++) {
                        int nextX = height + moveX[j];
                        int nextY = i + moveY[j];
                        if(!check(nextX,nextY))continue;
                        checkList = new LinkedList<>();
                        int min = isFloatBFS(nextX, nextY);
                        System.out.println(min);
                        if(check(nextX, nextY) && min>0){
                            for(int[] cur : checkList){
                                map[cur[0]][cur[1]] = -1;
                            }
                            for(int[] cur : checkList){
                                map[cur[0]+min][cur[1]] = idx;
                            }
                            printMap();
                            break;
                        }
                    }
                    break;
                }
            }
        }
    }

    public static int isFloatBFS(int x, int y){

       int minHeight = Integer.MAX_VALUE;

        visited = new boolean[R][C];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;

        //bfs를 돌면서 모든 위치에 대해서
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            checkList.add(cur);

            int cnt = 1;
            while(cur[0]+cnt<R && map[cur[0]+cnt][cur[1]]!='x'){
                cnt++;
            }
            System.out.println(cur[0]+" "+cur[1]+" "+cnt);
            minHeight = Math.min(minHeight, cnt-1);
            for (int i = 0; i < 4; i++) {
                int nextX = cur[0] + moveX[i];
                int nextY = cur[1] + moveY[i];
                if(check(nextX, nextY) && !visited[nextX][nextY] && map[nextX][nextY]=='x'){
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }

        return minHeight;
    }

    public static boolean check(int x, int y){
        return x>=0 && x<R && y>=0 && y<C;
    }

    public static void printMap(){
        System.out.println("프린트!!");
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j]==-1?".":map[i][j]);
            }
            System.out.println();
        }
    }

    public static void paintColor(){

        int idx = 1;

        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j]!=-1 && !visited[i][j]){

                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                    while(!queue.isEmpty()){
                        int[] cur = queue.poll();
                        map[cur[0]][cur[1]] = idx;
                        for (int k = 0; k < 4; k++) {
                            int nextX = cur[0] + moveX[k];
                            int nextY = cur[1] = moveY[k];
                            if(check(nextX, nextY) && !visited[nextX][nextY] && map[nextX][nextY]!=-1){
                                map[nextX][nextY] = idx;
                                visited[nextX][nextY] = true;
                                queue.add(new int[]{nextX,nextY});
                            }
                        }
                    }
                    idx++;
                }

            }
        }


    }
}
