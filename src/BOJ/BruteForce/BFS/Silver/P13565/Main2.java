package BOJ.BruteForce.BFS.Silver.P13565;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
    static int N,M;
    static char arr[][];
    static boolean visited[][];
    static int[] moveX={0,1,0,-1}, moveY={1,0,-1,0};
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String cur = bf.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = cur.charAt(j);
            }
        }

        boolean flag = false;
        for (int i = 0; i < M; i++) {
            if(bfs(i)){
                flag = true;
                break;
            }
        }
        System.out.println(flag?"YES":"NO");

    }

    public static boolean bfs(int index){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,index});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if(cur[0] == N-1){
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int nextX = cur[0] + moveX[i];
                int nextY = cur[1] + moveY[i];
                if(check(nextX, nextY) && !visited[nextX][nextY]){
                    queue.add(new int[] {nextX, nextY});
                    visited[nextX][nextY] = true;
                }
            }
        }
        return false;
    }

    public static boolean check(int x, int y){
        if(x>=0 && x< N && y>=0 && y<M && arr[x][y]=='0'){
            return true;
        }
        return false;
    }

}
