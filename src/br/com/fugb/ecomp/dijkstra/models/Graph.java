package br.com.fugb.ecomp.dijkstra.models;

import java.util.List;

/**
 * Classe responsável por guardar a referência do Grafo.
 * @author Felipe Bonezi <felipebonezi@gmail.com>
 *
 */
public class Graph {

	private static final String DEFAULT_IDENTIFIER = "Dijkstra Graph";
	
	/**
	 * Identificador do grafo.
	 */
	private String identifier;
	
	/**
	 * Lista de todas as arestas que o grafo possui.
	 */
	private List<Edge> edges;
	
	/**
	 * Lista de todas os vértices que o grafo possui.
	 */
	private List<Vertex> vertex;
	
	public Graph(List<Vertex> vertex, List<Edge> edges) {
		this(DEFAULT_IDENTIFIER, vertex, edges);
	}
	
	public Graph(String identifier, List<Vertex> vertex, List<Edge> edges) {
		this.identifier = identifier;
		this.vertex = vertex;
		this.edges = edges;
	}
	
	public String getIdentifier() {
		return identifier;
	}

	public List<Vertex> getVertex() {
		return vertex;
	}
	
	public List<Edge> getEdges() {
		return edges;
	}
	
}
