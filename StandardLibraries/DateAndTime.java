import java.time.*;
import java.util.Date;
import java.time.format.DateTimeFormatter;
public class DateAndTime {
    public static void main(String[] args) {
        Date date = new Date(); // this is deprecated. so use time package
        System.out.println("Date: " + date);
        Instant start=Instant.now();
        System.out.println("Current timestamp is: " + start);
        LocalDate today=LocalDate.now();
        System.out.println("Today's date is: " + today);
        LocalTime now=LocalTime.now();
        System.out.println("Current time is: " + now);
        LocalDateTime currentDateTime=LocalDateTime.now();
        System.out.println("Current date and time is: " + currentDateTime);
        ZonedDateTime zonedDateTime=ZonedDateTime.now();
        System.out.println("Current date and time with timezone is: " + zonedDateTime);
        Duration duration=Duration.ofHours(5);
        System.out.println("Duration of 5 hours is: " + duration);
        Period period=Period.ofDays(10);
        System.out.println("Period of 10 days is: " + period);
        LocalDate nextDate = today.plus(Period.ofMonths(1));
        System.out.println("Date after 1 month: " + nextDate);
        LocalDate dateAfter10Days=today.plusDays(10);
        System.out.println("Date after 10 days: " + dateAfter10Days);
        LocalTime newTime = now.plus(Duration.ofMinutes(45));
        System.out.println("Time after adding 45 minutes: " + newTime);
        LocalTime timeAfter2Hours=now.plusHours(2);
        System.out.println("Time after 2 hours: " + timeAfter2Hours);
        LocalDateTime dateTimeAfter3DaysAnd4Hours=currentDateTime.plusDays(3).plusHours(4);
        System.out.println("Date and time after 3 days and 4 hours: " + dateTimeAfter3DaysAnd4Hours);
        ZonedDateTime zonedDateTimeAfter5DaysAnd6Hours=zonedDateTime.plusDays(5).plusHours(6);
        System.out.println("Zoned date and time after 5 days and 6 hours: " + zonedDateTimeAfter5DaysAnd6Hours);
        Instant instantAfter7Days=start.plusSeconds(7 * 24 * 60 * 60); // Instant has no format() method.
        System.out.println("Timestamp after 7 days: " + instantAfter7Days);

        System.out.println("\n=== Formatting Date and Time ===");
        LocalDateTime currentDateTimeNow=LocalDateTime.now();
        System.out.println("Before formatting: "+currentDateTimeNow.toString());
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");
        String formattedDate = currentDateTimeNow.format(myFormatObj);
        System.out.println("After formatting: "+formattedDate);

        Instant end=Instant.now();
        System.out.println("\nCurrent timestamp is: " + end);
        Duration executionTime = Duration.between(start, end); // time difference between two instant objects
        System.out.println("Execution time of this program is: " + executionTime.toMillis() + " milliseconds");
    }
}