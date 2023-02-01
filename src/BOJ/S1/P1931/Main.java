package BOJ.S1.P1931;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N,cnt;
    static PriorityQueue<meet> pq;
    static ArrayList<meet> meets;
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("E:\\SSAFY9\\intelliJ_workspace\\algorithm_java\\src\\BOJ\\S1\\P1931\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        pq = new PriorityQueue<>();
        meets = new ArrayList<>();
        cnt = 0;
        for (int i = 0; i <N; i++) {
            st = new StringTokenizer(bf.readLine());
            meet newMeet = new meet(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            pq.add(newMeet);
        }
        boolean sameTimeChecker = false;

        meet latestMeet=pq.poll();
        cnt++;

        while(!pq.isEmpty()){
            meet curMeet = pq.poll();
            //이전 것의 끝나는 시간보다 현재의 시작하는 시간이 늦으면 추가
            if(curMeet.start>=latestMeet.end){
                //이 때 이전 것과 현재 것이 같은데 checker가 true라면 continue
                if(curMeet.start == latestMeet.start && curMeet.end ==latestMeet.end){
                    if(sameTimeChecker){
                        continue;
                    }
                    sameTimeChecker = true;
                }else{
                    sameTimeChecker = false;
                }
                latestMeet = curMeet;
                cnt++;
            }
        }

        System.out.println(cnt);


    }

}
class meet implements Comparable<meet>{
    int start;
    int end;

    meet(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(meet o) {
        if(o.end==this.end){
            return this.start-o.start;
        }else{
            return this.end-o.end;
        }
    }

    @Override
    public String toString() {
        return start + " "+ end;
    }
}
