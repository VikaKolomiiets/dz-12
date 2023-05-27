package persontests;

import datesourse.DateForDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import personalization.Man;
import personalization.Person;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PersonGetFullAge {

    @Test(dataProviderClass = DateForDataProvider.class, dataProvider ="person-data-full-age")
    public void testPersonGetFullAgePositive(int year, int month, int day){
        int fullAges = (int) ChronoUnit.YEARS.between(LocalDate.of(year, month, day), LocalDate.now());

        Person person = new Man("Jon", "White", LocalDate.of(year, month, day));
        Assert.assertEquals(person.getFullAge(), fullAges, "Method getFullAge doesn't work");
        System.out.println("Full age is " + person.getFullAge() + ", if data of birth " + person.getDateOfBirth());
    }
}

