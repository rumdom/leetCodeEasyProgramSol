package Algorithms;

public class BinaryTree {

    public static void main(String[] args) {

    }
}


class NodeB {
    NodeB left, right;
    int data;

    public NodeB(int data) {
        this.data = data;
    }

    public void insertB(int d) {
        if (d <= data) {
            if (left == null) {
                left = new NodeB ( d );
            } else {
                left.insertB ( d );
            }
        } else {
            if (right == null) {
                right = new NodeB ( d );

            } else {
                right.insertB ( d );
            }
        }
    }

    public boolean containsB(int d) {
        if (d == data) {
            return true;
        } else if (d < data) {
            if (left == null) {
                return false;
            } else {
                return left.containsB ( d );
            }
        } else {
            if (right == null) {
                return false;

            } else {
                return right.containsB ( d );
            }
        }
    }

    public void printInorder() {
        if (left != null) {
            left.printInorder ( );
        }
        System.out.println ( data );
        if (right != null) {
            right.printInorder ( );
        }
    }
}
