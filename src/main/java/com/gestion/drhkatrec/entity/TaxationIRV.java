package com.gestion.drhkatrec.entity;

import jakarta.persistence.*;

import java.sql.Date;
@Entity
public class TaxationIRV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "numeroNote")
    private Notes notes;
    String adrese;
    @Column(length = 30)
    String marque;
    @Column(length = 30)
    String chassit;
    @Column(length = 30)
    String numeroPlaque;
    @Column(length = 30)
    String puissanceFiscale;
    @Column(length = 30)
    Double montant;
    @Column(length = 3)
    String devise;
    @Column(length = 30)
    String taxateur;
    @Column(length = 30)
    String lieu;
    @Column(length = 30)
    Date note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
    }

    public String getAdrese() {
        return adrese;
    }

    public void setAdrese(String adrese) {
        this.adrese = adrese;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getChassit() {
        return chassit;
    }

    public void setChassit(String chassit) {
        this.chassit = chassit;
    }

    public String getNumeroPlaque() {
        return numeroPlaque;
    }

    public void setNumeroPlaque(String numeroPlaque) {
        this.numeroPlaque = numeroPlaque;
    }

    public String getPuissanceFiscale() {
        return puissanceFiscale;
    }

    public void setPuissanceFiscale(String puissanceFiscale) {
        this.puissanceFiscale = puissanceFiscale;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public String getTaxateur() {
        return taxateur;
    }

    public void setTaxateur(String taxateur) {
        this.taxateur = taxateur;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Date getNote() {
        return note;
    }

    public void setNote(Date note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "TaxationIRV{" +
                ", notes=" + notes +
                ", adrese='" + adrese + '\'' +
                ", marque='" + marque + '\'' +
                ", chassit='" + chassit + '\'' +
                ", numeroPlaque='" + numeroPlaque + '\'' +
                ", puissanceFiscale='" + puissanceFiscale + '\'' +
                ", montant='" + montant + '\'' +
                ", devise='" + devise + '\'' +
                ", taxateur='" + taxateur + '\'' +
                ", lieu='" + lieu + '\'' +
                ", note=" + note +
                '}';
    }
}
