package br.ed.hashingEnc;

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
		if (fatorDeCarga() <= 75)
			hash = this.Redimensonar(hash);
		int posicao = funcHash(obj.hashCode());
		if (hash[posicao] != null) {
			no = inserir(posicao, obj);
		} else {
			hash[posicao] = new Hash<T>(posicao, no);
			hash[posicao].total++;
			total++;
		}
		return true;
	}

	public NoSimpEnc<T> inserir(int posicao, T obj) {
		NoSimpEnc<T> novoNo = new NoSimpEnc<T>(obj);
		NoSimpEnc<T> inicio = hash[posicao].elemento;
		while (inicio.getNext() != null) {
			inicio = inicio.getNext();
		}
		inicio.setNext(novoNo);
		hash[posicao].total++;
		return inicio;
	}

	public boolean removeMeio(int posicao, int posElemento) {
		NoSimpEnc<T> depois = hash[posicao].elemento;
		NoSimpEnc<T> antes = hash[posicao].elemento;
		NoSimpEnc<T> temp = hash[posicao].elemento;
		int cont = 0;
		if (posElemento <= 1) {
			if (posElemento == 1) {
				hash[posicao].elemento.setNext(null);
				hash[posicao].total--;
			} else {
				hash[posicao] = null;
				hash[posicao].total--;
			}
			return true;
		}
		if (posElemento == hash[posicao].total) {
			while (cont <= hash[posicao].total - 1) {
				hash[posicao].elemento.getNext();
				cont++;
			}
			hash[posicao].elemento = null;
			hash[posicao].total--;
			return true;
		}
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
			antes.getNext();
			hash[posicao].total--;
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

	public int fatorDeCarga() {
		return (total / hash.length) * 100;
	}

	private int funcHash(int chave) {
		return chave % hash.length;
	}

	private int buscarPosElemento(T obj) {
		NoSimpEnc<T> temp = null;
		for (int i = 0; i < hash.length; i++) {
			int count = 0;
			if (hash[i] != null) {
				temp = hash[i].elemento;
				while (temp != null) {
					if (temp != null && temp.getElement().equals(obj)) {
						return count;
					}
					temp = temp.getNext();
					count++;
				}
			}
		}
		return -1;
	}

	private Hash<T>[] Redimensonar(Hash<T>[] listaElementos) {
		Hash<T>[] arrayRedimensionar = (Hash<T>[]) new Object[this.hash.length
				+ total];
		System.arraycopy(listaElementos, 0, arrayRedimensionar, 0,
				listaElementos.length);
		listaElementos = arrayRedimensionar;
		return listaElementos;
	}
}