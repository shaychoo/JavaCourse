package il.ac.hit.innerClass;

/**
 * Created by shay on 21/07/2014.
 */
public class Line2D {

    private Point2D startPoint, endPoint;

    public Line2D(Point2D startPoint, Point2D endPoint) {
        this.setStartPoint(startPoint);
        this.setEndPoint(endPoint);
    }

    public Point2D getStartPoint() {
        return startPoint;
    }

    private void setStartPoint(Point2D startPoint) {
        this.startPoint = startPoint;
    }

    public Point2D getEndPoint() {
        return endPoint;
    }

    private void setEndPoint(Point2D endPoint) {
        this.endPoint = endPoint;
    }

    public class Point2D {
        private int x;
        private int y;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }


    }
}
