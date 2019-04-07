import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class tomtom1 {

    public static int solution(int N, String S) {

        ArrayList<HashSet<String>> arrangement = new ArrayList<HashSet<String>> ( );

        for (int i = 1; i <= N; i++) {
            HashSet<String> seatSet1 = new HashSet<String> ( );
            seatSet1.add ( i + "A" );
            seatSet1.add ( i + "B" );
            seatSet1.add ( i + "C" );

            arrangement.add ( seatSet1 );

            HashSet<String> seatSet2 = new HashSet<String> ( );
            seatSet2.add ( i + "D" );
            seatSet2.add ( i + "E" );
            seatSet2.add ( i + "F" );
            seatSet2.add ( i + "G" );

            arrangement.add ( seatSet2 );

            HashSet<String> seatSet3 = new HashSet<String> ( );
            seatSet3.add ( i + "H" );
            seatSet3.add ( i + "J" );
            seatSet3.add ( i + "K" );

            arrangement.add ( seatSet3 );
        }

        System.out.println ( arrangement );

        String[] reservations = S.split ( "\\s" );
        System.out.println ( Arrays.toString ( reservations ) );

        HashSet<String> unavailable_seats = new HashSet<> ( );

        for (String res : reservations) {
            for (HashSet<String> a : arrangement) {
                if (a.contains ( res ) && a.size ( ) == 3) {
                    unavailable_seats.add ( combine ( a ) );
                    break;
                } else if (a.contains ( res ) && a.size ( ) == 4) {
                    a.remove ( res );
                    if (!checkSeats ( a )) {
                        unavailable_seats.add ( combine ( a ) );
                    }
                    break;
                }
            }
        }

        return arrangement.size ( ) - unavailable_seats.size ( );
    }

    public static String combine(HashSet<String> a) {
        StringBuilder result = new StringBuilder ( );
        for (String x : a) {
            result.append ( x );
        }
        return result.toString ( );
    }


    public static boolean checkSeats(HashSet<String> a) {

        HashSet<String> members = new HashSet<> ( );
        for (String x : a) {
            members.add ( x.substring ( 1 ) );
        }
        System.out.println ( members );

        return (members.contains ( "D" ) && members.contains ( "E" ) && members.contains ( "F" )) || (members.contains ( "G" ) && members.contains ( "E" ) && members.contains ( "F" ));

    }


    public static void main(String[] args) {

        System.out.println ( solution ( 2, "1A 2D 1C" ) );
//        System.out.println(solution(1, ""));
    }
}