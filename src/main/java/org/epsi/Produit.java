package org.epsi;


import javax.persistence.*;
import java.sql.Date;

@Entity
    @Table(name = "Produit")
    public class Produit {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;


    private String nom;


    private Date date_Limite_Conso;


    private Integer code_Produit;


    private Integer quantite;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDate_Limite_Conso() {
        return date_Limite_Conso;
    }

    public void setDate_Limite_Conso(Date date_Limite_Conso) {
        this.date_Limite_Conso = date_Limite_Conso;
    }

    public Integer getCode_Produit() {
        return code_Produit;
    }

    public void setCode_Produit(Integer code_Produit) {
        this.code_Produit = code_Produit;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }
}
