public class Person {
    String name;
    int age;

    public Person(String line) {
        String[] person=line.split(" ");
        name=person[0];
        age=Integer.parseInt(person[1]);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name+" "+ age;
    }
}
