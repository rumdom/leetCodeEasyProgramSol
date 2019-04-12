import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestAll {
    public static void main(String[] args) {
        // int[] array = {1, 3, 6, 4, 5, 5, 3, 2, 8};

        // String[] arrayStr = {"java", "Ram", "sds", "sdf", "sds", "java"};
        // System.out.println ( reverseString ( "d" ) );
        //System.out.println ( findDuplicateStringElements ( arrayStr ) );
        // System.out.println ( findDuplicateIntElements ( array ) );
        //System.out.println ( searchElement ( array, 6 ) );


       // System.out.println ( firstNonRepeatedChar ( "hdgshfdgsfjgs" ) );
        System.out.println ( firstNonRepeatedChar ( "arramya" ) );
    }

    private static HashSet<Integer> findDuplicateIntElements(int[] array) {
        HashSet<Integer> duplicate_elements = new HashSet<> ( );
        Arrays.sort ( array );
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] - array[i] == 0) {
                duplicate_elements.add ( array[i] );
            }
        }
        return duplicate_elements;
    }

    private static Set<String> findDuplicateStringElements(String[] array) {
        Set<String> duplicate_elements = new HashSet<> ( );
        Set<String> elements = new HashSet<> ( );
        for (int i = 0; i < array.length; i++) {
            if (!elements.add ( array[i] )) {
                duplicate_elements.add ( array[i] );
            } else {
                elements.add ( array[i] );
            }
        }
        return duplicate_elements;
    }

    private static int searchElement(int[] array, int search) {
        Arrays.sort ( array );
        int x = Arrays.binarySearch ( array, 0, array.length, search );//returns index

        return x;
    }

    private static String reverseString(String str) {
        if ((str == null && str.isEmpty ( )) || str.length ( ) == 1) {
            return str;
        }
        char[] charArray = str.toCharArray ( );
        swap ( charArray, 0, charArray.length - 1 );
        String string = new String ( charArray );
        return string;

    }

    private static void swap(char[] array, int start, int end) {
        while (start < end) {
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }


    private static String firstNonRepeatedChar(String str) {
        if ((str == null && str.isEmpty ( )) || str.length ( ) == 1) {
            return str;
        }
        char[] charArr = str.toCharArray ( );
        Stream<Character> myStreamOfCharacters = IntStream
                .range ( 0, charArr.length )
                .mapToObj ( i -> charArr[i] );

        List<Character> myListOfCharacters = myStreamOfCharacters.collect ( Collectors.toList ( ) );


        for (int i = 0; i < charArr.length; i++) {
            Character currentChar = charArr[i];
            int counter = 0;
            while (myListOfCharacters.contains ( currentChar )) {
                myListOfCharacters.remove ( currentChar );
                counter++;
            }
            if (counter == 1) {
                return String.valueOf ( currentChar );
            }
        }

        return " ";
    }
}
