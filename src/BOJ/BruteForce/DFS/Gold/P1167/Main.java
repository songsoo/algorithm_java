package BOJ.BruteForce.DFS.Gold.P1167;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int V;
    static ArrayList<node>[] map;
    static int max;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(bf.readLine());
        map = new ArrayList[V+1];
        visited= new boolean[V+1];
        max = 0;
        int start = -1;
        for (int i = 1; i <= V; i++) {
            map[i] = new ArrayList();
        }

        for (int i = 1; i <= V; i++) {

            StringTokenizer st = new StringTokenizer(bf.readLine());
            int cur = Integer.parseInt(st.nextToken());
            if(start == -1 && st.countTokens()==3){
                start = cur;
            }
            while(true){
                int idx = Integer.parseInt(st.nextToken());
                if(idx==-1){
                    break;
                }
                int length = Integer.parseInt(st.nextToken());
                map[cur].add(new node(idx, length));
            }
        }
        getDist(start);
        System.out.println(max);
    }

    public static int getDist(int i){

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        visited[i] = true;
        int first = 0;
        int second = 0;
        for (int j = 0; j < map[i].size(); j++) {
            node cur = map[i].get(j);
            if(visited[cur.index])continue;
            int gotLength = cur.length+getDist(cur.index);
            pq.add(gotLength);
        }

        if(!pq.isEmpty()){
            int cur = pq.poll();
            first = cur;
        }
        if(!pq.isEmpty()){
            int cur = pq.poll();
            second = cur;
        }
        max = Math.max(max, first + second);
        return first;
    }

}
class node{
    int index;
    int length;
    node(int index, int length){
        this.index = index;
        this.length = length;
    }
}