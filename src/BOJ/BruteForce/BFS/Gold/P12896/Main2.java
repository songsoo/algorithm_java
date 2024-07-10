package BOJ.BruteForce.BFS.Gold.P12896;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
    static int N;
    static ArrayList<Integer> arr[];
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        // 시작점 구하기
        int first = bfs(1)[0];
        int second = bfs(first)[0];
        int[] last = bfs(second);
        System.out.println(last[1]/2 + ((last[1]%2==0)?0:1));
    }
    public static int[] bfs(int start){

        boolean[] visited = new boolean[N+1];

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start,0));
        visited[start] = true;
        Node last = new Node(start, 0);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            last.to = cur.to;
            last.length = cur.length;
            for(int next : arr[cur.to]){
                if(!visited[next]){
                    visited[next] = true;
                    queue.add(new Node(next,cur.length+1));
                }
            }
        }
        return new int[]{last.to, last.length};
    }
    
}
class Node{
    int to;
    int length;

    public Node(int to, int length) {
        this.to = to;
        this.length = length;
    }
}