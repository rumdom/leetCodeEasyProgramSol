package HackerRank;

import java.util.Scanner;

public class StdINOUT {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner ( System.in );
//        System.out.println ( "enter ur name" );
//        String data = scanner.next ( );
//        int myage = scanner.nextInt ( );
//
//        scanner.close ( );
//        System.out.println ( "You typed " + data + " " + myage );
//
//    }


    private static final Scanner scanner = new Scanner ( System.in );

//    public static void main(String[] args) {
//        int N = scanner.nextInt ( );
//        scanner.skip ( "(\r\n|[\n\r\u2028\u2029\u0085])?" );
//        if (N % 2 == 0) {
//            if (N > 20 || (N >= 2 && N <= 5)) {
//                System.out.println ( "Not Weird" );
//            } else {
//                System.out.println ( "Weird" );
//            }
//        } else {
//            System.out.println ( "Weird" );
//        }
//
//        scanner.close ( );
//    }


    public static void main(String[] args) {
        Scanner scan = new Scanner ( System.in );
        int i = scan.nextInt ( );
        Double d = scan.nextDouble ( );
        scan.nextLine ();
        String s = scan.nextLine ( );
        // Write your code here.
        scan.close ( );
        System.out.println ( "String: " + s );
        System.out.println ( "Double: " + d );
        System.out.println ( "Int: " + i );
    }

}