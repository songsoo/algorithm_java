package SDS.SDS_day3.P1202;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("src/SDS.SDS_day3/P1202/input.txt"));

        List<Integer> bags = new ArrayList<>();
        List<jewel> jewels = new ArrayList<>();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine()," ");
            jewel a = new jewel(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            jewels.add(a);
        }



        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(bf.readLine()," ");
            bags.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(jewels);
        Collections.sort(bags);

        PriorityQueue<jewel> pq = new PriorityQueue<>(Comparator.comparingInt(jewel::getValue).reversed());
        //PriorityQueue<jewel> pq = new PriorityQueue<>();

        int jIndex = 0;
        long result = 0;
        for (int i = 0; i < bags.size(); i++) {
            while(jIndex<N && jewels.get(jIndex).weight <= bags.get(i)) {
                pq.add(jewels.get(jIndex++));
            }
            if(!pq.isEmpty()){
                result += pq.poll().value;
            }
        }
        System.out.println(result);
    }
}

class jewel implements Comparable<jewel>{
    int weight;
    int value;
    jewel(int weight, int value){
        this.weight = weight;
        this.value = value;
    }

    @Override
    public String toString() {
        return weight+"/"+value;
    }

    public int getValue(){
        return value;
    }

    @Override
    public int compareTo(jewel o) {

        if(weight<o.weight){
            return -1;
        }else if(weight == o.weight){
            return o.value-value;
        }else{
            return 1;
        }
    }
}