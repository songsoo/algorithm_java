package BOJ.BruteForce.BackTracking.S2.P2961;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, min;
    static boolean[] visited;
    static int[] sour, bitter;
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("D:\\IntelliJ\\algorithm_java\\src\\BOJ\\S2\\P2961\\input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        visited = new boolean[N];
        sour = new int[N];
        bitter = new int[N];
        min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            sour[i] = Integer.parseInt(st.nextToken());
            bitter[i] = Integer.parseInt(st.nextToken());
        }

        powerSet(0,1);
        System.out.println(Math.abs(min));
    }
    public static void powerSet(int idx,int cnt){
        if(idx==N){
            return;
        }
        //단만과 쓴맛의 차이를 구함
        int sourTot = 1;
        int bitterTot = 0;
        visited[idx] = true;
        for (int i = 0; i < N; i++) {
            if(visited[i]){
                sourTot *= sour[i];
                bitterTot += bitter[i];
            }
        }
        //System.out.println(Arrays.toString(visited));
        min = Math.min(min,Math.abs(sourTot-bitterTot));
        System.out.println(Math.abs(sourTot-bitterTot));

        //현재를 포함하는 경우 재귀
        powerSet(idx+1,cnt+1);
        visited[idx] = false;
        //현재를 포함하지 않는 경우 재귀
        powerSet(idx+1,cnt);
    }
}
