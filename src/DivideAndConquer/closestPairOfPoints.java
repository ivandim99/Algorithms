package DivideAndConquer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class closestPairOfPoints {

    /** Class representing a 2D point. */
    static class Point {

        public double x;

        public double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    /** Useful methods for this assignment. */
    class Util {

        // Counts how often the distance function was called.
        // In an exam we may use such counters in places where you cannot edit them ;)
        // For our largest test case, this counter is checked to be less than 3 million. Our solution
        // uses about 1.2 million calls to the distance function.
        static int count_distances = 0;

        /**
         * Takes two points and computes the euclidean distance between the two points.
         *
         * @param point1 - first point.
         * @param point2 - second point.
         * @return euclidean distance between the two points.
         * @see <a
         *     href="https://en.wikipedia.org/wiki/Euclidean_distance">https://en.wikipedia.org/wiki/Euclidean_distance</a>
         */
        public static double distance(Point point1, Point point2) {
            Util.count_distances++;
            return Math.sqrt(Math.pow(point1.x - point2.x, 2.0D) + Math.pow(point1.y - point2.y, 2.0D));
        }

        /**
         * Takes a list of points and sorts it on x (ascending).
         *
         * @param points - points that need to be sorted.
         */
        public static void sortByX(List<Point> points) {
            Collections.sort(points, Comparator.comparingDouble(point -> point.x));
        }

        /**
         * Takes a list of points and sorts it on y (ascending) .
         *
         * @param points - points that need to be sorted.
         */
        public static void sortByY(List<Point> points) {
            Collections.sort(points, Comparator.comparingDouble(point -> point.y));
        }

        /**
         * Takes a list of points and returns the distance between the closest pair. This is done by
         * brute forcing.
         *
         * @param points - list of points that need to be considered.
         * @return smallest pair-wise distance between points.
         */
        public static double bruteForce(List<Point> points) {
            int size = points.size();
            if (size <= 1) return Double.POSITIVE_INFINITY;
            double bestDist = Double.POSITIVE_INFINITY;
            for (int i = 0; i < size - 1; i++) {
                Point point1 = points.get(i);
                for (int j = i + 1; j < size; j++) {
                    Point point2 = points.get(j);
                    double distance = Util.distance(point1, point2);
                    if (distance < bestDist) bestDist = distance;
                }
            }
            return bestDist;
        }
    }

    /**
     * Takes a list of points and returns the distance between the closest pair. This is done with
     * divide and conquer.
     *
     * @param points - list of points that need to be considered.
     * @return smallest pair-wise distance between points.
     */
    public static double closestPair(List<Point> points) {
        if(points.size() <= 1) {
            return Integer.MAX_VALUE;
        }

        List<Point> ListX = new ArrayList<>();
        Util.sortByX(ListX);
        List<Point> ListY = new ArrayList<>();
        Util.sortByY(ListY);

        return closestPair(ListX,ListY);
    }

    public static double closestPair(List<Point> ListX, List<Point> ListY) {
        int size = ListX.size();
        if(size <= 3) {
            return Util.bruteForce(ListX);
        }

        int mid = size / 2;
        List<Point> leftPart = ListX.subList(0,mid);
        List<Point> rightPart = ListX.subList(mid+1,size);

        List<Point> sortedLeft = new ArrayList<>();
        List<Point> sortedRight = new ArrayList<>();

        for(Point point: ListY) {
            if(point.x < ListX.get(mid).x) {
                sortedLeft.add(point);
            }
            else {
                sortedRight.add(point);
            }
        }

        double left = closestPair(leftPart,sortedLeft);
        double right = closestPair(rightPart,sortedRight);

        double delta = Math.min(left,right);

        List<Point> midStrip = new ArrayList<>();

        double midX = leftPart.get(leftPart.size() - 1).x;

        for(Point point: ListY) if (Math.abs(midX - point.x) < delta)
            midStrip.add(point);

        for (int i = 0; i < midStrip.size() - 1; i++) {
            Point point1 = midStrip.get(i);
            for (int j = i + 1; j < midStrip.size() && (midStrip.get(j).y - midStrip.get(i).y < delta); j++) {
                Point point2 = midStrip.get(j);
                double distance = Util.distance(point1, point2);
                if (distance < delta) {
                    delta = distance;
                }
            }
        }
        return delta;
    }

}
