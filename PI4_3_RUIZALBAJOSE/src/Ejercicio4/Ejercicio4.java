package Ejercicio4;

import java.util.ArrayList;

import java.util.List;

import us.lsi.pd.AlgoritmoPD.Sp;
import us.lsi.pd.AlgoritmoPD.Tipo;
import us.lsi.common.Preconditions;
import us.lsi.pd.ProblemaPD;

public class Ejercicio4 implements ProblemaPD<List<String>, Integer, Ejercicio4> {
	/*
	 * PI4.4. Dada una cadena encontrar una partición mínima en subcadenas tales que
	 * cada una de ellas sea un palíndromo. Como ejemplo concreto, para la entrada
	 * "ababbbabbababa", una partición mínima válida será: “a | bab | bbabb | ababa”
	 * 
	 * a) Implementar una solución mediante Programación Dinámica.
	 */

	private List<Character> ls;
	private Integer i;
	private Integer j;

	@Override
	public Tipo getTipo() {
		// TODO Auto-generated method stub
		return Tipo.Min;
	}

	public boolean esPalindromo(List<Character> t) {
		boolean res = true;
		int index;
		index = t.size();
		for (int i = 0; i < t.size(); i++) {
			if (!t.subList(i, i + 1).equals(t.subList(index - 1, index))) {
				res = false;
				break;
			}
			index = index - 1;
		}
		return res;

	}

	public Ejercicio4(List<Character> ls) {
		this.ls = ls;
	}

	public Ejercicio4(List<Character> ls, Integer inicio, Integer fin) {
		this.ls = ls;
		i = inicio;
		j = fin;
	}

	public static Ejercicio4 create(List<Character> ls, Integer i, Integer j) {
		return new Ejercicio4(ls, i, j);
	}

	public static Ejercicio4 create(List<Character> ls) {
		return new Ejercicio4(ls);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return j - i;
	}

	public Ejercicio4 getSubProblema(Integer a, int np) {
		// TODO Auto-generated method stub
		Preconditions.checkArgument(np < 2);
		if (np == 0) {
			return new Ejercicio4(this.ls, this.i, a);
		} else if (np == 1) {
			return new Ejercicio4(this.ls, a, this.j);
		}
		return null;
	}

	@Override
	public Sp<Integer> getSolucionParcialPorAlternativa(Integer a, List<Sp<Integer>> ls) {
		// TODO Auto-generated method stub
		return Sp.create(a, ls.get(0).propiedad + ls.get(1).propiedad);
	}

	@Override
	public int getNumeroSubProblemas(Integer a) {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public List<String> getSolucionReconstruidaCasoBase(Sp<Integer> sp) {
		// TODO Auto-generated method stub
		String s = "";
		List<String> res = new ArrayList<>();
		for (int k = i; k < j; k++) {
			s = s + this.ls.get(k);
		}
		res.add(s);
//		return Lists2.newList(s);
		return res;
	}

	@Override
	public List<String> getSolucionReconstruidaCasoRecursivo(Sp<Integer> sp, List<List<String>> ls) {
		ls.get(0).addAll(ls.get(1));
		return ls.get(0);
	}

	@Override
	public boolean esCasoBase() {
		// TODO Auto-generated method stub
		if (esPalindromo(this.ls.subList(this.i, this.j))) {
			return true;

		} else {
			return false;
		}
	}

	@Override
	public Sp<Integer> getSolucionParcialCasoBase() {
		// TODO Auto-generated method stub
		return Sp.create(null, 1.);
	}

	@Override
	public List<Integer> getAlternativas() {
		// TODO Auto-generated method stub
		List<Integer> a = new ArrayList<Integer>();
		for (int k = this.i + 1; k < this.j - 1; k++) {
			a.add(k);
		}

		return a;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((i == null) ? 0 : i.hashCode());
		result = prime * result + ((j == null) ? 0 : j.hashCode());
		result = prime * result + ((ls == null) ? 0 : ls.hashCode());
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
		Ejercicio4 other = (Ejercicio4) obj;
		if (i == null) {
			if (other.i != null)
				return false;
		} else if (!i.equals(other.i))
			return false;
		if (j == null) {
			if (other.j != null)
				return false;
		} else if (!j.equals(other.j))
			return false;
		if (ls == null) {
			if (other.ls != null)
				return false;
		} else if (!ls.equals(other.ls))
			return false;
		return true;
	}

}
