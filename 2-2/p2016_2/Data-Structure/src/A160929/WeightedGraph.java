package A160929;

//  Data Structures with Java
//  by John R. Hubbard and Anita Huray
//  Copyright 2004 by Prentice Hall
//  chap16\list04\WeightedGraph.java

public class WeightedGraph {
	private Vertex start;

	private static class Vertex {
		Object object;
		Edge edges;
		Vertex nextVertex;
		boolean done;
		int dist;
		Vertex back;

		Vertex(Object object) {
			this.object = object;
		}

		public String toString() {
			return "(" + object + ":" + edges + "\n";
		}

		void printPath() {
			if (back == null)
				return;
			back.printPath();
			System.out.print("->" + object + "(" + dist + ")");
		}
	}

	private static class Edge {
		Vertex to;
		int weight;
		Edge nextEdge;


		Edge(Vertex to, int weight, Edge nextEdge) {
			this.to = to;
			this.weight = weight;
			this.nextEdge = nextEdge;
		}

		public String toString() {
			// 빈칸을 채우시오
			return (weight + "->" + to.object + (nextEdge == null ? ")" : "," + nextEdge));
		}
	}

	// 각각의 Edge와 Vertex를 초기화
	public WeightedGraph(String[] args) {
		Vertex v = start = new Vertex(args[0]);
		for (int i = 1; i < args.length; i++) {
			v = v.nextVertex = new Vertex(args[i]);
			v.dist = Integer.MAX_VALUE; // infinity
		}
	}

	// 두 개의 Vertex를 받아 연결
	public void addEdge(String vString, String wString, int weight) {
		Vertex v = find(vString);
		Vertex w = find(wString);
		// 빈칸을 채우시오: Vertex 타입의 w변수를 선언하고 find함수를 사용하여 정점wString이
		// 있다면 w에 저장
		v.edges = new Edge(w, weight, v.edges);
		
	}

	public void findShortestPaths() {
		// implements Dijkstra Algorithm:
		for (Vertex v = start; v != null; v = closestVertex()) {
			v.done = true;
			for (Edge e = v.edges; e != null; e = e.nextEdge) {
				Vertex w = e.to;
				if (!w.done  && w.dist > (v.dist + e.weight) ) 
						// 빈칸을 채우시오: 정점 w가 최단 경로가 정해져 있지 않고, 
						// 현재 간선 e의 가중치값과 정점 v의 dist값의 합이 w의 dist값보다 작으면
						
					{
						// 빈칸을 채우시오: w의 dist값을 v의 dist값과 e의 가중치값의 합으로 바꿈
						w.dist = (v.dist + e.weight);
						w.back = v;
					}
			}
		}
	}

	// 출력
	public void printPaths() {
		for (Vertex v = start.nextVertex; v != null; v = v.nextVertex) {
			System.out.print("\n" + start.object);
			v.printPath();
		}
		System.out.println();
	}

	// 출력
	public String toString() {
		StringBuffer buf = new StringBuffer();
		for (Vertex v = start; v != null; v = v.nextVertex)
			buf.append(v.toString());
		return buf + "";
	}

	// 입력받은(매개변수로 받은) Vertex가 v에 있는지 찾음
	private Vertex find(Object object) {
		// returns the vertex that contains the specified object:
		for (Vertex v = start; v != null; v = v.nextVertex)
			if (v.object.equals(object))
				return v;
		return null;
	}

	private Vertex closestVertex() {
		// returns the undone vertex with smallest dist field:
		Vertex v = null;
		int minDist = Integer.MAX_VALUE;
		for (Vertex w = start; w != null; w = w.nextVertex)
			if (!w.done && w.dist < minDist) {
				v = w;
				minDist = w.dist;
			}
		return v;
	}
}
