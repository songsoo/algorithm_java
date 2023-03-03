package BOJ.BruteForce.BFS.G3.P16236;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static int[] start = new int[2];
    static int[] moveY = {-1,0,1,0}, moveX={0,-1,0,1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\SSAFY\\IdeaProjects\\algorithm_java\\src\\BOJ\\BruteForce\\BFS\\G3\\P16236\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==9){
                    start[0] = i;
                    start[1] = j;
                    arr[i][j] = 0;
                }
            }
        }
        int size = 2;
        int sizeUp = 0;
        int count=0;
        while(true){
            loc next;
            visited = new boolean[N][N];
            next = bfs(size);
            start[0] = next.x;
            start[1] = next.y;
            if(next.x==-1 && next.y==-1){
                break;
            }else{
                arr[start[0]][start[1]] = 0;
            }
            if(++sizeUp == size){
                size++;
                sizeUp = 0;
            }
            count+= next.count;
            //printArr();
            //System.out.println(start[0]+" "+start[1]+" "+next.count);
        }
        System.out.println(count);

    }
    public static void printArr(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static loc bfs(int size){

        Queue<loc> queue = new LinkedList<>();
        queue.add(new loc(start[0],start[1],0));
        PriorityQueue<loc> pq = new PriorityQueue<>();
        while(!queue.isEmpty()){
            loc cur = queue.poll();
            int count = cur.count;
            if(visited[cur.x][cur.y] ){
               continue;
            }
            visited[cur.x][cur.y] = true;
            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + moveX[i];
                int nextY = cur.y + moveY[i];
                if((check(nextX,nextY) && arr[nextX][nextY]==size) || (check(nextX,nextY) && arr[nextX][nextY]==0) ){
                    queue.add(new loc(nextX, nextY,count+1));
                }else if(check(nextX,nextY) && arr[nextX][nextY]<size){
                    pq.add(new loc(nextX, nextY, count+1));
                }
            }
        }
        if(!pq.isEmpty()){
            return pq.poll();
        }else{
            return new loc(-1, -1,0);
        }
    }
    public static boolean check(int x, int y){
        if(x>=0 && x<N && y>=0 && y<N){
            return true;
        }
        return false;
    }
}
class loc implements Comparable<loc>{
    int x;
    int y;
    int count;
    public loc(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }

    @Override
    public int compareTo(loc o) {
        if(count == o.count) {
            if (this.x != o.x) {
                return this.x - o.x;
            } else {
                return this.y - o.y;
            }
        }else{
            return this.count -o.count;
        }
    }
}