package BOJ.Graph.UnionFind.P1043;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int arr[];
    static int parent[];
    static boolean knows[];
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        knows = new boolean[N+1];
        parent = new int[N+1];
        for (int i = 0; i < N+1; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(bf.readLine());
        int knowMemNum = Integer.parseInt(st.nextToken());

        for (int i = 0; i < knowMemNum; i++) {
            knows[Integer.parseInt(st.nextToken())] = true;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int count = Integer.parseInt(st.nextToken());
            int std = Integer.parseInt(st.nextToken());
            arr[i] = std;
            for (int j = 0; j < count-1; j++) {
                int cur = Integer.parseInt(st.nextToken());
                union(std, cur);
            }
        }
        int result = 0;
        for (int i = 0; i < M; i++) {
            if(!knows[find(arr[i])]){
                result++;
            }
        }

        System.out.println(result);

    }

    static void union(int i, int j){
        i = find(i);
        j = find(j);
        parent[Math.min(i,j)] = Math.max(i,j);
        knows[i] = knows[i] || knows[j];
        knows[j] = knows[i] || knows[j];
    }

    static int find(int i){
        if(parent[i]==i){
            return i;
        }
        return parent[i] = find(parent[i]);
    }

}
