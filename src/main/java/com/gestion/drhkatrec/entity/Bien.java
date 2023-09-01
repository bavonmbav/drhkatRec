package com.gestion.drhkatrec.entity;

import javax.persistence.*;

@Entity
public class Bien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "Contribuable")
    public Users users;
    @Column(name = "adresse", length = 30)
    public String adresse;
    @Column(name="natureBien")
    public String natureBien;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNatureBien() {
        return natureBien;
    }

    public void setNatureBien(String natureBien) {
        this.natureBien = natureBien;
    }

    @Override
    public String toString() {
        return "Bien{" +
                "users=" + users +
                ", adresse='" + adresse + '\'' +
                ", natureBien='" + natureBien + '\'' +
                '}';
    }
}
