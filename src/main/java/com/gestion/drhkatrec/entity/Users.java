package com.gestion.drhkatrec.entity;

import jakarta.persistence.*;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    private static int counter = 0;
    @Column(name = "nom", length = 59)
    String nom;
    @Column(name = "postnom", length = 50)
    String postnom;
    @Column(name = "email", length = 20)
    String email;
    @Column(name = "phhone", length = 12)
    String phone;
    @Column(name = "genre", length = 2)
    String genre;
    @Column(name = "ville", length = 30)
    String ville;
    @Column(name = "province", length = 30)
    String province;
    @Column(nullable = false, unique = true, length = 10, updatable = false)
    private String matricule;

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Users() {
    }

    public Users(Long id, String nom, String postnom, String email, String phone, String genre, String ville, String province) {
        this.id = id;
        this.nom = nom;
        this.postnom = postnom;
        this.email = email;
        this.phone = phone;
        this.genre = genre;
        this.ville = ville;
        this.province = province;

        genMatricule();
    }


    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPostnom() {
        return postnom;
    }

    public void setPostnom(String postnom) {
        this.postnom = postnom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Users{" +
                "nom='" + nom + '\'' +
                ", postnom='" + postnom + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", genre='" + genre + '\'' +
                ", ville='" + ville + '\'' +
                ", province='" + province + '\'' +
                '}';
    }

    public void genMatricule() {
        counter++;
        if (this.matricule == null) {
            this.matricule = "23" + nom.substring(0, 2).toUpperCase() + String.format("%03d", counter);
        }
    }
}
