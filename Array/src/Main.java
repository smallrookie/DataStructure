public class Main {

    public static void main(String[] args) {
	// write your code here
        Array arr = new Array(20);
        for (int i = 0; i < 10; ++i) {
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(1, 1000);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);
    }
}
