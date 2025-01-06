package com.example.sistemaPulseira.service.implementacao;

import com.example.sistemaPulseira.entity.Cliente;
import com.example.sistemaPulseira.repository.PulseiraRepository;
import com.example.sistemaPulseira.service.PulseiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PulseiraServiceImpl implements PulseiraService {
    @Autowired
    private PulseiraRepository pulseiraRepository;


    public List<Cliente> getAllClientes() {
        return pulseiraRepository.findAll();
    }
}
