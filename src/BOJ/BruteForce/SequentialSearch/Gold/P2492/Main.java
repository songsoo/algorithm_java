package BOJ.BruteForce.SequentialSearch.Gold.P2492;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N,M,T,K;
    static ArrayList<dot> dots;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\SSAFY\\IdeaProjects\\algorithm_java\\src\\BOJ\\BruteForce\\SequentialSearch\\G3\\P2492\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dots = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            dots.add(new dot(x,y));
        }

        int max = 0;
        int x= 0;
        int y = M;

        for (int i = 0; i < dots.size() ; i++) {
           dot a = dots.get(i);
            for (int j = 0; j < dots.size(); j++) {
                dot b = dots.get(j);
                if(a.compareTo(b)==0){
                    continue;
                }
                if(a.compareTo(b)>0){
                    continue;
                }
                dot cur = new dot(b.x,a.y);
                if(b.x+K<a.x || b.y+K<a.y){
                    continue;
                }
                if(cur.x+K > N){
                    cur.x = N-K;
                }if(cur.y-K < 0){
                    cur.y=K;
                }
                int getDot = cur.getDots();
                if(getDot>max){
                    max = getDot;
                    x = cur.x;
                    y = cur.y;
                }
            }
        }
        System.out.println(x +" "+y);
        System.out.println(max);

    }

    static class dot implements Comparable<dot>{
        int x;
        int y;
        dot(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(dot o) {
            // 하나가 일방적으로 크면 문제가 있다.
            if((this.x>o.x && this.y<o.y)||(o.x>this.x && o.y<this.y)){
                return 0;
            }
            if(this.x==o.x && this.y==o.y){
                return -1;
            }
            if(this.x==o.x){
                return o.y - this.y;
            }else{
                return o.x - this.x;
            }
        }

        public int getDots(){
            int count = 0;
            for(dot cur : dots){
                if(cur.x>=this.x && cur.x<=this.x+K && cur.y>=this.y-K && cur.y<=this.y){
                    count++;
                }
            }
            return count;
        }
        public void change(dot o){
            int tmp = o.x;
            o.x = this.x;
            this.x = tmp;

            tmp = o.y;
            o.y = this.y;
            this.y = tmp;
        }
    }
}
