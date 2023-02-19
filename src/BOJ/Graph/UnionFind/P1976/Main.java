package BOJ.Graph.UnionFind.P1976;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] parent;
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("D:\\IntelliJ\\algorithm_java\\src\\BOJ\\Graph\\UnionFind\\P1976\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());

        parent = new int[N+1];

        for (int i = 1; i < N+1; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= N; j++) {
                int cur = Integer.parseInt(st.nextToken());
                if(cur==1){
                    if(parent[i]!=j && parent[j]!=i){
                        union(i,j);
                    }
                }
            }
        }

        // 여기서 문제 발생
        // find가 아닌 parent를 사용했음..
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int tot = find(Integer.parseInt(st.nextToken()));
        for (int i = 1; i < M; i++) {
            if(tot != find(Integer.parseInt(st.nextToken()))){
                System.out.println("NO");
                System.exit(0);
            }
        }
        System.out.println("YES");

    }

    public static int find(int x){
        if(x==parent[x]){
            return x;
        }else{
            return parent[x] = find(parent[x]);
        }
    }

    public static void union(int x, int y){
        x = parent[x];
        y = parent[y];
        if(x==y){
            return;
        }else{
            parent[Math.max(x,y)] = Math.min(x,y);
        }
    }
}
