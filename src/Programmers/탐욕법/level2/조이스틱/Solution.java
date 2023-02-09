package Programmers.탐욕법.level2.조이스틱;

public class Solution {

    public static void main(String[] args) {
        System.out.print(solution("AABAABBBB"));
    }

    static char[] nameArr;
    public static int solution(String name) {

        int answer = 0;
        nameArr = name.toCharArray();

        //이름에서 A가 아닌 것들 모두 count
        answer += countAlphabet(nameArr);
        if(answer==0){
            return 0;
        }
        //answer = answer + Math.min(countMove(nameArr),countMoveR(nameArr));
        System.out.println(countMove());
        return answer;
    }

    public static int countAlphabet(char[] nameArr){
        int result = 0;
        for (int i = 0; i < nameArr.length; i++) {
            char spell = nameArr[i];
            result += spell - 'A' >= 13 ? 'Z' - spell + 1 : spell - 'A';
        }
        return result;
    }

    //시작부터 오른쪽으로 이동했을 경우
    public static int countMove(){
        //오른쪽으로 한 칸씩 이동하면서 num count, 마지막으로 A의 행렬이 나타나지 않을 때 까지 증가시킨다.
        //이 때 다음 칸이 A라면 뒤로 돌아가는 것을 카운트한다.
        int count = 0; //앞으로 이동한 회수
        int minBack = Integer.MAX_VALUE; //현재까지 앞으로 온 길이 + 뒤로 돌아간 값 중 가장 짧은 것
        int curACount = 0; //가장 최근에 만난 A가 연달아 나온 회수
        for (int i = 0; i < nameArr.length-1; i++) {
            //자신의 다음이 A인지 확인하고 A인 것이 확인되면 다음 문자를 확인한다.
            //이 때 다음 문자가 있을 수도 있고 없을 수도 있다.
            //다음 문자까지의 숫자를 count하고
                //있다면
                    // 1. moveBack을 반대방향으로 다음 문자까지 진행하고 현재 count와 비교하여 minBack에 업데이트한다
                    // 2. i를 다음 숫자까지 이동하고 count를 증가시킨다.
                //없다면
                    //index는 nameArr.length를 가리킬 것이다.
                    //ACount만큼 추가이동을 시키지 않도록 설정하며, 다음 count++를 제외시킨다(이동을 안하는 것이기 때문에)
            //자신의 다음이 A가 아니라면 aCount를 0으로 초기화
            //count 증가
            if(nameArr[i+1]=='A'){
                int j = i + 1;
                //A밖에 없다면 j는 length까지, 그 외의 것이 있다면 해당 지점까지
                while(j<nameArr.length && nameArr[j]=='A'){
                    curACount++;
                    j++;
                }
                if(j==nameArr.length){
                    System.out.println("jmm");
                }
                else if(j!=nameArr.length){
                    count+=curACount;
                }
                i = j;
            }else if(nameArr[i+1]!='A'){
                System.out.println("right"+i+1);
                curACount = 0;
            }
            count++;
        }
        System.out.println(count);
        //앞으로 쭉 간 길이
        return count;
    }

    // j : 그 다음으로 만날 A가 아닌 값의 위치
    // i : 현재 위치
    // i에서 뒤로 돌아가서 j를 만날 때 까지 count
    // j가
    public static int moveBack(int i, int j){
        int count = 0;
        int curACount = 0;
        while(i!=j){
            i--;
            count++;
            if(i==-1){
                i = nameArr.length-1;
            }
            if(nameArr[i]=='A'){
                curACount++;
            }else if(nameArr[i]!='A'){
                curACount=0;
            }
        }
        return count - curACount;
    }


}
