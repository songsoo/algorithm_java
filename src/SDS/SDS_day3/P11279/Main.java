package SDS.SDS_day3.P11279;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("src/SDS.SDS_day3/P11279/input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(),"");

        int n = Integer.parseInt(st.nextToken());
        Heap heap = new Heap();

        for(int i=0;i<n;i++){
            st = new StringTokenizer(bf.readLine(),"");
            int cal = Integer.parseInt(st.nextToken());

            if(cal==0){
                System.out.println(heap.delete());
            }else{
                heap.insert(cal);
            }
            heap.print();
        }

    }

}

class Heap {
    List<Integer> list;
    int index;
    Heap(){
        list = new ArrayList<>();
        list.add(0);
    }

    public void insert(int n){
        list.add(n);
        int current = list.size() -1;
        int parent = current/2;
        while(true){
            if(parent==0 || list.get(current)>=list.get(parent)){
                break;
            }
            swap(parent,current);

            current = parent;
            parent = current/2;

        }
    }

    public void print(){

    }

    public int delete(){
        if(list.size()==1){
            return 0;
        }

        int result = list.get(1);

        list.set(1,list.get(list.size()-1));
        list.remove(list.size()-1);

        int current = 1;
        while(true){
            int left = current *2;
            int right = current * 2 + 1;
            if(left >= list.size()){
                break;
            }
            int minValue = list.get(left);
            int minPos = left;

            if(right < list.size() && minValue > list.get(right)) {
                minValue = list.get(right);
                minPos = right;
            }

            if(minValue < list.get(current)){
                swap(minPos, current);
            }
            current = minPos;
        }
        return result;
    }

    public void swap(int a, int b){
        int temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b,temp);
    }

}


