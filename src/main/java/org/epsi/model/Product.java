package org.epsi.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String name;

    private Date dateLimiteConso;

    private Integer codeProduit;

    private Integer quantity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nom) {
        this.name = nom;
    }

    public Date getDateLimiteConso() {
        return dateLimiteConso;
    }

    public void setDateLimiteConso(Date date_Limite_Conso) {
        this.dateLimiteConso = date_Limite_Conso;
    }

    public Integer getCodeProduit() {
        return codeProduit;
    }

    public void setCodeProduit(Integer code_Produit) {
        this.codeProduit = code_Produit;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantite) {
        this.quantity = quantite;
    }

    public Integer getRemainingDays() {return 5;}

}