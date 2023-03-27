package Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class P13905 {
    static int N,M,S,E, min;
    static ArrayList<ArrayList<edge>> root;
    static boolean visited[];
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("C:\\Users\\SSAFY\\IdeaProjects\\algorithm_java\\src\\Test\\Input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());

        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;

        root = new ArrayList();
        visited = new boolean[N+1];
        for (int i = 0; i < N+1; i++) {
            root.add(new ArrayList<edge>());
        }

        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(bf.readLine());
            int h1 = Integer.parseInt(st.nextToken());
            int h2 = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            root.get(h1).add(new edge(h2, k));
            root.get(h2).add(new edge(h1, k));
        }

        PriorityQueue<edge> queue = new PriorityQueue<edge>();
        queue.add(new edge(S,Integer.MAX_VALUE));
        visited[S] = true;
        while(!queue.isEmpty()){
            edge cur = queue.poll();
            visited[cur.to] = true;
            min = Math.min(min, cur.value);
            if(cur.to == E){
                break;
            }
            for(edge next : root.get(cur.to)){
                if(!visited[next.to]){
                    queue.add(next);
                }
            }
        }
        if(!visited[E]){
            min = 0;
        }
        System.out.println(min);

    }
}
class edge implements Comparable<edge>{
    int to;
    int value;
    edge(int to, int value){
        this.to = to;
        this.value = value;
    }


    @Override
    public int compareTo(edge o) {
        return o.value - this.value;
    }
}