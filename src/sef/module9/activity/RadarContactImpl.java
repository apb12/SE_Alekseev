package sef.module9.activity;

/**
 * Implementation of a RadarContact
 *
 * @author John Doe
 */
public class RadarContactImpl implements RadarContact {


    /**
     * Creates a RadarContact with the specified ID, bearing and distance.
     *
     * @param contactID the contact's ID
     * @param bearing the contact's bearing
     * @param distance the contact's distance
     */
    private String contactID;
    private double bearing;
    private double distance;

    public RadarContactImpl(String contactID, double bearing, double distance) {
        this.contactID = contactID;
        if (distance > 0) {
            this.distance = distance;
        } else this.distance = 0.0;
        if (bearing > 0) {
            this.bearing = bearing % 360;
        }
        if (bearing < 0) {
            double tempBearing = bearing % 360;
            if (tempBearing == 0) {
                this.bearing = -tempBearing;
            } else
                this.bearing = 360 + (bearing % 360);
        }
    }


    /* (non-Javadoc)
     * @see sef.module8.activity.RadarContact#getBearing()
     */
    public final double getBearing() {
        return bearing;
    }


    /* (non-Javadoc)
     * @see sef.module8.activity.RadarContact#setBearing(double)
     */
    public final void setBearing(double bearing) {
        if (bearing > 0) {
            this.bearing = bearing % 360;
        }
        if (bearing < 0) {
            double tempBearing = bearing % 360;
            if (tempBearing == 0) {
                this.bearing = -tempBearing;
            } else
                this.bearing = 360 + (bearing % 360);
        }

    }


    /* (non-Javadoc)
     * @see sef.module8.activity.RadarContact#getDistance()
     */
    public final double getDistance() {
        return distance;
    }

    /* (non-Javadoc)
     * @see sef.module8.activity.RadarContact#setDistance(double)
     */
    public final void setDistance(double distance) {
        if (distance > 0) {
            this.distance = distance;
        } else distance = 0.0;

    }

    /* (non-Javadoc)
     * @see sef.module8.activity.RadarContact#getContactID()
     */
    public final String getContactID() {
        return contactID;
    }

    /* (non-Javadoc)
     * @see sef.module8.activity.RadarContact#setContactID(java.lang.String)
     */
    public final void setContactID(String contactID) {
        this.contactID = contactID;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "RadarContactImpl{" +
                "contactID='" + contactID + '\'' +
                ", bearing=" + bearing +
                ", distance=" + distance +
                '}';
    }

}
