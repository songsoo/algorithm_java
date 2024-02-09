package BOJ.BruteForce.DFS.Gold.P1967;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P1967 {
    static int N, max;
    static node[] nodes;
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("E:\\ssafy\\intelliJWorkSpace\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        nodes = new node[N+1];
        max = 0;
        for (int i = 0; i <= N; i++) {
            nodes[i] = new node(i);
        }
        for (int i = 1; i < N ; i++) {

            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            nodes[a].addChild(nodes[b]);
            nodes[b].setValue(value);

        }
        dfs(1);
        System.out.println(max);

    }
    public static int dfs(int index){

        node cur = nodes[index];
        int sum = 0;
        ArrayList<Integer> lengths = new ArrayList<>();
        lengths.add(0);
        for(node child : cur.childs){
            int length = dfs(child.index);
            lengths.add(length);
        }
        Collections.sort(lengths,Collections.reverseOrder());
        for (int i = 0; i < lengths.size(); i++) {
            sum += lengths.get(i);
            if(i==1) break;
        }
        max = Math.max(max,sum);
        return cur.value+lengths.get(0);
    }
    public static class node implements Comparable<node>{
        int index;
        int value;
        ArrayList<node> childs = new ArrayList<>();
        node(int index){
            this.index = index;
        }
        public void setValue(int value){
            this.value = value;
        }
        public void addChild(node child){
            childs.add(child);
        }

        @Override
        public int compareTo(node o) {
            return o.value - value;
        }
    }
}
