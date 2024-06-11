package com.testeRed.ventures.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_PROTEINAS")
public class ProteinasModel implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String imageInactive;

    private String  imageActive;
    private String name;
    private String description;
    private double price;

    //Construtor deve ser comentado quando for utilzar o banco de dados real
    public ProteinasModel(UUID id, String imageInactive, String  imageActive, String name, String description, double price) {
        this.id = id;
        this.imageInactive = imageInactive;
        this.imageActive = imageActive;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getImageInactive() {
        return imageInactive;
    }

    public void setImageInactive(String imageInactive) {
        this.imageInactive = imageInactive;
    }

    public String getImageActive() {
        return imageActive;
    }

    public void setImageActive(String imageActive) {
        this.imageActive = imageActive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
