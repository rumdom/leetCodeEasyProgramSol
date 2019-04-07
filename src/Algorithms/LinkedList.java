package Algorithms;

public class LinkedList {
    Node head;

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList ( );
        Node node2 = new Node ( 2 );
        Node node3 = new Node ( 3 );
        linkedList.head = new Node ( 1 );
        linkedList.head.next = node2;
        node2.next = node3;
        linkedList.printContentOfLinkedList ( );
        linkedList.middleOFLinkedList ( );
    }

    private void printContentOfLinkedList() {
        int counter = 0;
        Node n = head;
        while (n != null) {
            System.out.println ( n.data );
            n = n.next;
            counter++;
        }
        System.out.println ( "size" + counter );
    }

    private void middleOFLinkedList() {
        int counter = 0;
        Node n = head;
        while (n != null) {
            n = n.next;
            counter++;
        }
        Node middle = head;
        counter = counter / 2;
        int j = 0;
        while (j < counter) {
            j++;
            middle = middle.next;
        }
        System.out.println ( "middle" + middle.data );
    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        next = null;
    }
}