package org.example.todo;

import org.example.entity.Categories;
import org.example.entity.TaskInfo;
import org.example.entity.Todo;
import org.example.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.Date;
import java.util.List;

public class Start {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_demo_postgres");

    public static Todo addTodo(String titre, Boolean completed, int id_utilisateur){
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        User user = viewUser(id_utilisateur);
        Todo todo = new Todo(titre, completed, user);
        em.persist(todo);

        em.getTransaction().commit();

        return todo;

    }

    public static TaskInfo addTaskInfo (String description, Date date, String propiete, int id){
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        TaskInfo taskInfo = new TaskInfo(description, date, propiete );

        em.persist(taskInfo);

        em.getTransaction().commit();
        updateTodo(id, taskInfo);
        em.close();


        return taskInfo;
    }



    public static Categories addCategories(String name){
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Categories categories = new Categories(name);
        em.persist(categories);

        em.getTransaction().commit();

        em.close();

        return categories;
    }

    public  static void addUser(String name){
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        User user = new User(name);
        em.persist(user);

        em.getTransaction().commit();
        em.close();

    }

    public static  void viewAllTaskUser(int id){
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        List<Todo> todoList = null;

        Query query = em.createQuery("select t from Todo t where id_utilisateur = :id", Todo.class);


        query.setParameter("id", id);

        todoList = query.getResultList();

        for (Todo t : todoList){
            System.out.println(t);
        }

        em.getTransaction().commit();
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

    public  static  void viewAllTodoCategory(int id){
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        List<Categories> todoList = null;

       Query query = em.createQuery("select t from Categories t where id = :id", Categories.class);

        query.setParameter("id", id);

        todoList = query.getResultList();


        for ( Categories t : todoList){
            System.out.println(t.getTodo());
        }

        em.getTransaction().commit();


    }

    public static User viewUser(int id){
        EntityManager em = emf.createEntityManager();
        User user = em.find(User.class, id);
        return user;
    }

    public  static Categories viewCategory(int id){
        EntityManager em = emf.createEntityManager();
        Categories categories = em.find(Categories.class, id);
        return categories;
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

    public  static  void updateTodoCategories(int id, Categories categories){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Todo todo = em.find(Todo.class, id);
        todo.setCategories(categories);
        em.getTransaction().commit();
    }

    public  static void deleteTodo(int id){
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Todo todo = em.find(Todo.class, id);
        em.remove(todo);
        em.getTransaction().commit();

    }

    public  static  void deleteCategories(int id){
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Categories categories = em.find(Categories.class, id);
        em.remove(categories);
        em.getTransaction().commit();
    }

    public  static  void  deleteUser(int id){
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        User user = em.find(User.class, id);
        em.remove(user);
        em.getTransaction().commit();
    }

    public  static  void  deleteTodoToCategories(int id, int id_category){
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Todo todo = em.find(Todo.class, id);
//        Categories categories = viewCategory(id_category);
//        categories.getTodo().remove(todo);
//        em.persist(categories);
//        for (Categories c : todo.getCategories()){
//            if (id_category != c.getId()){
//                List<Categories>
//            }
//        }
        System.out.println(todo.getCategories().size());
        todo.getCategories().removeIf(c -> c.getId() == id_category);
        System.out.println(todo.getCategories().size());
        em.merge(todo);
        em.getTransaction().commit();
    }


}
