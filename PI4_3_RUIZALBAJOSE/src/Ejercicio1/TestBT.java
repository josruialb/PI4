package Ejercicio1;

import java.util.ArrayList;

import us.lsi.bt.AlgoritmoBT;

public class TestBT {
	public static void main(String[] args) {

		Ejercicio1BT b = Ejercicio1BT.create();

		
		
		AlgoritmoBT<SolucionBT, Integer, Ejercicio1BT> alg = AlgoritmoBT.create(b);
		alg.ejecuta();
		SolucionBT sol = SolucionBT.create(new ArrayList<>());
		System.out.println(sol);
		for (SolucionBT s : alg.getSoluciones()) {
			System.out.println(s);
		}
	}
}
