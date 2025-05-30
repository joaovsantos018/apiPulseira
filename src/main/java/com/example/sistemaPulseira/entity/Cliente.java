package com.example.sistemaPulseira.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Cliente {

    @Id
    @Column(name = "pulseiraID")
    public Integer pulseiraID;


    public Double saldo ;

    public String nome;
}
