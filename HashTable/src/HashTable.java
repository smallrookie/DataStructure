import java.util.TreeMap;

public class HashTable<K, V> {

    private static final int upperTol = 10;         // 平均每个hash地址冲突的上界
    private static final int lowerTol = 2;          // 平均每个hash地址冲突的下界
    private static final int initCapacity = 53;     // HashTable初始容量

    private TreeMap<K, V>[] hashtable;
    private int M;                            // HashTable容量
    private int size;                         // HashTable元素个数

    public HashTable(int M) {
        this.M = M;
        size = 0;
        hashtable = new TreeMap[M];
        for (int i = 0; i < M; ++i) {
            hashtable[i] = new TreeMap<>();
        }
    }

    public HashTable() {
        this(initCapacity);
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;     // 确保hashcode为正值
    }

    // 获得HashTable元素个数
    public int getSize() {
        return size;
    }

    // 添加元素
    public void add(K key, V value) {

        TreeMap<K, V> map = hashtable[hash(key)];
        if (map.containsKey(key)) {
            map.put(key, value);
        }
        else {
            map.put(key, value);
            size ++;

            if (size >= upperTol * M) {
                resize(2 * M);
            }
        }
    }

    // 删除元素
    public V remove(K key) {

        TreeMap<K, V> map = hashtable[hash(key)];
        V ret = null;
        if (map.containsKey(key)) {
            ret = map.remove(key);
            size --;

            if (size < lowerTol * M && M / 2 >= initCapacity) {
                resize(M / 2);
            }
        }

        return ret;
    }

    // 修改HashTable
    public void set(K key, V value) {

        TreeMap<K, V> map = hashtable[hash(key)];
        if (!map.containsKey(key)) {
            throw new IllegalArgumentException(key + " doesn't exist!");
        }
        map.put(key, value);
    }

    // HashTable是否含有key
    public boolean contains(K key) {
        return hashtable[hash(key)].containsKey(key);
    }

    // 获得key对应的value
    public V get(K key) {
        return hashtable[hash(key)].get(key);
    }

    // HashTable的动态空间处理
    private void resize(int newM) {

        TreeMap<K, V>[] newHashTable = new TreeMap[newM];
        for (int i = 0; i < newM; ++i) {
            newHashTable[i] = new TreeMap<>();
        }

        int oldM = M;
        this.M = newM;
        for (int i = 0; i < oldM; ++i) {
            TreeMap<K, V> map = hashtable[i];
            for (K key : map.keySet()) {
                newHashTable[hash(key)].put(key, map.get(key));
            }
        }

        this.hashtable = newHashTable;
    }
}
