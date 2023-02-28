package BOJ.Graph.MST.Kruskal.G4.P1197;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1197 {
    static int[][] graph;
    static int[] parent;
    static int total;
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("E:\\SSAFY9\\intelliJ_workspace\\algorithm_java\\src\\BOJ\\Graph\\MST\\PRIM\\G4\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken())+1;
        int M = Integer.parseInt(st.nextToken());
        total = 0;
        parent = new int[N];
        graph = new int[M][3];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            graph[i][0] = from;
            graph[i][1] = to;
            graph[i][2] = value;
        }

        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        Arrays.sort(graph,(o1,o2)->o1[2]-o2[2]);

        for (int i = 0; i < M; i++) {
            if(union(graph[i][0],graph[i][1])){
                total+=graph[i][2];
            }
        }

        System.out.println(total);

    }

    public static int find(int x){
        if(x==parent[x]){
            return x;
        }else{
            return parent[x] = find(parent[x]);
        }
    }

    public static boolean union(int x, int y){
        x = find(x);
        y = find(y);
        if(x != y){
            parent[Math.max(x,y)]=Math.min(x,y);
            return true;
        }
        return false;
    }
}
