import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	char[] arr = br.readLine().toCharArray();
    	int sum = 0;
    	for (char c : arr) {
    		sum += Integer.parseInt(String.valueOf(c));
    	}
    	
    	System.out.println(sum);
    }
}