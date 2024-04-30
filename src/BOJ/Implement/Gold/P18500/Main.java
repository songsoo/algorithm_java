package BOJ.Implement.Gold.P18500;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static int[][] map;
    static int[] moveX = {-1, 0 , 1 ,0}, moveY={0 ,-1 ,0, 1};
    static LinkedList<int[]> checkList;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("C:\\Users\\송수현\\IdeaProjects\\algorithm_java\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            char[] curStr = bf.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                map[i][j] = curStr[j]=='.'?-1:0;
            }
        }
        colorMap();

        int n = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            int height = R-Integer.parseInt(st.nextToken());
            throwStick(height, i%2==0);
        }
        printMap();

    }

    public static void throwStick(int x, boolean isLeft){

        if(isLeft){
            for (int i = 0; i < C; i++) {
                if(map[x][i]!=-1){
                    map[x][i] = -1;
                    colorMap();
                    for (int j = 0; j < 4; j++) {
                        int nextX = x + moveX[j];
                        int nextY = i + moveY[j];
                        if(check(nextX, nextY) && map[nextX][nextY]!=-1){
                            int height = checkFloat(nextX, nextY);
                            if(height > 0){
                                for(int[] cur : checkList){
                                    map[cur[0]][cur[1]] = -1;
                                }
                                for(int[] cur : checkList){
                                    map[cur[0]+height][cur[1]] = 1;
                                }
                            }
                        }
                    }
                    break;
                }
            }
        }else{
            for (int i = C-1; i >= 0; i--) {
                if(map[x][i]!=-1){
                    map[x][i] = -1;
                    colorMap();
                    for (int j = 0; j < 4; j++) {
                        int nextX = x + moveX[j];
                        int nextY = i + moveY[j];
                        if(check(nextX, nextY) && map[nextX][nextY]!=-1){
                            int height = checkFloat(nextX, nextY);
                            if(height > 0){
                                for(int[] cur : checkList){
                                    map[cur[0]][cur[1]] = -1;
                                }
                                for(int[] cur : checkList){
                                    map[cur[0]+height][cur[1]] = 1;
                                }
                                colorMap();
                            }
                        }
                    }
                    break;
                }
            }
        }

    }

    public static int checkFloat(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        boolean[][] visited = new boolean[R][C];
        visited[x][y] = true;
        int minHeight = R;
        checkList = new LinkedList<>();
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            int tmp = 0;
            checkList.add(new int[]{curX, curY});
            while(check(curX+tmp+1, curY) && (map[curX+tmp+1][curY]==-1 || map[x][y]==map[curX+tmp+1][curY])){
                tmp++;
            }

            minHeight = Math.min(minHeight, tmp);
            for (int i = 0; i < 4; i++) {
                int nextX = curX + moveX[i];
                int nextY = curY + moveY[i];
                if(check(nextX, nextY) && !visited[nextX][nextY] && map[nextX][nextY]==map[x][y]){
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX,nextY});
                }
            }
        }
        return minHeight;
    }
    public static boolean check(int x, int y){
        return x>=0 && x<R && y>=0 && y<C;
    }

    public static void printMap(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(map[i][j]==-1?".":"x");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void colorMap(){

        int idx = 1;
        boolean visited[][] = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] != -1 && !visited[i][j]){
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                    while(!queue.isEmpty()){
                        int[] cur = queue.poll();
                        map[cur[0]][cur[1]] = idx;
                        for (int k = 0; k < 4; k++) {
                            int nextX = cur[0] + moveX[k];
                            int nextY = cur[1] + moveY[k];
                            if(check(nextX, nextY) && !visited[nextX][nextY] && map[nextX][nextY] != -1){
                                visited[nextX][nextY] = true;
                                queue.add(new int[]{nextX, nextY});
                            }
                        }
                    }
                    idx++;
                }
            }
        }
    }


}
