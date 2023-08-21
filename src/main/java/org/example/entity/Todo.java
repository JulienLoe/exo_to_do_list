package org.example.entity;

import javax.persistence.*;



    @Entity
    @Table(name = "todo")
    public class Todo {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String titre;
        private Boolean completed;

        public Todo(){

        }

        public Todo( String titre, Boolean completed) {

            this.titre = titre;
            this.completed = false;
        }

        public Todo(int id, String titre, Boolean completed) {
            this.id = id;
            this.titre = titre;
            this.completed = false;
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

        @Override
        public String toString() {
            return "todo{" +
                    "id=" + id +
                    ", titre='" + titre + '\'' +
                    ", completed=" + completed +
                    '}';
        }
    }


