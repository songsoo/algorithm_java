package BOJ.BruteForce.SequentialSearch.G3.P2492;

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

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dots = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(bf.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            dots.add(new dot(x,y));
        }

        int max = 0;
        int x= N;
        int y = 0;

        for (int i = 0; i < dots.size() ; i++) {
           dot a = dots.get(i);
            for (int j = i+1; j < dots.size(); j++) {
                dot b = dots.get(j);
                if(a.compareTo(b)==0){
                    continue;
                }
                else if(a.compareTo(b)>0){
                    dot tmp = b;
                    b = a;
                    a = tmp;
                }
                dot cur = new dot(b.x,a.y);
                int getDot = cur.getDots();
                if(getDot>max){
                    max = getDot;
                    x = cur.x+K;
                    y = cur.y;
                }
            }
        }
        System.out.println(y +" "+x);
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
            if((this.x>o.x && this.y>o.y)||(o.x>this.x && o.y>this.y)){
                return 0;
            }
            if(this.x==o.x){
                return this.y - o.y;
            }else{
                return o.x - this.x;
            }
        }

        public int getDots(){
            int count = 0;
            for(dot cur : dots){
                if(cur.x>=this.x && cur.x<=this.x+K && cur.y>=this.y && cur.y<=this.y+K){
                    count++;
                }
            }
            return count;
        }
    }
}
