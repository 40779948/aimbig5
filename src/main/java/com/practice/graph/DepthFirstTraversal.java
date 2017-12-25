/**
 * 
 */
package com.practice.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * @author swamygorli
 *
 */
public class DepthFirstTraversal {

	private static void DFS(Graph<Integer> g) {
		Set<Long> visited = new HashSet<Long>();

		for (Vertex<Integer> vertex : g.getAllVertex()) {
			if (!visited.contains(vertex.getId()))
				DFSUtil(vertex, visited);
		}
	}

	private static void DFSUtil(Vertex<Integer> vertex, Set<Long> visited) {

		visited.add(vertex.getId());
		System.out.println(vertex);

		for (Vertex<Integer> adjacent : vertex.getAdjacentVertexes()) {
			if (!visited.contains(adjacent.getId()))
				DFSUtil(adjacent, visited);
		}

	}

	public static void main(String[] args) {

		Graph<Integer> graph = new Graph<Integer>(true);

		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 4);
		graph.addEdge(4, 6);
		graph.addEdge(6, 5);
		graph.addEdge(5, 3);
		DFS(graph);
	}
}