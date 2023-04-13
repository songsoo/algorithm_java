package Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;

public class P12904 {
    static LinkedList<Character> S,T;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
        S = new LinkedList<>();
        T = new LinkedList<>();
        String str = bf.readLine();
        for (int i = 0; i < str.length(); i++) {
            S.add(str.charAt(i));
        }
        str = bf.readLine();
        for (int i = 0; i < str.length(); i++) {
            T.add(str.charAt(i));
        }

    }
    public static
}
