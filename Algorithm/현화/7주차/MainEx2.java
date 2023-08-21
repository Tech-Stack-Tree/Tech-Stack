import java.util.*;
//호텔 대실
class Solution {
    private static int HOUR = 60;
    private static int MAX_TIME = 1450;
    private static int CLEAN_TIME = 10;

    public int solution(String[][] book_time) {
        int answer = 0;
        int[] totalBooks = new int[MAX_TIME];
        for(String[] books : book_time){
            String inTime = books[0];
            String outTime = books[1];

            totalBooks[calTime(inTime)]+=1;
            totalBooks[calTime(outTime)+CLEAN_TIME]-=1;
        }

        for(int i=1;i<totalBooks.length;i++){
            //누적합
            totalBooks[i]+=totalBooks[i-1];
            answer = Math.max(answer, totalBooks[i]);
        }

        return answer;
    }

    private static int calTime(String time){
        String[] spTime = time.split(":");
        int hour=Integer.parseInt(spTime[0])*HOUR;
        int minute = Integer.parseInt(spTime[1]);
        return hour+minute;
    }
}