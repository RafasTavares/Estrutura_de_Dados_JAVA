package hashTable;
import java.util.*;

public class SeparateChaining<K,V> implements HashTable<K, V> {
	private LinkedList<HashTableNode<K,V>>[] list ;
	private int slotNumber , slotNumberFunction ;
	private int elementsNumber ;
	private final int maxLoadFactor = 3 ;
	private final int initial_size  = 10 ;
	private final int increment_factor = 2;
	private int collisions;

	public SeparateChaining()
	{
		@SuppressWarnings("unchecked")
		LinkedList<HashTableNode<K,V>>[] linkedLists = (LinkedList<HashTableNode<K,V>>[])new LinkedList[initial_size];
		list = linkedLists;
		elementsNumber = 0;
		collisions = 0;
		slotNumberFunction = slotNumber = initial_size;
		for (int i = 0; i < list.length; i++) {
			list[i] = new LinkedList<HashTableNode<K,V>>();
		}
	}

	// return the number of the slots in the hash table
	private int getListSize()
	{
		return list.length;
	}

	// apply the same steps of the put function but on the new larger hash table
	private void rehashing(LinkedList<HashTableNode<K,V>>[] newList)
	{
		for (int i = 0; i < newList.length; i++) {
			newList[i] = new LinkedList<HashTableNode<K,V>>();
		}
		Iterator<K> itr = keys().iterator();
		K key;
		while(itr.hasNext())
		{
			key = itr.next();
			int position = rehashFunction(key);
			newList[position].add(new HashTableNode<K,V>(key, get(key)));
		}

	}

	@Override
	public void put(K key, V value) {
		if(maxLoadFactor*slotNumber>=elementsNumber)
		{	
			// the load is smaller than the max load factor so add the element normally

			// apply the hash function of the key
			int position = hashFunction(key);
			
			// boolean to check if the element is already existed in the hash table
			// a better way to implement is to call contains function to check if the
			// element is already existed in the hash table instead of hard code it
			boolean checkIfExcisted = false;
			
			// iterate over the array and check if the element exists
			for(HashTableNode<K,V> node : list[position])
			{
				if(node.getKey().equals(key)){
					checkIfExcisted = true;
					node.setValue(value);
					break;
				}
				// increment the number of collision because we hit a wrong place
				// in other words a collision occurred
				++collisions;
			}
			// if not existed (checkIfExcisted==false) then add it the slot number linked list
			if(!checkIfExcisted){
				elementsNumber++;
				list[position].add(new HashTableNode<K,V>(key,value));
			}
				
		} else {
			System.out.println("max load factor entered");
			// make the array bigger by the increment factor and then re-hashing
			int newSize = getListSize()*increment_factor;
			
			// Construct the new linked list of the hash table
			@SuppressWarnings("unchecked")
			LinkedList<HashTableNode<K,V>>[] linkedLists = (LinkedList<HashTableNode<K,V>>[])new LinkedList[newSize];
			slotNumberFunction = newSize; // must be before the @hashInNewList because it depends on @slotNumber
			
			// apply rehashing 
			rehashing(linkedLists);
			
			// assign the pointers to the new hash table
			slotNumber = newSize;
			list = linkedLists;
			// apply put function after rehashing on the new hash table
			put(key,value);
		}
	}

	@Override
	public V get(K key) {
		// apply the hash function on the key
		int position = hashFunction(key);

		// check if the key is already existed in the hash table
		for(HashTableNode<K,V> x: list[position])
		{
			if(x.getKey().equals(key))
				return x.getValue();
		}
		// not found return null
		return null;
	}

	@Override
	public void delete(K key) {
		// apply the hash function on the key
		int position = hashFunction(key);

		// iterate over the hash table to check if existed delete it
		for (int i=0;i<list[position].size();i++) {
			if(list[position].get(i).getKey().equals(key))
			{
				list[position].remove(i);
				// Decreasing the elements number after deletion
				--elementsNumber;
				break;
			}
		}
	}


	@Override
	public boolean contains(K key) {
		// apply the hash function on the key
		int position = hashFunction(key);

		// iterate over the hash table and check if existed
		for(HashTableNode<K,V> x: list[position])
		{
			// if existed return true
			if(x.getKey().equals(key))
				return true;
		}
		// not existed return false
		return false;
	}

	@Override
	public boolean isEmpty() {
		// if the elements number = 0 then the hash table is empty
		return elementsNumber==0?true:false;
	}

	@Override
	public int size() {
		// return the number of the elements in the hash table
		return elementsNumber;
	}

	@Override
	public Iterable<K> keys() {
		// return a linked list contains all the nodes in the hash table
		LinkedList<K> allKeys = new LinkedList<K>();
		for (int i=0; i<list.length;i++ ) {
			for (HashTableNode<K,V> x: list[i]) {
				allKeys.add(x.getKey());
			}
		}
		return allKeys;
	}

	// hashFunction used in normal put function
	private int hashFunction(K key) {
		return key.hashCode()%slotNumber;
	}
	
	// hashFunction used in rehashing 
	private int rehashFunction(K key) {
		return key.hashCode()%slotNumberFunction;
	}

	//return the number of the collisions occared
	@Override
	public int collisonsNumber() {
		return collisions;
	}

	// reutrn the number of the nodes in the list which descrips the 
	// memory used in the hash table
	@Override
	public int getMemoryInfo() {
		int mem_size = 0;
		for(int i=0;i<list.length;i++)
			mem_size += (list[i].size()==0?1:list[i].size());

		return mem_size;
	}

}
