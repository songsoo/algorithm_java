package SDS_day3.P10818;

import java.io.*;
import java.nio.Buffer;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("src/SDS_day3/P10818/input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        stack stk = new stack();

        for(int i=0;i<n;i++){
            st = new StringTokenizer(bf.readLine()," ");

            String get = st.nextToken();

            if(get.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                stk.push(num);
            }else if(get.equals("pop")){
                System.out.println(stk.pop());
            }else if(get.equals("size")){
                System.out.println(stk.size());
            }else if(get.equals("empty")){
                System.out.println(stk.empty());
            }else if(get.equals("top")){
                System.out.println(stk.top());
            }

        }

    }


}
class stack{

    int arr[];
    int index;

    stack(){
        index = 0;
        arr = new int[10000];
    }

    public void push(int n){
        arr[index++] = n;
    }

    public int pop(){
        if(index==0){
            return -1;
        }else{
            return arr[--index];
        }
    }
    public int size(){
        return index;
    }

    public int empty(){
        if(index==0){
            return 1;
        }else{
            return 0;
        }
    }

    public int top(){
        if(index==0){
            return -1;
        }else{
            return arr[index-1];
        }
    }

    public void print(){
        if(index==0){
            System.out.println("empty");
        }else {
            for (int i = 0; i < index; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println(": "+index);
        }

    }

}