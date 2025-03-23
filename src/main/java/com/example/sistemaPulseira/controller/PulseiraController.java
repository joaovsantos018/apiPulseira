package com.example.sistemaPulseira.controller;

import com.example.sistemaPulseira.DTO.RecargaDTO;
import com.example.sistemaPulseira.entity.Cliente;
import com.example.sistemaPulseira.exceptions.ClienteException;
import com.example.sistemaPulseira.service.PulseiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pulseira")
public class PulseiraController {

    @Autowired
    private PulseiraService pulseiraService;


    @PostMapping("/salvaCliente")
    public Cliente salvaCliente(@RequestBody Cliente cliente)  {
        try {
        return pulseiraService.salvaCliente(cliente);
        } catch (Exception e) {
            throw new ClienteException("Erro ao salvar o cliente");
        }
    }

    @GetMapping("/getByPulseiraID/{id}")
    public Object getByPulseiraId(@PathVariable("id") Integer id) {
        return pulseiraService.getByPulseiraId(id);
    }


    @GetMapping("/getAll")
    public List<Cliente> allClientes() {
    return pulseiraService.getAllClientes();
    }


    @PostMapping("/recarregaConsumacao")
    public Cliente recarregaPorPulseiraId (@RequestBody RecargaDTO recargaDTO) {
        return pulseiraService.recargaPorPulseiraId(recargaDTO.getValor(), recargaDTO.getPulseiraId());
    }

}
