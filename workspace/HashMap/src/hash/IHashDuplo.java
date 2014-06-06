package hash;

public interface IHashDuplo<T> {

	public void clear();
	public boolean add(T obj);
	public boolean remove(T obj);
	public boolean contains(T obj);
	public int funcHash();
	public String toString();

}
