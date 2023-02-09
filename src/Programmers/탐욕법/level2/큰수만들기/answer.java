package Programmers.탐욕법.level2.큰수만들기;

import java.util.Collections;
import java.util.PriorityQueue;

public class answer {
    public static void main(String[] args) {
        System.out.println(solution("7231072",2));
    }
    public static String solution(String number, int k) {
        String answer = "";
        int N = number.length();
        k = N-k;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // 자신이 갈 수 있는 최대한 오른쪽까지 확인하면서 우선순위 큐에 넣는다.
        // 만약 기존에 있던 최대값보다 큰 값이 나오면 왼쪽은 아예 다 버린다.
        // 우선순위 큐에서 가장 큰 숫자를 answer로 넘기고 없앤다.
        // 마지막 위치를 start지점으로 놓고 다음 라운드는 해당 지점부터 시작하여 반복한다.
        int start = 0;
        // K개만큼 넣는다.
        for (int i = 0; i < k; i++) {
            //최대한 끝까지 가는 경우는
            int j=0;
            //System.out.println(start);
            for (j = start; j <= N-(k-i); j++) {
                //System.out.println(start+" "+N+" "+k+" "+j);
                int newValue = number.charAt(j)-'0';
                if(!pq.isEmpty()&&pq.peek()<newValue){
                    pq.clear();
                }
                pq.add(newValue);
            }
            answer+=pq.poll();
            start = j;
        }
        int count =0 ;
        for (int i = 0; i < k; i++) {
            if(answer.charAt(i)=='0'){
                count++;
            }else{
                break;
            }
        }
        answer = answer.substring(count);
        return answer;
    }
}
