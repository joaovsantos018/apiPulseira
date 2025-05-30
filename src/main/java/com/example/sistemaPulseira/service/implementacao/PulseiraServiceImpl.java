package com.example.sistemaPulseira.service.implementacao;

import com.example.sistemaPulseira.entity.Cliente;
import com.example.sistemaPulseira.exceptions.ClienteException;
import com.example.sistemaPulseira.repository.PulseiraRepository;
import com.example.sistemaPulseira.service.PulseiraService;
import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public Cliente deleteCliente(Integer id) {
        Optional<Cliente> cliente = pulseiraRepository.findById(id);
        if (cliente.isPresent()) {
            pulseiraRepository.deleteById(id);
            return cliente.get();
        } else {
            throw new EntityNotFoundException("Cliente não encontrado");
        }
    }

    public Map<String, Double> getSaldoByPulseiraId(Integer pulseiraId) {
        Optional<Cliente> clienteOptional = pulseiraRepository.findById(pulseiraId);
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            Map<String, Double> response = new HashMap<>();
            response.put("saldo", cliente.getSaldo());
            return response;

        } else {
            throw new RuntimeException("Cliente não encontrado para");
        }
    }

    public Cliente recargaPorPulseiraId(Double valor, Integer pulseiraId) {
        try {
            Optional<Cliente> clienteOpt = pulseiraRepository.findById(pulseiraId);
            if (clienteOpt.isPresent()) {
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

    public Cliente consumacaoPorPulseira(Double valor, Integer pulseiraId) {
        try {
            Optional<Cliente> clienteOpt = pulseiraRepository.findById(pulseiraId);
            if (clienteOpt.isPresent()) {

                Cliente cliente = clienteOpt.get();

                log.info("cliente" + cliente);

                if (cliente.saldo < valor) {
                    throw new ClienteException("Saldo insuficiente");
                }

                cliente.setSaldo(cliente.getSaldo() - valor);


                return pulseiraRepository.save(cliente);
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public Cliente getByPulseiraId(Integer id) {
        return pulseiraRepository.findById(id).orElseThrow(() -> new ClienteException("Cliente não encontrado para o id" + id));
    }
}
