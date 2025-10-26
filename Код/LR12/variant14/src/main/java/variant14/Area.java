package variant14;

import blackBoxTesting.IArea;

public class Area implements IArea {

    private final double R;

    public Area(double r) {
        R = r;
    }

    @Override
    public boolean isPointInArea(double x, double y) {
        if (Double.compare(x, -R) >= 0 && Double.compare(x, 0) <= 0) {
            if (Double.compare(y, 0) >= 0 && Double.compare(y, R) <= 0) {
                if (!inFirstCircle(x, y)) return true;
            }
        }

        if (Double.compare(x, 0) >= 0 && Double.compare(x, R) <= 0) {
            if (Double.compare(y, -R) >= 0 && Double.compare(y, 0) <= 0) {
                return !inSecondCircle(x, y);
            }
        }

        return false;
    }

    private boolean inFirstCircle(double x, double y) {
        double value = Math.pow(x + R, 2) + Math.pow(y - R, 2);
        double radius = Math.pow(R, 2);
        return Double.compare(value, radius) < 0;
    }

    private boolean inSecondCircle(double x, double y) {
        double value = Math.pow(x - R, 2) + Math.pow(y + R, 2);
        double radius = Math.pow(R, 2);
        return Double.compare(value, radius) < 0;
    }
}
