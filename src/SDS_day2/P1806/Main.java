package SDS_day2.P1806;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        int N,S;
        int arr[];

        System.setIn(new FileInputStream("src/SDS_day2/P1806/input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N+1];


        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int low=0, high=0, sum=arr[0],min=Integer.MAX_VALUE,count=0;
        while(true){
            if(sum>=S){
                min = Math.min(high - low + 1, min);
                sum -= arr[low++];
            }else{
                sum += arr[++high];
            }
            if(high==N){
                break;
            }

        }
        if(min == Integer.MAX_VALUE){
            min = 0;
        }
        System.out.println(min);



    }

}
