/**
 * 
 */
package com.practice.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author swamygorli
 *
 */
public class BreadthFirstTraversal {

	private static void BFS(Graph<Integer> g) {
		Set<Long> visited = new HashSet<Long>();
		Queue<Vertex<Integer>> queue = new LinkedList<Vertex<Integer>>();

		for (Vertex<Integer> vertex : g.getAllVertex()) {
			if (!visited.contains(vertex.getId())) {
				queue.add(vertex);
				visited.add(vertex.getId());

				while (!queue.isEmpty()) {
					System.out.println(queue.poll());
					for (Vertex<Integer> adjacent : vertex.getAdjacentVertexes()) {
						if (!visited.contains(adjacent.getId())) {
							queue.add(adjacent);
							visited.add(adjacent.getId());
						}
					}
				}
			}
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

		BFS(graph);

	}

}
