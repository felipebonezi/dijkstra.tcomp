package br.com.fugb.ecomp.dijkstra.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.com.fugb.ecomp.dijkstra.models.Edge;
import br.com.fugb.ecomp.dijkstra.models.Graph;
import br.com.fugb.ecomp.dijkstra.models.Vertex;

public abstract class DijkstraAlgorithm {

	private static Set<Vertex> passedVertex;
	private static Set<Vertex> notPassedVertex;
	private static Map<Vertex, Integer> previousDistances;
	private static Map<Vertex, Vertex> vertexToVertex;
	private static List<Edge> edgesPath;
	
	static {
		passedVertex = new HashSet<Vertex>(25);
		notPassedVertex = new HashSet<Vertex>(25);
		previousDistances = new HashMap<Vertex, Integer>(25);
		vertexToVertex = new HashMap<Vertex, Vertex>(25);
		edgesPath = new ArrayList<Edge>(25);
	}
	
	public static List<Vertex> calculateShortestVertex(Graph graph, Vertex source, Vertex destination) {
		passedVertex.clear();
		notPassedVertex.clear();
		previousDistances.clear();
		vertexToVertex.clear();
		edgesPath.clear();
		
		calculateAllShortestsPaths(graph, source);
		return fillShortestVertexPath(source, destination);
	}
	
	public static List<Edge> calculateShortestEdges(Graph graph, Vertex source, Vertex destination) {
		passedVertex.clear();
		notPassedVertex.clear();
		previousDistances.clear();
		vertexToVertex.clear();
		edgesPath.clear();
		
		calculateAllShortestsPaths(graph, source);
		return fillShortestEdgesPath(graph, source, destination);
	}

	private static void calculateAllShortestsPaths(Graph graph, Vertex source) {
		previousDistances.put(source, 0);
		notPassedVertex.add(source);
		
		do {
			Vertex currentVertex = null;
			for (Vertex vertex : notPassedVertex) {
				if (currentVertex == null) {
					currentVertex = vertex;
				} else {
					Integer distanceA = previousDistances.get(vertex);
					if (distanceA == null)
						distanceA = Integer.MAX_VALUE;
					
					Integer distanceB = previousDistances.get(currentVertex);
					if (distanceB == null)
						distanceB = Integer.MAX_VALUE;
					
					currentVertex = (distanceA < distanceB ? vertex : currentVertex);
				}
			}
			
			passedVertex.add(currentVertex);
			notPassedVertex.remove(currentVertex);
			
			List<Vertex> vertexNeighborhood = new LinkedList<Vertex>();
			for (Edge edge : graph.getEdges()) {
				Vertex initial = edge.getInitial();
				Vertex destination = edge.getDestination();
				if (initial.equals(currentVertex) && !passedVertex.contains(destination)) {
					vertexNeighborhood.add(destination);
				}
			}
			
			for (Vertex vertex : vertexNeighborhood) {
				Integer vertexDistance = previousDistances.get(vertex);
				if (vertexDistance == null)
					vertexDistance = Integer.MAX_VALUE;
				
				Integer currentDistance = previousDistances.get(currentVertex);
				if (currentDistance == null)
					currentDistance = Integer.MAX_VALUE;
				
				Edge choosenEdge = null;
				for (Edge edge : graph.getEdges()) {
					Vertex initial = edge.getInitial();
					Vertex destination = edge.getDestination();
					if (initial.equals(currentVertex) && destination.equals(vertex)) {
						choosenEdge = edge;
						break;
					}
				}
				
				if (choosenEdge == null)
					throw new RuntimeException("ARRRRGH! :(");
				
				int weight = choosenEdge.getWeight();
				if (vertexDistance > (currentDistance + weight)) {
					previousDistances.put(vertex, (currentDistance + weight));
					vertexToVertex.put(vertex, currentVertex);
					notPassedVertex.add(vertex);
				}
			}
		} while(notPassedVertex.size() > 0);
	}
	
	private static List<Vertex> fillShortestVertexPath(Vertex source, Vertex destination) {
		Vertex vertex = vertexToVertex.get(destination);
		if (vertex == null)
			throw new RuntimeException("Holy shit, there's no path from " + source + " to " + destination);
		
		List<Vertex> shortestPath = new ArrayList<Vertex>();
		shortestPath.add(destination);
		do {
			shortestPath.add(vertex);
			vertex = vertexToVertex.get(vertex);
		} while (vertex != null);
		
		Collections.reverse(shortestPath);
		
		return shortestPath;
	}
	
	private static List<Edge> fillShortestEdgesPath(Graph graph, Vertex source, Vertex destination) {
		Vertex vertexTo = vertexToVertex.get(destination);
		Vertex vertexFrom = destination;
		if (vertexTo == null)
			throw new RuntimeException("Holy shit, there's no path from " + source + " to " + destination);
		
		do {
			for (Edge edge : graph.getEdges()) {
				Vertex from = edge.getInitial();
				Vertex to = edge.getDestination();
				if (from.equals(vertexTo) && to.equals(vertexFrom)) {
					vertexFrom = from;
					edgesPath.add(edge);
					break;
				}
			}
			vertexTo = vertexToVertex.get(vertexFrom);
		} while (vertexTo != null);
		
		Collections.reverse(edgesPath);
		
		return edgesPath;
	}
	
}
