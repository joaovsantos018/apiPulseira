package com.example.sistemaPulseira.controller;

import com.example.sistemaPulseira.DTO.RecargaDTO;
import com.example.sistemaPulseira.entity.Cliente;
import com.example.sistemaPulseira.exceptions.ClienteException;
import com.example.sistemaPulseira.service.PulseiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pulseira")
public class PulseiraController {


    //Atualizar Cliente
    //Deletar Cliente OK
    //Ver Saldo da pulseira OK
    //Histórico de recarga
    //Busca por nome
    //Consumação


    @Autowired
    private PulseiraService pulseiraService;


    @GetMapping("/getByPulseiraID/{id}")
    public Cliente getByPulseiraId(@PathVariable("id") Integer id) {
        return pulseiraService.getByPulseiraId(id);
    }


    @PostMapping("/salvaCliente")
    public Cliente salvaCliente(@RequestBody Cliente cliente)  {
        if(cliente.getNome() == null || cliente.getNome().isEmpty()){
            throw new ClienteException("O nome do cliente não pode ser nulo");
        }
        return pulseiraService.salvaCliente(cliente);
    }

    @DeleteMapping("/deleteByPulseira/{id}")
    public Cliente deleteCliente(@PathVariable("id") Integer id) {
        return pulseiraService.deleteCliente(id);
    }

    @GetMapping("/consultaSaldo/{id}")
    public Map<String, Double> getSaldoByPulseiraId(@PathVariable("id") Integer pulseiraId) {
        return pulseiraService.getSaldoByPulseiraId(pulseiraId);
    }


    @GetMapping("/getAll")
    public List<Cliente> allClientes() {
    return pulseiraService.getAllClientes();
    }


    @PostMapping("/recarregaConsumacao")
    public Cliente recarregaPorPulseiraId (@RequestBody RecargaDTO recargaDTO) {
        if(recargaDTO.getValor() <= 0) {
            throw new ClienteException("O valor de recarga tem que ser maior que 0");
        }
        return pulseiraService.recargaPorPulseiraId(recargaDTO.getValor(), recargaDTO.getPulseiraId());
    }

    @PostMapping("/consumacao")
    public Cliente consumacao (@RequestBody RecargaDTO recargaDTO) {
        if(recargaDTO.getValor() <= 0) {
            throw new ClienteException("O valor de consumação tem que ser maior que 0");
        }
        return pulseiraService.consumacaoPorPulseira(recargaDTO.getValor(), recargaDTO.getPulseiraId());
    }
}
