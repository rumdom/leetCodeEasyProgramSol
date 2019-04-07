import java.util.Arrays;
import java.util.Stack;

public class tomtom3 {


    public static int solution(String S) {
        Stack<Integer> stack = new Stack<Integer> ( );

        String[] operations = S.split ( "\\s" );
        System.out.println ( Arrays.toString ( operations ) );
        try {
            for (String operation : operations) {
                switch (operation) {
                    case "POP":
                        stack.pop ( );
                        break;
                    case "DUP":
                        stack.push ( stack.peek ( ) );
                        break;
                    case "+":
                        stack.push ( stack.pop ( ) + stack.pop ( ) );
                        break;
                    case "-":
                        stack.push ( stack.pop ( ) - stack.pop ( ) );
                        break;
                    default:
                        stack.push ( Integer.parseInt ( operation ) );

                }
            }
        } catch (Exception e) {
            return -1;
        }
        System.out.println ( stack );

        return stack.pop ( );

    }

    public static void main(String[] args) {
          System.out.println(solution("13 DUP 4 POP 5 DUP + DUP + -"));
      //  System.out.println ( solution ( "5 6 + -" ) );
    }
}
