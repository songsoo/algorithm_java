package BOJ.Implement.G4.P17406;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr,rotLoc;
    static int N,M,R,cur,next;
    static int[] moveX= {0,1,0,-1}, moveY= {1,0,-1,0}, perm;
    static ArrayList<int[]> perms;
    static boolean[] visited;


    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algorithm_java\\src\\BOJ\\Implement\\G4\\P17406\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        perms = new ArrayList<>();
        visited = new boolean[R];
        perm = new int[R];
        dfs(0);
        int min = Integer.MAX_VALUE;

        rotLoc = new int[R][3];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(bf.readLine());
            rotLoc[i][0] = Integer.parseInt(st.nextToken());
            rotLoc[i][1] = Integer.parseInt(st.nextToken());
            rotLoc[i][2] = Integer.parseInt(st.nextToken());
        }

        for(int[] a:perms){

            int[][] copiedArr = new int[N][M];

            for (int i = 0; i < N; i++) {
                copiedArr[i] = Arrays.copyOf(arr[i],M);
            }

            rotateArr(a, copiedArr);

            for (int i = 0; i < N; i++) {
                int result=0;
                for (int j = 0; j < M; j++) {
                    result+=copiedArr[i][j];
                }
                min = Math.min(min,result);
            }

        }

        System.out.println(min);

    }

    public static void rotateArr(int[] a, int[][] copiedArr){
        for (int k = 0; k < R; k++) {
            int numOfLayer = rotLoc[a[k]][2];

            for (int j = 0; j < numOfLayer; j++) {

                int n  = 8 * (rotLoc[a[k]][2]-j);
                int startX = rotLoc[a[k]][0]-rotLoc[a[k]][2]-1+j;
                int startY = rotLoc[a[k]][1]-rotLoc[a[k]][2]-1+j;
                int endX = rotLoc[a[k]][0]+rotLoc[a[k]][2]-1-j;
                int endY = rotLoc[a[k]][1]+rotLoc[a[k]][2]-1-j;

                goOneLayer(startX,startY,endX+1,endY+1, n, copiedArr);

            }
        }
    }

    public static void goOneLayer(int x, int y,int N , int M, int count, int[][] copiedArr){

        int startX = x;
        int startY = y;
        int ver = 0;
        int nextX = x + moveX[ver];
        int nextY = y + moveY[ver];

        cur = copiedArr[x][y];
        for (int i = 0; i < count; i++) {
            next = copiedArr[nextX][nextY];
            copiedArr[nextX][nextY] = cur;
            cur = next;

            x = nextX;
            y = nextY;

            nextX = x + moveX[ver];
            nextY = y + moveY[ver];

            if (nextX >= N || nextX < startX || nextY >= M || nextY < startY) {
                ver = (ver + 1) % 4;
                nextX = x + moveX[ver];
                nextY = y + moveY[ver];
            }
        }
    }

    public static void dfs(int cnt){
        if(cnt==R){
           perms.add(Arrays.copyOf(perm,R));
           return;
        }

        for (int i = 0; i < R; i++) {
            if(visited[i])continue;
            perm[cnt] = i;

            visited[i] = true;
            dfs(cnt+1);
            visited[i] = false;
        }
    }



}