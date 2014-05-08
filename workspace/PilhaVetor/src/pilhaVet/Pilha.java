package pilhaVet;

public class Pilha<T> implements IPilha<T> {

	Vetor<T> vetor;
	int tam = 0;

	public Pilha() {
		vetor = new Vetor<T>(3);
	}

	@Override
	public void empilhe(T objeto) {
		vetor.AdicionarInicio(objeto);
		tam++;
	}

	@Override
	public T desempilhe() throws PilhaVaziaException {
		if (tam == 0)
			throw new PilhaVaziaException("");
		T elemento = getTopo();
		vetor.RemoverInicio();
		tam--;
		return elemento;
	}

	@Override
	public T getTopo() throws PilhaVaziaException {
		if (tam == 0)
			throw new PilhaVaziaException("");
		return vetor.GetPrimeiro();
	}

	@Override
	public int size() {
		return tam;
	}

	@Override
	public boolean estaVazia() {
		return tam == 0;
	}

	@Override
	public boolean contem(T objeto) {
		return vetor.contem(objeto);

	}

	@Override
	public String toString() {
		return vetor.toString();
	}

	public T[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

}
