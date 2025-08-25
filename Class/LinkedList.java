package Class;

public class LinkedList {

    private Node head;
    private Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void insertFirst(String task) {
        Node newNode = new Node(task);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.forward = head;
            head = newNode;
        }
    }

    public void insertLast(String task) {
        Node newNode = new Node(task);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.forward = newNode;
            tail = newNode;
        }
    }

    public void deleteFirst() {
        if (isEmpty()) {
            System.out.println("No hay tareas pendientes.");
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.forward;
        }
    }

    public void deleteLast() {
        if (isEmpty()) {
            System.out.println("No hay tareas pendientes");
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            Node iteratorNode = head;

            while (iteratorNode.forward != tail) {
                iteratorNode = iteratorNode.forward;
            }

            tail = iteratorNode;
            tail.forward = null;
        }
    }

    public void find() {
        
    }
}
