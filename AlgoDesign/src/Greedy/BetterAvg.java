package Greedy;
class BetterAvg {

    public static double solve(int n, double[] list) {
        int l = 0;
        int r = n - 1;
        int m = l + (r - l) / 2;
        mergeSort(list,l,r);
        if(n % 2 == 0) {
            return (list[m] + list[m + 1]) / 2;
        }
        return list[m];
    }


    public static void mergeSort(double[] list,int l,int r) {
        if(l < r) {
            int m = l + (r - l) / 2;
            mergeSort(list,l,m);
            mergeSort(list,m + 1,r);
            merge(list,l,m,r);
        }
    }

    public static void merge(double[] list,int l,int m,int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        double[] R = new double[n1];
        double[] L = new double[n2];

        for(int i = 0;i < n1;i++) {
            R[i] = list[l + i];
        }

        for(int j = 0;j <n2;j++) {
            L[j] = list[m + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = l;

        while(i < n1 && j < n2) {
            if (R[i] <= L[j]) {
                list[k] = R[i];
                i++;
            }
            else {
                list[k] = L[j];
                j++;
            }
            k++;
        }

        while(i < n1) {
            list[k] = R[i];
            i++;
            k++;
        }

        while(j < n2) {
            list[k] = L[j];
            j++;
            k++;
        }
    }
}

