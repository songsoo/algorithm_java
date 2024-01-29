package BOJ.SimpleSilver.P11656;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            arr.add(str.substring(i));
        }
        Collections.sort(arr);

        StringBuilder sb = new StringBuilder();
        for(String cur : arr){
            sb.append(cur+"\n");
        }
        System.out.println(sb.toString());

    }
}
