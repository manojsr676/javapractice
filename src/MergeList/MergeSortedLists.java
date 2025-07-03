package MergeList;


class Node {
    int data;
    Node next;

    Node(int val) {
        this.data = val;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    LinkedList() {
        this.head = null;
    }

    void append(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class MergeSortedLists {

    public static Node mergeLists(Node head1, Node head2) {
        // Dummy node to simplify logic
        Node dummy = new Node(0);
        Node tail = dummy;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }

        // Append the remaining nodes
        tail.next = (head1 != null) ? head1 : head2;

        return dummy.next;  // Return merged list head
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.append(1);
        list1.append(3);
        list1.append(5);
        list1.append(7);

        LinkedList list2 = new LinkedList();
        list2.append(2);
        list2.append(4);
        list2.append(6);
        list2.append(8);

        System.out.print("List 1: ");
        list1.display();

        System.out.print("List 2: ");
        list2.display();

        Node mergedHead = mergeLists(list1.head, list2.head);

        System.out.print("Merged List: ");
        Node temp = mergedHead;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
