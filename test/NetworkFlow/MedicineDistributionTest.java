package NetworkFlow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MedicineDistributionTest {

    @Test()
    public void exampleOneType() {
        int n = 2;
        int m = 3;
        int k = 1;
        int[] a = {0, 2, 1};
        int[] t = {0, 1, 1, 1};
        boolean[][] c = new boolean[n + 1][m + 1];
        c[1][1] = true;
        c[1][2] = true;
        c[2][2] = true;
        c[2][3] = true;
        /**
         * This test models the situation where: Doctor 1 can handle shipments 1 and 2, and do at
         * most 2. Doctor 2 can handle shipments 2 and 3, and do at most 1. All shipments are the
         * same type.
         *
         * <p>This is doable, for example by having doctor 1 do shipment 1 and 2 and doctor 2 do
         * shipment 3.
         */
        Assertions.assertTrue(MedicineDistribution.needAMedic(n, m, k, a, t, c));
    }

    @Test()
    public void exampleOneTypeLimit() {
        int n = 2;
        int m = 5;
        int k = 1;
        int[] a = {0, 5, 5};
        int[] t = {0, 1, 1, 1, 1, 1};
        boolean[][] c = new boolean[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                c[i][j] = true;
            }
        }
        /**
         * This test models the situation where: Doctor 1 can do all shipments. Doctor 2 can do all
         * shipments. All shipments are the same type.
         *
         * <p>This is _not_ doable, as a doctor can do at most 2 shipments of the same type.
         */
        Assertions.assertFalse(MedicineDistribution.needAMedic(n, m, k, a, t, c));
    }

    @Test()
    public void exampleTwoTypes() {
        int n = 2;
        int m = 5;
        int k = 2;
        int[] a = {0, 5, 5};
        int[] t = {0, 1, 1, 1, 2, 2};
        boolean[][] c = new boolean[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                c[i][j] = true;
            }
        }
        /**
         * This test models the situation where: Doctor 1 can do all shipments. Doctor 2 can do all
         * shipments. Shipments 1-3 are of type 1, 4-5 are of type 2.
         *
         * <p>This is doable, in a variety of ways.
         */
        Assertions.assertTrue(MedicineDistribution.needAMedic(n, m, k, a, t, c));
    }

    @Test()
    public void exampleTwoTypesImpossible() {
        int n = 2;
        int m = 5;
        int k = 2;
        int[] a = {0, 3, 2};
        int[] t = {0, 1, 1, 1, 2, 2};
        boolean[][] c = new boolean[n + 1][m + 1];
        c[1][1] = true;
        c[1][2] = true;
        c[1][3] = true;
        c[1][2] = true;
        c[1][4] = true;
        c[1][5] = true;
        /**
         * This test models the situation where: Doctor 1 can do all shipments of type 1. Doctor 2
         * can do all shipments of type 2, and one of type 1, but only 2 alltogether! Shipments 1-3
         * are of type 1, 4-5 are of type 2.
         *
         * <p>This is _not_ doable, as doctor one cannot do all the ones of type 1. Which means
         * doctor two needs to do three, which she cannot do.
         */
        Assertions.assertFalse(MedicineDistribution.needAMedic(n, m, k, a, t, c));
    }

}