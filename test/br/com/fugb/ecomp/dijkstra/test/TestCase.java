package br.com.fugb.ecomp.dijkstra.test;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

import br.com.fugb.ecomp.dijkstra.models.Edge;
import br.com.fugb.ecomp.dijkstra.models.Vertex;

public class TestCase {

	@Test
	public void modelsTest() {
		Vertex initial = new Vertex("VÁ");
		Vertex destination = new Vertex("VÄ");
		
		assertTrue(!(String.valueOf(initial.hashCode()).equals(initial)));
		assertTrue(!(String.valueOf(destination.hashCode()).equals(destination)));
		
		System.out.println(initial);
		System.out.println(destination);
		
		int randomWeight1 = (int) (Math.random() * 100);
		int randomWeight2 = (int) (Math.random() * 100);
		
		Edge edge1 = new Edge(initial, destination, randomWeight1);
		Edge edge2 = new Edge("IDENTIFIER", initial, destination, randomWeight2);
		
		assertTrue(!(String.valueOf(edge1.hashCode()).equals(edge1)));
		assertTrue(!(String.valueOf(edge2.hashCode()).equals(edge2)));
		
		assertTrue(edge1.getInitial() == initial);
		assertTrue(edge1.getDestination() == destination);
		assertTrue(edge2.getInitial() == initial);
		assertTrue(edge2.getDestination() == destination);
		
		System.out.println(edge1);
		System.out.println(edge2);
	}

}
