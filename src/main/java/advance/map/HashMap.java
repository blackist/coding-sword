package advance.map;

/**
 * TODO 自定义 Hash Map
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/9/12
 */
public class HashMap<K, V> implements Map<K, V> {

	private int size = 0;

	private Entry<K, V>[] table;

	public HashMap() {
		table = new Entry[16];
	}

	@Override
	public V put(K k, V v) {
		int index = hash(k);
		Entry<K, V> entry = table[index];
		if (entry == null) {
			table[index] = new Entry<>(k, v, null, index);
		} else {
			table[index] = new Entry<>(k, v, entry, index);
		}
		size++;

		return table[index].getValue();
	}

	private int hash(K k) {
		int index = k.hashCode() % (16 - 1);
		return Math.abs(index);
	}

	@Override
	public V get(K k) {
		if (size == 0) {
			return null;
		}
		int index = hash(k);
		Entry<K, V> entry = getEntry(k, index);

		return entry == null ? null : entry.getValue();
	}

	private Entry<K, V> getEntry(K k, int index) {
		for (Entry<K, V> e = table[index]; e != null; e = e.next) {
			if (e.hash == index && (k == e.getKey() || k.equals(e.getKey()))) {
				return e;
			}
		}
		return null;
	}

	@Override
	public int size() {
		return size;
	}

	class Entry<K, V> implements Map.Entry<K, V> {

		K k;
		V v;
		Entry<K, V> next;
		int hash;

		public Entry(K k, V v, Entry<K, V> next, int hash) {
			this.k = k;
			this.v = v;
			this.next = next;
			this.hash = hash;
		}

		@Override
		public K getKey() {
			return k;
		}

		@Override
		public V getValue() {
			return v;
		}
	}
}
