package Algorithms;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class IceCreamParlourBinarySearch {

    public static void main(String[] args) {
        int[] menu = {2, 7, 13, 8, 4, 13, 5};
//        HashMap<Integer, Integer> menu = new HashMap<> ( );
//        menu.put ( 1, 7 );
//        menu.put ( 2, 9 );
//        menu.put ( 3, 13 );
//        menu.put ( 4, 8 );
//        menu.put ( 5, 2 );
//        menu.put ( 6, 13 );
//        menu.put ( 7, 5 );
////        menu.put ( 1, 13 );
////        menu.put ( 6, 13 );


        // int[] menu = {13,13};
        System.out.println ( Arrays.toString ( solution ( menu, 10 ) ) );
        // System.out.println ( Arrays.toString ( findPossibleChoices ( menu, 10 ) ) );

    }

    private static int[] solution(int[] menuArray, int money) {


        AtomicInteger index = new AtomicInteger ( );
        Map<Integer, Integer> menu = Arrays.stream ( menuArray ).boxed ( ).collect ( Collectors.toMap ( x -> index.getAndIncrement ( ), x -> x ) );

        System.out.println ( menu );
        int[] indices = new int[2];
        for (int i = 1; i < menu.size ( ); i++) {
            int reminder = money - menu.get ( i );
            if (reminder < 0)
                continue;
            for (Map.Entry<Integer, Integer> entry : menu.entrySet ( )) {
                if (entry.getValue ( ).equals ( reminder )) {
                    int j = entry.getKey ( );
                    if (i != j) {
                        indices[0] = Math.min ( i, j );
                        indices[1] = Math.max ( i, j );
                        return indices;
                    }
                }
            }
        }
        return null;
    }


    private static int[] findPossibleChoices(int[] menu, int money) {
        int[] indices = null;
        int[] sortedMenu = menu.clone ( );
        Arrays.sort ( sortedMenu );
        for (int i = 0; i < sortedMenu.length; i++) {
            int complement = money - sortedMenu[i];
            if (complement < 0) {
                break;
            }
            int location = Arrays.binarySearch ( sortedMenu, i + 1, sortedMenu.length, complement );
            if (location >= 0 && location < menu.length && sortedMenu[location] == complement) {
                indices = getIncidexsOfValues ( menu, sortedMenu[i], complement );
                return indices;
            }
        }

        return null;
    }

    private static int[] getIncidexsOfValues(int[] menu, int value1, int value2) {
        int index1 = indexOf ( menu, value1, -1 );
        int index2 = indexOf ( menu, value2, index1 );
        int[] indices = {Math.min ( index1, index2 ), Math.max ( index1, index2 )};
        return indices;
    }

    private static int indexOf(int[] menu, int value, int excludeThis) {
        for (int i = 0; i < menu.length; i++) {
            if (menu[i] == value && i != excludeThis) {
                return i;
            }
        }
        return -1;
    }

}
