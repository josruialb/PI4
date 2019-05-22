package Ejercicio1;

import java.util.ArrayList;
import java.util.List;

import us.lsi.bt.EstadoBT;

public class Ejercicio1BT implements EstadoBT<SolucionBT, Integer, Ejercicio1BT> {
	public static List<Integer> listaNumeros;

	private List<Integer> ls;
	private Integer pos;
	private Double ls0;
	private Double ls1;
	private List<Integer> subls0;
	private List<Integer> subls1;
	private List<List<Integer>> solucion = new ArrayList<List<Integer>>();

	@Override
	public Tipo getTipo() {
		return Tipo.Min;
	}

	@Override
	public Ejercicio1BT getEstadoInicial() {
		return create();
	}

	public static Ejercicio1BT create() {
		return new Ejercicio1BT();

	}

	private Ejercicio1BT() {
		ls = List.of(1, 6, 3, 2);
		pos = 0;
		ls0 = 0.0;
		ls1 = 0.0;
		subls0 = new ArrayList<Integer>();
		subls1 = new ArrayList<Integer>();
		solucion = new ArrayList<List<Integer>>();

	}

	@Override
	public Ejercicio1BT avanza(Integer a) {
		if (a == 0) {
			subls0.add(ls.get(pos));
			if (!subls0.isEmpty()) {
				ls0 = ls0 + subls0.get(subls0.size() - 1);
			}

			pos = pos + 1;
		}
		if (a == 1) {
			subls1.add(ls.get(pos));
			if (!subls1.isEmpty()) {
				ls1 = ls1 + subls0.get(subls1.size() - 1);
			}

			pos++;
		}
		return this;
	}

	@Override
	public Ejercicio1BT retrocede(Integer a) {
		if (a == 0) {
			pos = pos - 1;
			if (!subls0.isEmpty()) {
				ls0 = ls0 - subls0.get(subls0.size() - 1);
				subls0.remove(subls0.size() - 1);
			}

		}
		if (a == 1) {
			pos = pos - 1;
			if (!subls1.isEmpty()) {
				ls1 = ls1 - subls1.get(subls1.size() - 1);
				subls1.remove(subls1.size() - 1);
			}
		}
		return this;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return ls.size() - pos;
	}

	@Override
	public boolean esCasoBase() {
		// TODO Auto-generated method stub

		return listaNumeros.size() == pos && (ls0.equals(ls1));
	}
	// boolean casoB = (pos == ls.size());
//		if (casoB && ls0.equals(ls1)) {
//			solucion.add(subls0);
//			solucion.add(subls1);
//			SolucionBT.create(solucion);
//		}
//		return casoB;
//	}

	@Override
	public List<Integer> getAlternativas() {
		List<Integer> res = new ArrayList<Integer>();
		res.add(0);
		res.add(1);
		return res;
	}

	@Override
	public SolucionBT getSolucion() {
		if (ls0.equals(ls1)) {
			solucion.add(subls0);
			solucion.add(subls1);
		}
		return SolucionBT.create(solucion);

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ls == null) ? 0 : ls.hashCode());
		result = prime * result + ((ls0 == null) ? 0 : ls0.hashCode());
		result = prime * result + ((ls1 == null) ? 0 : ls1.hashCode());
		result = prime * result + ((pos == null) ? 0 : pos.hashCode());
		result = prime * result + ((solucion == null) ? 0 : solucion.hashCode());
		result = prime * result + ((subls0 == null) ? 0 : subls0.hashCode());
		result = prime * result + ((subls1 == null) ? 0 : subls1.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ejercicio1BT other = (Ejercicio1BT) obj;
		if (ls == null) {
			if (other.ls != null)
				return false;
		} else if (!ls.equals(other.ls))
			return false;
		if (ls0 == null) {
			if (other.ls0 != null)
				return false;
		} else if (!ls0.equals(other.ls0))
			return false;
		if (ls1 == null) {
			if (other.ls1 != null)
				return false;
		} else if (!ls1.equals(other.ls1))
			return false;
		if (pos == null) {
			if (other.pos != null)
				return false;
		} else if (!pos.equals(other.pos))
			return false;
		if (solucion == null) {
			if (other.solucion != null)
				return false;
		} else if (!solucion.equals(other.solucion))
			return false;
		if (subls0 == null) {
			if (other.subls0 != null)
				return false;
		} else if (!subls0.equals(other.subls0))
			return false;
		if (subls1 == null) {
			if (other.subls1 != null)
				return false;
		} else if (!subls1.equals(other.subls1))
			return false;
		return true;
	}

}