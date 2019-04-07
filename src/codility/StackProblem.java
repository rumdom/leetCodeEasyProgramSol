package codility;

import java.util.Stack;

public class StackProblem {
    public static void main(String[] args) {
        // System.out.println ( solution ( "13 DUP 4 POP 5 DUP + DUP + -" ) );
        System.out.println ( solution ( "DUP " ) );
    }

    public static int solution(String str) {
        Stack<Integer> stack = new Stack<> ( );
        String[] operations = str.split ( "\\s+" );
        try {
            for (String operation : operations) {
                switch (operation) {
                    case "DUP":
                        stack.push ( stack.peek ( ) );
                        break;
                    case "POP":
                        stack.pop ( );
                        break;
                    case "+":
                        stack.push ( stack.pop ( ) + stack.pop ( ) );
                        break;
                    case "-":
                        stack.push ( stack.pop ( ) - stack.pop ( ) );
                        break;
                    default:
                        stack.push ( Integer.parseInt ( operation ) );
                        break;
                }
            }
            return stack.peek ( );
        } catch (Exception e) {
            return -1;
        }
    }
}
