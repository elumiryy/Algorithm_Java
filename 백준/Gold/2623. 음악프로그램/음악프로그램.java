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
	static int N, M; // N : 가수의 수, M : 보조 PD의 수
	static List<Integer> result; // 최종 순서 결과
	static int[] degree; // 진입차수 관리 배열
	static List<Integer>[] node; // 연결된 노드 정보 저장
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	result = new ArrayList<>();
    	degree = new int[N + 1];
    	node = new ArrayList[N + 1];
        
        // 리스트 초기화
        for (int i = 1; i <= N; i++) {
            node[i] = new ArrayList<>();
        }
    	
    	// 연결된 노드, 진입차수 설정
    	for (int i = 0; i < M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int cnt = Integer.parseInt(st.nextToken());
    		int before = 0;
    		for (int j = 0; j < cnt; j++) {
    			int num = Integer.parseInt(st.nextToken());
 
    			// 시작되는 노드의 경우
    			if (before == 0) {
    				before = num;
    				continue;
    			}
    			// 어떤 노드에 연결돼있는 노드의 경우
    			degree[num]++; // 차수 증가
    			node[before].add(num); // 이전 노드에 연결
    			before = num;
    		}
    	}
    	
    	// 진입차수가 0인 노드를 큐에 삽입
    	Queue<Integer> q = new LinkedList<>();
    	for (int i = 1; i <= N; i++) {
    		if (degree[i] == 0) {
    			q.add(i);
    		}
    	}
    	
    	while (!q.isEmpty()) {
    		int cur = q.poll();
    		result.add(cur); // 결과에 추가
    		for (int i : node[cur]) {
    			degree[i]--; // 연결된 노드의 차수 감소
    			// 만약 차수가 0이라면 큐에 삽입
    			if (degree[i] == 0) {
    				q.add(i);
    			}
    		}
    	}
    	
    	if (result.size() != N) {
    		sb.append(0);
    	}
    	else {    		
    		for (int i : result) {
    			sb.append(i).append("\n");
    		}
    	}
    	
    	bw.write(String.valueOf(sb));
    	bw.flush();
    }
}