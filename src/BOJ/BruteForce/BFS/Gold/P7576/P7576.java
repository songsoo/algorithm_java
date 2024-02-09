package BOJ.BruteForce.BFS.Gold.P7576;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7576 {
    static int N,M,count,date;
    static int[][] arr;
    static ArrayList<node> start;
    static boolean[][] visited;
    static int[] moveX= {-1,0,1,0},moveY={0,-1,0,1};
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("E:\\ssafy\\intelliJWorkSpace\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        count = N*M;
        date = 0;
        visited = new boolean[N][M];
        start = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==1){
                    count--;
                    start.add(new node(i,j,0));
                }else if(arr[i][j]==-1){
                    count--;
                }
            }
        }

        bfs();

        if(count==0){
            System.out.println(date);
        }else{
            System.out.println("-1");
        }

    }

    public static void bfs(){
        Queue<node> queue = new LinkedList<>();
        for(node cur: start){
            queue.add(cur);
        }

        while(!queue.isEmpty()){
            node cur = queue.poll();
            date = Math.max(cur.count, date);
            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + moveX[i];
                int nextY = cur.y + moveY[i];
                if(check(nextX,nextY)){
                    visited[nextX][nextY] = true;
                    queue.add(new node(nextX,nextY,cur.count+1));
                    count--;
                }
            }
        }
    }

    public static boolean check(int x, int y){
        if(x>=0 && x<N && y>=0 && y<M && !visited[x][y] && arr[x][y]==0){
            return true;
        }return false;
    }

    public static class node{
        int x;
        int y;
        int count;

        public node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}