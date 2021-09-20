package JavaWeekendTasks;

import java.time.*;
import java.time.temporal.TemporalAdjusters;

/**
 * Written Questions:
 *
 * 1. LocalDateTime or ZonedDateTime classes can store all the way from
 *    years to nanoseconds.
 *
 * 2. You can find a previous thursday by using TemporalAdjusters:
 *     - TemporalAdjuster.previous(DayOfWeek.THURSDAY)
 *
 * 3. ZoneId can take into account special rules like daylight savings
 *    and previous transitions, whereas ZoneOffset is just a straight value
 *    describing the zone offset from the UTC.
 *
 * 4. You can convert an Instant to a ZonedDateTime by giving it a zone:
 *     - instant.atZone(ZoneId.of(zoneString));
 *    You can do the reverse by just converting to Instant:
 *     - ZonedDateTime.now().toInstant();
 */
public class DateTimeAPI {

    public void monthLengths(Integer year) {
        // check year is valid
        try {
            Year test = Year.of(year);
        } catch (Exception e) {
            System.out.println("Cannot parse year: " + year + "\n");
            return;
        }

        // print out months for the year
        System.out.println("Values for Year " + year + ":");
        for (Month m : Month.values()) {
            YearMonth month = YearMonth.of(year, m);
            System.out.println("  Month: " + month + ", Length: " + month.lengthOfMonth());
        }
        System.out.println();
    }

    public void listMondays(String m) {
        // check if month is valid
        Month month;
        try {
            month = Month.valueOf(m);
        } catch (Exception e) {
            System.out.println("Cannot parse month: " + m + "\n");
            return;
        }

        // start at first monday
        LocalDate date = Year.now().atMonth(month).atDay(1);
        date = date.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));

        // count all mondays
        System.out.println("List of Mondays in " + month + ":");
        Month countMonth = month;
        while (countMonth == month) {
            System.out.println("  " + date);
            date = date.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
            countMonth = date.getMonth();
        }
        System.out.println();
    }

    public void checkFriday13(LocalDate date) {
        // print the result of testing against Friday the 13th
        System.out.println(date + " occurs on Friday the 13th: " + (date.getDayOfWeek() == DayOfWeek.FRIDAY && date.getDayOfMonth() == 13));
    }

    // test Q's 5-7
    public static void main(String[] args) {
        DateTimeAPI homework = new DateTimeAPI();

        // length of months
        homework.monthLengths(2000);
        homework.monthLengths(2001);

        // mondays in a month
        homework.listMondays("JANUARY");
        homework.listMondays("MAY");
        homework.listMondays("JULYTOBER");

        // is it Friday the 13th
        homework.checkFriday13(Year.now().atMonth(5).atDay(13));
        homework.checkFriday13(Year.now().atMonth(8).atDay(13));
    }
}
