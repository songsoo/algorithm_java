package SWEA.Test.P1949;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static int T;
    static int N,K,result;
    static int[][] arr;
    static int[] moveX = {0,-1,0,1}, moveY={-1,0,1,0};
    static boolean[][] visited;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("E:\\SSAFY9\\intelliJ_workspace\\algorithm_java\\src\\SWEA\\Test\\P1949\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st  = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            visited = new boolean[N][N];
            arr = new int[N][N];
            result = 0;
            int max = 0;
            ArrayList<int[]> start = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if(max<arr[i][j]){
                        max = arr[i][j];
                        start.clear();
                        start.add(new int[]{i, j});
                    }else if(max==arr[i][j]){
                        start.add(new int[]{i, j});
                    }
                }
            }

            for(int[] startLoc : start){
                visited[startLoc[0]][startLoc[1]] = true;
                goNext(startLoc[0], startLoc[1],1, false);
                visited[startLoc[0]][startLoc[1]] = false;
            }
            System.out.println("#"+test_case+" "+result);
        }
    }

    public static void goNext(int x, int y,int cnt, boolean hasCut){
        //printBlank(cnt);
        //System.out.println(x+" "+y +" : "+cnt);
        result = Math.max(cnt,result);

        for (int i = 0; i < 4; i++) {

            int nextX = x + moveX[i];
            int nextY = y + moveY[i];

            if(check(nextX, nextY) && isSmaller(x, y, nextX, nextY)){

                visited[nextX][nextY] = true;
                goNext(nextX,nextY,cnt+1,hasCut);
                visited[nextX][nextY] = false;

            }else if(check(nextX, nextY) && hasCut==false && canCut(x,y,nextX,nextY)){

                int tmp = arr[nextX][nextY];
                arr[nextX][nextY] = arr[x][y]-1;
                visited[nextX][nextY] = true;
                goNext(nextX,nextY,cnt+1,true);
                visited[nextX][nextY] = false;
                arr[nextX][nextY] = tmp;

            }
        }

    }

    public static boolean check(int nextX, int nextY){
        if(nextX>=0 && nextX<N && nextY>=0 && nextY<N&& !visited[nextX][nextY]){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isSmaller(int x, int y, int nextX, int nextY){
        if(arr[x][y]>arr[nextX][nextY]){
            return true;
        }else{
            return false;
        }
    }

    public static boolean canCut(int x,int y,int nextX,int nextY){
        if(arr[x][y]+K <= arr[nextX][nextY]){
            return false;
        }
        return true;
    }

    public static void printBlank(int n){
        for (int i = 0; i < n; i++) {
            System.out.print(" ");
        }
    }


}
