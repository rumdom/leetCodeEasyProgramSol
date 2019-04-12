package Algorithms;

import java.io.File;

public class RecursionFileSearchByType {

    public static void main(String[] args) {
        File folder = new File ( "C:\\Users\\get2r\\Documents\\Resume" );
        System.out.println ( countFileByType ( folder ) );
    }

    private static int countFileByType(File folder) {
        int count = 0;
        for (File fileEntry : folder.listFiles ( )) {
            if (fileEntry.isDirectory ( )) {
                count += countFileByType ( fileEntry );
            } else {
                if (fileEntry.getName ( ).toLowerCase ( ).endsWith ( ".docx" )) {
                    count++;
                }
            }
        }
        return count;
    }

}
