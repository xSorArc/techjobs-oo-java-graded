package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    Job testJob1 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"),
            new PositionType("Quality Control"), new CoreCompetency("Persistence"));
    Job testJob2 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"),
            new PositionType("Quality Control"), new CoreCompetency("Persistence"));

    @Test
    public void testSettingJobId() {
        Job emptyJob1 = new Job();
        Job emptyJob2 = new Job();
        assertNotEquals(emptyJob1, emptyJob2);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        // Use assertTrue and assertEquals statements to test that the constructor correctly assigns
        // both the class and value of each field. Your test should have 5 assert statements of each type.
        // The "instanceof" keyword can be used to check the class of an object.

        assertTrue(testJob1.getName() instanceof String);  // Replace with null check?
        assertEquals("Product Tester", testJob1.getName());

        assertTrue(testJob1.getEmployer() instanceof Employer);
        assertEquals("ACME", String.valueOf(testJob1.getEmployer()));

        assertTrue(testJob1.getLocation() instanceof Location);
        assertEquals("Desert", String.valueOf(testJob1.getLocation()));

        assertTrue(testJob1.getPositionType() instanceof PositionType);
        assertEquals("Quality Control", String.valueOf(testJob1.getPositionType()));

        assertTrue(testJob1.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", String.valueOf(testJob1.getCoreCompetency()));
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(testJob1.equals(testJob2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        // When passed a Job object, it should return a string that contains a blank line
        // before and after the job information.

        int indexLength = testJob1.toString().length();
        assertEquals(testJob1.toString().charAt(0), '\n');
        assertEquals(testJob1.toString().charAt(indexLength - 1), '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        // The string should contain a label for each field, followed by the data stored in that field.
        // Each field should be on its own line.

        assertEquals("\nID: 9\nName: Product Tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality " +
                "Control\nCore Competency: Persistence\n", testJob1.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        // If a field is empty, the method should add, “Data not available” after the label.

        Job emptyJob3 = new Job();
        emptyJob3.setName("Product Tester");
        assertEquals("\nID: 5\nName: Product Tester\nEmployer: Data not available\nLocation: Data not available" +
                "\nPosition Type: Data not available\nCore Competency: Data not available\n", emptyJob3.toString());
    }

    @Test
    public void BonusTest() {  //Rename test
        // (Bonus) If a Job object ONLY contains data for the id field, the method should return,
        // "OOPS! This job does not seem to exist."

        Job emptyJob4 = new Job();
        assertEquals("OOPS! This job does not seem to exist.", emptyJob4.toString());
    }
}
