package BOJ.BruteForce.BackTracking.Gold.P5558;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int H, W, N, min;
    static int[][] length;
    static int[] moveX = {-1,0,1,0}, moveY={0,-1,0,1};
    static char[][] map;
    static ArrayList<Node> points;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ_Repository\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;

        map = new char[H][W];
        length = new int[N+1][N+1];

        int[] start = new int[2];
        points = new ArrayList<>();

        int idx = 1;
        for (int i = 0; i < H; i++) {
            map[i] = bf.readLine().toCharArray();
            for (int j = 0; j < W; j++) {
                if(map[i][j]=='S'){
                    map[i][j] = '0';
                    start[0] = i;
                    start[1] = j;
                }else if(map[i][j]>='0' && map[i][j]<='9'){
                    points.add(new Node(i, j, map[i][j]-'0'));
                }
            }
        }

        Collections.sort(points);
        for (int i = 0; i < N; i++) {
            Node cur = points.get(i);
            map[cur.x][cur.y] = (char)('0'+i+1);
        }
        bfs(start[0], start[1], 0);
        for (int i = 0; i < N; i++) {
            Node cur = points.get(i);
            bfs(cur.x, cur.y, i+1);
        }

        visited = new boolean[N+1];
        dfs(0, 0, 0);
        System.out.println(min);

    }

    public static void dfs(int index, int curIdx, int sum){
        if(index==N){
            min = Math.min(min, sum);
            return;
        }
        for (int i = 1; i <= N; i++) {
            if(!visited[i] && index+1 >= points.get(i-1).cnt){
                visited[i] = true;
                dfs(index+1, i, sum+length[curIdx][i]);
                visited[i] = false;
            }
        }
    }

    public static void bfs(int x, int y, int idx){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 0));
        boolean[][] visited = new boolean[H][W];
        visited[x][y] = true;
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            int nextLoc = map[cur.x][cur.y]-'0';
            if(nextLoc>=0 && nextLoc<=10){
                length[idx][nextLoc] = cur.cnt;
            }
            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + moveX[i];
                int nextY = cur.y + moveY[i];
                if(check(nextX, nextY) && map[nextX][nextY] !='X' && !visited[nextX][nextY]){
                    visited[nextX][nextY] = true;
                    queue.add(new Node(nextX, nextY, cur.cnt+1));
                }
            }
        }
    }

    public static boolean check(int x, int y){
        return x>=0 && x<H && y>=0 && y<W;
    }
}
class Node implements Comparable<Node>{
    int x;
    int y;
    int cnt;

    public Node(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Node o) {
        return this.cnt - o.cnt;
    }
}
