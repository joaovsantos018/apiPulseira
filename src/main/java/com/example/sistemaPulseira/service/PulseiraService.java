package com.example.sistemaPulseira.service;

import com.example.sistemaPulseira.entity.Cliente;

import java.util.List;

public interface PulseiraService {
    List<Cliente> getAllClientes();

    Cliente salvaCliente(Cliente cliente);

    Cliente recargaPorPulseiraId(Double valor, Integer pulseiraId);

    Object getByPulseiraId(Integer id);
}
