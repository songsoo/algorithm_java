package BOJ.BruteForce.BFS.Gold.P5827;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, res;
    static char[][] map;
    static int[][][] visited;
    static int[] moveX={0,0}, moveY={-1,1};
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("C:\\Users\\송수현\\IdeaProjects\\algorithm_java\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new int[N][M][3];
        res = Integer.MAX_VALUE;

        int startX=0, startY=0;

        for (int i = 0; i < N; i++) {
            map[i] = bf.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);
                if(map[i][j]=='C'){
                    startX = i;
                    startY = j;
                }
            }
        }

        Queue<node> queue = new LinkedList<>();
        startX = move(startX, startY, 1,0);
        if(check(startX,startY)){
            queue.add(new node(startX, startY, 0, 1));
            visited[startX][startY][2] = 0;
        }
        while(!queue.isEmpty()){
            node cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            int cnt = cur.cnt;
            int gravity = cur.gravity;
            if(visited[x][y][gravity+1]<cnt){
                continue;
            }
            if(map[x][y]=='D'){
                res = Math.min(cnt,res);
                continue;
            }
            // 중력 바꿈
            int nextX = move(x, y, gravity * -1, cnt+1);
            int newGravity = gravity*-1;
            if(check(nextX, y) && visited[nextX][y][newGravity+1]>cnt+1){
                visited[nextX][y][newGravity+1] = cnt+1;
                queue.add(new node(nextX, y, cnt+1, gravity * -1));
            }
            // 가로 움직임
            for (int i = 0; i < 2; i++) {
                nextX = x + moveX[i];
                int nextY = y + moveY[i];
                if(check(nextX, nextY)){
                    nextX = move(nextX, nextY, gravity, cnt);
                    if(check(nextX, nextY) && visited[nextX][nextY][gravity+1]>cnt){
                        visited[nextX][nextY][gravity+1] = cnt;
                        queue.add(new node(nextX, nextY, cnt, gravity));
                    }
                }
            }

        }
        System.out.println(res==Integer.MAX_VALUE?-1:res);

    }

    public static int move(int x, int y, int gravity, int cnt){
        while(check(x, y)){
            if(map[x][y]=='D'){
                res = Math.min(res, cnt);
            }
            x += gravity;
        }
        // 범위를 벗어나면 -1 리턴
        if(x>=N || x<0){
            return -1;
        }
        return x - gravity;
    }

    public static boolean check(int x, int y){
        return x>=0 && x<N && y>=0 && y<M && map[x][y]!='#';
    }
}
class node{
    int x;
    int y;
    int cnt;
    int gravity;

    public node(int x, int y, int cnt, int gravity) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.gravity = gravity;
    }
}