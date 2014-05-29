package br.com.fugb.ecomp.dijkstra.models;

/**
 * Classe respons�vel por guardar a refer�ncia do V�rtice utilizado no Grafo.
 * @author Felipe Bonezi <felipebonezi@gmail.com>
 *
 */
public class Vertex {

	/**
	 * Identificador utilizado na impress�o do nome do v�rtice.
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
