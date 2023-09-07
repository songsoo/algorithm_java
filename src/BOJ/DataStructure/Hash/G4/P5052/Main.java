package BOJ.DataStructure.Hash.G4.P5052;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    static int N,M;
    static HashSet<String> b;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("C:\\Users\\SSAFY\\Desktop\\알고리즘\\algorithm_java\\src\\BOJ\\DataStructure\\Hash\\G4\\P5052\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());

        loop:
        for (int i = 0; i < N; i++) {

            M = Integer.parseInt(bf.readLine());
            b = new HashSet<String>();

            for (int j = 0; j < M; j++) {
                String a = bf.readLine();

                if(b.contains(a)){
                    System.out.println("false");
                    continue loop;
                }else{
                    for (int k = 1; k < a.length()+1; k++) {
                        b.add(a.substring(0,k));
                        System.out.println(a.substring(0,k));
                    }
                }
            }
            System.out.println("true");
        }
    }
}
