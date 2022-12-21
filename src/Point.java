import java.util.ArrayList;

public class Point {
    private int xCoord;
    private int yCoord;

    public Point(int x, int y) {
        xCoord = x;
        yCoord = y;
    }

    public static ArrayList<Integer>  getPoints(String msg) {
        ArrayList<Integer> coords = new ArrayList<Integer>();
        String currentCoord = "";
        int numCoord;
        for (int i = 0; i < msg.length(); i++) {
            String letter = msg.charAt(i) + "";
            boolean isNum = !letter.equals(" ");
            if (isNum) {
                currentCoord += letter;
            } else {
                numCoord = Integer.parseInt(currentCoord);
                coords.add(numCoord);
                currentCoord = "";
            }
        }
        numCoord = Integer.parseInt(currentCoord);
        coords.add(numCoord);
        return coords;
    }

    public int getXCoord() {
        return xCoord;
    }

    public void setXCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public int getYCoord() {
        return yCoord;
    }

    public void setYCoord(int yCoord) {
        this.yCoord = yCoord;
    }
}