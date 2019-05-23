package Ejercicio1;

import java.util.ArrayList;
import java.util.List;

import us.lsi.bt.EstadoBT;
import us.lsi.common.Lists2;

public class Ejercicio1BT implements EstadoBT<List<Integer>, Integer, Ejercicio1BT> {

	public static List<Integer> numeros = List.of(1, 3, 1, 1, 2, 5, 8, 10, 6, 11);

	private List<Integer> ls;
//	private List<Integer> subls0;
//	private List<Integer> subls1;
	private Integer sum0;
	private Integer sum1;
	private Integer pos;


	public Ejercicio1BT(List<Integer> numeros,List<Integer> ls, Integer sum0, Integer sum1, Integer pos) {
		super();
		Ejercicio1BT.numeros = numeros;
		this.ls = ls;
		this.sum0 = sum0;
		this.sum1 = sum1;
		this.pos = pos;
	}

	public static Ejercicio1BT create() {
		return new Ejercicio1BT(numeros, new ArrayList<Integer>(), 0, 0, 0);
	}

	@Override
	public Tipo getTipo() {
		return Tipo.Min;
	}

	@Override
	public Ejercicio1BT getEstadoInicial() {
		return create();
	}

	@Override
	public Ejercicio1BT avanza(Integer a) {
		Integer e = numeros.get(pos);
		if (a == 1) {
			ls.add(e);
			sum0 = sum0 + e;
		} else {
			sum1 = sum1 + e;
		}
		pos = pos + 1;
		return this;
	}

	@Override
	public Ejercicio1BT retrocede(Integer a) {
		pos = pos - 1;
		Integer e = numeros.get(pos);
		if (a == 1) {
			ls.remove(ls.size() - 1);
			sum0 = sum0 - e;
		} else {
			sum1 = sum1 - e;
		}
		return this;
	}

	@Override
	public int size() {
		return numeros.size() - pos;
	}

	@Override
	public boolean esCasoBase() {

		return pos == numeros.size();
	}

	@Override
	public List<Integer> getAlternativas() {
		List<Integer> res = new ArrayList<Integer>();
		res.add(0);
		res.add(1);
		return res;
	}

	@Override
	public List<Integer> getSolucion() {
		if (sum0 == sum1) {
			return Lists2.newList(this.ls);
		}
		return null;

	}

	public Double getObjetivo() {
		return (double) this.ls.size();

	}
}