package BOJ.SimpleSilver.P1021;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            arr.add(i);
        }
        int index = 0;
        int result = 0;
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < M; i++) {

            int cur = arr.indexOf(Integer.parseInt(st.nextToken()));
            int a = Math.abs(index-cur);
            int b = arr.size()-a;

            result += Math.min(a,b);

            if(cur==arr.size()-1){
                index = 0;
            }else{
                index = cur;
            }
            arr.remove(cur);

        }
        System.out.println(result);
    }
}
