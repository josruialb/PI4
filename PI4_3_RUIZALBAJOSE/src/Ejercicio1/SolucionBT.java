package Ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class SolucionBT{

	public static List<List<Integer>> solucion;

	
	 public static SolucionBT create() {
		 return new SolucionBT();
	 }
	public static SolucionBT create(List<List<Integer>> sol) {
		return new SolucionBT(solucion);

	}

	private SolucionBT(List<List<Integer>> sol) {
		solucion = new ArrayList<List<Integer>>(sol);

	}

	public SolucionBT() {
	}
	@Override
	public String toString() {
		return "" + solucion;
		
	}
}
