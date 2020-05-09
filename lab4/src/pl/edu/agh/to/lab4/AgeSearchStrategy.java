package pl.edu.agh.to.lab4;

public class AgeSearchStrategy implements SearchStrategy {

    private int age;

    public AgeSearchStrategy(int age){
        this.age = age;
    }


    @Override
    public boolean filter(Suspect suspect) {
        if(suspect.getAge() == this.age) return true;
        return false;
    }

}
