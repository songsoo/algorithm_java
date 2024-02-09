package BOJ.BruteForce.BFS.Gold.P22944;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, H, D;
    static char[][] map;
    static int[] start, end, moveX={-1,0,1,0},moveY={0,-1,0,1};
    static int[][] visited;
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("C:\\Users\\SSAFY\\IdeaProjects\\algorithm_java\\src\\BOJ\\BruteForce\\BFS\\G4\\P22944\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new char[N][N];
        start = new int[2];
        end = new int[2];
        visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = bf.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j]=='S'){
                    start[0] = i;
                    start[1] = j;
                }else if(map[i][j]=='E'){
                    end[0] = i;
                    end[1] = j;
                }
            }
        }

        bfs();

    }

    public static void bfs(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start[0], start[1], H, 0, 0));
        visited[start[0]][start[1]] = H;

        int result = 0;
        loop:
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + moveX[i];
                int nextY = cur.y + moveY[i];
                int nextHP = cur.hp;
                int nextUmb = cur.umb;

                if(check(nextX,nextY,nextHP)){

                    if(map[nextX][nextY]=='E'){
                        result = cur.count+1;
                        break loop;
                    }

                    if(map[nextX][nextY]=='U'){
                        nextUmb = D;
                    }

                    if(nextUmb==0){
                        nextHP--;
                    }else{
                        nextUmb--;
                    }
                    if(visited[nextX][nextY]<nextUmb+nextHP){
                        visited[nextX][nextY] = nextUmb+nextHP;
                        queue.add(new Node(nextX, nextY, nextHP,nextUmb, cur.count+1));
                    }
                }
            }
        }
        if(result==0){
            System.out.println("-1");
        }else {
            System.out.println(result);
        }
    }

    public static boolean check(int x, int y, int hp){
        if(x>=0 && x<N && y>=0 && y<N && hp>0){
            return true;
        }return false;
    }
}
class Node{
    int x;
    int y;
    int hp;
    int umb;
    int count;

    public Node(int x, int y, int hp,int umb, int count) {
        this.x = x;
        this.y = y;
        this.hp = hp;
        this.umb = umb;
        this.count = count;
    }
}