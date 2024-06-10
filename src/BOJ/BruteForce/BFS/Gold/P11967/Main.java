package BOJ.BruteForce.BFS.Gold.P11967;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] moveX = {-1,0,1,0}, moveY = {0,-1,0,1};
    static boolean[][] light, go;
    static ArrayList<int[]> arr[][];
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("D:\\IntelliJ_Repository\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        light = new boolean[N+1][N+1];
        go = new boolean[N+1][N+1];

        arr = new ArrayList[N+1][N+1];
        for (int i = 0; i < N+1; i++) {
            for (int j = 0; j < N+1; j++) {
                arr[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            arr[x1][y1].add(new int[]{x2, y2});
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1,1});
        light[1][1] = true;
        go[1][1] = true;
        int cnt = 1;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = cur[0] + moveX[i];
                int nextY = cur[1] + moveY[i];
                // 현재 도달한 곳의 사방으로 갈 수 있는데 아직 안 간 곳이 있다면 간다.
                if(check(nextX, nextY) && light[nextX][nextY] && !go[nextX][nextY]){
                    go[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                }
            }
            for(int[] next : arr[cur[0]][cur[1]]){
                if(!light[next[0]][next[1]]){
                    light[next[0]][next[1]] = true;
                    cnt++;
                    // 현재의 위치에서 불을 켠 곳들이 갈 수 있는 곳이라면 간다.
                    for (int i = 0; i < 4; i++) {
                        // 불 켜진 곳 기준 사방의 위치
                        int nextX = next[0] + moveX[i];
                        int nextY = next[1] + moveY[i];
                        if(check(nextX, nextY) && go[nextX][nextY] && !go[next[0]][next[1]]){
                            go[next[0]][next[1]] = true;
                            queue.add(new int[]{next[0], next[1]});
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(cnt);

    }

    public static boolean check(int x, int y){
        return x>=1 && x<N+1 && y>=1 && y<N+1;
    }

}
