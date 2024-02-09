package BOJ.SimpleSilver.P14425;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

//14425
public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] strs = new String[N+1];
        for (int i = 0; i < N; i++) {
            strs[i] = bf.readLine();
        }
        int res = 0;
        for (int i = 0; i < M; i++) {
            String cur = bf.readLine();
            for (int j = 0; j < N; j++) {
               if(strs[j].length()==cur.length() && strs[j].equals(cur)){
                   res++;
                   break;
               }
            }
        }
        System.out.println(res);

    }
}
