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
	static int[] cnt = new int[26];
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	char[] arr = br.readLine().toCharArray();
    	for (int i = 0; i < arr.length; i++) {
    		int code = (int) arr[i];
    		// 대문자이면
    		if (code < 97) {
    			cnt[code - 65]++;
    			continue;
    		}
    		// 소문자이면
    		cnt[code - 97]++;
    	}
    	
    	int index = 0;
    	int max = 0;
    	int count = 0;
    	for (int i = 0; i < cnt.length; i++) {
    		if (max < cnt[i]) {
    			index = i;
    			max = cnt[i];
    			count = 1;
    			continue;
    		}
    		if (max == cnt[i]) {
    			count++;
    		}
    	}

    	if (count != 1) {
    		System.out.println("?");
    	} else {
    		System.out.println((char) (index + 65));
    	}
    }
}