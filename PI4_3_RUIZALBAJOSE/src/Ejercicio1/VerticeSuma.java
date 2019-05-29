package Ejercicio1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import us.lsi.graphs.SimpleEdge;
import us.lsi.graphs.VirtualVertex;

public class VerticeSuma implements VirtualVertex<VerticeSuma, SimpleEdge<VerticeSuma>> {

	private List<Integer> num;
	private Integer sumIzq;
	private Integer sumDer;
	private Integer pos;
	private List<Integer> listSumIzq;

	public VerticeSuma(List<Integer> num, Integer sumIzq, Integer sumDer, Integer pos, List<Integer> listSumIzq) {
		super();
		this.num = num;
		this.sumIzq = sumIzq;
		this.sumDer = sumDer;
		this.pos = pos;
		this.listSumIzq = listSumIzq;
	}

	public static VerticeSuma create(List<Integer> num, Integer sumIzq, Integer sumDer, Integer pos,
			List<Integer> listSumIzq) {
		return new VerticeSuma(num, sumIzq, sumDer, pos, new ArrayList<Integer>());
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return this.pos<= num.size();
	}

	@Override
	public Set<VerticeSuma> getNeighborListOf() {
		
		Set<VerticeSuma> s = new HashSet<VerticeSuma>();
		if(this.pos==this.num.size()) {
			return s;
		}
		List<Integer> nListSumIzq= new ArrayList<Integer>(this.listSumIzq);
		nListSumIzq.add(this.num.get(this.pos));
		
		s.add(new VerticeSuma(num, sumIzq+this.num.get(this.pos), sumDer, pos+1, nListSumIzq));
		nListSumIzq = new ArrayList<Integer>(this.listSumIzq);
		s.add(new VerticeSuma(num, sumIzq, this.sumDer + this.num.get(this.pos) , pos+1, nListSumIzq));
		
		return s;
	}

	@Override
	public Set<SimpleEdge<VerticeSuma>> edgesOf() {
		// TODO Auto-generated method stub
		return this.getNeighborListOf().stream().map(x->SimpleEdge.of(this,x)).collect(Collectors.toSet());
	}

public static Boolean esEstadoFinal(VerticeSuma v) {
	return v.pos== v.num.size() && v.sumIzq==v.sumDer;
}
public static Double pesoArista(SimpleEdge<VerticeSuma> v ) {
	VerticeSuma origen = v.source;
	VerticeSuma destino = v.target;
	Double res = 0.;
	if(origen.sumIzq<destino.sumDer) {
		res =1.;
	}
return res;
}
public Double getTam() {
	return (double) this.listSumIzq.size();
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((listSumIzq == null) ? 0 : listSumIzq.hashCode());
	result = prime * result + ((num == null) ? 0 : num.hashCode());
	result = prime * result + ((pos == null) ? 0 : pos.hashCode());
	result = prime * result + ((sumDer == null) ? 0 : sumDer.hashCode());
	result = prime * result + ((sumIzq == null) ? 0 : sumIzq.hashCode());
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
	VerticeSuma other = (VerticeSuma) obj;
	if (listSumIzq == null) {
		if (other.listSumIzq != null)
			return false;
	} else if (!listSumIzq.equals(other.listSumIzq))
		return false;
	if (num == null) {
		if (other.num != null)
			return false;
	} else if (!num.equals(other.num))
		return false;
	if (pos == null) {
		if (other.pos != null)
			return false;
	} else if (!pos.equals(other.pos))
		return false;
	if (sumDer == null) {
		if (other.sumDer != null)
			return false;
	} else if (!sumDer.equals(other.sumDer))
		return false;
	if (sumIzq == null) {
		if (other.sumIzq != null)
			return false;
	} else if (!sumIzq.equals(other.sumIzq))
		return false;
	return true;
}

@Override
public String toString() {
	return "VerticeSuma [listSumIzq=" + listSumIzq + "]";
}

}
