package BOJ.BruteForce.BFS.Gold.P2636;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int r,c;
    static int[][] arr,copiedArr;
    static boolean[][] visited;
    static int[] dr={-1,0,1,0}, dc={0,-1,0,1};
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("E:\\SSAFY9\\intelliJ_workspace\\algorithm_java\\src\\BOJ\\BruteForce\\BFS\\G4\\P2636\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < c; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count=0;
        int prevAns=0;
        int ans=0;
        while(true){
            prevAns = ans;
            ans = bfs();
            if(ans==0){
                break;
            }
            count++;
        }
        System.out.println(count+"\n"+prevAns);
    }
    public static int bfs(){

        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[r][c];
        visited[0][0]=true;
        queue.add(new int[]{0,0});
        int count = 0;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cur[0]+dr[i];
                int nc = cur[1]+dc[i];
                if(nr>=0&&nr<r &&nc>=0&&nc<c&&!visited[nr][nc]){
                    visited[nr][nc]=true;
                    if(arr[nr][nc]==1){
                        count++;
                        arr[nr][nc]=0;
                    }else {
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
        }
        return count;
    }
}
