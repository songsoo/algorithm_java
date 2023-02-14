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

        // 시작 지점과 끝 지점을 routeArr에 저장하고 끝나는 지점을 기준으로 오름차순 정렬
        ArrayList<route> routeArr = new ArrayList<>();

        for (int i = 0; i < routes.length; i++) {
            routeArr.add(new route(routes[i][0],routes[i][1]));
        }
        Collections.sort(routeArr);

        // 하나 꺼낸 녀석의 끝지점이 루트 중간에 포함되어있는 놈들 모두 제거
        // (꺼낸 끝 지점에 카메라를 놓는다고 가정하는 것)
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