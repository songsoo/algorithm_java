package Study.SDS_day1.P1713;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    static int N,K;
    static student[] studentArr;

    public static void main(String[] args) throws FileNotFoundException {

        System.setIn(new FileInputStream("src/SDS.SDS_day1/P1713/input.txt"));

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        studentArr = new student[101];
        List<student> list = new ArrayList<>();
        for(int k=0;k<K;k++){
            int number = sc.nextInt();
            if(studentArr[number]==null){
                studentArr[number] = new student(number,0,0,false);
            }

            if(studentArr[number].isIn==true){
                studentArr[number].number++;
            }else{
                if(list.size()==N){
                    Collections.sort(list);
                    student student = list.remove(0);
                    student.isIn = false;
                }

                studentArr[number].number = 1;
                studentArr[number].isIn=true;
                studentArr[number].time = k;
                list.add(studentArr[number]);
            }
        }

        Collections.sort(list, new Comparator<student>() {
            @Override
            public int compare(student o1, student o2) {
                return Integer.compare(o1.name,o2.name);
            }
        });

        for(student a:list){
            System.out.print(a+" ");
        }
    }
}
class student implements Comparable<student>{
    int name;
    int time;
    int number;
    boolean isIn;

    student(int name, int time, int number,boolean isIn){
        this.name = name;
        this.time = time;
        this.number = number;
        this.isIn = isIn;
    }

    public int getName(){
        return name;
    }
    public int getNumber(){
        return number;
    }
    public int getTime(){
        return time;
    }
    public boolean getIsIn(){return isIn;}

    public void setName(int name){
        this.name = name;
    }
    public void setNumber(int number){
        this.number = number;
    }
    public void setTime(int time){
        this.time = time;
    }
    public void setIsIn(boolean isIn){this.isIn = isIn;}

    public String toString(){
        return Integer.toString(name);
    }


    @Override
    public int compareTo(student o) {
        int comp = Integer.compare(number,o.number);
        if(number==o.number){
            return time-o.time;
        }else{
            return comp;
        }
    }
}
