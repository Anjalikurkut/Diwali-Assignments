import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node(int d) { data = d; next = null; }
}

public class DAY02_CircularLinkedList {
    private Node tail; // tail.next is head

    public DAY02_CircularLinkedList() { tail = null; }

    // Insert at nth position (1-based). If list empty, position 1 inserts node.
    public void insertAtPosition(int data, int pos) {
        Node newNode = new Node(data);
        if (tail == null) {
            // empty list
            newNode.next = newNode;
            tail = newNode;
            return;
        }
        if (pos <= 1) {
            // insert at head
            Node head = tail.next;
            newNode.next = head;
            tail.next = newNode;
            return;
        }
        // traverse to (pos-1)th node or tail if shorter
        Node curr = tail.next; // head
        int idx = 1;
        while (idx < pos - 1 && curr != tail) {
            curr = curr.next;
            idx++;
        }
        // insert after curr
        newNode.next = curr.next;
        curr.next = newNode;
        if (curr == tail) tail = newNode; // update tail if appended at end
    }

    // Delete first node that matches data
    public boolean deleteByValue(int data) {
        if (tail == null) return false;
        Node curr = tail.next; // head
        Node prev = tail;
        do {
            if (curr.data == data) {
                if (curr == prev) {
                    // only one node
                    tail = null;
                } else {
                    prev.next = curr.next;
                    if (curr == tail) tail = prev;
                }
                return true;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != tail.next);
        return false;
    }

    // Modify first node matching oldData to newData
    public boolean modifyNode(int oldData, int newData) {
        if (tail == null) return false;
        Node curr = tail.next;
        do {
            if (curr.data == oldData) {
                curr.data = newData;
                return true;
            }
            curr = curr.next;
        } while (curr != tail.next);
        return false;
    }

    public void display() {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }
        Node curr = tail.next;
        System.out.print("Circular List: ");
        do {
            System.out.print(curr.data + " ");
            curr = curr.next;
        } while (curr != tail.next);
        System.out.println();
    }

    // Simple CLI demo
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DAY02_CircularLinkedList list = new DAY02_CircularLinkedList();
        while (true) {
            System.out.println("\n1.Insert at position 2.Delete by value 3.Modify node 4.Display 5.Exit");
            System.out.print("Choose: ");
            int ch = sc.nextInt();
            if (ch == 1) {
                System.out.print("Enter data: ");
                int d = sc.nextInt();
                System.out.print("Enter position (1-based): ");
                int p = sc.nextInt();
                list.insertAtPosition(d, p);
            } else if (ch == 2) {
                System.out.print("Enter value to delete: ");
                int d = sc.nextInt();
                boolean ok = list.deleteByValue(d);
                System.out.println(ok ? "Deleted." : "Value not found.");
            } else if (ch == 3) {
                System.out.print("Enter old value: ");
                int oldv = sc.nextInt();
                System.out.print("Enter new value: ");
                int newv = sc.nextInt();
                boolean ok = list.modifyNode(oldv, newv);
                System.out.println(ok ? "Modified." : "Value not found.");
            } else if (ch == 4) {
                list.display();
            } else break;
        }
        sc.close();
    }
}