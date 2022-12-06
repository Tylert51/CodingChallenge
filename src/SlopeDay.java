import java.util.Scanner;
public class SlopeDay {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("How many seconds left until slope day?");
        int sec = s.nextInt();
        System.out.println(convertSeconds(sec));
    }

    public static String convertSeconds(int seconds) {
        if(seconds == 0) {
            return "NOW!";
        } else if (seconds >= Math.pow(10,9)) {
            return "Number too large!";
        } else if (seconds < 60) {
            return seconds + " seconds";
        } else if (seconds < 3600) {
            int min = seconds / 60;
            int sec = seconds % 60;
            return min + " minutes " + sec + " seconds";
        } else if (seconds < 86400) {
            int hrs = seconds / 3600;
            int min = (seconds - (hrs * 3600)) / 60;
            int sec = (seconds - (hrs * 3600)) % 60;
            return hrs + " hours " + min + " minutes " + sec + " seconds";
        } else {
            int days = seconds / 86400;
            int hrs = (seconds - (days * 86400)) / 3600;
            int leftOverSec = (seconds - ((days * 86400) + (hrs * 3600)));
            int min = leftOverSec / 60;
            int sec = leftOverSec % 60;
            return days + " days " + hrs + " hours " + min + " minutes " + sec + " seconds";
        }
    }
}
