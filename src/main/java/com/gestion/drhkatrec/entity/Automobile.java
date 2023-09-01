package com.gestion.drhkatrec.entity;

import javax.persistence.Entity;


import javax.persistence.*;
@Entity
@Table(name = "automobile")
public class Automobile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @ManyToOne
    @JoinColumn(name = "contribuable_id")
    private Users contribuable;
    // Utilisation d'une énumération pour restreindre les valeurs possibles
    @Column(length = 2)
    String genre; // Valeur par défaut
    @Column(length = 20)
    String  marque ;
    @Column(length = 20)
    String  modele ;
    @Column(length = 20)
    String  matricule ;
    @Column(length = 20)
    String  NumChassis ;
    @Column(length = 20)
    String  puissanceFiscale ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getContribuable() {
        return contribuable;
    }

    public void setContribuable(Users contribuable) {
        this.contribuable = contribuable;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNumChassis() {
        return NumChassis;
    }

    public void setNumChassis(String numChassis) {
        NumChassis = numChassis;
    }

    public String getPuissanceFiscale() {
        return puissanceFiscale;
    }

    public void setPuissanceFiscale(String puissanceFiscale) {
        this.puissanceFiscale = puissanceFiscale;
    }

    @Override
    public String toString() {
        return "Automobile{" +
                "id=" + id +
                ", contribuable=" + contribuable +
                ", genre='" + genre + '\'' +
                ", marque='" + marque + '\'' +
                ", modele='" + modele + '\'' +
                ", matricule='" + matricule + '\'' +
                ", NumChassis='" + NumChassis + '\'' +
                ", puissanceFiscale='" + puissanceFiscale + '\'' +
                '}';
    }
}
