package BOJ.Greedy.Gold.P2212;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N,K;
    static HashSet<Integer> sensorsh;
    static PriorityQueue<Integer> sensors;
    static PriorityQueue<distance> distances;
    static ArrayList<distance> distGroup;
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("D:\\IntelliJ\\algorithm_java\\src\\BOJ\\G5\\P2212\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(bf.readLine());
        
        N = Integer.parseInt(st.nextToken());
        st  = new StringTokenizer(bf.readLine());
        K = Integer.parseInt(st.nextToken());
        st  = new StringTokenizer(bf.readLine());

        sensorsh = new HashSet();
        sensors = new PriorityQueue<>();
        distances = new PriorityQueue<>();
        distGroup = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            sensorsh.add(Integer.parseInt(st.nextToken()));
        }

        //우선 HashSet에 넣어서 중복 제거하고 우선순위큐에 넣는다
        for(int a : sensorsh){
            sensors.add(a);
        }
        int groupNum=sensors.size();
        // 인접한 두 센서끼리의 거리를 우선순위큐에 넣는다.
        // 거리가 짧은 것부터 출력될 수 있도록 설정해놓았다.
        while(true) {
            int a = sensors.poll();
            if (sensors.isEmpty()) {
                break;
            }
            int b = sensors.peek();
            distances.add(new distance(a, b));
        }


        //반복문을 돌면서 우선순위큐에서 하나씩 꺼낸다.
        //가장 거리가 짧은 것부터 check해나가면서
        //군집이 총 K개일 때까지 추가한다.
        //groupNum 수정하니 정답
        while(!distances.isEmpty() && groupNum > K){

            distance newDist = distances.poll();

            //연결되어있는게 있으면 군집 개수 안늘림
            for(int i=distGroup.size()-1;i>=0;i--){
                distance curDist = distGroup.get(i);
                //겹치면 잡아먹음
                if(newDist.isConnected(curDist)){
                    //System.out.print(newDist + " + "+curDist);
                    newDist.connect(curDist);
                    //System.out.println(" = "+newDist);


                    distGroup.remove(curDist);
                }

            }
            distGroup.add(newDist);
            groupNum--;
            //System.out.println(distGroup +" "+ groupNum + " "+K);
            if(groupNum==K){
                break;
            }
        }
        int result = 0;
        for (distance a :distGroup) {
            System.out.println(a);
            result+=a.value;

        }

        System.out.println(result);

    }


}
class distance implements Comparable<distance>{

    int start;
    int end;
    int value;

    public distance(int start, int end) {
        this.start = start;
        this.end = end;
        this.value = end - start;
    }

    public boolean isConnected(distance o){
        if(this.start==o.end || this.end==o.start){
            return true;
        }else{
            return false;
        }
    }

    public void connect(distance o){
        this.start = Math.min(this.start, o.start);
        this.end = Math.max(this.end, o.end);
        value = end - start;
    }

    @Override
    public int compareTo(distance o) {
        return this.value - o.value;
    }

    @Override
    public String toString() {
        return "distance{" +
                "start=" + start +
                ", end=" + end +
                ", value=" + value +
                '}';
    }
}
