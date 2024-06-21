package BOJ.Implement.Silver.P18110;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main2 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(bf.readLine()));
        }

        Collections.sort(arr);

        int cut = (int)Math.round((double)N*15/100);
        int sum = 0;
        for (int i = cut; i < N-cut; i++) {
            sum += arr.get(i);
        }
        System.out.println(Math.round((double)sum/(N-2*cut)));
    }
}
