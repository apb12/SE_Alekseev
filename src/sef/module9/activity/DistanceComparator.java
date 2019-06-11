package sef.module9.activity;

import java.util.Comparator;

/**
 * Comparator used to compare the distance attributes of two RadarContacts.  If the
 * first parameter is closer than the second, the compare() method will return a negative
 * number.  If the two parameters are of the same distance, it will return 0.  If
 * the first parameter is farther away than the second, it will return a postive number
 *
 * @author John Doe
 */
public class DistanceComparator implements Comparator<RadarContact> {
    @Override
    public int compare(RadarContact o1, RadarContact o2) {
        if (o1.getDistance() > o2.getDistance()) {
            return 1;
        }
        if (o1.getDistance() < o2.getDistance()) {
            return -1;
        }

        return 0;
        /* (non-Javadoc)
         * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
         */

    }
}