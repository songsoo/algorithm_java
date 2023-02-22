package BOJ.BruteForce.BFS.G4.P3055;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static char[][] arr;
    static boolean[][] waterVisited, dochiVisited;
    static int[] moveX={1,0,-1,0}, moveY={0,1,0,-1};
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("E:\\SSAFY9\\intelliJ_workspace\\algorithm_java\\src\\BOJ\\BruteForce\\BFS\\G4\\P3055\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        ArrayList<int[]> water = new ArrayList<>();
        int[] start = new int[2];
        for (int i = 0; i < N; i++) {
            arr[i] = bf.readLine().toCharArray();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(arr[i][j]=='*'){
                    water.add(new int[]{i,j});
                }else if(arr[i][j]=='S'){
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        waterVisited = new boolean[N][M];
        dochiVisited = new boolean[N][M];

        bfs(water, start);
    }
    public static void bfs(ArrayList<int[]> water, int[] start){
        Queue<ArrayList<int []>> queue = new LinkedList<>();
        Queue<ArrayList<int[]>> queue2 = new LinkedList<>();
        ArrayList<int[]> dochi = new ArrayList<>();
        dochi.add(start);
        queue2.add(dochi);
        queue.add(water);

        int count = 1;
        while(queue2.peek().size()>0){

            // 물 일단 퍼뜨려놓고
            ArrayList<int[]> curWaterList = queue.poll();
            ArrayList<int[]> nextWaterList = new ArrayList<>();
            for(int[] curWater : curWaterList){
                for (int i = 0; i < 4; i++) {
                    int nextX = curWater[0]+moveX[i];
                    int nextY = curWater[1]+moveY[i];
                    if(checkW(nextX,nextY)){
                        waterVisited[nextX][nextY]=true;
                        arr[nextX][nextY]='*';
                        nextWaterList.add(new int[]{nextX,nextY});
                    }
                }
            }
            queue.add(nextWaterList);

            ArrayList<int[]> curDochiList = queue2.poll();
            ArrayList<int[]> nextDochiList = new ArrayList<>();
            for(int[] curDochi: curDochiList){
                for (int i = 0; i < 4; i++) {
                    int nextX = curDochi[0]+moveX[i];
                    int nextY = curDochi[1]+moveY[i];
                    if(checkD(nextX,nextY)){
                        dochiVisited[nextX][nextY]=true;
                        nextDochiList.add(new int[]{nextX,nextY});
                    }
                    if(isFinished(nextX,nextY)){
                        System.out.println(count);
                        return;
                    }
                }
            }
            queue2.add(nextDochiList);

            count++;

        }
        System.out.println("KAKTUS");
    }

    public static boolean checkW(int x, int y){
        if(x>=0 && x<N && y>=0 && y<M && !waterVisited[x][y] && arr[x][y]!='D' && arr[x][y]!='X'){
            return true;
        }
        return false;
    }
    public static boolean checkD(int x, int y){
        if(x>=0 && x<N && y>=0 && y<M && !dochiVisited[x][y] && arr[x][y]!='X' && arr[x][y]!='*'){
            return true;
        }
        return false;
    }
    public static boolean isFinished(int x, int y){
        if(x>=0 && x<N && y>=0 && y<M && arr[x][y]=='D'){
            return true;
        }
        return false;
    }
}
