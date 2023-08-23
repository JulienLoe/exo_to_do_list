package org.example;

import org.example.entity.Categories;
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

    private static  Categories categories = new Categories();
    public static void main(String[] args) throws ParseException {


            boolean running = true;
            while (running) {
                System.out.println("1. Créer une Todo");
                System.out.println("2. Afficher totutes les todos");
                System.out.println("3. Marquer todo comme fini");
                System.out.println("4. Supprimer une todo");
                System.out.println("5. Afficher toutes les taches d'une catégories");
                System.out.println("6. Ajouter un utilisateur");
                System.out.println("7. Afficher toutes les taches d'un utilisateur");
                System.out.println("8. Supprimer un utilisateur et toutes ses tâches");
                System.out.println("9. Ajouter une tache à une catégories");
                System.out.println("10. Supprimer une catégories");
                System.out.println("11. Supprimer une taches à une catégorie");
                System.out.println("12. Ajouter une catégorie");
                System.out.println("0. Quitter");
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
                        viewAllCategorie();
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
                        createCategories();
                        break;
                    case 10:
                        categoriesDelete();
                        break;
                    case 11:
                        todoOfCategoriesDelete();
                        break;
                    case 12:
                        createCategoriesAsso();
                        break;
                    case 0:
                        running = false;
                        break;

                    default:
                        System.out.println("Choix invalide !");
                }

            }
            System.out.println("Au revoir !");


    }
    private static void createTodo() throws ParseException {
        boolean completed = false;
        System.out.println("ID de l'utilisateur :");
        int id_user = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Titre  : ");
        String titre = scanner.nextLine();

        Todo todo = Start.addTodo(titre, completed, id_user);
        createTask(todo.getId());
    };

    private static  void createUser(){
        System.out.println("Votre nom :");
        String nom = scanner.nextLine();
        Start.addUser(nom);
    }

    private  static  void createCategories(){
        System.out.println("ID de la catégorie :");
        int id_category = scanner.nextInt();
        System.out.println("A quelle Todo faut-il l'associer :");
        int id = scanner.nextInt();
        Categories categories1 = Start.viewCategory(id_category);

        Start.updateTodoCategories(id, categories1);
    }

    private  static  void createCategoriesAsso(){
        System.out.println("Nom de la catégorie :");
        String nom = scanner.nextLine();
        Start.addCategories(nom);
    }

    private  static TaskInfo createTask(int id) throws ParseException {


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

//    private  static  void updateTask() throws ParseException {
//        System.out.println("ID de la Todo :");
//        int id = scanner.nextInt();
//        TaskInfo taskInfo =  createTask();
//        Start.updateTodo(id, taskInfo);
//    }

    private static void  viewTodo(){

        Start.viewAllTodo();
    }

    private static void  viewAllCategorie(){
        System.out.println("ID de la catégorie :");
        int id = scanner.nextInt();
        Start.viewAllTodoCategory(id);
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

    private  static  void categoriesDelete(){
        System.out.println("ID de la categories à supprimer :");
        int id = scanner.nextInt();
        Start.deleteCategories(id);
    }

    private  static  void todoOfCategoriesDelete(){
        System.out.println("ID de la categories :");
        int id_category = scanner.nextInt();
        System.out.println("ID de Todo à supprimer :");
        int id_todo = scanner.nextInt();
        Start.deleteTodoToCategories(id_todo, id_category);
    }
}