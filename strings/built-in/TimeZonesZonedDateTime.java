import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/*
 * Program to display current time in different time zones
 */
public class TimeZonesZonedDateTime {

    public static void main(String[] args) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
        
        // Get current times for specified time zones
        ZonedDateTime nowGmt = ZonedDateTime.now(ZoneId.of("GMT"));
        ZonedDateTime nowIst = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        ZonedDateTime nowPst = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));

        // Display formatted times for each zone
        System.out.println("GMT: " + nowGmt.format(fmt));
        System.out.println("IST: " + nowIst.format(fmt));
        System.out.println("PST: " + nowPst.format(fmt));
    }
}
