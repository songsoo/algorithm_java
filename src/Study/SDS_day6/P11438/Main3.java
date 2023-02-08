package Study.SDS_day6.P11438;


//LCA, Lowest Common Ancestor 최소 공통 조상
//두 노드의 가장 가까운 공통 조상을 구하라

// 1.depth를 맞추기 (서로의 depth 차이를 이진수로 만들어 각 진수에 맞게 건너가기)
// 2.가장 위의 정점을 확인 후, 계속 내려오다가(이진수로(2^k -> 2^(k-1) -> ... 1)) 서로 다른게 나오면 거기서부터 다시 내려가기 이어감
// depthbase는 0, k는 log2(N)+1 --> log(N)/log(2)

// 트리를 BFS,DFS를 통해 만들어야 한다.
// 여기선 DFS를 사용할 경우 재귀함수의 반복 사용으로
// stack overflow가 날 수 있으니 BFS를 사용한다.

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main3 {


    static int parent[][];
    //static int oneParent[];
    static int depth[];

    public static void main(String[] args) throws Exception{

        boolean vst[];
        int N,M,depthMax,k;

        System.setIn(new FileInputStream("src/SDS.SDS_day6/P11438/Input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(bf.readLine());

        ArrayList<Integer>[] adj = new ArrayList[N+1];

        for(int i=1;i<N;i++){
            adj[i] = new ArrayList<>();
        }

        //oneParent = new int[N+1];

        depth = new int[N+1];
        vst = new boolean[N+1];
        depth[1] = 0;
        //depthMax = 0;
        k=18;
        parent = new int[k][N+1];
        int up,down;

        for (int i = 0; i < N-1; i++) {

            st = new StringTokenizer(bf.readLine()," ");

            up = Integer.parseInt(st.nextToken());
            down = Integer.parseInt(st.nextToken());

            adj[up].add(down);
            adj[down].add(up);

        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        vst[1] = true;

        while(!queue.isEmpty()){
            int cur = queue.poll();

            for(int i=0;i<adj[cur].size();i++){
                int next = adj[cur].get(i);

                if(vst[next]){
                    continue;
                }
                    vst[next] = true;
                    //oneParent[next] = cur;
                    parent[0][next] = cur;
                    queue.add(next);
                    depth[next] = depth[cur]+1;
                    //if(depthMax<depth[next]){
                        //depthMax = depth[next];
                    //}


            }
        }


        //k = (int) (Math.log10(depthMax)/ Math.log10(2))+1;

        //parent = new int[k][N+1];
        //parent[0] = oneParent;

        for(int i=1;i<k;i++){
            for(int j=0;j<N+1;j++){
                parent[i][j] = parent[i-1][parent[i-1][j]];
            }
        }


        M = Integer.parseInt(bf.readLine());
        int a,b;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine()," ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            System.out.println(getLCS(a,b));
        }




    }
    static int getLCS(int a, int b) {
        if(depth[a] > depth[b]) {
            int tmp = b;
            b = a;
            a = tmp;
        }
        int gap = depth[b] - depth[a];
        //gap 2진수만큼 위로 올리기
        for(int i = 0; i < 18; i++) {
            if((gap & (1 << i)) > 0) {
                b = parent[i][b];
            }
        }
        //올려서 똑같으면 리턴
        if(a == b) {
            return a;
        }
        //위부터 아래로 내려오면서 마지막으로 같은 숫자 확인 (분기점)
        for(int i = 17; i >= 0; i--) {
            //다른 숫자 만나면 그 곳을 기준으로 위에서부터 다시 보기
            if(parent[i][a] != parent[i][b]) {
                a = parent[i][a];
                b = parent[i][b];
            }
        }
        return parent[0][a];
    }



}
