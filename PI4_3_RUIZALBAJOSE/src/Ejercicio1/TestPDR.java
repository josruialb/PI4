package Ejercicio1;

import java.util.Arrays;

import us.lsi.pd.AlgoritmoPD;

public class TestPDR {

	public static void main(String[] args) {
		AlgoritmoPD.isRandomize = false;
		
		Ejercicio1PDR e = Ejercicio1PDR.create(Arrays.asList(1, 3, 1, 1, 2, 5, 8, 10, 6,11));
		var a = AlgoritmoPD.createPDR(e);
		a.ejecuta();
		
		
		if(a.getSolucion()==null) {
			System.out.println("No hay solucion");
		}else{
			System.out.println("Solucion" + a.getSolucion() );
		}
		
	}

}
