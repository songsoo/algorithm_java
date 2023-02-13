package Programmers.탐욕법.level3.섬연결하기;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {

    }
    static ArrayList<link>[] linkArr;
    static boolean[] visited;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        linkArr = new ArrayList[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            linkArr[i] = new ArrayList<>();
        }
        for (int i = 0; i < costs.length; i++) {
            int a1 = costs[i][0];
            int a2 = costs[i][1];
            int value = costs[i][2];
            linkArr[a1].add(new link(a1,a2,value));
            linkArr[a2].add(new link(a2,a1,value));
        }

        PriorityQueue<link> pq = new PriorityQueue<>();
        visited[0] = true;
        for(link lin : linkArr[0]){
            pq.add(lin);
        }
        int cnt = 0;
        while(cnt<n-1){
            link newLink = pq.poll();
            if(!visited[newLink.a2]){
                visited[newLink.a2] = true;
                for(link lin : linkArr[newLink.a2]){
                    pq.add(lin);
                }
                cnt++;
                answer+=newLink.value;
            }
        }



        return answer;
    }


}
class link implements Comparable<link>{
    int a1;
    int a2;
    int value;
    link(int a1, int a2, int value){
        this.a1 = a1;
        this.a2 = a2;
        this.value = value;
    }

    @Override
    public int compareTo(link o) {
        //오름차순 정렬
        return this.value-o.value;
    }
}
