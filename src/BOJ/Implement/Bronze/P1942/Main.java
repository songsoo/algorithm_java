package BOJ.Implement.Bronze.P1942;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for (int test_case = 0; test_case < 3; test_case++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            //시작
            int hour = 0;
            int minute = 0;
            int second = 0;

            String[] strs =  st.nextToken().split(":");
            hour = Integer.parseInt(strs[0]);
            minute = Integer.parseInt(strs[1]);
            second = Integer.parseInt(strs[2]);
            time start = new time(hour, minute, second);

            strs =  st.nextToken().split(":");
            hour = Integer.parseInt(strs[0]);
            minute = Integer.parseInt(strs[1]);
            second = Integer.parseInt(strs[2]);
            time end = new time(hour, minute, second);

            int count = 0;
            while(start.compareTo(end)!=0){
                if(start.getTime()%3==0){
                    count++;
                }
                start.growUp();
            }
            if(start.getTime()%3==0){
                count++;
            }
            System.out.println(count);

         }
    }
}
class time implements Comparable<time> {
    int hour;
    int minute;
    int second;

    public time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getTime(){
        return hour*10000+minute*100+second;
    }

    public void growUp(){
        second++;
        if(second>=60){
            second = 0;
            minute++;
        }
        if(minute>=60){
            minute=0;
            hour++;
        }
        if(hour>=24){
            hour=0;
            minute=0;
            second=0;
        }
    }
    @Override
    public String toString(){
        return hour+":"+minute+":"+second;
    }
    @Override
    public int compareTo(time o){
        return this.getTime() - o.getTime();
    }


}