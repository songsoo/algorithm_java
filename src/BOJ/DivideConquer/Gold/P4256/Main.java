package BOJ.DivideConquer.Gold.P4256;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] preOrder;
    static int[] inOrder;
    static int idx;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ_Repository\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        sb = new StringBuilder();

        for (int test_case = 0; test_case < T; test_case++) {
            int n = Integer.parseInt(bf.readLine());

            preOrder = new int[n+1];
            inOrder = new int[n+1];

            StringTokenizer st1 = new StringTokenizer(bf.readLine());
            StringTokenizer st2 = new StringTokenizer(bf.readLine());
            for (int i = 0; i < n; i++) {
                preOrder[i] = Integer.parseInt(st1.nextToken());
                inOrder[Integer.parseInt(st2.nextToken())] = i;
            }
            idx = 0;
            check(0, n-1);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    public static void check(int from, int to){
        if(from == to){
            sb.append(preOrder[idx++]+" ");
            return;
        }else if(from > to){
            return;
        }
        // 현재 찾는 범위 시작 지점을 inOrder에서 찾기
        int curLoc = inOrder[preOrder[idx]];
        int curIdx = preOrder[idx];
        idx++;
        check(from, curLoc -1);
        check(curLoc +1, to);
        sb.append(curIdx+" ");
    }
}
