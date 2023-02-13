package BOJ.G4.P1987;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R,C,max;
    static char[][] arr;
    static boolean[] visited;
    static int[] moveX={-1,0,1,0},moveY={0,-1,0,1};
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("E:\\SSAFY9\\intelliJ_workspace\\algorithm_java\\src\\BOJ\\G4\\P1987\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        max = 0;
        arr =new char[R][C];
        visited = new boolean[26];

        for (int i = 0; i < R; i++) {
            String str= bf.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j]=str.charAt(j);
            }
        }

        visited[arr[0][0]-'A'] = true;
        dfs(0,0,1);
        System.out.println(max);
    }
    public static void dfs(int x, int y, int cnt){

        max = Math.max(max,cnt);

        for (int i = 0; i < 4; i++) {
            int newX = x+moveX[i];
            int newY = y+moveY[i];
            if(newX>=0 && newX<R && newY>=0 && newY<C && !visited[arr[newX][newY]-'A']){
                visited[arr[newX][newY]-'A']=true;
                dfs(newX,newY,cnt+1);
                visited[arr[newX][newY]-'A']=false;

            }

        }

    }
}
