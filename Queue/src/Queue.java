public interface Queue<E> {

    // 获取队列大小
    int getSize();

    // 队列是否为空
    boolean isEmpty();

    // 元素进队
    void enqueue(E e);

    // 元素出队
    E dequeue();

    // 访问队列第一个位置的元素
    E getFront();
}
