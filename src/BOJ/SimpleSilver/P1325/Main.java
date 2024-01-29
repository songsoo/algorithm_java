package BOJ.SimpleSilver.P1325;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static LinkedList<Integer>[] arr;
    static boolean[] visited, tmpVisited;
    static int cycleNum = 0, cycleIndex = 0;
    static int[] count;
    static int max;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new LinkedList[N+1];
        max = 0;
        count = new int[N+1];
        visited = new boolean[N+1];

        for (int i = 0; i < N+1; i++) {
            arr[i] = new LinkedList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            arr[from].add(to);
        }

        for (int i = 1; i < N+1; i++) {
            if(!visited[i]){
                tmpVisited = new boolean[N+1];
                // 이전에 돌았는지 확인
                visited[i] = true;
                // cycle인지 확인
                tmpVisited[i] = true;
                dfs(i,0);
            }
        }

        System.out.println(Arrays.toString(count));

    }

    public static void dfs(int cur, int cnt){
        for(int next : arr[cur]){
            //cycle확인
            if(!tmpVisited[next]){
                visited[next] = true;
                tmpVisited[next] = true;
                dfs(next , cnt+1);
            }
        }
        count[cur] += cnt;
    }

}
class queueItem{
    int index;
    int count;

    public queueItem(int index, int count) {
        this.index = index;
        this.count = count;
    }
}