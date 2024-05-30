package com.testeRed.ventures.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "TB_CALDOS")
public class CaldosModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idCaldo;
    private String name;
    private BigDecimal value;

    public UUID getIdCaldo() {
        return idCaldo;
    }

    public void setIdCaldo(UUID idCaldo) {
        this.idCaldo = idCaldo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }


}
