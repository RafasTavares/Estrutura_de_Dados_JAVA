package pilhaVet;

public class Pilha<T> implements IPilha{

	Vetor<T> vetor;
	int tam = 0;
	public Pilha (){
		vetor = new Vetor<T>(3);
	}
	
	@Override
	public void empilhe(Object objeto) {
		vetor.AdicionarInicio((T)objeto);
		tam++;
	}

	@Override
	public Object desempilhe() throws PilhaVaziaException {
		T elemento = (T) getTopo();
		vetor.RemoverInicio();
		tam--;
		return elemento;
	}

	@Override
	public Object getTopo() throws PilhaVaziaException {
		
		return vetor.hashCode();
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
	public boolean contem(Object objeto) {
		return vetor.contem((T)objeto);
		
	}
	@Override
	public String toString() {
		return vetor.toString();
	}

	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

}
