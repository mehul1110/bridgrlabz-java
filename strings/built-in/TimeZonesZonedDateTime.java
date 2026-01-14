import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeZonesZonedDateTime {
    public static void main(String[] args) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
        ZonedDateTime nowGmt = ZonedDateTime.now(ZoneId.of("GMT"));
        ZonedDateTime nowIst = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        ZonedDateTime nowPst = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));

        System.out.println("GMT: " + nowGmt.format(fmt));
        System.out.println("IST: " + nowIst.format(fmt));
        System.out.println("PST: " + nowPst.format(fmt));
    }
}
