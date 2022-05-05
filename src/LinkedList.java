public class LinkedList {
    Node head;
    Node tail;

    class Node {
        int data;
        Node next;

        Node(int d) {
            this.data = d;
            next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    public void push(int newNodeData) {
        Node newNode = new Node(newNodeData);

        if(head == null)  {
            head = newNode;
            tail = head;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    void print() {
        Node currentNode = head;

        while(currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println("");
    }

    Node reverse(Node head, int k) {
        if(head == null) return  null;

        Node current = head;
        Node prev = null;
        Node next = null;

        int  count = 0;

        while(count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;

            current = next;
            count++;
        }

        if (next != null) {
            head.next = reverse(next, k);
        }

        return prev;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        list.push(5);
        list.push(6);

        list.print();

        list.head = list.reverse(list.head, 2);

        list.print();
    }
}
