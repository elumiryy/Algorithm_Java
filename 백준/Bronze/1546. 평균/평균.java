import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer strtk = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(strtk.nextToken());
		
		double score[] = new double[n]; 
		double avg, max = 0,sum = 0;
		
		strtk = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			score[i] = Double.parseDouble(strtk.nextToken());
			
			if(score[i]>max) 
				max = score[i]; 
		}
		
		for(int i=0;i<score.length;i++) {
			score[i] = (score[i]/max)*100;
			sum += score[i];
		}
		br.close();
		
		avg = sum / n;
		
		System.out.println(avg);
		
		
	}
}