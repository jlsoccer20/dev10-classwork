import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Exercise01 {

    // LocalDate
    // ========================
    // Complete the numbered tasks below.
    // Open and execute the accompanying tests to confirm your solution is correct.

    //LocalDate today = LocalDate.now();

    // 1. return today's date
    LocalDate getToday() {
        return null;
    }

    // 2. return December 17, 1903 as a LocalDate
    LocalDate getFirstFlightDate() {
        return null;
    }

    // 3. if parameter is in the future, return null.
    // Otherwise, add 5 days to the parameter and return the result.
    LocalDate makeFutureNullShiftThePast(LocalDate date) {
        return null;
    }

    // 4. return the fifth Friday from the parameter date.
    // if the date is Friday, don't count it.
    LocalDate fiveFridaysFromDate(LocalDate date) {
        return null;
    }

    // 5. given a date and a count,
    // return a list of the next `fridayCount` Fridays after the date.
    // if the date is Friday, don't include it.
    List<LocalDate> getNextFridays(LocalDate date, int fridayCount) {
        // if date is friday, dont include
        if (date.getDayOfWeek() == DayOfWeek.FRIDAY){
            date = date.plusDays(1);
        }

        //Loop until Friday
        while (date.getDayOfWeek() != DayOfWeek.FRIDAY){
            date = date.plusDays(1);
        }

        List<LocalDate> results = new ArrayList<>();
        //do{
        //    results.add()
        //}

        return null;
    }

    // 6. return the absolute value of the days between two dates.
    // one may be before two, two may be before one, but neither will be null
    int getDaysBetween(LocalDate one, LocalDate two) {
        return Math.abs((int) one.until(two, ChronoUnit.DAYS));
    }

}
