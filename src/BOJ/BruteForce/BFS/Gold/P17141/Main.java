package BOJ.BruteForce.BFS.Gold.P17141;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

//P17141
public class Main {
    static int N, M, virusCnt, max,result,blockNum, map[][], count[][];
    static int[] selected;
    static int[] moveX = {-1,0,1,0}, moveY = {0,-1,0,1};
    static boolean[][] visited;
    static ArrayList<int[]> virusList;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        virusCnt = 0;
        blockNum = N*N;
        map = new int[N][N];
        selected = new int[M];
        max = -1;
        result = Integer.MAX_VALUE;
        virusList = new ArrayList<>();
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                int cur = Integer.parseInt(st.nextToken());
                map[i][j] = cur;
                if(cur == 2){
                    virusList.add(new int[]{i,j});
                    virusCnt++;
                }
                else if(cur == 1){
                    blockNum--;
                }
            }
        }


        dfs(-1,0);

        System.out.println(result>N*N?-1:result);
    }

    public static void dfs(int cur, int index){
        if(index==M){
            result = Math.min(result,bfs());
            return;
        }

        for (int i = cur+1; i < virusCnt; i++) {
            selected[index] = i;
            dfs(i, index+1);
        }
    }

    public static int bfs(){
        count = new int[N][N];
        Queue<point> queue = new LinkedList<>();
        visited = new boolean[N][N];

        for (int i = 0; i < M; i++) {
            int[] cur = virusList.get(selected[i]);
            queue.add(new point(cur[0], cur[1], 0));
            visited[cur[0]][cur[1]] = true;
        }


        int max = 0;
        int cnt = 0;
        while (!queue.isEmpty()) {
            point cur = queue.poll();
            cnt++;
            max = Math.max(max, cur.cnt);
            for (int i = 0; i < 4; i++) {
                point nextPoint = new point(cur.x + moveX[i], cur.y + moveY[i], cur.cnt + 1);
                if (check(nextPoint.x, nextPoint.y) && !visited[nextPoint.x][nextPoint.y]) {
                    queue.add(nextPoint);
                    visited[nextPoint.x][nextPoint.y] = true;
                    count[nextPoint.x][nextPoint.y] = nextPoint.cnt;
                }
            }
        }
        if(blockNum!=cnt){
            max = Integer.MAX_VALUE;
        }
        return max;
    }
    public static boolean check(int x, int y){
        return (x>=0 && x<N && y>=0 && y<N && map[x][y] != 1);
    }
}
class point{
    int x;
    int y;
    int cnt;

    public point(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}
