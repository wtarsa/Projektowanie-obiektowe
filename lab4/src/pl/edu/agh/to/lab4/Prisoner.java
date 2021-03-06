package pl.edu.agh.to.lab4;

import java.util.Calendar;

public class Prisoner implements Suspect{
    private final int judgementYear;

    private final int sentenceDuration;

    private final String personalID;

    private final String name;

    private final String surname;

    private int age;

    public Prisoner(String name, String surname, String pesel, int judgementYear, int sentenceDuration) {
        this.name = name;
        this.surname = surname;
        this.personalID = pesel;
        this.judgementYear = judgementYear;
        this.sentenceDuration = sentenceDuration;
    }

    public String getPersonalID() {
        return personalID;
    }

    public boolean isSuspicious() {
        return judgementYear + sentenceDuration >= getCurrentYear();
    }

    public int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String display() {
        return this.name + " " + this.surname;
    }

    @Override
    public int getAge() {
        this.age = getCurrentYear() - (1900+Integer.parseInt(this.personalID.substring(0, 2)));
        if(this.age > 100) this.age -= 100;
        return this.age;
    }

}
