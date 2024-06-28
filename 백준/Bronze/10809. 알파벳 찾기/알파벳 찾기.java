import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
    	int[] cntArr = new int[26];
    	Arrays.fill(cntArr, -1);
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	char[] arr = br.readLine().toCharArray();
    	
    	for (int i = 0; i < arr.length; i++) {
    		if (cntArr[arr[i] - 97] == -1) {
    			cntArr[arr[i] - 97] = i;
    		}
    	}
    	
    	for (int i : cntArr) {
    		System.out.print(i + " ");
    	}
    
    }
}