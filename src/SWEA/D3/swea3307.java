package SWEA.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea3307 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(bf.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < n; i++) {
                arr[i]=(Integer.parseInt(st.nextToken()));
            }
            System.out.println("#"+test_case+" "+LIS(arr,arr.length));
        }
    }
    public static int LIS(int[] arr, int n){
        int[] lisArr = new int[n];
        Arrays.fill(lisArr,Integer.MAX_VALUE);
        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i];
            int index = Arrays.binarySearch(lisArr,cur);
            index = -(index+1);
            lisArr[index] = cur;
        }

        for (int i = 0; i < lisArr.length; i++) {
            if(lisArr[i]==Integer.MAX_VALUE){
                return i;
            }
        }
        return lisArr.length;
    }
}
