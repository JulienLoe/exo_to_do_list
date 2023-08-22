package org.example.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


//On souhaite rajouter des utilisateurs à notre programme TodoList.
//
//        Un utilisateur est défini par un nom.
//
//        Un utilisateur peut avoir plusieurs taches et une tache ne peut etre attribuer qu'a un seul utilisateur.
//
//
//
//        Dans le menu princial de l'application on doit pouvoir :
//
//        - Ajouter un utilisateur
//
//        - Afficher toutes les taches d'un utilisateur
//
//        - Supprimer un utilisateur et toutes ses tâches
@Entity
@Table(name = "menbre")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nom")
    private String nom;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Todo> todo = new HashSet<Todo>();

    public User(){

    }

    public User(String nom){
        this.nom = nom;
    }

    public User(int id, String nom, Set<Todo> todo) {
        this.id = id;
        this.nom = nom;
        this.todo = todo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", todo=" + todo +
                '}';
    }
}
