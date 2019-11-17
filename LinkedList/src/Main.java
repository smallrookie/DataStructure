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

        int opCount = 10000000;

        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time_1 = testStack(arrayStack, opCount);
        System.out.println("ArrayStack Time: " + time_1 + "s");

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time_2 = testStack(linkedListStack, opCount);
        System.out.println("LinkedListStack Time: " + time_2 + "s");
    }
}

