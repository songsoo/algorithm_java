package Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class compare {
    public static void main(String[] args) throws Exception {
        P13905 test = new P13905();
        세부 sebu = new 세부();

        File f = new File("src/Test/Input.txt");

        while(true) {


            BufferedWriter bf = new BufferedWriter(new FileWriter(f));
            int N = (int) (Math.random() * 100) + 1;
            int M = N * 2;
            String text = N + " " + M + "\n";
            int S = (int) (Math.random() * N);
            int E;
            while (true) {
                E = (int) (Math.random() * N);
                if (S == E) {
                    continue;
                }
                break;
            }
            text += S + " " + E + "\n";
            for (int i = 0; i < M; i++) {
                int h1 = (int) (Math.random() * N) + 1;
                int h2 = (int) (Math.random() * N) + 1;
                if (h1 == h2) {
                    i--;
                    continue;
                }
                int value = (int) (Math.random() * 100);
                text += h1 + " " + h2 + " " + value + "\n";
            }
            bf.write(text);
            bf.flush();
            bf.close();

            if (sebu.Go() != test.Go()) {
                System.out.println(text);
                break;
            }
        }
    }
}
