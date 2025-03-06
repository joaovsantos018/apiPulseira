package com.example.sistemaPulseira.repository;


import com.example.sistemaPulseira.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PulseiraRepository extends JpaRepository<Cliente, Integer> {

}
