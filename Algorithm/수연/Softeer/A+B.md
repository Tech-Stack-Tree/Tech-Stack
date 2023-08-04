### A+B

##### 문제  
두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.   
      
[A+B](https://softeer.ai/practice/info.do?idx=1&eid=362)  
    

``` java
import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine()); 

        for(int i=0; i<cnt; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            bw.write("Case #"+(i+1)+": "+(num1+num2)+"\n");
        }   
        bw.close();
    }
}

```
