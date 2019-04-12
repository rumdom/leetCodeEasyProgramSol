public class PrimeOrNot {

    public static void main(String[] args) {
        System.out.println ( isPrime ( 127) );
    }

    private static boolean isPrime(int num) {

        int i = 1;
        int counter = 0;
        if (num <= 0) {
            return false;
        } else {
            while (i <= num) {
                if (num % i == 0) {
                    counter++;
                }
                i++;
            }
        }
        if (counter == 2) {
            return true;
        }
        return false;
    }
}
