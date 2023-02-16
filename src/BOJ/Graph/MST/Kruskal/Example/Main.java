package BOJ.Graph.MST.Kruskal.Example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static int V,E;
    static int[][] graphs;
    static int[] parent;

    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("E:\\SSAFY9\\intelliJ_workspace\\algorithm_java\\src\\BOJ\\Graph\\MST\\Kruskal\\Example\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        V = Integer.parseInt(bf.readLine());
        E = Integer.parseInt(bf.readLine());


        graphs = new int[E][3];
        parent = new int[V+1];

        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            graphs[i][0] = Integer.parseInt(st.nextToken());
            graphs[i][1] = Integer.parseInt(st.nextToken());
            graphs[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(graphs,(o1,o2)->o1[2]-o2[2]);

        int total = 0;

        for (int i = 0; i < graphs.length; i++) {
            int from = graphs[i][0];
            int to = graphs[i][1];
            int value = graphs[i][2];

            //사이클이 안생길 때
            if(find(from)!=find(to)){
                union(from,to);
                total += value;
            }

        }
        System.out.println(total);

    }

    public static int find(int i){
        if(i==parent[i]){
            return i;
        }else{
            return parent[i] = find(parent[i]);
        }
    }
    public static void union(int i, int j){
        i = parent[i];
        j = parent[j];
        if(i<j){
            parent[j] = i;
        }else{
            parent[i] = j;
        }

    }

}
