package BOJ.SimpleSilver.P1011;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = to-from;

            int qo = (int)Math.ceil(Math.sqrt(dist));
            if(dist>Math.pow(qo,2)-qo){
                sb.append(2*qo-1+"\n");
            }else{
                sb.append(2*qo-2+"\n");
            }
        }
        System.out.println(sb.toString());
    }
}
