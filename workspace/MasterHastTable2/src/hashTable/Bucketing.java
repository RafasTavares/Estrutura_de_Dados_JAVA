package hashTable;
import java.util.*;

public class Bucketing<K,V> implements HashTable<K, V> {
	private HashTableNode<K,V>[] list ;
	private LinkedList<HashTableNode<K,V>> overflowArea ;
	private boolean[] tombstone ;
	private int slotNumber , slotNumberFunction;
	private int elementsNumber ;
	private final double maxLoadFactor = 0.75 ;
	private final int initial_size  = 10 ; // the initial size of the hash table array
	private final int increment_factor = 2 ; // used for resizing the hash table array
	private final int bucketSize = 2; // the number of slots of every bucket
	private int collisions;
	
	
	public Bucketing()
	{
		@SuppressWarnings("unchecked")
		HashTableNode<K,V>[] linkedLists = (HashTableNode<K, V>[])new HashTableNode[initial_size];
		list = linkedLists;
		overflowArea = new LinkedList<HashTableNode<K,V>>();
		tombstone = new boolean[initial_size];
		elementsNumber = 0;
		collisions = 0;
		slotNumberFunction = slotNumber = initial_size ;
	}

	private boolean maxLoadFactorExceeded()
	{
		if((double)elementsNumber/(double)slotNumber<=maxLoadFactor)
			return false;
		return true;
	}

	private void rehashing(HashTableNode<K,V>[] a,LinkedList<HashTableNode<K,V>> b)
	{
		Iterator<K> itr = keys().iterator();
		K key ;
		while(itr.hasNext())
		{
			key = itr.next();
			int start_position = rehashFunction(key);
			boolean found = false;
			
			for (int i=0; i<bucketSize;i++) {
				if (a[start_position+i]==null) {
					a[start_position+i] = new HashTableNode<K,V>(key,get(key));
					found = true;
					break;
				}
				++collisions;
			}
			if(!found)
				b.add(new HashTableNode<K,V>(key,get(key)));
		}

	}

	@Override
	public void put(K key, V value) {
		if(maxLoadFactorExceeded())
		{
			int newSize = list.length*increment_factor;
			@SuppressWarnings("unchecked")
			HashTableNode<K,V>[] lists = (HashTableNode<K, V>[])new HashTableNode[newSize];
			LinkedList<HashTableNode<K,V>> overflow = new LinkedList<HashTableNode<K,V>>();
			slotNumberFunction = newSize;
			rehashing(lists,overflow);
			list = lists;
			overflowArea = overflow;
			tombstone = new boolean[newSize];
			slotNumber = newSize;
			put(key,value);
		} else {
			/*i choosed the first design*/
			int start_position = hashFunction(key);
			boolean found = false;
			if(contains(key))
			{
				for (int i=0;i<bucketSize;i++) {
					if(list[start_position+i]!=null)
					{
						if(list[start_position+i].getKey().equals(key))
						{
							list[start_position+i].setValue(value);;
							found = true;
							break;
						}
						++collisions;
					}
				}
				if(!found)
				{
					for (HashTableNode<K,V> x: overflowArea) {
						if(x.equals(key))
						{
							x.setValue(value);
							break;
						}
						++collisions;
					}
				}
				
			} else {
				for (int i=0; i<bucketSize;i++) {
					if (list[start_position+i]==null) {
						list[start_position+i] = new HashTableNode<K,V>(key,value);
						tombstone[start_position+i] = false;
						found = true;
						break;
					}
					++collisions;
				}
				if(!found)
					overflowArea.add(new HashTableNode<K,V>(key,value));
				// increase the number of the elements
				++elementsNumber;
			}
		}	
	}

	@Override
	public V get(K key) {
		if(!contains(key)) return null;

		int start_position = hashFunction(key);
		boolean inOverFlowArea = false;
		HashTableNode<K,V> node ;
		
		for(int i=0;i<bucketSize;i++)
		{
			node = list[start_position+i];

			if(node.getKey().hashCode()==key.hashCode())
				return node.getValue();
			else if(node==null&tombstone[start_position+i])
				inOverFlowArea = true;
			else if(node==null&!tombstone[start_position+i]){
				return null;
			}
		}

		if (inOverFlowArea) {
			for (HashTableNode<K,V> x: overflowArea) {
				if(x.getKey().equals(key))
					return x.getValue();
			}
		}


		return null;
	}

	@Override
	public void delete(K key) {
		if(contains(key))
		{
			int start_position = hashFunction(key);
			HashTableNode<K,V> node ;
			boolean inOverFlowArea = false;
			for(int i=0;i<bucketSize;i++)
			{
				node = list[start_position+i];
				if(node!=null)
				{
					if(node.getKey().equals(key))
					{
						list[start_position+i] = null;
						tombstone[start_position+i] = true;
						--elementsNumber;
						return ; 
					}
				} else if(node==null&tombstone[start_position+i]) {
					inOverFlowArea = true;
				}
			}

			if (inOverFlowArea) {
				for (int i=0;i<overflowArea.size();i++) {
					node = overflowArea.get(i);
					if(node.getKey().equals(key))
					{
						overflowArea.remove(i);
						--elementsNumber ;
						return ;
					}
				}
			}

		}
	}

	@Override
	public boolean contains(K key) {
		int start_position = hashFunction(key);
		HashTableNode<K,V> node ;
		for (int i=0;i<bucketSize;i++) {
			node = list[start_position+i];
			
			if(node==null)
			{
				if(!tombstone[start_position+i])
					return false;
			} else {
				if(node.getKey().equals(key))
					return true;
			}
		}
		
		for (HashTableNode<K,V> x: overflowArea) {
			if(x.getKey().equals(key))
				return true;
		}
		
		
		return false;
	}

	@Override
	public boolean isEmpty() {
		return elementsNumber==0?true:false;
	}

	@Override
	public int size() {
		return elementsNumber;
	}

	@Override
	public Iterable<K> keys() {
		LinkedList<K> allKeys = new LinkedList<K>();
		for (HashTableNode<K,V> x: list) {
			if(x!=null)
				allKeys.add(x.getKey());
		}
		for(HashTableNode<K,V> x: overflowArea)
		{
			allKeys.add(x.getKey());
		}
		return allKeys;
	}

	private int hashFunction(K key) {
		return bucketSize*(key.hashCode()%(slotNumber/bucketSize));
	}
	
	private int rehashFunction(K key) {
		return bucketSize*(key.hashCode()%(slotNumberFunction/bucketSize));
	}

	@Override
	public int collisonsNumber() {
		return collisions;
	}

	@Override
	public int getMemoryInfo() {
		return slotNumber + overflowArea.size();
	}

}
