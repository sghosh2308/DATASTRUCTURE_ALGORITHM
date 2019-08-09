import java.time.Duration;
import java.time.Instant;

/*When repeatedly searching an unsorted Single Linked List, it can be advantageous to move an item to
        the head of the list when it is found, if it is likely that the same item will be searched for again in the near
        future.
           */
class LinkedList {
        Node Head;
        int length = 0;// Count the length of the linked list

        static class Node {
            int data;
            Node next;

            Node(int data, Node next) {
                this.data = data;
                this.next = next;
            }

            Node(int data) {
                this(data, null);
            }
        }

    /*This function add next node this it always append at the end of the list and is using Varages concept this one or
    many node can be created at once
    * */

        public void append(int... data) {
            for (int node_data : data) {
                Node generate_node = new Node(node_data);
                if (this.Head == null) {
                    this.Head = generate_node;
                } else {
                    Node traverse = this.Head;
                    while (traverse.next != null) traverse = traverse.next;
                    traverse.next = generate_node;
                }
                this.length++;
            }
        }

        public void print() {
            if (this.Head == null) return;
            Node traverse = this.Head;
            StringBuilder data = new StringBuilder();
            while (traverse != null) {
                data.append(traverse.data).append(", ");
                traverse = traverse.next;
            }
            System.out.println(data);
        }

        public boolean linearsearch(int data) {
            if (this.Head == null) return false;
            Instant start,stop;
            start=Instant.now();
            if (Head.data == data) {
                stop=Instant.now();
                long timeElapsed = Duration.between(start, stop).toNanos();
                System.out.println("TIME TAKEN "+timeElapsed);
                return true;
            } else {
                Node traverse = this.Head;
                while (traverse.next != null) {
                    if (traverse.next.data == data) {
                        traverse.next = traverse.next.next;
                        this.Head = new Node(data, this.Head);
                        stop=Instant.now();
                        long timeElapsed = Duration.between(start, stop).toNanos();
                        System.out.println("TIME TAKEN "+timeElapsed);
                        return true;
                    }
                    traverse = traverse.next;
                }
            }
            return false;
        }
    }
    public class Modified_linearsearch{
        public static void main(String args[]) {
            LinkedList l = new LinkedList();
            l.append(new int[]{1, 2, 343, 545, 6780, 123, 45, 1000, 200, 221, 11, 23, 46, 99, 3, 4, 5, 6, 7, 8, 9, 10, 11});
            l.print();
            if (l.linearsearch(3)) {
                System.out.println("DATA FOUND");
            } else {
                System.out.println("DATA NOT FOUND");
            }
            l.print();
            if (l.linearsearch(3)) {
                System.out.println("DATA FOUND");
            } else {
                System.out.println("DATA NOT FOUND");
            }
            if (l.linearsearch(3)) {
                System.out.println("DATA FOUND");
            } else {
                System.out.println("DATA NOT FOUND");
            }
            if (l.linearsearch(3)) {
                System.out.println("DATA FOUND");
            } else {
                System.out.println("DATA NOT FOUND");
            }

        }
    }


