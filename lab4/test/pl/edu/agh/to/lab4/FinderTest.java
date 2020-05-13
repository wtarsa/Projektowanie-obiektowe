package pl.edu.agh.to.lab4;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FinderTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private PrintStream originalOut;

    private PersonDataProvider personDataProvider = new PersonDataProvider();
    private PrisonersDatabase prisonerDatabase = new PrisonersDatabase();
    private StudentDataProvider studentDataProvider = new StudentDataProvider();

    private Finder suspectFinder = new Finder();

    @Test
    public void testDisplayingNotJailedPrisoner() {
        prisonerDatabase.addPrisoner("Wiezeienie stanowe", new Prisoner("Jan", "Kowalski", "802104543357", 2000, 1));
        CompositeSearchStrategy searchStrategy = new CompositeSearchStrategy();
        searchStrategy.addStrategy(new NameSearchStrategy("Jan"));
        ArrayList<Suspect> searchSuspects = (ArrayList<Suspect>) suspectFinder.display(searchStrategy);
        boolean contains = false;
        for(Suspect suspect: searchSuspects){
            contains = contains || suspect.display().equals("Jan Kowalski");
        }
        assertTrue(contains);
    }

    @Test
    public void testDisplayingSuspectedPerson() {
        personDataProvider.addPerson("Jan", "Kowalski", 20);
        CompositeSearchStrategy searchStrategy = new CompositeSearchStrategy();
        searchStrategy.addStrategy(new NameSearchStrategy("Jan"));
        ArrayList<Suspect> searchSuspects = (ArrayList<Suspect>) suspectFinder.display(searchStrategy);
        boolean contains = false;
        for(Suspect suspect: searchSuspects){
            contains = contains || suspect.display().equals("Jan Kowalski");
        }
        assertTrue(contains);
    }


    @Test
    public void testNotDisplayingTooYoungPerson() {
        personDataProvider.addPerson("Jan", "Kowalski", 15);
        CompositeSearchStrategy searchStrategy = new CompositeSearchStrategy();
        searchStrategy.addStrategy(new NameSearchStrategy("Jan"));
        ArrayList<Suspect> searchSuspects = (ArrayList<Suspect>) suspectFinder.display(searchStrategy);
        boolean contains = false;
        for(Suspect suspect: searchSuspects){
            contains = contains || (suspect.display().equals("Jan Kowalski") && suspect.getAge() > 18);
        }
        assertFalse(contains);
    }

    @Test
    public void testNotDisplayingJailedPrisoner() {
        personDataProvider.addPerson("Jan", "Kowalski", 20);
        prisonerDatabase.addPrisoner("Wiezeienie stanowe", new Prisoner("Jan", "Kowalski2", "802104543357", 2000, 21));
        CompositeSearchStrategy searchStrategy = new CompositeSearchStrategy();
        searchStrategy.addStrategy(new NameSearchStrategy("Jan"));
        ArrayList<Suspect> searchSuspects = (ArrayList<Suspect>) suspectFinder.display(searchStrategy);
        boolean contains = false;
        for(Suspect suspect: searchSuspects){
            contains = contains || (suspect.display().equals("Jan Kowalski2") && suspect instanceof Prisoner && !((Prisoner) suspect).isSuspicious());
        }
        assertFalse(contains);
    }

    private void assertContentIsDisplayed(String expectedContent) {
        assertTrue("Application did not contain expected content: " + outContent.toString(), outContent.toString()
                .contains(expectedContent));
    }

    private void assertContentIsNotDisplayed(String expectedContent) {
        assertFalse("Application did contain expected content although it should not: " + outContent.toString(), outContent.toString()
                .contains(expectedContent));
    }

    @Before
    public void redirectSystemOut() {
        suspectFinder.addDataProvider(personDataProvider);
        suspectFinder.addDataProvider(prisonerDatabase);
        suspectFinder.addDataProvider(studentDataProvider);
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void resetSystemOut() {
        System.setOut(originalOut);
    }

}
