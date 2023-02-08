package Study.SDS_day1.P1260;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N,M,V;
    static List<Integer> list[];
    static Queue<Integer> queue;
    static List<Integer> result;
    static boolean[] check;

    public static void main(String[] args) throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        queue = new LinkedList<>();
        result = new ArrayList<>();
        check = new boolean[N+1];

        for (int i = 0; i < N+1; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);

        }

        for (int i = 0; i < N+1; i++) {
            Collections.sort(list[i]);
        }

        dfs(V);
        printResult();
        result = new ArrayList<>();
        check = new boolean[N+1];

        queue.add(V);
        while(!queue.isEmpty()){
            bfs(queue.poll());
        }
        printResult();
    }

    public static void dfs(int v){
        if(!check[v]){
            check[v] = true;
            result.add(v);
            for(int next : list[v]){
                dfs(next);
            }
        }
    }

    public static void bfs(int v){
        if(!check[v]){
            check[v] = true;
            result.add(v);
            for(int next:list[v]){
                queue.add(next);
            }
        }
    }

    public static void printResult(){
        for(int res : result){
            System.out.print(res+" ");
        }
        System.out.println();
    }
}
