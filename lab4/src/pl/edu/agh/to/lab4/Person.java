package pl.edu.agh.to.lab4;

public class Person {
    private final String name;

    private final String surname;

    private int age;

    public Person(String name, String surname, int age) {
        this.age = age;
        this.name = name;
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String display() {
        return name + " " + surname;
    }
}
