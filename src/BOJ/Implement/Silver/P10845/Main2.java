package BOJ.Implement.Silver.P10845;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf=  new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> queue = new LinkedList<>();
        int n = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String op = st.nextToken();
            if(op.equals("push")){
                queue.add(Integer.parseInt(st.nextToken()));
            }else if(op.equals("pop")){
                if(queue.size()>0){
                    sb.append(queue.pop()).append("\n");
                }else{
                    sb.append(-1).append("\n");
                }
            }else if(op.equals("size")){
                sb.append(queue.size()).append("\n");
            }else if(op.equals("empty")){
                sb.append(queue.isEmpty()?1:0).append("\n");
            }else if(op.equals("front")){
                if(queue.size()>0){
                    sb.append(queue.getFirst()).append("\n");
                }else{
                    sb.append(-1).append("\n");
                }
            }else if(op.equals("back")){
                if(queue.size()>0){
                    sb.append(queue.getLast()).append("\n");
                }else{
                    sb.append(-1).append("\n");
                }            }

        }
        System.out.println(sb.toString());
    }
}
