package BOJ.BinarySearch.P20182;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main2 {
    static int N,M,A,B,C, result;
    static ArrayList<node>[] arr;
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("C:\\Users\\송수현\\IdeaProjects\\algorithm_java\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N+1];
        result = Integer.MAX_VALUE;

        for (int i = 0; i < N+1; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a].add(new node(b, c));
            arr[b].add(new node(a, c));
        }

        int start = 1;
        int end = 21;
        while(start <= end){
            int mid = (start + end)/2;
            if(dijkstra(mid)){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        System.out.println(start==22?-1:start);

    }

    public static boolean dijkstra(int maxShame){
        int[] dist = new int[N+1];
        Arrays.fill(dist, 10000001);
        boolean[] visited= new boolean[N+1];
        PriorityQueue<node> pq = new PriorityQueue<>();
        pq.add(new node(A, 0));
        visited[A] = true;

        while(!pq.isEmpty()){
            node cur = pq.poll();
            if(cur.to == B){
                return true;
            }
            for(node next : arr[cur.to]){
                if(next.length <= maxShame && cur.length + next.length <= C && dist[next.to] > cur.length + next.length && !visited[next.to]){
                    visited[cur.to] = true;
                    dist[next.to] = cur.length + next.length;
                    pq.add(new node(next.to, cur.length+next.length));
                }
            }
        }
        return false;
    }
}
class node implements Comparable<node>{
    int to;
    int length;

    public node(int to, int length) {
        this.to = to;
        this.length = length;
    }


    @Override
    public int compareTo(node o) {
        return this.length - o.length;
    }
}