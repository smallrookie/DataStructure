import java.util.Random;

public class Main {

    // 测试使用stack运行opCount个push和pop操作所需时间，单位：秒
    private static double testStack(Stack<Integer> stack, int opCount) {

        long starTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }

        long endTime = System.nanoTime();
        return (endTime - starTime) / 10e9 * 1.0;
    }

    // 测试使用q运行opCount个enqueue和dequeue操作所需时间，单位：秒
    private static double testQueue(Queue<Integer> q, int opCount) {

        long starTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }

        long endTime = System.nanoTime();
        return (endTime - starTime) / 10e9 * 1.0;
    }

    public static void main(String[] args) {

//        LinkedList<Integer> linkedList = new LinkedList<>();
//        for (int i = 0; i < 5; i++) {
//            linkedList.addLast(i);
//            System.out.println(linkedList);
//        }
//
//        linkedList.add(2, 666);
//        System.out.println(linkedList);
//
//        linkedList.set(2, 999);
//        System.out.println(linkedList);
//
//        linkedList.remove(2);
//        System.out.println(linkedList);
//
//        linkedList.removeFirst();
//        System.out.println(linkedList);
//
//        linkedList.removeLast();
//        System.out.println(linkedList);

        int opCount = 100000;

//        ArrayStack<Integer> arrayStack = new ArrayStack<>();
//        double time_1 = testStack(arrayStack, opCount);
//        System.out.println("ArrayStack Time: " + time_1 + "s");
//
//        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
//        double time_2 = testStack(linkedListStack, opCount);
//        System.out.println("LinkedListStack Time: " + time_2 + "s");

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time_1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue Time: " + time_1 + "s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time_2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue Time: " + time_2 + "s");

        LinkdedListQueue<Integer> linkdedListQueue = new LinkdedListQueue<>();
        double time_3 = testQueue(linkdedListQueue, opCount);
        System.out.println("linkdedListQueue Time: " + time_3 + "s");
    }
}

