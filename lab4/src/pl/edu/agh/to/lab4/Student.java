package pl.edu.agh.to.lab4;

public class Student implements Suspect {

    private final String name;
    private final String surname;
    private final int age;
    private final int index;

    public Student(String name, String surname, int age, int index){
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.index = index;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getSurname() {
        return this.surname;
    }

    @Override
    public String display() {
        return this.name + " " + this.surname;
    }

    @Override
    public int getAge() {
        return this.age;
    }
}
