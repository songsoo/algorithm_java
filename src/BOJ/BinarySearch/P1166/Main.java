package BOJ.BinarySearch.P1166;

import java.nio.Buffer;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        int W = sc.nextInt();
        int H = sc.nextInt();

        double l = 0;
        double r = Math.max(Math.max(L,W),H);

        for(int i=0; i<1000;i++){
            double mid = (l + r) / 2;
            if(((long)(L/mid)*(long)(W/mid)*(long)(H/mid))>=N){
                l = mid;
            }else{
                r = mid;
            }
        }

        System.out.println(l);
    }
}
