import java.time.*;
import java.util.*;

// Given a log file as below, find the list of customers that visited on 3 consecutive days.
// Can assume that the log file is sorted on timestamp

// UserId      datetime
// user1       01/01/2014 08:00:00
// user2       01/01/2014 08:00:00
// user1       01/03/2014 08:00:00

class UserVisits {

    public static void main(String... args) {
        Record[] logfile = new Record[20];
        logfile[0] = new Record("0", LocalDate.parse("2007-12-03"));
        logfile[1] = new Record("1", LocalDate.parse("2007-12-03"));
        logfile[2] = new Record("0", LocalDate.parse("2007-12-03"));
        logfile[3] = new Record("2", LocalDate.parse("2007-12-04"));
        logfile[4] = new Record("5", LocalDate.parse("2007-12-04"));
        logfile[5] = new Record("2", LocalDate.parse("2007-12-04"));
        logfile[6] = new Record("0", LocalDate.parse("2007-12-04"));
        logfile[7] = new Record("3", LocalDate.parse("2007-12-04"));
        logfile[8] = new Record("4", LocalDate.parse("2007-12-04"));
        logfile[9] = new Record("3", LocalDate.parse("2007-12-05"));
        logfile[10] = new Record("0", LocalDate.parse("2007-12-05"));
        logfile[11] = new Record("4", LocalDate.parse("2007-12-05"));
        logfile[12] = new Record("0", LocalDate.parse("2007-12-06"));
        logfile[13] = new Record("5", LocalDate.parse("2007-12-07"));
        logfile[14] = new Record("0", LocalDate.parse("2007-12-07"));
        logfile[15] = new Record("4", LocalDate.parse("2007-12-07"));
        logfile[16] = new Record("0", LocalDate.parse("2007-12-08"));
        logfile[17] = new Record("4", LocalDate.parse("2007-12-08"));
        logfile[18] = new Record("0", LocalDate.parse("2007-12-09"));
        logfile[19] = new Record("4", LocalDate.parse("2007-12-09"));

        System.out.println(Arrays.toString(frequentUsers(logfile)));
    }

    // O(N)
    static String[] frequentUsers(Record[] log) {
         
        HashMap<String, UserStats> statistics = new HashMap<>();
        List<String> frequentUsers = new ArrayList<>();
        
        for (Record record : log) {
            UserStats userStats = statistics.get(record.userId);
            if (userStats == null) {
                statistics.put(record.userId, new UserStats(record.visit, 1));  
            } else {
                if (userStats.count > 2 || record.visit.equals(userStats.visit)) {
                    continue;
                }
                if (isNextDay(record.visit, userStats.visit)) {
                    userStats.count++;
                    if (userStats.count == 3) {
                        frequentUsers.add(record.userId);
                    }
                } else {
                    userStats.count = 1;
                }
                userStats.visit = record.visit;
            }
        }
        
        return frequentUsers.toArray(new String[frequentUsers.size()]); 
    }

    public static boolean isNextDay(LocalDate day, LocalDate to) {
        return day.minusDays(1).equals(to);
    }
}


class UserStats {

    LocalDate visit;
    Integer count;

    UserStats (LocalDate visit, Integer count) {
        this.visit = visit;
        this.count = count;
    }
}

class Record {

    String userId;
    LocalDate visit;

    Record (String userId, LocalDate visit) {
        this.userId = userId;
        this.visit = visit;
    }
}

