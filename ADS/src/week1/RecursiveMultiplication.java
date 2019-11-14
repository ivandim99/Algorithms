package week1;

public class RecursiveMultiplication {
    static int multiply(int num1, int num2) {
        if(num1 == 0 || num2 == 0)
            return  0;
        else if(num1 < 0) {
            return - num2 + multiply(num1 + 1,num2);
        }
        else {
            return num2 + multiply(num1 - 1,num2);
        }
    }
}
