package SWEA.D2.P1209;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
    static int T;
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("src/SWEA/D2/P1209/input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            bf.readLine();
            st = new StringTokenizer(bf.readLine());
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < 1000; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(map.get(num)==null){
                    map.put(num,1);
                }else{
                    map.put(num,map.get(num)+1);
                }

            }

            ArrayList<Integer> keyset = new ArrayList<>(map.keySet());
            keyset.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if(-map.get(o1)+map.get(o2)==0){
                        if(o1>o2) {
                            return -1;
                        }else{
                            return 1;
                        }
                    }
                    return -map.get(o1)+map.get(o2);
                }
            });
            System.out.println("#"+(i+1)+" "+keyset.get(0));

        }

    }
}
