package BOJ.BruteForce.BFS.Silver.P3187;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C, wolfCnt, sheepCnt;
    static char map[][];
    static int cnt[][], moveX[]={-1,0,1,0}, moveY[]={0,-1,0,1};
    static boolean visited[][];
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("C:\\Users\\송수현\\IdeaProjects\\algorithm_java\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        // 최대로 나눠질 수 있는 구역의 수
        int maxCnt = R*C/2 + (R*C%2==1?1:0);
        cnt = new int[maxCnt][2];
        sheepCnt = 0;
        wolfCnt = 0;

        for (int i = 0; i < R; i++) {
            map[i] = bf.readLine().toCharArray();
        }

        int index = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(!visited[i][j] && map[i][j]!='#'){
                    bfs(i, j, index);
                    index++;
                }
            }
        }
        System.out.println(sheepCnt + " " + wolfCnt);

    }
    public static void bfs(int i, int j, int index){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;
        while(!queue.isEmpty()){

            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            if(map[x][y]=='v'){
                cnt[index][0]++;
            }else if(map[x][y]=='k'){
                cnt[index][1]++;
            }

            for (int k = 0; k < 4; k++) {
                int nextX = x + moveX[k];
                int nextY = y + moveY[k];
                if(check(nextX,nextY)){
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }

        if(cnt[index][0]>=cnt[index][1]){
            wolfCnt += cnt[index][0];
        }else{
            sheepCnt += cnt[index][1];
        }
    }

    public static boolean check(int x, int y){
        return x<R && x>=0 && y<C && y>=0 && map[x][y]!='#' && !visited[x][y];
    }
}
