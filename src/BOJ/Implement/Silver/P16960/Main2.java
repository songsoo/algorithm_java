package BOJ.Implement.Silver.P16960;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] arr = new ArrayList[N+1];
        int[] visited = new int[M+1];
        int count = 0;

        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList();
            st = new StringTokenizer(bf.readLine());
            int lamps = Integer.parseInt(st.nextToken());
            for (int j = 0; j < lamps; j++) {
                int cur = Integer.parseInt(st.nextToken());
                visited[cur]++;
                arr[i].add(cur);
            }
        }
        boolean flag = false;
        loop:
        for (int i = 1; i <= N; i++) {
            for(int cur : arr[i]){
                if(visited[cur]-1 <= 0){
                    continue loop;
                }
            }
            flag = true;
            break;
        }

        System.out.println(flag?1:0);

    }
}
