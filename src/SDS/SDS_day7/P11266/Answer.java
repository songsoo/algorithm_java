package SDS.SDS_day7.P11266;

import java.io.*;
import java.util.*;



public class Answer {
    static int order[];
    static boolean isCut[];
    static int cnt;
    static ArrayList<Integer> adj[];
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/SDS.SDS_day7/P11266/Input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        order = new int[N+1];
        isCut = new boolean[N+1];
        adj = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<Integer>();
        }

        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
        System.out.println("Now you are at: ");
        for(int i = 1; i <= N; i++) {
            System.out.println("Now you are at: " + i);
            // Root만 순회한다.
            if(order[i] == 0) {
                System.out.println(i+" GOGO!");
                dfs(i, true);
            }
        }
        int ans = 0;
        for(int i = 1; i <= N; i++) {
            ans += isCut[i] ? 1 : 0;
        }
        sb.append(ans + "\n");
        for(int i = 1; i <= N; i++) {
            if(isCut[i]) {
                sb.append(i + " ");
            }
        }
        System.out.println(sb);
    }

    // root인지 아닌지에 대해 전달받음, 연결 그래프가 아니라 섬처럼 여러개가 둥실 떠다닐 땐 root가 여러개 있을 수도 있다.
    private static int dfs(int cur, boolean isRoot) {
        //입력받는 순서대로 order에 cnt만큼 숫자 입력
        order[cur] = ++cnt;
        //리턴값에 우선 현재 순번을 입력
        int ret = cnt;
        int child = 0;
        System.out.println("dfs "+cur);
        //연결된 노드를 순회하면서
        for(int next : adj[cur]) {
            //아직 안가본 노드에 대해
            System.out.println("("+order[cur]+")"+"["+cur+"]"+"["+next+"]"+"adj "+next);
                if(order[next] == 0) {
                    //child 노드 숫자 증가 (root의 경우 사용하기 위함)
                    // Root-A-B-Root로 연결되어있을 경우엔 child가 둘인 것 처럼 보이나, A에서 dfs를 통해 B를 들어가기 때문에
                    // B는 자식노드가 아닌 것으로 나타남
                    child++;
                    System.out.println("("+order[cur]+")"+"["+cur+"]"+"["+next+"]"+"Not yet checked vertex ");
                    //자신보다 order가 낮은 노드를 순회하면서 지금까지 거치지 않았던 루트로 갈 수 있는 최저 값을 구함
                    int low = dfs(next, false);
                    System.out.println("("+order[cur]+")"+"["+cur+"]"+"["+next+"]"+"low is  "+low);
                    //Root도 아니고 low가 현재
                    if(!isRoot && low >= order[cur]) {
                        System.out.println("("+order[cur]+")"+"["+cur+"]"+"["+next+"]"+"low is  "+low);
                        isCut[cur] = true;
                    }
                    ret = Math.min(ret, low);
            }
            // 이미 거쳐갔던 노드라면 그곳에서 추가적으로 순회하지는 않고 해당 정점과
            else {
                System.out.println("("+order[cur]+")"+"["+cur+"]"+"["+next+"]"+"Already checked vertex  "+ret+" "+order[next]);
                ret = Math.min(ret, order[next]);
            }
        }
        if(isRoot && child > 1) {
            isCut[cur] = true;
        }
        return ret;
    }
}