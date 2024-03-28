package BOJ.Implement.Silver.P18311;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        long cur = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        boolean found = false;
        arr.add(0);
        for (int i = 1; i < N+1; i++) {
            int curDist = Integer.parseInt(st.nextToken());
            cur += curDist;
            arr.add(curDist);
            if(cur > K){
                found = true;
                System.out.println(i);
                break;
            }
        }
        if(!found){
            for (int i = N; i >= 1; i--) {
                cur += arr.get(i);
                if(cur > K){
                    found = true;
                    System.out.println(i);
                    break;
                }
            }
        }

    }
}
