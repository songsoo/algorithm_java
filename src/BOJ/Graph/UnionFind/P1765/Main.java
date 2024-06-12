package BOJ.Graph.UnionFind.P1765;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, result;
    static int parent[];
    static boolean isEnemy[][];
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("D:\\IntelliJ_Repository\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());

        parent = new int[N+1];
        isEnemy = new boolean[N+1][N+1];
        result = 0;
        for (int i = 0; i < N+1; i++) {
            parent[i] = i;
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            char op = st.nextToken().charAt(0);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(op=='F'){
                union(a,b);
            }else{
                queue.add(new int[]{a,b});
            }
        }

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int a = cur[0];
            int b = cur[1];
            isEnemy[a][b] = true;
            isEnemy[b][a] = true;
            for (int i = 1; i < N+1; i++) {
                if(isEnemy[a][i]){
                    union(b, i);
                }
            }
            for (int i = 1; i < N+1; i++) {
                if(isEnemy[b][i]){
                    union(a, i);
                }
            }
        }
        for (int i = 1; i < N+1; i++) {
            if(parent[i]==i){
                result++;
            }
        }

        System.out.println(result);

    }

    public static int find(int x){
        if(x == parent[x]){
            return x;
        }else{
            return parent[x] = find(parent[x]);
        }
    }
    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x!=y){
            parent[Math.max(x,y)] = Math.min(x,y);
        }
    }
}
