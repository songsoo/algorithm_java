package SWEA.Test.P1868;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int T,N,findNum;
    static int arr[][];
    static boolean visited[][];
    static ArrayList<int[]> start;
    static int[] moveX={1,0,-1,0},moveY={0,1,0,-1};
    static int[] movePOPX={0,1,1,1,0,-1,-1,-1}, movePOPY={1,1,0,-1,-1,-1,0,1};
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("E:\\SSAFY9\\intelliJ_workspace\\algorithm_java\\src\\SWEA\\Test\\P1868\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {

            N = Integer.parseInt(bf.readLine());
            arr = new int[N][N];
            visited = new boolean[N][N];
            start = new ArrayList<>();
            findNum = 0;
            for (int i = 0; i < N; i++) {
                String str = bf.readLine();
                for (int j = 0; j < N; j++) {
                    char chr = str.charAt(j);
                    if(chr=='*'){
                        arr[i][j]=-1;
                        visited[i][j]=true;
                        plusAround(i,j);
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(arr[i][j]==0){
                        start.add(new int[] {i,j});
                    }
                }
            }


            
            for (int[] cur: start) {
                if (!visited[cur[0]][cur[1]]) {
                    visited[cur[0]][cur[1]] = true;
                    goNext(cur[0], cur[1]);
                    findNum++;
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visited[i][j]){
                        findNum++;
                    }
                }
            }

            System.out.println("#"+test_case+" "+findNum);

        }
    }
    
    public static void goNext(int x, int y){
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[] {x,y});
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for (int i = 0; i < 8; i++) {
                int nextX = cur[0] + movePOPX[i];
                int nextY = cur[1] + movePOPY[i];
                if(check(nextX,nextY)&&arr[nextX][nextY]==0){
                    visited[nextX][nextY]=true;
                    queue.add(new int[] {nextX, nextY});
                }else if(check(nextX,nextY)){
                    visited[nextX][nextY]=true;
                }
            }
        }
    }
    
    public static void plusAround(int x,int y){
        for (int i = 0; i < 8; i++) {
            int nextX = x+movePOPX[i];
            int nextY = y+movePOPY[i];
            if(canGo(nextX,nextY)){
                arr[nextX][nextY]++;
            }
        }
    }
    public static boolean canGo(int x, int y){
        if(x>=0 && x<N && y>=0 && y<N &&arr[x][y]!=-1){
            return true;
        }
        return false;
    }

    public static boolean check(int x, int y){
        if(x>=0 && x<N && y>=0 && y<N &&!visited[x][y]){
            return true;
        }
        return false;
    }

}
