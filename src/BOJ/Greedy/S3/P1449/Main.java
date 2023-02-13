package BOJ.Greedy.S3.P1449;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int N, tape;
    static ArrayList<Integer> list;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("D:\\IntelliJ\\algorithm_java\\src\\BOJ\\S3\\P1449\\input.txt"));
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        tape = Integer.parseInt(st.nextToken());

        st  = new StringTokenizer(bf.readLine());
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        int cur = 0;
        int cnt = 1;
        for (int i = 1; i < N; i++) {
            // 자신의 다음 카운트를 계속 넘어가면서 length와 차이를 비교하고
            // length보다 커지면 cur을 변경하여 count 증가
            if(list.get(i)-list.get(cur)+1>tape){
                cur = i;
                cnt++;
            }
        }
        System.out.println(cnt);

    }
}