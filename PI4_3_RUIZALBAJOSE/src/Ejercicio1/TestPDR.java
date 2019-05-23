package Ejercicio1;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

import us.lsi.pd.AlgoritmoPD;

public class TestPDR {

	public static void main(String[] args) {
		AlgoritmoPD.isRandomize = false;

		Ejercicio1PDR e = Ejercicio1PDR.create(Arrays.asList(1, 3, 1, 1, 2, 5, 8, 10, 6, 11));
		var a = AlgoritmoPD.createPDR(e);
		a.ejecuta();
//		List<Integer> k = a.getSolucion(); 
//		List<Integer> kk2 = List.of(1, 3, 1, 1, 2, 5, 8, 10, 6, 11);
//		System.out.println(kk2.removeAll(k));

		if (a.getSolucion() == null) {
			System.out.println("No hay solucion");
		} else {
			System.out.println("Solucion" + a.getSolucion());
		}

	}

}
