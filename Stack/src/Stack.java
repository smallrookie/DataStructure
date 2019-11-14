public interface Stack<E> {

    // 获取栈的大小
    int getSize();

    // 栈是否为空
    boolean isEmpty();

    // 元素入栈
    void push(E e);

    // 元素出栈
    E pop();

    // 查看栈顶元素
    E peek();
}
