package BOJ.Greedy.Gold.P3109;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C, result, resultMax;
    static char[][] map;
    static boolean[][] visited;
    static int[] moveX = {-1, 0 , 1}, moveY= {1, 1, 1};
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("C:\\Users\\송수현\\IdeaProjects\\algorithm_java\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        result = 0;
        resultMax = 0;
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = bf.readLine().toCharArray();
        }
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            goNext(i,0);
        }

        System.out.println(result);
    }
    public static boolean goNext(int x, int y){
        if(y==C-1){
            result++;
            return true;
        }
        for (int i = 0; i < 3; i++) {
            int nextX = x+moveX[i];
            int nextY = y+moveY[i];
            if(check(nextX, nextY) && !visited[nextX][nextY] && map[nextX][nextY]!='x'){
                visited[nextX][nextY] = true;
                if(goNext(nextX,nextY)){
                    return true;
                }
                visited[nextX][nextY] = false;
            }
        }
        map[x][y] = 'x';
        return false;
    }
    public static boolean check(int x, int y){
        return x>=0 && x<R && y>=0 && y<C;
    }
}
