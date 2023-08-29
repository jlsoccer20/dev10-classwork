import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class Exercise05 {

    // THE GODMOTHER
    // ========================
    // Complete the numbered tasks below.
    // Open and execute the accompanying tests to confirm your solution is correct.

    // 1. Your Godmother gives you $10 every other Friday throughout the year.
    // Payments start on the first Friday of the year.
    // Given a date, calculate payments expected from that date until the end of the year.
    BigDecimal calculateGiftsTilEndOfYear(LocalDate date) {
        // Find first friday of the year
        //LocalDate firstFriday = getFirstFridayOfYear();
        LocalDate firstFriday = LocalDate.of(date.getYear(), 1, 1);
        while (firstFriday.getDayOfWeek() != DayOfWeek.FRIDAY){
            firstFriday = firstFriday.plusDays(1);
        }


        LocalDate lastDay = LocalDate.of(date.getYear(), 12, 31);
        LocalDate current = firstFriday;
        BigDecimal total = BigDecimal.ZERO;
        do{
            if(!current.isBefore(date)){
                total = total.add(current.getDayOfMonth());
            }
            current = current.plusWeeks(2);
        } while (!lastDay.isBefore(current));
        return total;
    }

    // 2. Your Godmother is getting quirky. She adjusted her payment schedule.
    // She still pays every other Friday throughout the year, starting on the first Friday of the year.
    // But now, she pays a number of dollars equal to the day of the month.
    // Examples
    // Jan 31 == $31
    // Mar 1 == $1
    // July 12 == $12
    // Given a date, calculate payments expected from that date until the end of the year.
    BigDecimal calculateQuirkyGiftsTilEndOfYear(LocalDate date) {


        LocalDate firstFriday = LocalDate.of(date.getYear(), 1, 1);
        while (firstFriday.getDayOfWeek() != DayOfWeek.FRIDAY){
            firstFriday = firstFriday.plusDays(1);
        }


        LocalDate lastDay = LocalDate.of(date.getYear(), 12, 31);
        LocalDate current = firstFriday;
        BigDecimal total = BigDecimal.ZERO;
        do{
            if(!current.isBefore(date)){
                total = total.add(BigDecimal.valueOf(current.getDayOfMonth()));
            }
            current = current.plusWeeks(2);
        } while (!lastDay.isBefore(current));

        return total;


    }
    private BigDecimal calculateTotal(LocalDate firstFriday){
        LocalDate lastDay = LocalDate.of(firstFriday.getYear(),12,31);
        LocalDate current = firstFriday;
        BigDecimal total = BigDecimal.ZERO;

        do{
            if(!current.isBefore(firstFriday)){
                total = total.add(BigDecimal.valueOf(current.getDayOfMonth()))
            }
        }
    }
    private LocalDate getFirstFridayOfYear (LocalDate date){
        LocalDate firstFriday = LocalDate.of(date.getYear(),1,1);
    }

}
