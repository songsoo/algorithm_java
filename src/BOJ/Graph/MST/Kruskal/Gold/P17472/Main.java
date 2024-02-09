package BOJ.Graph.MST.Kruskal.Gold.P17472;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, index;
    static int[][] arr,graph;
    static int[] moveX = {-1,0,1,0}, moveY = {0,-1,0,1},parent;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("C:\\Users\\SSAFY\\IdeaProjects\\algorithm_java\\src\\BOJ\\Graph\\MST\\Kruskal\\G1\\P17472\\input.txt"));
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        index = 2;//index-2가 전체 개수

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
        graph = new int[index][index];
        parent = new int[index];
        for (int i = 0; i < index; i++) {
            Arrays.fill(graph[i],10000);
            parent[i] = i;
        }

        // 각 인덱스마다의 최소 거리를 구한다, 이 때 거리는 2이상일 것

        for (int i = 0; i < N; i++) {
            int count = 0;
            int cur = arr[i][0];
            for (int j = 1; j < M; j++) {
                if(cur==arr[i][j]){
                    count = 0 ;
                    continue;
                }
                if(arr[i][j]==0){
                    count++;
                    continue;
                }
                else if(cur!=arr[i][j] && count>1){
                    graph[cur][arr[i][j]] = Math.min(graph[cur][arr[i][j]],count);
                    count = 0;
                    cur = arr[i][j];
                }
                if(cur!=arr[i][j]){
                    count = 0;
                    cur = arr[i][j];
                }
            }
        }

        for (int j = 0; j < M; j++) {
            int count = 0;
            int cur = arr[0][j];
            for (int i = 1; i < N; i++) {
                if(cur==arr[i][j]){
                    count = 0;
                    continue;
                }
                if(arr[i][j]==0){
                    count++;
                    continue;
                }
                else if(cur!=arr[i][j] && count>1){
                    graph[cur][arr[i][j]] = Math.min(graph[cur][arr[i][j]],count);
                }
                if(cur!=arr[i][j]){
                    count = 0;
                    cur = arr[i][j];
                }
            }
        }

        PriorityQueue<edge> pq = new PriorityQueue<>();
        for (int i = 0; i < index; i++) {
            for (int j = 0; j < index; j++) {
                if(graph[i][j]!=10000){
                    pq.add(new edge(i,j,graph[i][j]));
                }
            }
        }
        int count = 0;
        int result = 0;
        while(!pq.isEmpty() && count<index-3){
            edge cur = pq.poll();
            if(find(cur.from)!=find(cur.to)){
                union(cur.from, cur.to);
                count++;
                result += cur.value;
            }
        }

        System.out.println(count==index-3?result:-1);
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
        this.from = Math.max(x,y);
        this.to = Math.min(x,y);
        this.value = value;
    }
    @Override
    public int compareTo(edge o) {
        return Integer.compare(this.value, o.value);
    }
}