package BOJ.BruteForce.SequentialSearch.Bronze.P2309;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static ArrayList<Integer> height;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algorithm_java\\src\\BOJ\\B1\\P2309\\input.txt"));
        Scanner sc = new Scanner(System.in);
        height = new ArrayList<>();
        while(sc.hasNext()){
            height.add(sc.nextInt());
        }
        visited= new boolean[height.size()];
        Collections.sort(height);

        comb(0,0,0);
    }
    public static void comb(int idx, int sum,int cnt){

        if(cnt==7){if(sum==100){
            for (int i = 0; i < height.size(); i++) {
                if(visited[i]){
                    System.out.println(height.get(i));
                }
            }
            System.exit(0);
        }else{
            return;
        }}
        for (int i = idx; i < height.size(); i++) {
            visited[i] = true;
            comb(i+1,sum+height.get(i),cnt+1);
            visited[i] = false;
        }
    }
}
