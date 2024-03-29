package BOJ.BruteForce.BFS.Gold.P2636;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {
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
            melt3();
            if(ans==0){
                break;
            }
            count++;
        }
        System.out.println(count+"\n"+prevAns);
    }
    public static int bfs(){
        copiedArr = new int[r][c];
        for (int i = 0; i < r; i++) {
            copiedArr[i] = Arrays.copyOf(arr[i],c);
        }
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
                    if(copiedArr[nr][nc]==1){
                        count++;
                        copiedArr[nr][nc]=3;
                    }else {
                        copiedArr[nr][nc]=2;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
        }
        return count;
    }

    public static void melt3(){
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(copiedArr[i][j]==3 &&copiedArr[i][j]==2  ){
                    copiedArr[i][j]=0;
                }
            }
        }
        for (int i = 0; i < r; i++) {
            arr[i] = Arrays.copyOf(copiedArr[i],c);
        }
    }


}
