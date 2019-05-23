package Ejercicio1;

import java.util.ArrayList;
import java.util.List;

import us.lsi.bt.AlgoritmoBT;

public class TestBT {
	public static void main(String[] args) {

		AlgoritmoBT.conFiltro = false;
		AlgoritmoBT.isRandomize = false;
		AlgoritmoBT.numeroDeSoluciones = 1;

		Ejercicio1BT eIni = Ejercicio1BT.create();
		var a = AlgoritmoBT.create(eIni);
		a.ejecuta();

		List<Integer> ls = new ArrayList<>(Ejercicio1BT.numeros);
		for (int i = 0; i < ls.size(); i++) {
			for (int j = 0; j < a.getSolucion().size(); j++) {
				ls.remove(a.getSolucion().get(j));

			}
		}

		if (a.getSolucion() == null) {
			System.out.println("No hay solucion");
		} else {
			System.out.println("Solucion: " + a.getSolucion()+ls);

		}
	}

}