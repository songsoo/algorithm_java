package BOJ.Graph.UnionFind.P1717;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] parent;
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("E:\\SSAFY9\\intelliJ_workspace\\algorithm_java\\src\\BOJ\\Graph\\UnionFind\\P1717\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  =new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent  = new int[N+1];

        for (int i = 0; i < N+1; i++) {
            parent[i] = i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());

            int op = Integer.parseInt(st.nextToken());
            int a1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());

            if(op==1){
                sb.append(find(a1)==find(a2)?"YES\n":"NO\n");
            }else{
                union(a1,a2);
            }

        }
        System.out.println(sb.toString());

    }

    public static int find(int i){
        if(i==parent[i]){
            return i;
        }else{
            return parent[i] = find(parent[i]);
        }
    }
    public static void union(int i, int j){
        i = find(i);
        j = find(j);
        if(i==j){
            return;
        }
        if(i<j){
            parent[j]=i;
        }else{
            parent[i]=j;
        }
    }

}
