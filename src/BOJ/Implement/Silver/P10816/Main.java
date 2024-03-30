package BOJ.Implement.Silver.P10816;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if(hash.containsKey(cur)){
                hash.put(cur, hash.get(cur)+1);
            }else{
                hash.put(cur, 1);
            }
        }
        int M = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if(hash.containsKey(cur)){
                sb.append(hash.get(cur)+" ");
            }else{
                sb.append(0+" ");
            }
        }

        System.out.println(sb.toString());
    }
}
