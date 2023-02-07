package Programmers.탐욕법.level2.조이스틱;

public class Solution {

    public static void main(String[] args) {
        System.out.print(solution("ABAABAAB"));
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
        //System.out.println(countMove(nameArr)+" "+countMoveR(nameArr));
        //System.out.println(moveRight(false,2));
        //System.out.println(moveRight(true,2));
        System.out.println(moveBack(false,4,1));
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

    public static int countMove(char[] nameArr){
        int min = Integer.MAX_VALUE;
        int count =1;
        // 정방향으로 움직이다가 A무리를 만나면 건너갈지 뒤돌아갈지 선택
        for (int i = 0; i < nameArr.length-1; i++) {
            if( nameArr[i+1]=='A' ){
                //현재 위치 다음부터 시작해서
                int j=i+1;
                //A가 몇개가 나오는지 확인
                while(j<nameArr.length && nameArr[j]=='A'){
                    j++;
                }
                //끝까지 A가 안나오고 끝났으면 j = i
                if(j==nameArr.length){
                    j = i;
                }
                //A나온 개수만큼 count 증가
                count+=j-i;

                int tmpMin = Math.min(moveRight(false,j),moveBack(false,j,i));
                min = Math.min(min, tmpMin);

                i=j;
            }
            else{
                count++;
            }
        }
        return count;
    }

    public static int countMoveR(char[] nameArr){
        int min = Integer.MAX_VALUE;
        int count =1;
        // 정방향으로 움직이다가 A무리를 만나면 건너갈지 뒤돌아갈지 선택
        for (int i = nameArr.length-1; i >= 1; i--) {
            if( nameArr[i-1]=='A' ){
                int j=i-1;
                while(j>=1 && nameArr[j]=='A'){
                    j--;
                }
                if(j==0){
                    j = i;
                }
                count+=i-j;

                int tmpMin = Math.min(moveRight(true,j),moveBack(true,j,i));
                tmpMin += count;
                min = Math.min(min, tmpMin);
                i = j;
            }else {
                count++;
            }
        }
        return count;
    }

    public static int moveRight(boolean isReverse,int index){
        int count = 0;
        int tmp = 0;
        if(isReverse){
            for (int i = index-1; i >=0; i--) {
                count++;
                if(nameArr[i]=='A'){
                    tmp++;
                }else{
                    tmp=0;
                }
            }
        }else{
            for (int i = index+1; i < nameArr.length; i++) {
                count++;
                if(nameArr[i]=='A'){
                    tmp++;
                }else{
                    tmp=0;
                }
            }
        }
        return count-tmp;
    }

    public static int moveBack(boolean isReverse, int index,int cur){
        int count=0;
        if(isReverse){
            if(index==0){
                return 0;
            }
        }
        else {

            System.out.println(index);
            if(index==nameArr.length){
                return 0;
            }
            else{
                return nameArr.length-index+cur;
            }
        }
        return 1;
    }



}
