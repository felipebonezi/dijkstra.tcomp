package br.com.fugb.ecomp.dijkstra.test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.fugb.ecomp.dijkstra.algorithm.DijkstraAlgorithm;
import br.com.fugb.ecomp.dijkstra.models.Edge;
import br.com.fugb.ecomp.dijkstra.models.Graph;
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
	
	@Test
	public void algorithmTest() {
		List<Vertex> vertexs = new ArrayList<Vertex>();
        Vertex vertex1 = new Vertex("V1");
        Vertex vertex2 = new Vertex("V2");
        Vertex vertex3 = new Vertex("V3");
        Vertex vertex4 = new Vertex("V4");
        Vertex vertex5 = new Vertex("V5");
        Vertex vertex6 = new Vertex("V6");
        Vertex vertex7 = new Vertex("V7");
        Vertex vertex8 = new Vertex("V8");
        Vertex vertex9 = new Vertex("V9");
        Vertex vertex10 = new Vertex("V10");
        Vertex vertex11 = new Vertex("V11");
       
        vertexs.add(vertex1);
        vertexs.add(vertex2);
        vertexs.add(vertex3);
        vertexs.add(vertex4);
        vertexs.add(vertex5);
        vertexs.add(vertex6);
        vertexs.add(vertex7);
        vertexs.add(vertex8);
        vertexs.add(vertex9);
        vertexs.add(vertex10);
        vertexs.add(vertex11);
       
        List<Edge> edges = new ArrayList<Edge>();
        Edge edge1 = new Edge("A1.2", vertex1, vertex2, 5);
        Edge edge2 = new Edge("A1.3", vertex1, vertex3, 6);
        Edge edge3 = new Edge("A2.1", vertex2, vertex1, 5);
        Edge edge4 = new Edge("A2.6", vertex2, vertex6, 4);
        Edge edge5 = new Edge("A3.1", vertex3, vertex1, 6);
        Edge edge6 = new Edge("A3.5", vertex3, vertex5, 6);
        Edge edge7 = new Edge("A3.4", vertex3, vertex4, 5);
        Edge edge8 = new Edge("A4.3", vertex4, vertex3, 5);
        Edge edge9 = new Edge("A4.8", vertex4, vertex8, 10);
        Edge edge10 = new Edge("A4.10", vertex4, vertex10, 1);
        Edge edge11 = new Edge("A5.3", vertex5, vertex3, 6);
        Edge edge12 = new Edge("A5.6", vertex5, vertex6, 9);
        Edge edge13 = new Edge("A5.8", vertex5, vertex8, 3);
        Edge edge14 = new Edge("A5.9", vertex5, vertex9, 2);
        Edge edge15 = new Edge("A6.2", vertex6, vertex2, 4);
        Edge edge16 = new Edge("A6.5", vertex6, vertex5, 9);
        Edge edge17 = new Edge("A6.7", vertex6, vertex7, 2);
        Edge edge18 = new Edge("A6.8", vertex6, vertex8, 6);
        Edge edge19 = new Edge("A6.5", vertex6, vertex5, 9);
        Edge edge20 = new Edge("A7.6", vertex7, vertex6, 2);
        Edge edge21 = new Edge("A7.8", vertex7, vertex8, 1);
        Edge edge22 = new Edge("A7.11", vertex7, vertex11, 7);
        Edge edge23 = new Edge("A8.4", vertex8, vertex4, 10);
        Edge edge24 = new Edge("A8.5", vertex8, vertex5, 3);
        Edge edge25 = new Edge("A8.6", vertex8, vertex6, 6);
        Edge edge26 = new Edge("A8.7", vertex8, vertex7, 1);
        Edge edge27 = new Edge("A8.11", vertex8, vertex11, 2);
        Edge edge28 = new Edge("A9.5", vertex9, vertex5, 2);
        Edge edge29 = new Edge("A9.10", vertex9, vertex10, 2);
        Edge edge30 = new Edge("A9.11", vertex9, vertex11, 6);
        Edge edge31 = new Edge("A10.4", vertex10, vertex4, 1);
        Edge edge32 = new Edge("A10.9", vertex10, vertex9, 2);
        Edge edge33 = new Edge("A11.7", vertex11, vertex7, 7);
        Edge edge34 = new Edge("A11.8", vertex11, vertex8, 2);
        Edge edge35 = new Edge("A11.9", vertex11, vertex9, 6);
       
        edges.add(edge1);
        edges.add(edge2);
        edges.add(edge3);
        edges.add(edge4);
        edges.add(edge5);
        edges.add(edge6);
        edges.add(edge7);
        edges.add(edge8);
        edges.add(edge9);
        edges.add(edge10);
        edges.add(edge11);
        edges.add(edge12);
        edges.add(edge13);
        edges.add(edge14);
        edges.add(edge15);
        edges.add(edge16);
        edges.add(edge17);
        edges.add(edge18);
        edges.add(edge19);
        edges.add(edge20);
        edges.add(edge21);
        edges.add(edge22);
        edges.add(edge23);
        edges.add(edge24);
        edges.add(edge25);
        edges.add(edge26);
        edges.add(edge27);
        edges.add(edge28);
        edges.add(edge29);
        edges.add(edge30);
        edges.add(edge31);
        edges.add(edge32);
        edges.add(edge33);
        edges.add(edge34);
        edges.add(edge35);
        
        Graph graph = new Graph(vertexs, edges);
        List<Vertex> shortestPath = DijkstraAlgorithm.calculate(graph, vertex1, vertex8);
        for (Vertex vertex : shortestPath) {
        	System.out.println(vertex);
        }
	}

}
