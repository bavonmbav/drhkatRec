package com.gestion.drhkatrec.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
    private Users contribuable;
    @Column(length = 30)
    String adresse;
    @Column(length = 30)
    String natureTaxe;
    @Column(length = 30)
    String service;
    @Column(length = 30)
    String montant;
    @Column(length = 3)
    String Devise;
    @Column(length = 30)
    Long montantChiffre;
    @Column(length = 30)
    String ordonateur;
    @Column(length = 30)
    String Lieux;
    @Column(length = 30)
    Date note;

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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNatureTaxe() {
        return natureTaxe;
    }

    public void setNatureTaxe(String natureTaxe) {
        this.natureTaxe = natureTaxe;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getMontant() {
        return montant;
    }

    public void setMontant(String montant) {
        this.montant = montant;
    }

    public String getDevise() {
        return Devise;
    }

    public void setDevise(String devise) {
        Devise = devise;
    }

    public Long getMontantChiffre() {
        return montantChiffre;
    }

    public void setMontantChiffre(Long montantChiffre) {
        this.montantChiffre = montantChiffre;
    }

    public String getOrdonateur() {
        return ordonateur;
    }

    public void setOrdonateur(String ordonateur) {
        this.ordonateur = ordonateur;
    }

    public String getLieux() {
        return Lieux;
    }

    public void setLieux(String lieux) {
        Lieux = lieux;
    }

    public Date getNote() {
        return note;
    }

    public void setNote(Date note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Notes{" +
                "id=" + id +
                ", contribuable=" + contribuable +
                ", adresse='" + adresse + '\'' +
                ", natureTaxe='" + natureTaxe + '\'' +
                ", service='" + service + '\'' +
                ", montant='" + montant + '\'' +
                ", Devise='" + Devise + '\'' +
                ", montantChiffre=" + montantChiffre +
                ", ordonateur='" + ordonateur + '\'' +
                ", Lieux='" + Lieux + '\'' +
                ", note=" + note +
                '}';
    }
}
