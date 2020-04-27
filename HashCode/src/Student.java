public class Student {

    int grade;
    int cls;
    String firstName;
    String lastName;

    Student(int grade, int cls, String firstName, String lastName) {
        this.grade = grade;
        this.cls = cls;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int hashCode() {
        // 默认根据对象地址生成hashcode

        int B = 31;

        int hash = 0;
        hash = hash * B + grade;
        hash = hash * B + cls;

        // 区别大小写
        // hash = hash * B + firstName.hashCode();
        // hash = hash * B + lastName.hashCode();

        // 不区别大小写
        hash = hash * B + firstName.toLowerCase().hashCode();
        hash = hash * B + lastName.toLowerCase().hashCode();

        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        Student another = (Student)obj;
        return this.grade == another.grade &&
                this.cls == another.cls &&
                this.firstName.toLowerCase().equals(another.firstName.toLowerCase()) &&
                this.lastName.toLowerCase().equals(another.lastName.toLowerCase());

    }
}
