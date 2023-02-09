package BOJ.G3.P13904;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N,maxDate=0;
    static PriorityQueue<Integer> possi;
    static ArrayList<Integer>[] assigns;
    static int[] deads,points;
    //이 문제는 맨 앞 날짜부터 채워나가면서 진행하면 하루가 지날때마다 데드라인이 지난 일정을 삭제하는 것이 필요하기 때문에 X
    // 맨 뒤 날짜부터 채워가면서 진행하면 당일 내가 수행할 수 있는 모든 일정을 별 다른 처리없이 모두 확인 가능함
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algorithm_java\\src\\BOJ\\G3\\P13904\\input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        possi = new PriorityQueue<>(Collections.reverseOrder());
        deads = new int[N];
        points = new int[N];
        for (int i = 0; i < N; i++) {
            st  =new StringTokenizer(bf.readLine());

            int dead = Integer.parseInt(st.nextToken());
            int point = Integer.parseInt(st.nextToken());

            deads[i] = dead;
            points[i] = point;
            maxDate = Math.max(maxDate,dead);

        }
        assigns = new ArrayList[maxDate+1];
        for (int i = 1; i < maxDate+1; i++) {
            assigns[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            assigns[deads[i]].add(points[i]);
        }
        //마지막날부터 추가해나가면서 poll()
        int sum = 0;
        for (int i = maxDate; i >= 1; i--) {
            for (int j = 0; j < assigns[i].size(); j++) {
                possi.add(assigns[i].get(j));
            }
            if(!possi.isEmpty()){
                sum+=possi.poll();
            }
        }

        System.out.println(sum);

    }
}
