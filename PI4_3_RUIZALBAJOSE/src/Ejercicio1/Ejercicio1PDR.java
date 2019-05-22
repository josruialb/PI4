package Ejercicio1;

import java.util.ArrayList;
import java.util.List;

import us.lsi.common.Lists2;
import us.lsi.pd.AlgoritmoPD.Sp;
import us.lsi.pd.AlgoritmoPD.Tipo;
import us.lsi.pd.ProblemaPDR;

/*PI4.1. Dado un conjunto de enteros determinar si puede particionarse en dos subconjuntos de manera
que la suma de elementos en ambos subconjuntos sea la misma, y que el tamaño de uno de ellos sea
lo menor posible. Como ejemplo concreto, teniendo el conjunto de enteros {1, 3, 1, 1, 2, 5, 8, 10, 6,
11}, una solución óptima se obtiene con los subconjuntos {5, 8, 11} = 24 ,  y {1, 3, 1, 1, 2, 10, 6}.= 24  // =24 no sale xd

	a) Implementar una solución mediante Programación Dinámica con Reducción.
	b) Implementar una solución mediante Backtracking.
	c) Implementar una solución mediante Grafos Virtuales.*/

public class Ejercicio1PDR implements ProblemaPDR<List<Integer>, Integer, Ejercicio1PDR> {

	public static List<Integer> listaNumeros;

	private List<Integer> ls;
	private Integer index;
	private Integer sum0;
	private Integer sum1;

//	public Ejercicio1PDR clone() {
//		Ejercicio1PDR newProblem = new Ejercicio1PDR(this.ls, this.index, this.sum0, this.sum1);
//		return newProblem;
//	}

	private Ejercicio1PDR(List<Integer> ls, Integer index, Integer sum0, Integer sum1) {
		super();
		this.ls = ls;
		this.index = index;
		this.sum0 = sum0;
		this.sum1 = sum1;
	}

	public Ejercicio1PDR(List<Integer> l) {
		this(l, 0, 0, 0);
		// TODO Auto-generated constructor stub
	}

	public static Ejercicio1PDR create(List<Integer> ls, Integer index, Integer sum0, Integer sum1) {
		return new Ejercicio1PDR(ls, index, sum0, sum1);
	}

	public static Ejercicio1PDR create(List<Integer> numeros) {
		Ejercicio1PDR.listaNumeros = numeros;
		return new Ejercicio1PDR(new ArrayList<>());
	}

	public Tipo getTipo() {
		return Tipo.Min;
	}

	@Override
	public int size() {
		return listaNumeros.size() - index;
	}

	@Override
	public boolean esCasoBase() {
		// TODO Auto-generated method stub
		return listaNumeros.size() == index;
	}

	@Override
	public Ejercicio1PDR getSubProblema(Integer a) {
		List<Integer> nl = Lists2.newList(ls);
		Integer nsum0 = sum0;
		Integer nsum1 = sum1;
		Integer e = listaNumeros.get(index);

		if (a == 1) {
			nl.add(e);
			nsum0 = nsum0 + e;

		} else {
			nsum1 = nsum1 + e;
		}
		return Ejercicio1PDR.create(nl, index + 1, nsum0, nsum1);
	}

	@Override
	public Sp<Integer> getSolucionParcialPorAlternativa(Integer a, Sp<Integer> s) {
		// TODO Auto-generated method stub
		if (a == 1) {
			return Sp.create(a, s.propiedad + 1);
		}
		return Sp.create(a, s.propiedad);

	}

	@Override
	public List<Integer> getAlternativas() {
		// TODO Auto-generated method stub
		List<Integer> res = new ArrayList<>();
		res.add(0);
		res.add(1);
		return res;

	}

	@Override
	public List<Integer> getSolucionReconstruidaCasoBase(Sp<Integer> sp) {

		return new ArrayList<>();

	}

	@Override
	public List<Integer> getSolucionReconstruidaCasoRecursivo(Sp<Integer> sp, List<Integer> s) {
		// TODO Auto-generated method stub
		
		if (sp.alternativa == 1) {
			Integer e = listaNumeros.get(index);
//s.add(0,e);
			s.add(e);
			
		}else {
		
		}
		return s;
	}

	@Override
	public Sp<Integer> getSolucionParcialCasoBase() {
		// TODO Auto-generated method stub
		if (this.sum0 == this.sum1) {
			return Sp.create(null, 0.0);
		}
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((index == null) ? 0 : index.hashCode());
		result = prime * result + ((ls == null) ? 0 : ls.hashCode());
		result = prime * result + ((sum0 == null) ? 0 : sum0.hashCode());
		result = prime * result + ((sum1 == null) ? 0 : sum1.hashCode());
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
		Ejercicio1PDR other = (Ejercicio1PDR) obj;
		if (index == null) {
			if (other.index != null)
				return false;
		} else if (!index.equals(other.index))
			return false;
		if (ls == null) {
			if (other.ls != null)
				return false;
		} else if (!ls.equals(other.ls))
			return false;
		if (sum0 == null) {
			if (other.sum0 != null)
				return false;
		} else if (!sum0.equals(other.sum0))
			return false;
		if (sum1 == null) {
			if (other.sum1 != null)
				return false;
		} else if (!sum1.equals(other.sum1))
			return false;
		return true;
	}

}
