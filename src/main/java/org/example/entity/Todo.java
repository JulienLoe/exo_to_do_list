package org.example.entity;

import javax.persistence.*;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;


@Entity
    @Table(name = "todo")
    public class Todo {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String titre;
        private Boolean completed;

        @OneToOne
        @JoinColumn(name = "id_taskInfo")
        private TaskInfo taskInfo;

        @ManyToOne
        @JoinColumn(name = "id_utilisateur")
        private User user;

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinTable(name = "todo_categories", joinColumns = @JoinColumn(name = "todo_id"),
            inverseJoinColumns = @JoinColumn(name = "categories_id"))
    private List<Categories> categories = new ArrayList<>();

        public Todo(){

        }

        public Todo( String titre, Boolean completed, User user) {

            this.titre = titre;
            this.completed = false;
            this.user = user;
        }

        public Todo(int id, String titre, Boolean completed) {
            this.id = id;
            this.titre = titre;
            this.completed = false;
        }

    public List<Categories> getCategories() {
        return categories;
    }

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }

    public int getId() {
            return id;
        }

        public Todo(int id, Boolean completed){
            this.completed = completed;
            this.id = id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitre() {
            return titre;
        }

        public void setTitre(String titre) {
            this.titre = titre;
        }

        public Boolean getCompleted() {
            return completed;
        }

        public void setCompleted(Boolean completed) {
            this.completed = completed;
        }

        public void setTaskInfo(TaskInfo taskInfo){
            this.taskInfo = taskInfo;
        }

    public void setCategories(Categories categories){
        this.categories.add(categories);
    }

        @Override
        public String toString() {
            return "todo{" +
                    "id=" + id +
                    ", titre='" + titre + '\'' +
                    ", completed=" + completed +
                    taskInfo.toString()
            +'}';
        }
    }


