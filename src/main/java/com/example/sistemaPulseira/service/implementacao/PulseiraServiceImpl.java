package com.example.sistemaPulseira.service.implementacao;

import com.example.sistemaPulseira.entity.Cliente;
import com.example.sistemaPulseira.repository.PulseiraRepository;
import com.example.sistemaPulseira.service.PulseiraService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.lang.System.*;

@Data
@Slf4j
@Service
public class PulseiraServiceImpl implements PulseiraService {
    @Autowired
    private PulseiraRepository pulseiraRepository;


    public List<Cliente> getAllClientes() {
        return pulseiraRepository.findAll();
    }

    public Cliente salvaCliente(Cliente cliente) {
        return pulseiraRepository.save(cliente);
    }


    public Cliente recargaPorPulseiraId(Double valor, Integer pulseiraId) {
        try {
            Optional<Cliente> clienteOpt = pulseiraRepository.findById(pulseiraId);
            if(clienteOpt.isPresent()){
            Cliente cliente = clienteOpt.get();

            log.info("cliente" + cliente);

            cliente.saldo += valor;


            return pulseiraRepository.save(cliente);
            }
        return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public Object getByPulseiraId(Integer id) {
        return pulseiraRepository.findById(id);
    }
}
