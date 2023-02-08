package Study.SDS_day1.P1062;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 /*
public class Main {

    static int N, K;
    static int selectedCount=5, maxNum=0;
    static String[] words;
    static boolean[] visited;

    public static void checkboolean() {
        for(int i=0;i<26;i++) {
            if(visited[i]) {
                System.out.print(i+", ");
            }
        }
        System.out.println();
    }
    public static void dfs(int index) {
        checkboolean();
        // 1.체크인 visited
        visited[index] = true;
        selectedCount++;
        // 2.목적지인가 selectedCount == K
        if(selectedCount==K) {
            maxNum = Math.max(maxNum, getMaxWords());
            //return;

        }// 3.연결된 곳을 순회 index + 1 ~ 25
        // 	4.갈 수 있는가 visited
        //   5.간다 dfs
        else {
            for(int i=index+1;i<26;i++) {
                if(!visited[i]) {
                    dfs(i);
                }
            }
        }
        // 6.체크아웃 visited
        visited[index] = false;
        selectedCount--;

    }
    // a,n,t,c,i로 구성된 알파벳 개수 구하기
    public static int getMaxWords() {
        int maxwords = 0;

        // 총 단어 개수만큼 반복
        for(int i=0;i<N;i++) {
            maxwords++;
            // 각 단어의 길이만큼 반복
            for(int j=0;j<words[i].length();j++) {
                //단어의 알파벳 중에 a~z가 아니면 빼고
                if(((int)words[i].charAt(j))-97<0 || ((int)words[i].charAt(j))-97 >26) {
                    maxwords--;
                    break;
                }
                //이미 발견한 알파벳이면 빼고 (a,n,t,c,i)
                if(!visited[((int)words[i].charAt(j))-97]) {
                    maxwords--;
                    break;
                }

            }
        }
        return maxwords;
    }

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        System.setIn(new FileInputStream("src/SDS.SDS_day1/P1062/input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();
        StringTokenizer st = new StringTokenizer(line," ");

        N = Integer.valueOf(st.nextToken());
        K = Integer.valueOf(st.nextToken());

        words = new String[N];
        visited = new boolean[26];


        // 사용한 알파벳 저장
        visited['a'-'a']=true;
        visited['n'-'a']=true;
        visited['t'-'a']=true;
        visited['i'-'a']=true;
        visited['c'-'a']=true;

        for(int i=0;i<N;i++) {
            line = bf.readLine();
            words[i] = line.replaceAll("[antic]","");
        }
        maxNum=getMaxWords();
        for(int i=0;i<26;i++) {
            if(!visited[i]) {
                dfs(0);
            }
        }

        System.out.println(maxNum);

    }

}
*/

public class Main {

	static int N, K;
	static int selectedCount=0, maxNum=0;
	static String[] words;
	static boolean[] visited;

	public static void dfs(int index) {
		// 1.체크인 visited
		visited[index] = true;
		selectedCount++;
		// 2.목적지인가 selectedCount == K
		if(selectedCount==K) {
			int num = getMaxWords();
			if(maxNum<num) {
				maxNum = num;
			}
		}
		// 3.연결된 곳을 순회 index + 1 ~ 25
		// 	4.갈 수 있는가 visited
		//   5.간다 dfs
		for(int i=index+1;i<26;i++) {
			if(!visited[i]) {
				dfs(i);
			}
		}
		// 6.체크아웃 visited
		visited[index] = false;
		selectedCount--;

	}
    //선택된 알파벳으로 읽을 수 있는 단어 개수 구하기
	public static int getMaxWords() {
		int maxwords = 0;

		for(int i=0;i<N;i++) {
			maxwords++;
			for(int j=0;j<words[i].length();j++) {
				if(((int)words[i].charAt(j))-97<0 || ((int)words[i].charAt(j))-97 >26) {
					maxwords--;
					break;
				}
				if(!visited[((int)words[i].charAt(j))-97]) {
					maxwords--;
					break;
				}

			}
		}

		return maxwords;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line = bf.readLine();
		StringTokenizer st = new StringTokenizer(line," ");

		N = Integer.valueOf(st.nextToken());
		K = Integer.valueOf(st.nextToken());

		words = new String[N];
		visited = new boolean[26];

		for(int i=0;i<N;i++) {
			line = bf.readLine();
			words[i] = line;
		}


		dfs(0);

		System.out.println(maxNum);

	}

}
