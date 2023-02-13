package BOJ.Greedy.G5.P11000;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, result;
    static PriorityQueue<Integer> classrooms;
    static PriorityQueue<lecture> lectures;
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("src\\BOJ\\G5\\P11000\\input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        classrooms = new PriorityQueue<>();
        lectures = new PriorityQueue<>();
        result = 1;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            lectures.offer(new lecture(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        classrooms.add(lectures.poll().end);

        for (int i = 1; i < N; i++) {
            boolean isPossible = false;
            lecture lec = lectures.poll();
            int start = lec.start;
            int end = lec.end;

            // classroom에 들어있는 queue의 개수가 강의실 개수와 같다
            // queue에는 각 강의실의 끝나는 시간이 들어있다.
            // 가장 빨리 끝나는 강의실에 새로운 강의를 넣을 수 있다면 해당 강의실 끝나는 시간 업데이트
            // 아니라면 새로운 강의실을 열고 강의를 추가한다.
            if(!classrooms.isEmpty() && classrooms.peek()<=start){
                classrooms.poll();
            }
            classrooms.add(end);
        }

        System.out.println(classrooms.size());

    }

}
class lecture implements Comparable<lecture>{
    int start;
    int end;

    lecture(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(lecture o) {
        // 더 작은게 앞으로 가도록 사전식 배열
        return start - o.start;
    }

    @Override
    public String toString() {
        return  start +" " +end+" / ";
    }
}


// 사실상 답지를 보고 푼 문제
// 백준 제출 기록을 보면서 어떤식으로 잘못 풀었는지 확인하고
// 노션에 해당 문제 풀이 방법과 그리디 알고리즘에 대해서 기재할 것