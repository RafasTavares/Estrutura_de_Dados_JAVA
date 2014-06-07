package hashTable;

public interface HashTable <K, V> {
	
	// put key-value pair into the table
	public void put(K key, V value);
	
	//get value paired with key, return null if 
	// hash don't contain key
	public V get(K key);

	//remove key and it's value from the table
	public void delete(K key);

	//return true if there is a value paired with that key
	//and false otherwise
	public boolean contains(K key);

	//return true if the table is empty
	public boolean isEmpty();

	//return the size of the table
	public int size();

	//return all keys in the hash table
	Iterable<K> keys();
	
	public int collisonsNumber();
	
	public int getMemoryInfo();
	
}
