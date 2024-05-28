package BOJ.Implement.Silver.P11866;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            arr.add(i);
        }
        Queue<Integer> queue = new LinkedList<>();

        int idx = 0;
        while(arr.size()>0){
            idx = (idx+k-1)%arr.size();
            queue.add(arr.remove(idx));
        }
        System.out.print("<");
        for (int i = 0; i < n-1; i++) {
            System.out.print(queue.poll()+", ");
        }
        System.out.print(queue.poll());
        System.out.print(">");
    }
}
