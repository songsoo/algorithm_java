package Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    static int T,n;
    static char p[];
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());
        for (int i = 0; i < T; i++) {

            boolean back = false;
            boolean success = true;
            p = bf.readLine().toCharArray();
            n = Integer.parseInt(bf.readLine());
            String[] strArr = bf.readLine().replace("[","").replace("]","").split(",");
            int start=0, end = n-1;
            for (int j = 0; j < p.length; j++) {
                if(p[j]=='R'){
                    back = !back;
                }else{
                    // 가능한지 확인
                    if(end-start<0){
                        success = false;
                        break;
                    }
                    // 가능하다면 앞에서인지 뒤에서인지 확인해서 1 줄이기
                    if(back == true){
                        end--;
                    }else{
                        start++;
                    }
                }
            }

            if(!success){
                System.out.println("error");
            }else{
                if(end<start){
                    System.out.println("[]");
                }
                else {
                    System.out.print("[");
                    if (back) {
                        for (int j = end; j > start; j--) {
                            System.out.print(strArr[j] + ",");
                        }
                        System.out.println(strArr[start] + "]");
                    } else {
                        for (int j = start; j < end; j++) {
                            System.out.print(strArr[j] + ",");
                        }
                        System.out.println(strArr[end] + "]");
                    }
                }

            }

        }
    }
}
