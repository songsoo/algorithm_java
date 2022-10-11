package SDS_day1.P1713;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main2 {

    // 추천 받으면 반드시 사진틀에 게시
    // 가장 추천 수가 적은 학생 사진을 삭제, 추천 수 0으로 초기화
    // 게시된 학생이 추천 받을 때만 추천횟수 증가
    // 최종 후보의 학생 번호 순서대로 출력
    static int N,M,order;
    static student2[] studentList;
    static ArrayList<student2> bestStudents;

    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("src/SDS_day1/P1713/input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());

        studentList = new student2[101];
        bestStudents = new ArrayList<>();
        order = 0;

        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<M;i++){

            int newID = Integer.parseInt(st.nextToken());
            // 아직 입력되지 않은 학생은 집어넣고
            if(studentList[newID]==null){
                studentList[newID] = new student2(newID,0,0);
            }
            // 입력되지 않은 놈이면
                // 액자를 확인해서 3이상이면
                    // 가장 낮은 놈 빼고, 추천 수 0으로 만들고
                // 집어넣기
                // order에 따라 정렬
            // 입력된 놈이면 추천 수만 증가
            if(!bestStudents.contains(studentList[newID])){
                if(bestStudents.size()==N){
                    bestStudents.get(N-1).setRecom(0);
                    bestStudents.remove(N-1);
                }
                bestStudents.add(studentList[newID]);
                studentList[newID].setOrder(order++);
                studentList[newID].setRecom( studentList[newID].getRecom()+1);
            }else{
                studentList[newID].setRecom( studentList[newID].getRecom()+1);
            }
            Collections.sort(bestStudents);
        }

        Collections.sort(bestStudents, new Comparator<student2>(

        ) {
            @Override
            public int compare(student2 o1, student2 o2) {
                if(o1.getID()>o2.getID()){
                    return 1;
                }else{
                    return -1;
                }
            }
        });

        for (int i = 0; i < bestStudents.size(); i++) {
            System.out.print(bestStudents.get(i).toString());
        }


    }


}

class student2 implements Comparable<student2>{

    int id;
    int recom;
    int order;
    student2(int id, int recom, int order){
        this.id = id;
        this.recom = recom;
        this.order=order;
    }

    public void setRecom(int newRecom){
        this.recom = newRecom;
    }
    public void setOrder(int newOrder){
        this.order = newOrder;
    }

    public int getRecom(){
        return this.recom;
    }

    public int getOrder(){
        return this.order;
    }

    public int getID(){
        return this.id;
    }

    public String toString(){
        return this.id+" ";
    }


    @Override
    public int compareTo(student2 o) {
        // 기본적으로 오름차순
        // 추천수는 높은게 앞으로 (반대로)
        // this recom - o recom은 음수가 나와야 한다 하지만 반대니까 1을 return
        if(this.recom < o.recom){
            return 1;
        }else if(this.recom > o.recom){
            return -1;
        }else{
            // 순서는 낮은게 뒤로, 큰게 앞으로
            // this order - o order는 this가 작으면 음수가 나와야함
            return -this.order+o.order;
        }
    }
}