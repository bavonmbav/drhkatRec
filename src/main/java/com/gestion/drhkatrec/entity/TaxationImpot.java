package com.gestion.drhkatrec.entity;

import javax.persistence.*;

import java.sql.Date;

@Entity
public class TaxationImpot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "contribuables")
    private Users contribuable;
    @ManyToOne
    @JoinColumn(name = "numeroNote")
    private Notes notes;
    @Column(length = 3)
    String naturebien;
    @Column(length = 30)
    Double sperficiedubien;
    @Column(length = 3)
    String devise;
    @Column(length = 30)
    String montant;
    @Column(length = 30)
    Long Montantchiffre;
    @Column(length = 30)
    String TAxateur;
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

    public Users getContribuable() {
        return contribuable;
    }

    public void setContribuable(Users contribuable) {
        this.contribuable = contribuable;
    }

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
    }

    public String getNaturebien() {
        return naturebien;
    }

    public void setNaturebien(String naturebien) {
        this.naturebien = naturebien;
    }

    public Double getSperficiedubien() {
        return sperficiedubien;
    }

    public void setSperficiedubien(Double sperficiedubien) {
        this.sperficiedubien = sperficiedubien;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public String getMontant() {
        return montant;
    }

    public void setMontant(String montant) {
        this.montant = montant;
    }

    public Long getMontantchiffre() {
        return Montantchiffre;
    }

    public void setMontantchiffre(Long montantchiffre) {
        Montantchiffre = montantchiffre;
    }

    public String getTAxateur() {
        return TAxateur;
    }

    public void setTAxateur(String TAxateur) {
        this.TAxateur = TAxateur;
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
        return "TaxationImpot{" +
                "id=" + id +
                ", contribuable=" + contribuable +
                ", notes=" + notes +
                ", naturebien='" + naturebien + '\'' +
                ", sperficiedubien=" + sperficiedubien +
                ", devise='" + devise + '\'' +
                ", montant='" + montant + '\'' +
                ", Montantchiffre=" + Montantchiffre +
                ", TAxateur='" + TAxateur + '\'' +
                ", lieu='" + lieu + '\'' +
                ", note=" + note +
                '}';
    }
}
