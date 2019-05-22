package Ejercicio4;

import java.util.List;
import us.lsi.common.Lists2;
import us.lsi.pd.AlgoritmoPD;

public class TestPD {

	public static void main(String[] args) {
		AlgoritmoPD.isRandomize = false;
		List<Character> ls = Lists2.newList('a', 'b', 'a', 'b', 'b', 'b', 'a', 'b', 'b', 'a', 'b', 'a', 'b', 'a');
//		Ejercicio4 ej= Ejercicio4.create(Arrays.asList('a', 'b', 'a', 'b', 'b', 'b', 'a', 'b', 'b', 'a', 'b', 'a', 'b', 'a'));
		Integer i = 0;
		Integer j = ls.size();

		Ejercicio4 e = Ejercicio4.create(ls, i, j);
		var a = AlgoritmoPD.createPD(e);

		a.ejecuta();

		if (a.getSolucion() == null) {
			System.out.println("No hay solucion");
		} else {
			System.out.println("Solucion" + a.getSolucion());
		}

	}

}