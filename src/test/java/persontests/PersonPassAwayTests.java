package persontests;

import datesourse.DateForDataProvider;
import exceptions.OutOfDataRangeException;
import org.testng.Assert;
import org.testng.annotations.Test;
import personalization.Person;
import personalization.Woman;

import java.time.LocalDate;

public class PersonPassAwayTests {

    @Test(dataProviderClass = DateForDataProvider.class, dataProvider = "years-birth-death")
    public void testPersonPassAwayPositive(int yearBirth, int yearDeath){
    Person person = new Woman("Anni","Bugatti", LocalDate.of(yearBirth, 12, 01));
    person.passAway(LocalDate.of(yearDeath, 01, 01));
        Assert.assertEquals(person.getDateOfDeath().getYear(), yearDeath, "Method pass away doesn't change date of daath");
    }

    @Test(dataProviderClass = DateForDataProvider.class, dataProvider = "years-birth-death")
    public void testPersonPassAwayException(int yearBirth, int yearDeath){
        Person person = new Woman("Anni","Bugatti", LocalDate.of(yearDeath, 12, 01));
        Assert.assertThrows(OutOfDataRangeException.class, () -> person.passAway(LocalDate.of(yearBirth, 01, 01)));
    }
}
