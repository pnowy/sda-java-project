package pl.sda.programming1.recursion;

public class GDC {

    public static void main(String[] args) {
//        System.out.println(recursiveGdc(255, 102));
        System.out.println(recursiveFibonacci(40));
    }

    public static int recursiveFibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            int fibonacciNMinus1 = recursiveFibonacci(n - 1);
            int fibonacciNMinus2 = recursiveFibonacci(n - 2);
            int fibResult = fibonacciNMinus1 + fibonacciNMinus2;
            return fibResult;
        }
    }

    public static int recursiveGdc(int a, int b) {
        if (a == b) {
            return a;
        } else {
            // skrócony if (tenary operator)
            int newA = a > b ? a - b : a;
//            odpowiednik powyższej linijki w dłuższej formie (normalny if)
//            int newAA;
//            if (a > b) {
//                newAA = a - b;
//            } else {
//                newAA = a;
//            }
            int newB = b > a ? b - a : b;
//            taka sama sytuacja jak w przypadku wyliczania 'newA'
//            int newBB;
//            if (b > a) {
//                newBB = b - a;
//            } else {
//                newBB = b;
//            }
            int recursiveExecutionResult = recursiveGdc(newA, newB);
            return recursiveExecutionResult;
        }
    }

}
