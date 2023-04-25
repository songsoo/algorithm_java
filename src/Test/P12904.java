package Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class P12904 {
    static StringBuilder S;
    static int SS,ES;
    static boolean result;
    static HashMap<String,Boolean> visited = new HashMap();
    static String ans;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        S = new StringBuilder();
        visited = new HashMap<>();
        String str = bf.readLine();
        StringBuilder sb = new StringBuilder();

        SS = str.length();
        S.append(str);
        ans = bf.readLine();
        ES = ans.length();

        dfs(SS,S);
        System.out.println(0);
    }
    public static boolean dfs(int index, StringBuilder sb){
        if(index == ES){
            if(sb.toString().equals(ans)){
                System.out.println(1);
                System.exit(0);
            }
            return false;
        }

        StringBuilder sb2 = new StringBuilder(sb);
        StringBuilder sb3= new StringBuilder(sb);
        sb2.append("A");
        sb3.reverse().append("B");
        if(!visited.get(sb2.toString())){
            dfs(index+1,sb2.append("A"));
        }
        if(!visited.get(sb3.toString())) {
            dfs(index + 1, sb3.reverse().append("B"));
        }
        return false;
    }
}
