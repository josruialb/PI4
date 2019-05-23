package Ejercicio1;

import java.util.function.BiFunction;

import us.lsi.astar.AStarAlgorithm;
import us.lsi.graphs.SimpleEdge;

public class TestGV {

	public static void main(String[] args) {

//		VerticeSuma estadoInicial = VerticeSuma.create(0, 1, 2, 3, 4, 5, 6, 7, 8);
//		VerticeSuma estadoFinal = VerticeSuma.create(1, 2, 3, 4, 0, 5, 6, 7, 8);
//
//		System.out.println("Estado inicial\n" + estadoInicial);
//		System.out.println("Estado final\n" + estadoFinal);
//
//		var grafo = GrafoSuma.create(estadoInicial, estadoFinal);
//		BiFunction<VerticeSuma, VerticeSuma, Double> heuristica = (e1, e2) -> e1.getNumDiferentes(e2) - 1.; 
//		// es -1 porque aunque cambiemos 2 elementos, hacemos un solo movimiento
//
//		var alg = AStarAlgorithm.of(grafo, estadoInicial, estadoFinal, heuristica);
//
//		System.out.println("Vértices del camino mínimo:\n");
//		alg.getPathVertexList().forEach(v -> System.out.println(v + "\n"));
//
//		System.out.println("Número de movimientos:");
//		System.out.println(alg.getPath().getLength());
//
//		System.out.println("Vértices vecinos del estado inicial:");
//		var ss = grafo.edgesOf(estadoInicial);
//		for (SimpleEdge<VerticeSuma> simpleEdge : ss) {
//			System.out.println(Graphs.getOppositeVertex(grafo, simpleEdge, estadoInicial));
//		}
	}
}