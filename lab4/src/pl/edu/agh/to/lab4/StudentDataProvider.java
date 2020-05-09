package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Iterator;

public class StudentDataProvider implements SuspectAggregate{

    private ArrayList<Suspect> students;

    public StudentDataProvider(){
        students = new ArrayList<>();
        students.add(new Student("Artur", "Woźny", 22, 291032));
        students.add(new Student("Bartosz", "Majewski", 21, 291232));
        students.add(new Student("Kamil", "Bereda", 20, 291013));
        students.add(new Student("Marian", "Baczal", 19, 291142));
        students.add(new Student("Wiktor", "Rafa", 21, 291266));
        students.add(new Student("Adam", "Burkot", 20, 291157));
    }

    @Override
    public Iterator<Suspect> iterator() {
        return this.students.iterator();
    }
}
