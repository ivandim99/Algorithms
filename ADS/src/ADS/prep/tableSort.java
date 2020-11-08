package ADS.prep;

public class tableSort {

    public static void main(String[] args) {

        String[][] a = {{"a","aa"}, {"b"}, {"c"}, {"d"} , {"e"}};
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.println(a[i][j] + "i =" + i + "j=" + j);
            }
        }
        String c = "a";
        String b = "b";
        System.out.println(c.compareTo(b));
        System.out.println(b.compareTo(c));

    }
}
