package BOJ.SimpleSilver.P5883;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int arr[];
    static HashSet<Integer> hash;
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N];
        hash = new HashSet<>();
        hash.add(-1);
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(bf.readLine());
            arr[i] = cur;
            if(!hash.contains(cur)){
                hash.add(cur);
            }
        }
        int max = 0;
        for(int exc : hash){
            int prev = arr[0];
            int length = 1;
            for (int i = 1; i < N; i++) {
                if(exc == arr[i]){
                    continue;
                }
                if(prev == arr[i]){
                    length++;
                }else{
                    max = Math.max(max, length);
                    length = 1;
                    prev = arr[i];
                }
            }
            max = Math.max(max, length);
        }
        System.out.println(max);


    }
}
