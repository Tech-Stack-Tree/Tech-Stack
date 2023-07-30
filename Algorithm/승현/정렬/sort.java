//프로그래머스 정렬-1
import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

    for(int a =0; a<commands.length; a++) {
		int i,j,k;
		i = commands[a][0];
		j = commands[a][1];
		k = commands[a][2];
		
		int[] temp = Arrays.copyOfRange(array, i-1, j);
		Arrays.sort(temp);
		answer[a] = temp[k-1];
}
return answer;
    }
}
