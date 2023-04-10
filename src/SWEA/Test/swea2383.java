package SWEA.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class swea2383 {
    static int[][] arr, time;
    static ArrayList<int[]> people, stairs;
    static int N, min;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("E:\\ssafy\\intelliJWorkSpace\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(bf.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {

            N = Integer.parseInt(bf.readLine());
            arr = new int[N][N];
            min = Integer.MAX_VALUE;

            people = new ArrayList<>();
            stairs = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if(arr[i][j]==1){
                        people.add(new int[]{i,j});
                    }else if(arr[i][j]>1){
                        stairs.add(new int[]{i,j});
                    }
                }
            }

            time = new int[people.size()][stairs.size()];

            for (int i = 0; i < people.size(); i++) {
                for (int j = 0; j < stairs.size(); j++) {
                    time[i][j] = getDist(i,j);
                }
            }

            subset(0,new int[people.size()]);
            System.out.println("#"+test_case+" "+min);
        }
    }

    public static int getTime(int[] goTo){
        int max= 0;
        PriorityQueue<move> pq = new PriorityQueue<>();
        for (int i = 0; i < people.size(); i++) {
            pq.add(new move(i,time[i][goTo[i]], goTo[i]));
        }

        PriorityQueue<Integer> pq0 = new PriorityQueue<>();
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();

        int[] stairTime = new int[2];
        int i = 0;
        for (int[] stair: stairs){
            stairTime[i++] = arr[stair[0]][stair[1]];
        }

        while(!pq.isEmpty()){
            move cur = pq.poll();
            if(cur.to==0){
                if(pq0.size()>2){
                    int tmp = pq0.poll();
                    pq0.add(Math.max(tmp-1,cur.time)+stairTime[0]+1);
                }else{
                    pq0.add(cur.time+stairTime[0]+1);
                }
            }else if(cur.to==1){
                if(pq1.size()>2){
                    pq1.add(Math.max(pq1.poll()-1,cur.time)+stairTime[1]+1);
                }else{
                    pq1.add(cur.time+stairTime[1]+1);
                }
            }
        }
        while(!pq0.isEmpty()){
            max = Math.max(pq0.poll(),max);
        }
        while(!pq1.isEmpty()){
            max = Math.max(pq1.poll(),max);
        }
        return max;
    }

    public static void subset(int index, int[] goTo){
        if(index == people.size()){
            min = Math.min(min,getTime(goTo));
            return;
        }
        for (int i = 0; i < stairs.size(); i++) {
            goTo[index] = i;
            subset(index+1,goTo);
        }
    }


    public static int getDist(int i, int j){
        int[] person = people.get(i);
        int[] stair = stairs.get(j);
        return Math.abs(person[0]-stair[0])+Math.abs(person[1]-stair[1]);
    }


}
class move implements Comparable<move>{
    int index;
    int time;
    int to;
    move(int index, int time, int to){
        this.index = index;
        this.time = time;
        this.to = to;
    }

    @Override
    public int compareTo(move o) {
        return time - o.time;
    }
}