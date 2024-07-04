package BOJ.Implement.Gold.P16434;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long N, atk;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ_Repository\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Long.parseLong(st.nextToken());
        atk = Long.parseLong(st.nextToken());

        long min = 0;
        long hp = 0;
        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(bf.readLine());
            long t = Long.parseLong(st.nextToken());
            long a = Long.parseLong(st.nextToken());
            long h = Long.parseLong(st.nextToken());

            if(t==1){
                long atkTimes = h%atk==0?h/atk-1:h/atk;
                hp -= atkTimes*a;
            }else if(t==2){
                if(hp + h > 0){
                    hp = 0;
                }else{
                    hp += h;
                }
                atk += a;
            }

            min = Math.min(min, hp);

        }

        System.out.println(min * -1 + 1);

    }
}

