/**
 * 
 */
package com.practice.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author swamygorli
 *
 */
public class Graph<T> {
	private List<Edge<T>> allEdges;
	private Map<Long, Vertex<T>> allVertexes;
	boolean isDirected = false;

	public Graph(boolean isDirected) {
		allEdges = new ArrayList<Edge<T>>();
		allVertexes = new HashMap<Long, Vertex<T>>();
		this.isDirected = isDirected;
	}

	public void addVertex(Vertex<T> vertex) {

		if (allVertexes.containsKey(vertex.getId()))
			return;
		allVertexes.put(vertex.getId(), vertex);

		for (Edge<T> edge : vertex.getEdges()) {
			allEdges.add(edge);
		}

	}

	public Vertex<T> addSingleVertex(long id) {

		if (allVertexes.containsKey(id))
			return allVertexes.get(id);

		Vertex<T> vertex = new Vertex<T>(id);
		allVertexes.put(id, vertex);
		return vertex;

	}

	public void setDataForVertex(long id, T data) {

		if (allVertexes.containsKey(id)) {
			Vertex<T> vertex = allVertexes.get(id);
			vertex.setData(data);

		}
	}

	public void addEdge(long id1, long id2, int weight) {

		Vertex<T> vertex1 = null;
		if (allVertexes.containsKey(id1)) {
			vertex1 = allVertexes.get(id1);
		} else {
			vertex1 = new Vertex<T>(id1);
			allVertexes.put(id1, vertex1);
		}

		Vertex<T> vertex2 = null;
		if (allVertexes.containsKey(id2)) {
			vertex2 = allVertexes.get(id2);
		} else {
			vertex2 = new Vertex<T>(id2);
			allVertexes.put(id2, vertex2);
		}

		Edge<T> edge = new Edge<T>(isDirected, vertex1, vertex2, weight);
		allEdges.add(edge);

		vertex1.addAdjacentVertex(edge, vertex2);
		if (!isDirected)
			vertex2.addAdjacentVertex(edge, vertex1);

	}

	public void addEdge(long id1, long id2) {
		addEdge(id1, id2, 0);
	}

	public Vertex<T> getVertex(long id) {
		return allVertexes.get(id);
	}

	public List<Edge<T>> getAllEdges() {
		return allEdges;
	}

	public Collection<Vertex<T>> getAllVertex() {
		return allVertexes.values();
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		for (Edge<T> edge : getAllEdges()) {
			buffer.append(edge.getVertex1() + " " + edge.getVertex2() + " " + edge.getWeight());
			buffer.append("\n");
		}
		return buffer.toString();
	}

}

@SuppressWarnings("rawtypes")
class Vertex<T> {

	private long id;
	private List<Edge<T>> edges = new ArrayList<>();;
	private List<Vertex<T>> adjacentVertexes = new ArrayList<>();;
	private T data;

	Vertex(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<Edge<T>> getEdges() {
		return edges;
	}

	public List<Vertex<T>> getAdjacentVertexes() {
		return adjacentVertexes;
	}

	public int getDegree() {
		return edges.size();
	}

	public void addAdjacentVertex(Edge<T> e, Vertex<T> v) {
		edges.add(e);
		adjacentVertexes.add(v);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public String toString() {
		return String.valueOf(id);
	}

}

@SuppressWarnings("rawtypes")
class Edge<T>

{

	private boolean isDirected;
	private Vertex<T> vertex1;
	private Vertex<T> vertex2;
	private int weight;

	Edge(boolean isDirected, Vertex<T> vertex1, Vertex<T> vertex2, int weight) {
		this.isDirected = isDirected;
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.weight = weight;
	}

	Edge(boolean isDirected, Vertex<T> vertex1, Vertex<T> vertex2) {
		this.isDirected = isDirected;
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
	}

	Edge(Vertex<T> vertex1, Vertex<T> vertex2, int weight) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
	}

	public Vertex<T> getVertex1() {
		return vertex1;
	}

	public Vertex<T> getVertex2() {
		return vertex2;
	}

	public int getWeight() {
		return weight;
	}

	public boolean isDirected() {
		return isDirected;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vertex1 == null) ? 0 : vertex1.hashCode());
		result = prime * result + ((vertex2 == null) ? 0 : vertex2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		if (vertex1 == null) {
			if (other.vertex1 != null)
				return false;
		} else if (!vertex1.equals(other.vertex1))
			return false;
		if (vertex2 == null) {
			if (other.vertex2 != null)
				return false;
		} else if (!vertex2.equals(other.vertex2))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Edge [isDirected=" + isDirected + ", vertex1=" + vertex1 + ", vertex2=" + vertex2 + ", weight=" + weight
				+ "]";
	}

}
