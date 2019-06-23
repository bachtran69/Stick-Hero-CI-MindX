public class Student {
    // thuoc tinh
    String name;
    int age;

    // ham tao
    public Student() {
        name = "Nguyen Van A";
        age = 20;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // phuong thuc
    void sleep() {
        System.out.println("Sleeping..");
    }

    void eat() {
        System.out.println("Eating..");
    }
}
