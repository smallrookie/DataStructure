import java.util.ArrayList;

public class Main {

    private static double testSet(Set<String> set, String filename) {
        long startTime = System.nanoTime();
        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());
            for (String word: words)
                set.add(word);
            System.out.println("Total different words: " + set.getSize());
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) * 10e-9 * 1.0;
    }

    public static void main(String[] args) {
        String filename = "pride-and-prejudice.txt";

        BSTSet<String> bstSet = new BSTSet<>();
        double time1 = testSet(bstSet, filename);
        System.out.println("BSTSet: " + time1 + "s");

        System.out.println();

        LinkedListSet<String> listSet = new LinkedListSet<>();
        double time2 = testSet(listSet, filename);
        System.out.println("LinkedListSet: " + time2 + "s");
    }

}
