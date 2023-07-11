import java.util.*;

class Solution {

    public int solution(int k, int[] tangerine) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int answer = 1;

        for(int n : tangerine){
            hm.put(n,hm.getOrDefault(n,0)+1);
        }

        List<Integer> keySet = new ArrayList<>(hm.keySet());

        keySet.sort((o1,o2)->hm.get(o2).compareTo(hm.get(o1)));
        int n=0;
        for (int key : keySet) {
            n += hm.get(key);
            if(n>=k){
                break;
            }
            answer++;
        }

        return answer;

    }
}