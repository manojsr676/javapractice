package Datastucture.Linkedlist.Singly;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SLL {
    private Node head;

    SLL() {
        head = null;
    }

    void insertAtHead(int val) {
        Node n = new Node(val);
        n.next = head;
        head = n;
    }

    void insertAtEnd(int val) {
        if (head == null) {
            insertAtHead(val);
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node n = new Node(val);
        temp.next = n;
    }

    void insertAtPos(int val, int pos) {
        if (pos < 1) {
            System.out.println("Invalid position!");
            return;
        }

        Node newNode = new Node(val);

        if (pos == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node temp = head;
        int currentPos = 1;

        while (temp != null && currentPos < pos - 1) {
            temp = temp.next;
            currentPos++;
        }

        if (temp == null) {
            System.out.println("Position out of bounds.");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // ✅ Delete the head node
    void deleteAtHead() {
        if (head == null) {
            System.out.println("List is already empty.");
            return;
        }
        head = head.next;
    }

    // ✅ Delete a node by its value
    void deleteByValue(int val) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.data == val) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.data != val) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Value " + val + " not found in the list.");
            return;
        }

        temp.next = temp.next.next;
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}
