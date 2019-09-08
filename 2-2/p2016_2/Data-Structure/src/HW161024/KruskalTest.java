package HW161024;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class KruskalTest {
	public static void main(String args[]) {
		UndirectWeightedGraph graph = new UndirectWeightedGraph();
		graph.readFile();
		graph.kruskal();
	}
}

