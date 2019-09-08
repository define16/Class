package HW161024;

public class Edge {
	char VERTEX_1;  // edge 의 정점 한쪽 점
	char VERTEX_2;  // edge 의 정점 다른 한쪽의 점
	int WEIGHT;     // edge 의 가중치

	// Edge 에 값을 입력하기 위한 생성자
	public Edge(char v1, int w, char v2) {
		VERTEX_1 = v1;
		VERTEX_2 = v2;
		WEIGHT = w;
	}

	public String toString() {
		return VERTEX_1 + "-" + VERTEX_2 + " 가중치:" + WEIGHT;
	}
}

