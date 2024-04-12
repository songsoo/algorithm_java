package BOJ.Implement.Silver.P11728;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        ArrayList<Integer> arr = new ArrayList<>();


        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < m; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arr);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n+m; i++) {
            sb.append(arr.get(i)+" ");
        }
        System.out.println(sb.toString());


    }
}
