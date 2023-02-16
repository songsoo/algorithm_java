package BOJ.Graph.MST.PRIM.G4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 이 문제에서 정점의 개수는 10000개, 간선의 개수는 100000개로 정점의 개수가 더 적기 떄문에
// 프림 알고리즘을 사용해보기로 했다.
public class P1197 {
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("E:\\SSAFY9\\intelliJ_workspace\\algorithm_java\\src\\BOJ\\Graph\\MST\\PRIM\\G4\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());


        int N = Integer.parseInt(st.nextToken())+1;
        int M = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[N];
        int total = 0;
        ArrayList<edge>[] graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            graph[from].add(new edge(to, value));
            graph[to].add(new edge(from, value));
        }

        PriorityQueue<edge> pq = new PriorityQueue<>();
        pq.add(new edge(1,0));
        int numOfEdges=0;
        while(!pq.isEmpty()&&numOfEdges!=N-1){
            edge curEdge = pq.poll();

            if(visited[curEdge.from]) continue;
            visited[curEdge.from] = true;
            for(edge edg : graph[curEdge.from]){
                pq.add(edg);
            }
            total += curEdge.value;
            numOfEdges++;
        }

        System.out.println(total);

    }
}
class edge implements Comparable<edge>{
    int from;
    int value;
    edge(int from, int value){
        this.from = from;
        this.value = value;
    }

    @Override
    public int compareTo(edge o) {
        return this.value-o.value;
    }
}
