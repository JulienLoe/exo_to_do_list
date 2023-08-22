package org.example.todo;

import org.example.entity.TaskInfo;
import org.example.entity.Todo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Date;
import java.util.List;

public class Start {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_demo_postgres");

    public static void addTodo(String titre, Boolean completed){
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Todo todo = new Todo(titre, completed);
        em.persist(todo);

        em.getTransaction().commit();

    }

    public static TaskInfo addTaskInfo (String description, Date date, String propiete){
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        TaskInfo taskInfo = new TaskInfo(description, date, propiete );

        em.persist(taskInfo);

        em.getTransaction().commit();

        return taskInfo;
    }

    public static  void  viewAllTodo(){
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        List<Todo> todoList = null;

        todoList = em.createQuery("select t from Todo t", Todo.class).getResultList();

        for (Todo t : todoList){
            System.out.println(t);
        }

        em.getTransaction().commit();
    }

    public  static  Boolean viewTodo(int id){
        EntityManager em = emf.createEntityManager();
        Todo todo = em.find(Todo.class, id);
        return todo.getCompleted();


    }

    public  static  Todo viewTodoTitle(int id){
        EntityManager em = emf.createEntityManager();
        Todo todo = em.find(Todo.class, id);
        return todo;


    }

    public static void updateSatuts(int id, boolean completed){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Todo todo = em.find(Todo.class, id);
        todo.setCompleted(completed);
        em.getTransaction().commit();



    }

    public  static  void updateTodo(int id, TaskInfo taskInfo){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Todo todo = em.find(Todo.class, id);
        todo.setTaskInfo(taskInfo);
        em.getTransaction().commit();
    }

    public  static void deleteTodo(int id){
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Todo todo = em.find(Todo.class, id);
        em.remove(todo);
        em.getTransaction().commit();

    }


}
