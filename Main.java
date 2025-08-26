import Class.Queue;
import Class.Stack;
import Class.LinkedList;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

        private static final String RESET = "\u001B[0m";
        private static final String RED = "\u001B[31m";
        private static final String CYAN = "\u001B[36m";
        private static final String BLUE = "\u001B[34m";
        private static final String YELLOW = "\u001B[33m";


    public static void main(String[] args) {

        Queue queue = new Queue();
        Stack stack = new Stack();
        LinkedList linkedList = new LinkedList();
        Scanner scanner = new Scanner(System.in);

        int option = 0;

        do {
            System.out.println(YELLOW + "*** SISTEMA DE GESTIÓN DE TAREAS ***" + RESET);
            System.out.println("1- Gestionar tareas urgentes (Pila)\n2- Gestionar tareas programadas (Cola)\n3- Gestionar tareas por departamento (Lista)\n4- Salir del programa");

            try {
                System.out.print(BLUE + "\nIngresa una opción: " + RESET);
                option = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(RED + "Error. Opción inválida." + RESET);
                scanner.nextLine();
            }

            switch (option) {
                case 1: // Tareas urgentes (Stack)
                    int urgOption = 0;

                    do {
                        System.out.println(YELLOW + "\n*** Gestor de tareas urgentes ***" + RESET);
                        System.out.println("1- Agregar tarea urgente\n2- Ver última tarea\n3- Resolver última tarea\n4- Ver todas las tareas urgentes\n5- Regresar al gestor de tareas");

                        try {
                            System.out.print(BLUE + "\nIngresa una opción: " + RESET);
                            urgOption = scanner.nextInt();
                            scanner.nextLine();
                        } catch (InputMismatchException e) {
                            System.out.println(RED + "Error. Opción inválida." + RESET);
                            scanner.nextLine();
                        }

                        switch (urgOption) {
                            case 1: 
                                System.out.print(CYAN + "\nDetalles de la tarea urgente: " + RESET);
                                String urgTask = scanner.nextLine();
                                stack.push(urgTask);
                                break;
                            
                            case 2:
                                System.out.print(CYAN + "\nÚltima tarea agregada: " + RESET + YELLOW + stack.peek() + RESET + "\n");
                                break;

                            case 3:
                                String solvedStack = stack.pop();
                                System.out.println(CYAN + "\nTarea " + RESET + YELLOW + solvedStack + RESET + CYAN + " resuelta." + RESET);
                                break;
                            
                            case 4:
                                stack.show();
                                break;

                            default:
                                System.out.println(RED + "Opción inválida." + RESET);
                                break;
                        }
                    } while (urgOption != 5);
                    break;

                case 2: // Tareas programadas (Queue)
                    int progOption = 0;

                    do {
                        System.out.println(YELLOW + "\n*** Gestor de tareas programadas ***" + RESET);
                        System.out.println("1- Agregar tarea programada\n2- Ver tarea en progreso\n3- Terminar tarea en ejecución\n4- Ver todas las tareas programadas\n5- Regresar al gestor de tareas");

                        try {
                            System.out.print(BLUE + "\nIngresa una opción: " + RESET);
                            progOption = scanner.nextInt();
                            scanner.nextLine();
                        } catch (InputMismatchException e) {
                            System.out.println(RED + "Error. Opción inválida." + RESET);
                            scanner.nextLine();
                        }

                        switch (progOption) {
                            case 1: 
                                System.out.print(CYAN + "\nDetalles para de la tarea programada: " + RESET);
                                String progTask = scanner.nextLine();
                                queue.enqueue(progTask);
                                break;
                            
                            case 2:
                                System.out.print(CYAN + "\nTarea en progreso:" + RESET + YELLOW + queue.peek() + RESET + "\n");
                                break;

                            case 3:
                                String solvedQueue = queue.dequeue();
                                System.out.println(CYAN + "\nTarea " + RESET + YELLOW + solvedQueue + RESET + CYAN + " resuelta." + RESET);
                                break;
                            
                            case 4:
                                queue.display();
                                break;

                            default:
                                System.out.println(RED + "Opción inválida." + RESET);
                                break;
                        }
                    } while (progOption != 5);
                    break;

                case 3: // Tareas por departamento (LinkedList)
                    int deptOption = 0;
                    do {
                        System.out.println(YELLOW + "\n*** Gestor de tareas por departamento ***" + RESET);
                        System.out.println("1- Agregar tarea\n2- Buscar tareas por departamento\n3- Eliminar primera tarea\n4- Eliminar última tarea\n5- Mostrar todas las tareas\n6- Regresar al gestor de tareas");

                        try {
                            System.out.print(BLUE + "\nIngresa una opción: " + RESET);
                            deptOption = scanner.nextInt();
                            scanner.nextLine();
                        } catch (InputMismatchException e) {
                            System.out.println(RED + "Error. Opción inválida." + RESET);
                            scanner.nextLine();
                        }

                        switch (deptOption) {
                            case 1: 
                                System.out.print(CYAN + "\nDepartamento: " + RESET);
                                String dpt = scanner.nextLine();
                                System.out.print(CYAN + "\nDetalles de la tarea: " + RESET);
                                String deptTask = scanner.nextLine();
                                String newTask = dpt.concat(": ").concat(deptTask);
                                linkedList.insertFirst(newTask);
                                break;
                            
                            case 2:
                                System.out.print(CYAN + "\nDepartamento a buscar: " + RESET );
                                String findDpt = scanner.nextLine();
                                linkedList.findByDepartment(findDpt);
                                break;

                            case 3:
                                linkedList.deleteFirst();
                                break;
                            
                            case 4:
                                linkedList.deleteLast();
                                break;

                            case 5:
                                linkedList.show();
                                break;

                            default:
                                System.out.println(RED + "Opción inválida." + RESET);
                                break;
                        }
                    } while (deptOption != 6);
                    break;
                
                case 4:
                    System.out.println(RED + "Saliendo del programa..." + RESET);
                    break;

                default:
                    System.out.println(RED + "Opción inválida." + RESET);
                    break;
            }
        } while (option != 4);

        scanner.close();
    }
}
