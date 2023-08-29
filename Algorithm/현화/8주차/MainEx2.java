import java.util.*;

class Solution {
    public String[] solution(String[] record) {


        ArrayList<String> chatLog = new ArrayList<>();

        int count=0;

        HashMap<String,String> nickname = new HashMap<String,String>();

        for(int i=0;i<record.length;i++){
            String token = record[i].split(" ")[0];
            if(!token.equals("Leave")){
                String userId = record[i].split(" ")[1];
                String nick = record[i].split(" ")[2];
                nickname.put(userId,nick);
            }
        }

        for(int j=0;j<record.length;j++){
            String token = record[j].split(" ")[0];
            String userId = record[j].split(" ")[1];
            String nick = nickname.get(userId);
            switch(token){
                case "Enter":
                    chatLog.add(nick+"님이 들어왔습니다.");
                    break;
                case "Leave":
                    chatLog.add(nick+"님이 나갔습니다.");
                    break;
            }
        }

        String[] result= new String[chatLog.size()];
        int n=0;
        for(String s:chatLog){
            result[n++]=s;
        }
        return result;
    }
}