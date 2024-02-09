package BOJ.Greedy.Gold.P12904;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class P12904 {
    static StringBuilder S,ans;
    static int SS,ES;
    static HashSet<String> visited = new HashSet();

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        S = new StringBuilder();
        String str = bf.readLine();

        SS = str.length();
        S.append(str);
        ans = new StringBuilder(bf.readLine());
        ES = ans.length();

        for (int i = 0; i < ES-SS; i++) {
            if(ans.charAt(ans.length()-1)=='A'){
                ans.deleteCharAt(ES-i-1);
            }else{
                ans.deleteCharAt(ES-i-1);
                ans.reverse();
            }
        }

        if(ans.toString().equals(S.toString())){
            System.out.println("1");
        }else{
            System.out.println("0");
        }
    }

}
