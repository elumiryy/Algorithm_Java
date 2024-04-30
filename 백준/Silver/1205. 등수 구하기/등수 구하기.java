import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	// N : 리스트에 있는 점수 , newScore : 태수의 새로운 점수, P : 랭킹 리스트에 올라갈 수 있는 점수의 개수, result : 정답
	static int N, newScore, P, rank;
	static Integer[] score;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		newScore = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		score = new Integer[N + 1];
		if (N == 0) {
			bw.write(String.valueOf(1));
			bw.flush();
			return;
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			score[i] = Integer.parseInt(st.nextToken());
		}
		// 입력 끝
		
		// 만약 점수가 랭킹 리스트에 올라갈 수 없을 정도로 낮다면 -1을 출력
		if (N == P && score[N - 1] >= newScore) {
			rank = -1;
			bw.write(String.valueOf(rank));
			bw.flush();
			return;
		}
				
		// 새 점수를 포함해서 비오름차순 정렬
		score[N] = newScore;
		Arrays.sort(score, Collections.reverseOrder());
		
		// 등수 구하기
		rank = 1;
		for (int i = 0; i < N; i++) {
			if (score[i] > newScore) {
				rank++;
				continue;
			}
			break;
		}
		
		bw.write(String.valueOf(rank));
		bw.flush();
	}
}