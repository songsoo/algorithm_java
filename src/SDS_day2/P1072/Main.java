package SDS_day2.P1072;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/SDS_day2_P1072/input.txt"));
        Scanner sc = new Scanner(System.in);

        long X = sc.nextLong();
        long Y = sc.nextLong();

        long z = 100 * Y / X;

        if(z ==99){
            System.out.println(-1);
        }else{
            long start = 0;
            long end = X;
            while(start<end){
                long mid = (start+end)/2;
                long newRate = (100 * (Y + mid) / (X + mid));
                //승률이 그대로
                if(newRate == z){
                    start = mid+1;
                }
                //승률이 변함
                else{
                    end = mid;
                }

            }
            System.out.println(end);
        }



    }



}
