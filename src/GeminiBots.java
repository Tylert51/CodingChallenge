public class GeminiBots {

    private Point b1;
    private Point t1;

    private Point b2;
    private Point t2;
    private int max;
    private String answer;

    public GeminiBots(Point b1, Point t1, Point b2, Point t2, int max) {
        this.b1 = b1; this.t1 = t1;
        this.b2 = b2; this.t2 = t2;

        this.max = max;
        answer = "";
    }

    public String solve() {
        rotate2ndBoard();

        boolean isSolvable = canOrientX() && canOrientY();

        /*
        if (!isSolvable || !isOrientated()) {
            return "This is impossible";
        } else { */
            //if(!isOrientated()) {
                orientX();
                orientY();
            //}
            finishX();
            finishY();
        //}
        return answer;
    }

    private void rotate2ndBoard() {
        // this will allow the robots to be facing the same way and easier to solve

        int tempX = b2.getXCoord();
        int tempY = b2.getYCoord();

        b2.setXCoord(max - tempY);
        b2.setYCoord(tempX);

        tempX = t2.getXCoord();
        tempY = t2.getYCoord();

        t2.setXCoord(max - tempY);
        t2.setYCoord(tempX);
    }

    private boolean canOrientX() {
        // will return if the robot can be oriented on the x-axis
        int disBetweenBotsX = Math.abs(b2.getXCoord() - b1.getXCoord());
        int disBetweenGoalsX = Math.abs(t2.getXCoord() - t1.getXCoord());

        return disBetweenBotsX > disBetweenGoalsX;
    }

    private boolean canOrientY() {
        // will return if the robot can be oriented on the y-axis

        int disBetweenBotsY = Math.abs(b2.getYCoord() - b1.getYCoord());
        int disBetweenGoalsY = Math.abs(t2.getYCoord() - t1.getYCoord());

        return disBetweenBotsY > disBetweenGoalsY;
    }

    private void orientX() {
        // make the both robots same distance away from target x-wise
        String direction;
        int b1X = b1.getXCoord();
        int b2X = b2.getXCoord();

        int t1X = t1.getXCoord();
        int t2X = t2.getXCoord();

        int closestBot = whichClosestToWall(b1X, b2X);
        int closestWall = closestWall(closestBot);
        int movesTillWall = Math.abs(closestWall - closestBot);

        if (closestBot == b1X) {
            if (closestWall == 0) {
                direction = "L";
            } else {
                direction = "R";
            }
        } else {
            if (closestWall == 0) {
                direction = "D";
            } else {
                direction = "U";
            }
        }

        int disBetweenTarX = Math.abs(t2X - t1X);

        int extraDistance = Math.abs(b1X - b2X) - disBetweenTarX;

        int needToMove = movesTillWall + extraDistance;

        for (int i = 1; i <= needToMove; i++) {
            answer += direction + " ";
        }
    }

    private void orientY() {
        // make the both robots same distance away from target y-wise

        String direction;
        int b1Y = b1.getYCoord();
        int b2Y = b2.getYCoord();

        int t1Y = t1.getYCoord();
        int t2Y = t2.getYCoord();

        int closestBot = whichClosestToWall(b1Y, b2Y);
        int closestWall = closestWall(closestBot);
        int movesTillWall = Math.abs(closestWall - closestBot);

        if (closestBot == b1Y) {
            if (closestWall == 0) {
                direction = "D";
            } else {
                direction = "U";
            }
        } else {
            if (closestWall == 0) {
                direction = "R";
            } else {
                direction = "L";
            }
        }

        int disBetweenTarY = Math.abs(t2Y - t1Y);

        int extraDistance = Math.abs(b1Y - b2Y) - disBetweenTarY;

        int needToMove = movesTillWall + extraDistance;

        for (int i = 1; i <= needToMove; i++) {
            answer += direction + " ";
        }
    }

    private boolean isOrientated() {
        int disBetweenBotsX = Math.abs(b2.getXCoord() - b1.getXCoord());
        int disBetweenGoalsX = Math.abs(t2.getXCoord() - t1.getXCoord());

        int disBetweenBotsY = Math.abs(b2.getYCoord() - b1.getYCoord());
        int disBetweenGoalsY = Math.abs(t2.getYCoord() - t1.getYCoord());

        return (disBetweenBotsX == disBetweenGoalsX) && (disBetweenBotsY == disBetweenGoalsY);
    }

    private void finishX() {
        int b1X = b1.getXCoord();
        int t1X = t1.getXCoord();
        String direction;

        int diff = t1X - b1X;
        int absDiff = Math.abs(diff);

        if (diff > 0) {
            direction = "R";
        } else {
            direction = "L";
        }

        for (int i = 1; i <= absDiff; i++) {
            answer += direction + " ";
        }
    }

    private void finishY() {
        int b1Y = b1.getYCoord();
        int t1Y = t1.getYCoord();
        String direction;

        int diff = t1Y - b1Y;
        int absDiff = Math.abs(diff);

        if (diff > 0) {
            direction = "U";
        } else {
            direction = "D";
        }

        for (int i = 1; i <= absDiff; i++) {
            answer += direction + " ";
        }
    }



    /**
     * testing which coord is closest to a wall and will return that num
     * ex. (a = 5, b = 20) will return a since it is closest to a wall
     * @param b1 represents first coord
     * @param b2 represents second coord
     * @return either a or b, depending on which is closest to wall
     */
    private int whichClosestToWall(int b1, int b2) {
        int b1Diff = Math.abs(b1 - closestWall(b1));
        int b2Diff = Math.abs(b2 - closestWall(b2));

        if (b1Diff < b2Diff) {
            return b1;
        } else {
            return b2;
        }
    }

    /**
     * returns the wall that a coord is cloest to
     * @param a represents one value of the coord
     * @return either 0 or 99 depending on which wall is closer
     */
    private int closestWall(int a) {
        if (a < ((max + 1) / 2)) {
            return 0;
        } else {
            return max;
        }
    }
}
