package Programmers.탐욕법.level2.조이스틱;

import SDS.SDS_day2.P2842N.answer;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    static int answer = 0;

    public static void main(String[] args) {
        System.out.println(solution("ABBA"));
    }

    //거리가 가장 긴 것부터 찾고 그것을 기준으로 나누었을 때 왼쪽이 빠른가 오른쪽이 빠른가 확인
    public static int solution(String name) {
        char[] nameArr = name.toCharArray();
        int maxLen = 0, len = 0;
        int left = 0, ms = -1, me = -1;
        //현재 거리에서 양쪽 끝단에 있는 녀석 구하기, 최대 길이를 구하면 됨
        // 1. 모두 이어져있을 때
        // 2. 시작지점과 끝지점 이어져있는 최대 길이일때
        // 3. 일반적인 경우
        // 4.
        for (int i = 0; i < nameArr.length; i++) {
            char spell = nameArr[i];
            if (spell == 'A') {
                if (len == 0) {
                    left = i;
                }
                len++;
            } else {
                if (maxLen < len) {
                    ms = left;
                    me = i - 1;
                    maxLen = len;
                }
                len = 0;
                answer += spell - 'A' >= 13 ? 'Z' - spell + 1 : spell - 'A';
            }
        }
        if (maxLen < len) {
            ms = left;
            me = nameArr.length - 1;
        }
        // ms가 0일 때
        // 왼쪽으로 쭉 이어질 때
        // 이어지지 않을 때

        // 모두 다른거
        if (ms == 0) {
            if (me == nameArr.length - 1) {
                //전부 A!
                return 0;
            }

            maxLen = 0;
            len = 0;
            left = 0;
            int prevStart = me;
            ms = -1;
            me = -1;

            for (int i = prevStart + 1; i < nameArr.length; i++) {
                char spell = nameArr[i];
                if (spell == 'A') {
                    if (len == 0) {
                        left = i;
                    }
                    len++;
                } else {
                    if (maxLen < len) {
                        ms = left;
                        me = i - 1;
                        maxLen = len;
                    }
                    len = 0;
                }
            }

            if (maxLen < len) {
                ms = left;
                me = nameArr.length - 1;
            }

            //System.out.println("second longest:" + ms + " " + me);

            //A가 더이상 없을 때
            if (me == -1 && ms == -1) {
                return answer + (nameArr.length - 1 - prevStart);
            }
            if(ms==nameArr.length-1 && me==nameArr.length-1){
                int shortDist = Math.min(ms - 1, nameArr.length - me - 1);
                return answer*2 + 1;

            }
            //A가 있을때
            else {
                int shortDist = Math.min(ms - 1, nameArr.length - me - 1);
                int longDist = Math.max(ms - 1, nameArr.length - me - 1);
                System.out.println(shortDist + " " + longDist + " " + ms + " " + me);
                return answer + shortDist + Math.min(shortDist, me - ms + 1) + longDist;
            }


        }
        if (ms == -1) {
            //A없이 모두 다른거
            return answer + nameArr.length - 1;
        }
        if (ms > 0) {
            //ms-1이랑 length-me-1 중에 더 짧은거 *2 긴거 +1
            int shortDist = Math.min(ms - 1, nameArr.length - me - 1);
            int longDist = Math.max(ms - 1, nameArr.length - me - 1);
            return answer + shortDist + Math.min(shortDist, me - ms + 1) + longDist;
        }

        //System.out.println(ms + " " + me);

        return answer;
    }

}