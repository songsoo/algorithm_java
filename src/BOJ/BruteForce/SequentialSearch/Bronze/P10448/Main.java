package BOJ.BruteForce.SequentialSearch.Bronze.P10448;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static boolean poss[];
    static ArrayList<Integer> triNum;
    public static void main(String[] args) throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        poss = new boolean[3000];
        triNum = new ArrayList<>();

        for (int i = 1; i < 45; i++) {
            triNum.add(i*(i+1)/2);
        }

        for (int i = 0; i < triNum.size(); i++) {
            for (int j = i; j < triNum.size(); j++) {
                for (int k = j; k < triNum.size(); k++) {
                    poss[triNum.get(i) + triNum.get(j) + triNum.get(k)] = true;
                }
            }
        }

        for (int test_case = 0; test_case < T; test_case++) {
            int cur = Integer.parseInt(bf.readLine());
            System.out.println(poss[cur]?1:0);
        }
    }
}
