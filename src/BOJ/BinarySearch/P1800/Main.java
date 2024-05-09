package BOJ.BinarySearch.P1800;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, P, K;
    static ArrayList<edge>[] map;

    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("D:\\IntelliJ_Repository\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int maxLength = 0;

        map = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(bf.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            maxLength = Math.max(maxLength, length);
            map[node1].add(new edge(node2, length, 0));
            map[node2].add(new edge(node1, length, 0));
        }
        int max = maxLength;
        int minLength = 0;
        while(true){
            if(minLength>=maxLength){
                break;
            }
            int mid = (minLength + maxLength)/2;
            System.out.println(minLength+" "+maxLength+" "+mid);
            if(bfs(mid)){
                maxLength = mid;
            }else{
                minLength = mid+1;
            }
        }
        System.out.println(minLength>max?"-1":minLength);

    }

    public static boolean bfs(int mid){

        Queue<edge> queue = new LinkedList<>();
        queue.add(new edge(N, 0, 0));
        int[] visited = new int[N+1];
        Arrays.fill(visited, K+1);

        while(!queue.isEmpty()){

            edge cur = queue.poll();
            if(cur.to == 1){
                return true;
            }
            if(cur.cnt > visited[cur.to]){
                continue;
            }
            for(edge next : map[cur.to]){
                // 기준치보다 길이가 짧으면
                if(next.length<=mid && visited[next.to]>cur.cnt){
                    visited[next.to] = cur.cnt;
                    queue.add(new edge(next.to, next.length, cur.cnt));
                }
                // 기준치보다 길이가 길면
                else{
                    // 공짜 길이로 체크
                    if(cur.cnt<K && visited[next.to]>(cur.cnt+1)){
                        visited[next.to] = cur.cnt+1;
                        queue.add(new edge(next.to, next.length, cur.cnt+1));
                    }
                }
            }
        }
        return false;
    }
}
class edge{

    int to;
    int length;
    int cnt = 0;

    public edge(int to, int length, int cnt) {
        this.to = to;
        this.length = length;
        this.cnt = cnt;
    }
}