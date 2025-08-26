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
            System.out.println(YELLOW + "*** IT SOLUTIONS CUU ***" + RESET);
            System.out.println("1- Gestionar incidentes críticos\n2- Programar tareas\n3- Gestionar tareas por departamento\n4- Salir del programa");

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
                        System.out.println(YELLOW + "\n*** Incidentes críticos ***" + RESET);
                        System.out.println("1- Agregar incidente crítico\n2- Ver último incidente\n3- Marcar como resuelto el último incidente\n4- Ver todas los incidentes críticos\n5- Regresar al gestor de tareas");

                        try {
                            System.out.print(BLUE + "\nIngresa una opción: " + RESET);
                            urgOption = scanner.nextInt();
                            scanner.nextLine();
                        } catch (InputMismatchException e) {
                            System.out.println(RED + "Error." + RESET);
                            scanner.nextLine();
                        }

                        switch (urgOption) {
                            case 1: 
                                System.out.print(CYAN + "\nDetalles del incidente (Ej. Servidor caído, BDD corrompida): " + RESET);
                                String urgTask = scanner.nextLine();
                                stack.push(urgTask);
                                break;
                            
                            case 2:
                                System.out.print(CYAN + "\nÚltima incidente agregado: " + RESET + YELLOW + stack.peek() + RESET + "\n");
                                break;

                            case 3:
                                String solvedStack = stack.pop();
                                System.out.println(CYAN + "\nIncidente " + RESET + YELLOW + solvedStack + RESET + CYAN + " marcado como resuelto." + RESET);
                                break;
                            
                            case 4:
                                stack.show();
                                break;

                            case 5:
                                System.out.println("\nRegresando...\n");
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
                        System.out.println("\n1- Programar tarea\n2- Ver tarea en progreso\n3- Marcar como terminada la tarea en progreso\n4- Ver todas las tareas programadas\n5- Regresar al gestor de tareas");

                        try {
                            System.out.print(BLUE + "\nIngresa una opción: " + RESET);
                            progOption = scanner.nextInt();
                            scanner.nextLine();
                        } catch (InputMismatchException e) {
                            System.out.println(RED + "Error." + RESET);
                            scanner.nextLine();
                        }

                        switch (progOption) {
                            case 1: 
                                System.out.print(CYAN + "\nDetalles para programar la tarea: " + RESET);
                                String progTask = scanner.nextLine();
                                queue.enqueue(progTask);
                                break;
                            
                            case 2:
                                System.out.print(CYAN + "\nTarea en progreso:" + RESET + YELLOW + queue.peek() + RESET + "\n");
                                break;

                            case 3:
                                String solvedQueue = queue.dequeue();
                                System.out.println(CYAN + "\nTarea " + RESET + YELLOW + solvedQueue + RESET + CYAN + " marcada como resuelta." + RESET);
                                break;
                            
                            case 4:
                                queue.display();
                                break;

                            case 5:
                                System.out.println("\nRegresando...\n");
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
                            System.out.println(RED + "Error." + RESET);
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
                                System.out.println();
                                break;
                            
                            case 6:
                                System.out.println("\nRegresando...\n");
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
