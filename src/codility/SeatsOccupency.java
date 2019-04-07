package codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SeatsOccupency {

    public static void main(String[] args) {
        //System.out.println ( getAvailableSeats ( 2, "1A 2D 1C" ) );
        System.out.println ( solution ( 2, "1A 2D 1C" ) );

    }

    public static int getAvailableSeats(int n, String s) {
        String str[] = s.split ( " " );
        List<String> occupied = new ArrayList<> ( );
        int available = 0;

        occupied = Arrays.asList ( str );

        for (int i = 1; i <= n; i++) {

            if (!occupied.contains ( i + "A" ) && !occupied.contains ( i + "B" ) && !occupied.contains ( i + "C" )) {
                available++;
            }
            if (!(occupied.contains ( i + "D" ) && occupied.contains ( i + "G" )) && !(occupied.contains ( i + "E" ) || occupied.contains ( i + "F" ))) {
                available++;
            }
            if (!occupied.contains ( i + "H" ) && !occupied.contains ( i + "J" ) && !occupied.contains ( i + "K" )) {
                available++;
            }
        }
        return available;
    }

    public static int solution(int N, String str) {
        List<HashSet<String>> arrangements = new ArrayList<HashSet<String>> ( );
        for (int i = 1; i <= N; i++) {
            HashSet<String> abc = new HashSet<> ( );
            abc.add ( i + "A" );
            abc.add ( i + "B" );
            abc.add ( i + "C" );
            arrangements.add ( abc );
            HashSet<String> defg = new HashSet<> ( );
            defg.add ( i + "D" );
            defg.add ( i + "E" );
            defg.add ( i + "F" );
            defg.add ( i + "G" );
            arrangements.add ( defg );
            HashSet<String> hjk = new HashSet<> ( );
            hjk.add ( i + "H" );
            hjk.add ( i + "J" );
            hjk.add ( i + "K" );
            arrangements.add ( hjk );
        }
        HashSet<String> unavailable_seats = new HashSet<> ( );
        String[] reservations = str.split ( "\\s+" );
        for (String reservedSeat : reservations) {
            for (HashSet<String> seat : arrangements) {
                if (seat.contains ( reservedSeat ) && seat.size ( ) == 3) {
                    unavailable_seats.add ( combine ( seat ) );
                    break;
                } else if (seat.contains ( reservedSeat ) && seat.size ( ) == 4) {
                    seat.remove ( reservedSeat );
                    if (!checkSeat ( seat )) {
                        unavailable_seats.add ( combine ( seat ) );
                    }
                    break;
                }
            }
        }
        System.out.println ( unavailable_seats );
        return arrangements.size ( ) - unavailable_seats.size ( );
    }

    private static String combine(HashSet<String> a) {
        StringBuilder stringBuilder = new StringBuilder ( );
        for (String x :
                a) {
            stringBuilder.append ( x );

        }
        return stringBuilder.toString ( );
    }

    private static boolean checkSeat(HashSet<String> s) {
        List<String> output = new ArrayList<> ( );
        for (String seat : s) {
            String x = seat.substring ( seat.length ( ) - 1, seat.length ( ) );
           // System.out.println ( x );
            output.add ( x );
        }
        return ((output.contains ( "D" ) && output.contains ( "E" ) && output.contains ( "F" )) || (output.contains ( "G" ) && output.contains ( "E" ) && output.contains ( "F" )));

    }


}
