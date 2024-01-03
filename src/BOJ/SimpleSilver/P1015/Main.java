package BOJ.SimpleSilver.P1015;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        ArrayList<num> arr = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(bf.readLine());

        // 숫자 순서대로 정렬
        // 인덱스에
        for (int i = 0; i < T; i++) {
            int cur = Integer.parseInt(st.nextToken());
            arr.add(new num(i,cur));
        }
        Collections.sort(arr);
        for (int i = 0; i < T; i++) {
            arr.get(i).setCount(i);
        }
        Collections.sort(arr, new Comparator<num>() {
            @Override
            public int compare(num o1, num o2) {
                return o1.index-o2.index;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            sb.append(arr.get(i).count+" ");
        }

        System.out.println(sb.toString());

    }
}
class num implements Comparable<num>{
    int index;
    int size;
    int count=0;

    num(int index, int size){
        this.index = index;
        this.size = size;
    }

    @Override
    public int compareTo(num c){
        if(this.size != c.size){
            return this.size-c.size;
        }else{
            return -this.size+c.size;
        }

    }

    public void setCount(int count){
        this.count = count;
    }

    public int getCount(){
        return count;
    }
    @Override
    public String toString(){
        return "("+index+","+size+","+count+")";
    }
}
