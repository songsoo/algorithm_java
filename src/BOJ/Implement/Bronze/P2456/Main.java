package BOJ.Implement.Bronze.P2456;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        candidate[] candidates = new candidate[3];
        for (int i = 0; i < 3; i++) {
            candidates[i] = new candidate(i+1);
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 3; j++) {
                candidates[j].vote(Integer.parseInt(st.nextToken()));
            }
        }

        Arrays.sort(candidates);
        if(candidates[2].compareTo(candidates[1])==0){
            System.out.println(0 + " "+ candidates[2].getValue());
        }else{
            System.out.println(candidates[2].index +" "+candidates[2].getValue());
        }

    }
}
class candidate implements Comparable<candidate>{
    int index;
    int high = 0;
    int middle = 0;
    int low = 0;

    candidate(int index){
        this.index = index;
    }
    public int getValue(){
        return this.high * 3 + this.middle * 2 + this.low * 1;
    }
    public void vote(int value){
        if(value == 3){
            this.high++;
        }else if(value == 2){
            this.middle++;
        }else if(value == 1){
            this.low++;
        }
    }

    @Override
    public int compareTo(candidate o) {
        if(this.getValue() == o.getValue()){
            if(this.high==o.high){
                return this.middle - o.middle;
            }else{
                return this.high - o.high;
            }
        }else{
            return this.getValue()-o.getValue();
        }
    }
}
