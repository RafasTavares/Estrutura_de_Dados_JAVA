package hash;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Set;

public class HashDuplo<T> implements IHashDuplo<T> {

	private Hash<T>[] hash;
	private Hash<T> deletado;
	private int tam;
	private int contCarga;

	// private int[] chaves = new int[tam];
	public HashDuplo(int tam) {
		hash = new Hash[tam];
		this.tam = tam;
		// this.chaves = new int[tam];
		//

	}

	private int funcHash2(int num) {

		return 1 + (num % (tam - 1));
	}

	@Override
	public void clear() {
		for (int i = 0; i < hash.length - 1; i++) {
			hash[i] = deletado;
		}
	}

	@Override
	public boolean add(T obj) {
		double carga = contCarga / tam;
		if (carga >= 0.75) {
			Redimensionar();
			return true;

		}
		int pos = funcHash(obj.hashCode());

		if (hash[pos] == null || hash[pos].getDeletado()) {
			hash[pos] = new Hash<T>(obj.hashCode(), obj);
			// chaves[pos] = (Integer)obj;
			contCarga++;
			return true;
		} else {
			int posAtual = PosValida(pos, obj);
			hash[posAtual] = new Hash<T>(obj.hashCode(), obj);
			// chaves[posAtual] = (Integer)obj;
			contCarga++;
			return true;
		}

	}

	@Override
	public boolean remove(T obj) {
		int pos = funcHash(obj.hashCode());
		if (hash[pos] != null) {
			if (hash[pos].getElemento().equals(obj) && !hash[pos].getDeletado()) {
				hash[pos].setDeletado(true);
				contCarga--;
			} else {
				int posAtual = PosValida(pos, obj);
				hash[posAtual].setDeletado(true);
				contCarga--;
			}

			return true;

		} else
			return false;
		/*
		 * if (!hash[pos].getDeletado()) { if (hash[pos] == null) { return
		 * false;
		 * 
		 * } else if ((hash[pos].getElemento().equals(obj)) &&
		 * hash[pos].getDeletado() == false) { hash[pos].setDeletado(true); }
		 * return true; } else if (!hash[pos].getElemento().equals(obj)) {
		 * 
		 * int posAtual = PosValida(pos, obj); if ((hash[posAtual] != null ||
		 * hash[pos].getDeletado()) && hash[posAtual].getElemento().equals(obj))
		 * { hash[pos].setDeletado(true); } return true; } return false;
		 */
	}

	@Override
	public boolean contains(T obj) {
		int pos = funcHash(obj.hashCode());

		if (hash[pos] == null) {
			return false;

		} else if ((hash[pos].getElemento().equals(obj))
				&& hash[pos].getDeletado() == false) {
			return true;
		} else if (!hash[pos].getElemento().equals(obj)) {

			int posAtual = PosValida(pos, obj);
			if ((hash[posAtual] != null || hash[pos].getDeletado())
					&& hash[posAtual].getElemento().equals(obj)) {
				return false;
			}
		}

		return false;
	}

	public int PosValida(int pos, T obj) {
		int i = 1;
		int posAtual = pos;
		int h2 = funcHash2(obj.hashCode());

		while (hash[posAtual] != null
				&& !hash[posAtual].getElemento().equals(obj)) {

			posAtual = (pos + i * h2) % hash.length;
			i++;
		}
		return posAtual;

	}

	@Override
	public int funcHash() {
		// TODO Auto-generated method stub
		return 0;
	}

	private int funcHash(int num) {
		return num % tam;
	}

	public void Redimensionar() {
		int valor = tam;
		tam = tam + tam;
		HashDuplo<T> novoHash = new HashDuplo<T>(tam);
		for (int i = 0; i < valor - 1; i++) {
			if (hash[i] != null)
				novoHash.add(hash[i].getElemento());

		}
		hash = novoHash.hash;
	}

	public String ToString() {
		String resultado = "[";
		for (int i = 0; i < tam; i++) {
			if (hash[i] != null && hash[i].getDeletado() != true) {
				resultado = resultado + hash[i].getElemento();
				int cont = 0;
				cont = cont + 1;
				if (i < (tam - 1) && (cont - 1) < hash.length) {
					resultado = resultado + ", ";
				}
			}
		}
		return resultado + "]";
	}

	// PROVA - Quest - 2
	public T Retrive(int chave) {
		Object obj = (Object) chave;
		int pos = funcHash(obj.hashCode());

		if (hash[pos] == null) {
			return null;

		} else if ((hash[pos].getElemento().equals(obj))
				&& hash[pos].getDeletado() == false) {
			return hash[pos].getElemento();
		} else if (!hash[pos].getElemento().equals(obj)) {

			int posAtual = PosValida(pos, (T) obj);
			if ((hash[posAtual] != null && hash[posAtual].getDeletado() == false)
					&& hash[posAtual].getElemento().equals(obj)) {
				return hash[posAtual].getElemento();
			}
		}

		return null;
	}

	// PROVA - Quest 4
	public Set<T> Values() {
		// T[] ordenado = ((T[]) new Object[tam]);
		HashSet<T> values = new HashSet<T>();
		int[] vetor = new int[tam];
		for (int i = 0; i < this.tam; i++) {
			if (hash[i] != null && hash[i].getDeletado() == false) {
				vetor[i] = (Integer) hash[i].getElemento();
			}
		}
		 values.add((T) Ordenar(vetor));
	/*	for (int i = 0; i < this.tam; i++) {
			values.add((T) Ordenar(vetor));
		}*/
		return values;
	}

	public int[] Ordenar(int[] vetor) {
		for (int i = 0; i < this.tam - 1; i++) {
			for (int j = i; j <= this.tam - 1; j++) {
				if (vetor[i] > vetor[j]) {
					int temp = vetor[i];
					vetor[i] = vetor[j];
					vetor[j] = temp;
				}
			}
		}
		return vetor;
	}
}