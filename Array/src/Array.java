public class Array {
    private int[] data;
    private int size;

    // 无参构造函数，默认数组容量capacity=10
    public Array() {
        this(10);
    }

    // 构造函数，传入数组的容量capacity构造Array
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    // 获取数组中的元素个数
    public int getSize() {
        return size;
    }

    // 获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    // 返回数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 向所有元素后添加一个新元素
    public void addLast(int e) {
//        if (size == data.length) {
//            throw new IllegalArgumentException("AddLast failed. Array is full.");
//        }
//        data[size] = e;
//        size++;

        add(size, e);
    }

    // 向所有元素前添加一个新元素
    public void addFirst(int e) {
        add(0, e);
    }

    // 在第index个位置插入一个新元素e
    public void add(int index, int e) {
        if (size == data.length) {
            throw new IllegalArgumentException("Add failed. Array is full.");
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Required index >= 0 and index <= size.");
        }
        for (int i = size - 1; i >= index; --i) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    // 获取index索引位置的元素
    int get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Required index >= 0 and index <= size.");
        }
        return data[index];
    }

    // 修改index索引位置的元素
    void set(int index, int e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Required index >= 0 and index <= size.");
        }
        data[index] = e;
    }

    // 打印输出Array数组
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; ++i) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }
}
