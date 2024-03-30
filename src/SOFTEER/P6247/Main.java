package SOFTEER.P6247;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arr = new ArrayList();
        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<n; i++){
            arr.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(arr);
        HashMap<Integer, Integer> hash = new HashMap();
        StringBuilder sb = new StringBuilder();
        hash.put(arr.get(0), 0);
        hash.put(arr.get(n-1), 0);
        for(int i=1; i<n-1; i++){
            hash.put(arr.get(i), (i)*(n-1-i));
        }
        for(int i=0; i<q; i++){
            int median = Integer.parseInt(bf.readLine());
            if(hash.containsKey(median)){
                sb.append(hash.get(median)).append("\n");
            }else{
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
