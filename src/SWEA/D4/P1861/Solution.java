package SWEA.D4.P1861;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

    static int[][] visited;
    static int[][] arr;
    static int max, maxCount;
    static int[] moveX = {0,-1,0,1}, moveY={-1,0,1,0};
    static int T, N;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("E:\\SSAFY9\\intelliJ_workspace\\algorithm_java\\src\\SWEA\\D4\\P1861\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(bf.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(bf.readLine());
            arr = new int[N][N];
            visited = new int[N][N];
            maxCount = 0;
            max = 100;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            bfs();
            System.out.println("#"+test_case+" "+max+" "+(maxCount+1));

        }
    }

    public static void bfs(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                PriorityQueue<int[]> pq = new PriorityQueue<>();
                int count = visited[i][j];
                pq.add(new int[] {i,j});
                Stack<int[]> stk = new Stack<>();
                while(!pq.isEmpty()){
                    int[] cur = pq.poll();
                    stk.push(cur);
                    if(visited[cur[0]][cur[1]]!=0){
                        count = visited[cur[0]][cur[1]];
                    }else {
                        for (int k = 0; k < 4; k++) {
                            int nextX = cur[0] + moveX[k];
                            int nextY = cur[1] + moveY[k];
                            if (check(nextX, nextY) && arr[cur[0]][cur[1]]==arr[nextX][nextY]-1) {
                                pq.add(new int[]{nextX, nextY});
                                break;
                            }
                        }
                    }
                }
                if(!stk.isEmpty()){
                    stk.pop();
                }
                int size = stk.size();
                for (int k = 0; k < size; k++) {
                    int[] cur = stk.pop();
                    visited[cur[0]][cur[1]] = ++count;
                }
                if(visited[i][j]>maxCount){
                    max = arr[i][j];
                    maxCount = visited[i][j];
                }else if(visited[i][j]==maxCount && arr[i][j]<max){
                    max = arr[i][j];
                }
            }
        }
    }
    public static boolean check(int x, int y){
        if(x<N && x>=0 && y<N && y>=0){
            return true;
        }
        return false;
    }
}
