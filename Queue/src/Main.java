import java.util.Random;

public class Main {

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

        int opCount = 100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time_1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue Time: " + time_1 + "s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time_2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue Time: " + time_2 + "s");
    }
}
