package Class;

public class Stack {

    private int top;
    private final int capacity = 5;
    private String[] data;
    
    public Stack() {
        this.data = new String[this.capacity];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == this.capacity - 1;
    }

    public void push(String urg_task) {
        if (isFull()) {
            System.out.println("Ya hay demasiadas tareas urgentes por resolver.");
        } else {
            data[++top] = urg_task;
        }

    }

    public String pop() {
        if (isEmpty()) {
            System.out.println("No hay tareas urgentes por realizar.");
            return null;
        } else {
            return data[top--];
        }
    }

    public String peek() {
        if (isEmpty()) {
            System.out.println("No hay tareas urgentes por realizar.");
            return null;
        } else {
            return data[top];
        }
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("No hay tareas urgentes por realizar.");
        } else {
            System.out.println("Tareas urgentes pendientes: ");
            for (int i = top; i >= 0; i--) {
                
            }
        }
    }
}