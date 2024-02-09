package BOJ.Implement.Silver.P9536;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            LinkedList<String> words = new LinkedList<>();
            while(st.hasMoreTokens()){
                words.add(st.nextToken());
            }

            while(true){
                String cryStr = bf.readLine();
                st = new StringTokenizer(cryStr);
                if(cryStr.equals("what does the fox say?")){
                    break;
                }
                st.nextToken();
                st.nextToken();
                String cry = st.nextToken();
                for (int i = words.size()-1; i >= 0; i--) {
                    if(words.get(i).equals(cry)){
                        words.remove(i);
                    }
                }
            }

            for(String str : words){
                System.out.print(str+" ");
            }
        }

    }
}
