package Programmers.탐욕법.level2.구명보트;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println();
    }
    public int solution(int[] people, int limit) {
        int answer = 0;
        int index=0;
        int next=people.length-1;
        boolean[] visited = new boolean[people.length];
        Arrays.sort(people);
        while(index<people.length){
            if(visited[index]){
                continue;
            }
            while(next>0&&(visited[next]||people[index]+people[next]>limit)){
                next--;
            }
            if(next>0){
                visited[index]= true;
                visited[next] = true;
            }
            answer++;
            index++;
        }
        return answer;
    }
}
