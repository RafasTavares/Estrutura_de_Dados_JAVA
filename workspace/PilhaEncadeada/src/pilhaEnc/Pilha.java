package pilhaEnc;

public class Pilha<T> implements IPilha {

	ListSimpEnc<T> lista;
	private int tam;
		public Pilha (){
		lista = new ListSimpEnc<T>();
		
	}
	
	@Override
	public void empilhe(Object objeto) {
		lista.InserirInicio((T) objeto);
		tam++;
	}

	@Override
	public Object desempilhe() throws PilhaVaziaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getTopo() throws PilhaVaziaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean estaVazia() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contem(Object objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

}
