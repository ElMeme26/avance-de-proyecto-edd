package Class;

public class Queue {
    private int front;
    private int rear;
    private final int capacity = 40;
    private String[] data;

    public Queue() {
        this.data = new String[capacity];
        front = -1;
        rear = -1;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return rear == this.capacity - 1;
    }

    public void enqueue(String norm_task) {
        if (isFull()) {
            System.out.println("Ya hay demasiadas tareas programadas.");
            return;
        }

        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            rear++;
        }

        data[rear] = norm_task;
        System.out.println("Tarea agregada: " + norm_task);
    }

    public String dequeue() {
        if (isEmpty()) {
            System.out.println("No hay tareas por eliminar.");
            return null;
        }

        String task = data[front];
        data[front] = null;

        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front++;
        }

        return task;
    }

    public String peek() {
        if (isEmpty()) {
            System.out.println("No hay tareas urgentes por realizar.");
            return null;
        } else {
            return data[front];
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("No hay ninguna tarea pendiente.");
            return;
        }

        System.out.println("Tareas pendientes: ");
            for (int i = front; i <= rear; i++) {
                System.out.print(data[i] + " | ");
            }
        System.out.println();
    }
}
