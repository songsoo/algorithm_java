package BOJ.Graph.MST.Kruskal.G1.P17472;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static int N, M, index;
    static int[][] arr,graph;
    static int[] moveX = {-1,0,1,0}, moveY = {0,-1,0,1},parent;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("E:\\SSAFY9\\intelliJ_workspace\\algorithm_java\\src\\BOJ\\Graph\\MST\\Kruskal\\G1\\P17472\\input.txt"));
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        index = 2;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(arr[i][j]==1){
                    bfs(i,j);
                }
            }
        }

        PriorityQueue<edge> pq = new PriorityQueue<>();




    }
    public static int find(int x){
        if(x==parent[x]){
            return x;
        }else{
            return parent[x] = find(parent[x]);
        }
    }
    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x!=y){
            parent[Math.max(x,y)] = Math.min(x,y);
        }
    }

    public static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x,y});
        arr[x][y] = index;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = cur[0] + moveX[i];
                int nextY = cur[1] + moveY[i];
                if(check(nextX,nextY)&&arr[nextX][nextY]==1){
                    arr[nextX][nextY] = index;
                    queue.add(new int[]{nextX, nextY});
                }
            }

        }
        index++;
    }

    public static boolean check(int x, int y){
        if(x>=0 && x<N && y>=0 && y<M){
            return true;
        }return false;
    }
}
class edge implements Comparable<edge>{
    int from;
    int to;
    int value;
    edge(int x, int y, int value){
        this.from = x;
        this.to = y;
        this.value = value;
    }

    @Override
    public int compareTo(edge o) {
        return Integer.compare(this.value, o.value);
    }
}