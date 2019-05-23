package Ejercicio1;

import us.lsi.astar.AStarGraph;
import us.lsi.graphs.SimpleEdge;
import us.lsi.graphs.SimpleVirtualGraph;

public class GrafoSuma extends SimpleVirtualGraph<VerticeSuma, SimpleEdge<VerticeSuma>>  implements AStarGraph<VerticeSuma, SimpleEdge<VerticeSuma>> {

	public static GrafoSuma create(VerticeSuma... vertexSet) {
		return new GrafoSuma(vertexSet);
	}

	private GrafoSuma(VerticeSuma... vertexSet) {
		super(vertexSet);
	}

}
