import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        int a = 42;
        System.out.println(((Integer)a).hashCode());

        int b = -42;
        System.out.println(((Integer)b).hashCode());

        double c = 3.1415926;
        System.out.println(((Double)c).hashCode());

        String d = "imooc";
        System.out.println(d.hashCode());

        Student student = new Student(3, 2, "bobo", "Liu");
        System.out.println(student.hashCode());

        // 基于哈希表的集合
        HashSet<Student> set = new HashSet<>();
        set.add(student);

        // 基于哈希表的映射
        HashMap<Student, Integer> scores = new HashMap<>();
        scores.put(student, 100);
    }
}
