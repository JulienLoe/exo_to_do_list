package org.example.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "TaskInfo")
public class TaskInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    private java.sql.Date date;

    private String propriete;


    public TaskInfo() {
    }

    public TaskInfo(String description, java.sql.Date date, String propriete) {

        this.description = description;
        this.date = date;
        this.propriete = propriete;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }



    public String getPropriete() {
        return propriete;
    }

    public void setPropriete(String propriete) {
        this.propriete = propriete;
    }
}
