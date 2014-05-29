package br.com.fugb.ecomp.dijkstra.models;

/**
 * Classe responsável por guardar a referência do Vértice utilizado no Grafo.
 * @author Felipe Bonezi <felipebonezi@gmail.com>
 *
 */
public class Vertex {

	/**
	 * Identificador utilizado na impressão do nome do vértice.
	 */
	private String identifier;
	
	public Vertex(String identifier) {
		this.identifier = identifier;
	}
	
	@Override
	public String toString() {
		return this.identifier;
	}
	
}
