package Ejercicio1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

import us.lsi.astar.AStarAlgorithm;
import us.lsi.astar.AStarGraph;
import us.lsi.astar.AStarSimpleVirtualGraph;
import us.lsi.astar.PredicateHeuristic;
import us.lsi.graphs.SimpleEdge;

public class TestGV {

	public static void main(String[] args) {
		List<Integer> ls = Arrays.asList(1, 2, 3, 4, 0, 5, 6, 7, 8);
		VerticeSuma estadoInicial = VerticeSuma.create(ls, 0, 0, 0, new ArrayList<>());

		AStarGraph<VerticeSuma, SimpleEdge<VerticeSuma>> grafoEstrella = AStarSimpleVirtualGraph
				.of(v -> VerticeSuma.pesoArista(v));

		PredicateHeuristic<VerticeSuma> heuristica = (e1, e2) -> e1.getTam();
		// es -1 porque aunque cambiemos 2 elementos, hacemos un solo movimiento

		System.out.println("Vértices del camino mínimo:\n");

		AStarAlgorithm<VerticeSuma, SimpleEdge<VerticeSuma>> alg = AStarAlgorithm.of(grafoEstrella, estadoInicial, v-> VerticeSuma.esEstadoFinal(v), heuristica);


		VerticeSuma v = alg.getPathVertexList().get(alg.getPathVertexList().size() - 1);

		System.out.println(v);

	}
}