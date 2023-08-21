package org.example;

import org.example.entity.Todo;
import org.example.todo.Start;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private Todo todolist = new Todo();

    private static Start startTodo = new Start();
    public static void main(String[] args) {


            boolean running = true;
            while (running) {
                System.out.println("1. Créer une Todo");
                System.out.println("2. Afficher totutes les todos");
                System.out.println("3. Marquer todo comme fini");
                System.out.println("4. Supprimer une todo");
                System.out.println("5. Quitter");
                System.out.print("Choix : ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        createTodo();
                        break;
                    case 2:
                        viewTodo();
                        break;
                    case 3:
                        todoCompleted();
                        break;
                    case 4:
                        todoDelete();
                        break;
                    case 5:
                        running = false;
                        break;
                    default:
                        System.out.println("Choix invalide !");
                }

            }
            System.out.println("Au revoir !");


    }
    private static void createTodo() {
        boolean completed = false;
        System.out.print("Titre  : ");
        String titre = scanner.nextLine();
        Start.addTodo(titre, completed);
    };

    private static void  viewTodo(){
        Start.viewAllTodo();
    }

    private  static void  todoCompleted (){
        System.out.println("ID du Todo completed : ");
        int id = scanner.nextInt();
        Start.updateSatuts(id,!Start.viewTodo(id));
    }

    private  static  void todoDelete(){
        System.out.println("ID de la todo à supprimer : ");
        int id = scanner.nextInt();
        Start.deleteTodo(id);
    }
}