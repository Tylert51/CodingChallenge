import java.util.Scanner;
import java.util.ArrayList;

public class GeminiBotsRunner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter you coordinates here: ");
        String input = s.nextLine();

        ArrayList<Integer> coords = new ArrayList<Integer>();
        coords = Point.getPoints(input);

        Point b1 = new Point(coords.get(0), coords.get(1));
        Point t1 = new Point(coords.get(2), coords.get(3));
        Point b2 = new Point(coords.get(4), coords.get(5));
        Point t2 = new Point(coords.get(6), coords.get(7));

        GeminiBots bot = new GeminiBots(b1, t1, b2, t2, 7);
        System.out.println(bot.solve());



    }
}