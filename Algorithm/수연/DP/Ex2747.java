package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex2747 {
	public static int[] arr = new int[46];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int answer = fibonnaci(n);
		System.out.println(answer);
	}

	private static int fibonnaci(int n) {
		// TODO Auto-generated method stub
		if(n==0) {
			return 0;
		}
		if(n==1) {
			return 1;
		}
		if(arr[n]!=0){
			return arr[n];
		}
		
		return arr[n] = fibonnaci(n-1)+fibonnaci(n-2);
	}
}
