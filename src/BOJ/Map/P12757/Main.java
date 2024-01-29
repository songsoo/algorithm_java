package BOJ.Map.P12757;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    static int K;
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(bf.readLine());
            int key = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            map.put(key,value);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int op = Integer.parseInt(st.nextToken());
            // 추가
            if(op==1){
                int key = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                map.put(key,value);
            }
            // 변경
            else if(op == 2){
                int key = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());

                if(map.containsKey(key)){
                    map.put(key,value);
                }else{
                    Integer ceilingKey = map.ceilingKey(key);
                    Integer floorKey= map.floorKey(key);

                    int adjKey = getKey(ceilingKey,floorKey,key);
                    if(adjKey!=-1 && adjKey!=-2){
                        map.put(adjKey,value);
                    }

                }
            }
            // 찾기
            else if(op==3){
                int key = Integer.parseInt(st.nextToken());

                if(map.containsKey(key)){
                    sb.append(map.get(key)).append("\n");
                }else{
                    Integer ceilingKey = map.ceilingKey(key);
                    Integer floorKey = map.floorKey(key);

                    int adjKey = getKey(ceilingKey,floorKey,key);
                    if(adjKey==-2){
                       sb.append("?").append("\n");
                    }else if(adjKey == -1){
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(map.get(adjKey)).append("\n");
                    }
                }
            }
        }
        System.out.println(sb.toString());
    }

    public static int getKey(Integer a, Integer b, int key){

        if(a==null){
            a = Integer.MIN_VALUE;
        }
        if(b==null){
            b = Integer.MAX_VALUE;
        }

        if(key == a){
            return key;
        }else{
            // K이내의 범위에 없을 때
            // a와 b가 key와의 범위가 같을 때
            // a나 b가 null일 때

            long diff1 = Math.abs(key - a);
            long diff2 = Math.abs(b - key);
            long diff = Math.min(diff1, diff2);
            if(Math.abs(diff1)==Math.abs(diff2)){
                //같다
                return -2;
            }
            else if(diff<=K){
                if(diff1<diff2){
                    return a;
                }else{
                    return b;
                }
            }else{
                //없다
                return -1;
            }
        }
    }
}
