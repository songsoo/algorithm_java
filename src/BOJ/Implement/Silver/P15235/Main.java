package BOJ.Implement.Silver.P15235;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int[] fed = new int[N];
        int[] need = new int[N];
        int[] finished = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int total = 0;
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            need[i] = cur;
            total += cur;
        }

        int idx = 0;
        while(idx < total){
            for (int i = 0; i < N; i++) {
                if(fed[i] < need[i]){
                    fed[i]++;
                    idx++;
                    if(fed[i] == need[i]){
                        finished[i] = idx;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(finished[i]+" ");
        }

    }
}
