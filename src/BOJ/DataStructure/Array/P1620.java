package BOJ.DataStructure.Array;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P1620 {
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\BOJ\\DataStructure\\Array\\input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<String> arr = new ArrayList<>();
        HashMap<String, Integer> hash = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String cur = bf.readLine();
            arr.add(cur);
            hash.put(cur,i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String cur = bf.readLine();
            if(cur.charAt(0)<='Z' && cur.charAt(0)>='A'){
                sb.append(hash.get(cur)+"\n");
            }else{
                sb.append(arr.get(Integer.parseInt(cur)-1)+"\n");
            }
        }
        System.out.println(sb.toString());

    }
}
