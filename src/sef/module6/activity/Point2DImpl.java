package sef.module6.activity;


import java.util.Objects;

public class Point2DImpl implements Point2D {


    /**
     * Creates a Point2D object at a default location (0,0)
     */
    public Point2DImpl() {

    }

    /**
     * Create a Point2D object that represents a 2D coordinate specified
     * by the constructor parameters
     *
     * @param x coordinate of the point along the x-axis
     * @param y coordinate of the point along the y-axis
     */
    protected double x;
    protected double y;

    public Point2DImpl(double x, double y) {
        this.x = x;
        this.y = y;

    }


    /* (non-Javadoc)
     * @see sef.module5.activity.Point2D#move(double, double)
     */
    public final void move(double x, double y) {
        setX(x);
        setY(y);

    }


    /* (non-Javadoc)
     * @see sef.module5.activity.Point2D#setX(double)
     */
    public void setX(double x) {
        this.x = x;

    }


    /* (non-Javadoc)
     * @see sef.module5.activity.Point2D#setY(double)
     */
    public void setY(double y) {
        this.y = y;

    }


    /* (non-Javadoc)
     * @see sef.module5.activity.Point2D#getX()
     */
    public double getX() {

        return x;
    }


    /* (non-Javadoc)
     * @see sef.module5.activity.Point2D#getY()
     */
    public double getY() {

        return y;
    }


    /* (non-Javadoc)
     * @see sef.module5.activity.Point2D#translate(double, double)
     */
    public final void translate(double dx, double dy) {
        x = x + dx;
        y = y + dy;

    }


    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object p) {
        if (this == p) return true;
        if (!(p instanceof Point2DImpl)) return false;
        Point2DImpl point2D = (Point2DImpl) p;
        return Double.compare(point2D.x, x) == 0 &&
                Double.compare(point2D.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }


    /* (non-Javadoc)
     * @see sef.module5.activity.Point2D#equals(double, double)
     */

    public boolean equals(double x2, double y2) {
        return (x == x2 && y == y2);
    }


    /* (non-Javadoc)
     * @see sef.module5.activity.Point2D#getDistance(sef.module5.activity.Point2D)
     */
    public final double getDistance(Point2D p) {

        return getDistance(p.getX(), p.getY());
    }


    /* (non-Javadoc)
     * @see sef.module5.activity.Point2D#getDistance(double, double)
     */
    public final double getDistance(double x2, double y2) {
        double tx = x2 - x;
        double ty = y2 - y;
        double sum = tx * tx + ty * ty;

        return Math.sqrt(sum);
    }


}
