package com.testeRed.ventures.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;
@Entity
@Table(name = "TB_PEDIDOS")
public class PedidoModel implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String brothId;
    private String proteinId;

    private String name;

    //Construtor deve ser comentado quando for utilzar o banco de dados real
    public PedidoModel(UUID id, String brothId, String proteinId, String name) {
        this.id = id;
        this.brothId = brothId;
        this.proteinId = proteinId;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getBrothId() {
        return brothId;
    }

    public void setBrothId(String brothId) {
        this.brothId = brothId;
    }

    public String getProteinId() {
        return proteinId;
    }

    public void setProteinId(String proteinId) {
        this.proteinId = proteinId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
