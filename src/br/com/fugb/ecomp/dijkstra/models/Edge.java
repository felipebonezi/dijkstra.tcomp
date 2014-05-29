package br.com.fugb.ecomp.dijkstra.models;

public class Edge {

	private static final String DEFAULT_IDENTIFIER = "DIJKSTRA";

	/**
	 * Identificador da aresta.
	 */
	private String identifier;
	
	/**
	 * Ponto inicial.
	 */
	private Vertex initial;
	
	/**
	 *	Ponto de destino - final.
	 */
	private Vertex destination;
	
	/**
	 * O peso na utilização da aresta entre A e B.
	 * Podemos considerar várias unidades, mas neste exemplo
	 * iremos utilizar o conceito de kilometros.
	 */
	private int weight;
	
	public Edge(Vertex initial, Vertex destination, int weight) {
		this(DEFAULT_IDENTIFIER, initial, destination, weight);
	}
	
	public Edge(String identifier, Vertex initial, Vertex destination, int weight) {
		this.identifier = identifier;
		this.initial = initial;
		this.destination = destination;
		this.weight = weight;
	}

	public String getIdentifier() {
		return identifier;
	}

	public Vertex getInitial() {
		return initial;
	}

	public Vertex getDestination() {
		return destination;
	}

	public int getWeight() {
		return weight;
	}
	
	@Override
	public String toString() {
		return "[" + this.identifier + "] " + this.initial + " to " + this.destination + " using " + this.weight + "km.";
	}
	
}
