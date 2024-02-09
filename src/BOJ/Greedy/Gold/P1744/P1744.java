package BOJ.Greedy.Gold.P1744;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class P1744 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("E:\\ssafy\\intelliJWorkSpace\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> plus,minus;

        plus = new PriorityQueue<>(Collections.reverseOrder());
        minus = new PriorityQueue<>();
        int zeroCnt = 0;
        int result = 0;
        // 음수를 0으로 치워버리는 경우, 음수끼리 곱해서 양수를 만드는 경우
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(bf.readLine());
            if(cur>0){
                plus.add(cur);
            }else if(cur == 0){
                zeroCnt++;
            }else{
                minus.add(cur);
            }
        }

        while(!plus.isEmpty()){
            int cur = plus.poll();
            if(plus.size()>=1 && plus.peek()!=1){
                cur *= plus.poll();
            }
            result += cur;
        }
        while(!minus.isEmpty()){
            int cur = minus.poll();
            if(minus.size()>=1){
                cur *= minus.poll();
            }else{
                if(zeroCnt>0){
                    cur *= 0;
                }
            }
            result += cur;
        }
        System.out.println(result);
    }
}
