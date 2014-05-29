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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Vertex other = (Vertex) obj;
		if (identifier == null) {
			if (other.identifier != null)
				return false;
		} else if (!identifier.equals(other.identifier))
			return false;
		
		return true;
	}
	
	@Override
	public String toString() {
		return this.identifier;
	}
	
}
