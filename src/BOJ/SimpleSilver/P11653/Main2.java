package BOJ.SimpleSilver.P11653;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int index = 2;
        StringBuilder sb = new StringBuilder();
        while(N!=1){
            if(N%index==0){
                N/=index;
                sb.append(index+"\n");
            }else{
                index++;
            }
        }
        System.out.println(sb.toString());
    }
}
