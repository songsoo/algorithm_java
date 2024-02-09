package BOJ.SimpleSilver.P1251;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        PriorityQueue<String> pq = new PriorityQueue<>();
        int length = str.length();
        for (int i = 0; i < length-2; i++) {
            for (int j = i+1; j < length-1; j++) {
                StringBuilder sb1 = new StringBuilder();
                sb1.append(str.substring(0,i+1));
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str.substring(i+1,j+1));
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str.substring(j+1));
                sb1.reverse();
                sb2.reverse();
                sb3.reverse();
                pq.add(sb1.toString()+sb2.toString()+sb3.toString());
            }
        }
        System.out.println(pq.poll());

    }
}

