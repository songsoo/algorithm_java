package BOJ.Sorting.binarySearch.Silver.P18870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P18870 {
    static int N;
    static Integer[] first,second;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        first = new Integer[N];
        second = new Integer[N];
        for (int i = 0; i < N; i++) {
            int go = (Integer.parseInt(st.nextToken()));
            first[i] = go;
            second[i] = go;
        }
        StringBuilder sb = new StringBuilder();

        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        Arrays.sort(second);
        int count = 0;
        for (int i = 0; i < N; i++) {
            if(!map.containsKey(second[i])){
                map.put(second[i],count++);
            }

        }
        for (int i = 0; i < N; i++) {
            sb.append(map.get(first[i])).append(" ");
        }
        System.out.println(sb.toString());

    }
}
