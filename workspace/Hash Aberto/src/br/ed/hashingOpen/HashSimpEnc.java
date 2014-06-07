package br.ed.hashingOpen;

public class HashSimpEnc<T> implements IHashDuplo<T> {
	private Hash<T>[] hash;
	private int total;

	public HashSimpEnc(int tamInicial) {
		hash = new Hash[tamInicial];
	}

	@Override
	public void clear() {
		for (int i = 0; i < hash.length; i++) {
			if (hash[i] != null) {
				hash[i] = null;
				total--;
			}
		}
	}

	@Override
	public boolean add(T obj) {
		NoSimpEnc<T> no = new NoSimpEnc<T>(obj);
		NoSimpEnc<T> noCabeca = new NoSimpEnc<T>();
		// if (fatorDeCarga() >= 75)
		// hash = this.Redimensonar(hash);
		int posicao = funcHash(obj.hashCode());
		if (hash[posicao] == null) {
			hash[posicao] = new Hash<T>(posicao, noCabeca);
			total++;
		}
		no = inserir(posicao, obj);
		return true;
	}

	public NoSimpEnc<T> inserir(int posicao, T obj) {
		NoSimpEnc<T> novoNo = new NoSimpEnc<T>(obj);
		NoSimpEnc<T> inicio = hash[posicao].elemento;
		NoSimpEnc<T> temp = hash[posicao].elemento;
		int count = 0;
		while (count < hash[posicao].total) {
			temp = temp.getNext();
			count++;
		}
		temp.setNext(novoNo);
		novoNo.setNext(inicio);
		hash[posicao].total++;
		return temp;
	}

	public boolean removeMeio(int posicao, int posElemento) {
		NoSimpEnc<T> depois = hash[posicao].elemento.getNext();
		NoSimpEnc<T> antes = hash[posicao].elemento;
		NoSimpEnc<T> temp = hash[posicao].elemento.getNext();
		int cont = 0;
		if (posElemento <= hash[posicao].total) {
			while (cont < hash[posicao].total - 1) {
				if (cont < posElemento)
					antes = temp;
				else if (cont == posElemento)
					depois = temp.getNext();
				temp = temp.getNext();
				cont++;
			}
			antes.setNext(depois);
			hash[posicao].total--;
			if (hash[posicao].total == 0) {
				hash[posicao] = null;
				total--;
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean remove(T obj) {
		int posicao = funcHash(obj.hashCode());
		int posElemento = buscarPosElemento(obj);
		boolean removeu = false;
		if (posElemento != -1) {
			removeu = removeMeio(posicao, posElemento);
		}
		return removeu;
	}

	@Override
	public boolean contains(T obj) {
		int posElemento = buscarPosElemento(obj);
		if (posElemento != -1)
			return true;
		else
			return false;
	}

	public int size() {
		return total;
	}

	public double fatorDeCarga() {
		return ((double) total / hash.length) * 100;
	}

	private int funcHash(int chave) {
		return chave % hash.length;
	}

	private int buscarPosElemento(T obj) {
		NoSimpEnc<T> temp = null;
		for (int i = 0; i < hash.length; i++) {
			int count = 0;
			if (hash[i] != null) {
				temp = hash[i].elemento.getNext();
				while (temp.getElement() != null && count < hash[i].total) {
					if (temp.getElement().equals(obj)) {
						return count;
					}
					temp = temp.getNext();
					count++;
				}
			}
		}
		return -1;
	}

	public String toString() {
		int count = 0;
		int i = 0;
		String element = "";
		String retorno = "";
		while (i < hash.length) {
			if (hash[i] != null) {
				element = "[";
				while (count < hash[i].total) {
					if (hash[i].total > 0 || count < hash[i].total) {
						element += hash[i].elemento.getNext().getElement();
					}
					if (count < hash[i].total - 1)
						element += ", ";
					count++;
				}
				element += "]";
				retorno += element + "\n";
			}
			count = 0;
			i++;
		}
		return retorno;
	}

	// private Hash<T>[] Redimensonar(Hash<T>[] listaElementos) {
	// Hash<T>[] arrayRedimensionar = (Hash<T>[]) Array.newInstance(
	// Hash.class, this.hash.length + total);
	// System.arraycopy(listaElementos, 0, arrayRedimensionar, 0,
	// listaElementos.length);
	// listaElementos = arrayRedimensionar;
	// return listaElementos;
	// }
}