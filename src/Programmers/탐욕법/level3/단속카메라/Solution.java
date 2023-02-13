package Programmers.탐욕법.level3.단속카메라;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    public static void main(String[] args) {
        int[][] routes = {{-20,-15},{-14,-5},{-18,-13},{-5,-3}};
        System.out.println(solution(routes));
    }
    public static int solution(int[][] routes) {

        int answer = 0;

        ArrayList<route> routeArr = new ArrayList<>();

        for (int i = 0; i < routes.length; i++) {
            routeArr.add(new route(routes[i][0],routes[i][1]));
        }
        Collections.sort(routeArr);

        while(!routeArr.isEmpty()){
            int end = routeArr.get(0).end;
            for (int i = routeArr.size()-1; i >=1 ; i--) {
                if(end>=routeArr.get(i).start && end<=routeArr.get(i).end){
                    routeArr.remove(routeArr.get(i));
                }
            }
            routeArr.remove(routeArr.get(0));
            answer++;
        }

        return answer;
    }
}
class route implements Comparable<route>{
    int start;
    int end;
    route(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(route o){
        return this.end - o.end;
    }

}