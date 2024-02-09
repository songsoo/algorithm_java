package BOJ.TwoPointer.P14921;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int p = 0, q=N-1;
        int min = Integer.MAX_VALUE;
        while(p<q){
            if(Math.abs(arr[p]+arr[q])<Math.abs(min)){
                min = arr[p]+arr[q];
            }
            if(arr[p]+arr[q]>0){
                q--;
            }else if(arr[p]+arr[q]==0){
                break;
            }else{
                p++;
            }
        }
        System.out.println(min);
    }
}
