/*가장 큰 수*/
import java.util.*;
class Solution {
    public String solution(int[] numbers) {

        String[] result = new String[numbers.length];

        for(int i=0;i<numbers.length;i++){
            result[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(result,(o1,o2)->(o2+o1).compareTo(o1+o2));

        if(result[0].equals("0")){
            return "0";
        }

        String answer="";
        for(String a:result){
            answer+=a;
        }

        return answer;
    }
}