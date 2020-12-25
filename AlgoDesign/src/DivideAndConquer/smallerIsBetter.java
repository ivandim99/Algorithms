package DivideAndConquer;

public class smallerIsBetter {

    static class Solution {

        /**
         * Finds the x coordinate with the smallest distance between two linear equations, by recursively evaluating the median of the range and that integer + 1.
         * Depending on the value, a new evaluation is made with a smaller range to find the x coordinate with the smallest distance.
         * @param e1 the first equation to evaluate
         * @param e2 the second equation to evaluate
         * @param low the lower boundary of the range
         * @param high the upper boundary of the range
         * @return the x coordinate with the minimum difference between e1 and e2
         */
        public static long findMin(Equation e1, Equation e2, long low, long high) {
            if(low == high) {
                return low;
            }

            long mid = (low + high) / 2;

            if(Math.abs(e1.evaluate(mid) - e2.evaluate(mid)) < Math.abs(e1.evaluate(mid+1) - e2.evaluate(mid+1))) {
                return findMin(e1,e2,low,mid);
            }
            else {
                return findMin(e1,e2,mid + 1,high);
            }
        }
    }

    abstract class Equation {

        public abstract long evaluate(long x);
    }

    class QuadraticEquation extends Equation {

        private long secondPolynomial;

        private long firstPolynomial;

        private long constant;

        /**
         * Constructs a quadratic equation in the form of:
         * f(x) = secondPolynomial * x^2 + firstPolynomial * x + constant
         *
         * @param secondPolynomial the parameter for the second degree polynomial
         * @param firstPolynomial the parameter for the first degree polynomial
         * @param constant the parameter for the constant
         */
        public QuadraticEquation(long secondPolynomial, long firstPolynomial, long constant) {
            this.secondPolynomial = secondPolynomial;
            this.firstPolynomial = firstPolynomial;
            this.constant = constant;
        }

        /**
         * Evaluates the equation with the given x.
         * @param x value used to evaluate
         * @return the result of the equation1
         */
        public long evaluate(long x) {
            return secondPolynomial * x * x + firstPolynomial * x + constant;
        }
    }
}
