package SWEA.D4.P7465;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int T, N, M;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\SSAFY\\IdeaProjects\\algorithm_java\\src\\SWEA\\D4\\P7465\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            parent = new int[N+1];
            for (int j = 0; j < N+1; j++) {
                parent[j] = j;
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                union(x,y);
            }
            Set<Integer> set = new HashSet<>();

            for (int i = 1; i < N+1; i++) {
                set.add(find(i));
            }
            System.out.println("#"+test_case+" "+set.size());

        }

    }
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x!=y){
            parent[Math.max(x,y)] = Math.min(x,y);
        }
    }
    public static int find(int x) {
        if(x == parent[x]){
            return x;
        }else{
            return parent[x] = find(parent[x]);
        }
    }
}
