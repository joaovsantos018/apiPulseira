package com.example.sistemaPulseira.controller;

import com.example.sistemaPulseira.entity.Cliente;
import com.example.sistemaPulseira.service.PulseiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pulseira")
public class PulseiraController {

    @Autowired
    private PulseiraService pulseiraService;


    @GetMapping("/getAll")
    public List<Cliente> allClientes() {
    return pulseiraService.getAllClientes();
    }

}
