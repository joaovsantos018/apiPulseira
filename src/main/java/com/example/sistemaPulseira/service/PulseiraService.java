package com.example.sistemaPulseira.service;

import com.example.sistemaPulseira.entity.Cliente;

import java.util.List;
import java.util.Map;

public interface PulseiraService {
    List<Cliente> getAllClientes();

    Cliente salvaCliente(Cliente cliente);

    Cliente recargaPorPulseiraId(Double valor, Integer pulseiraId);

    Cliente consumacaoPorPulseira(Double valor, Integer pulseiraId);

    Cliente getByPulseiraId(Integer pulseiraId);

    Cliente deleteCliente(Integer pulseiraId);

    Map<String, Double> getSaldoByPulseiraId(Integer pulseiraId);
}
