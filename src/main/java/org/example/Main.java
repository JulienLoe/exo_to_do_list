package org.example;

import org.example.entity.TaskInfo;
import org.example.entity.Todo;
import org.example.todo.Start;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private Todo todolist = new Todo();

    private static Start startTodo = new Start();
    public static void main(String[] args) throws ParseException {


            boolean running = true;
            while (running) {
                System.out.println("1. Créer une Todo");
                System.out.println("2. Afficher totutes les todos");
                System.out.println("3. Marquer todo comme fini");
                System.out.println("4. Supprimer une todo");
                System.out.println("5. Ajouter une todoTask");
                System.out.println("6. Ajouter un utilisateur");
                System.out.println("7. Afficher toutes les taches d'un utilisateur");
                System.out.println("8. Supprimer un utilisateur et toutes ses tâches");
                System.out.println("9. Quitter");
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
                        createTask();
                        break;
                    case 6:
                        createUser();
                        break;
                    case 7:
                        viewTodoUser();
                        break;
                    case 8:
                        userDelete();
                        break;
                    case 9:
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
        System.out.println("ID de l'utilisateur :");
        int id_user = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Titre  : ");
        String titre = scanner.nextLine();
        Start.addTodo(titre, completed, id_user);
    };

    private static  void createUser(){
        System.out.println("Votre nom :");
        String nom = scanner.nextLine();
        Start.addUser(nom);
    }

    private  static TaskInfo createTask() throws ParseException {

        System.out.println("ID de ma TODO :");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Description : ");
        String description = scanner.nextLine();
        System.out.println("Date : ");
        String dateLine = scanner.nextLine();
        java.util.Date format = new SimpleDateFormat("yyyy/MM/dd").parse(dateLine);
        java.sql.Date date = new java.sql.Date(format.getTime());
        System.out.println("Priorites : ");
        String priorites = scanner.nextLine();

        return Start.addTaskInfo(description, date, priorites, id);
    }

    private  static  void updateTask() throws ParseException {
        System.out.println("ID de la Todo :");
        int id = scanner.nextInt();
        TaskInfo taskInfo =  createTask();
        Start.updateTodo(id, taskInfo);
    }

    private static void  viewTodo(){
        Start.viewAllTodo();
    }

    private  static  void viewTodoUser(){
        System.out.println("ID de l'utilisateur : ");
        int id = scanner.nextInt();
        Start.viewAllTaskUser(id);
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

    private  static  void userDelete(){
        System.out.println("ID de l'utilisateur à supprimer :");
        int id = scanner.nextInt();
        Start.deleteUser(id);
    }
}