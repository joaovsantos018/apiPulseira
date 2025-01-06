package com.example.sistemaPulseira.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Cliente {

    @Id
    public UUID pulseiraID;

    public Double saldo;

    public String nome;
}
