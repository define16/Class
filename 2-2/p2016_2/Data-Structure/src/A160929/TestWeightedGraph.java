package A160929;

//  Data Structures with Java
//  by John R. Hubbard and Anita Huray
//  Copyright 2004 by Prentice Hall
//  chap16\list04\TestWeightedGraph.java

public class TestWeightedGraph {
	public TestWeightedGraph() {
		String[] vertices = { "0", "1", "2", "3", "4" }; // String 배열에 정점을 저장
		WeightedGraph g = new WeightedGraph(vertices); // WeightedGraph 객체 생성
		g.addEdge("0", "1", 2);
		g.addEdge("0", "2", 5);
		g.addEdge("0", "4", 3);
		g.addEdge("1", "3", 4);
		g.addEdge("1", "4", 10);
		g.addEdge("2", "3", 6);
		g.addEdge("2", "4", 2);
		g.addEdge("4", "3", 2);
		g.addEdge("4", "2", 1);
		
	
		String[] vertices2 = { "A", "B", "C", "D", "E","F","G","H" }; 
		WeightedGraph g2 = new WeightedGraph(vertices2);
		g2.addEdge("A", "B", 6);
		g2.addEdge("A","E",1);
		g2.addEdge("A","F",5);
		g2.addEdge("B","C",1);
		g2.addEdge("B","F",3);
		g2.addEdge("C","D",2);
		g2.addEdge("C","F",1);
		g2.addEdge("C","G",2);
		g2.addEdge("C","H",4);
		g2.addEdge("D","H",1);
		g2.addEdge("E","F",2);
		g2.addEdge("F","G",2);
		g2.addEdge("G","H",6);
		
		System.out.print(g);
		System.out.println();
		System.out.print(g2);
		
		g.findShortestPaths();
		g.printPaths();
		
		g2.findShortestPaths();
		g2.printPaths();
	}

	public static void main(String[] args) {
		new TestWeightedGraph();
	}
}

