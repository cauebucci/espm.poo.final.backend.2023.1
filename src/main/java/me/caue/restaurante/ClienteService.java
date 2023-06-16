package me.caue.restaurante;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteTO> list() {
        List<ClienteTO> clientes = new ArrayList<>();
        clienteRepository.findAll().forEach(c -> 
            clientes.add(new ClienteTO(c.getCpf(), c.getNome(), c.getNumero())));
        return clientes;
    }

    public ClienteTO find(String cpf) {
        return clienteRepository.findById(cpf)
            .map(c -> new ClienteTO(c.getCpf(), c.getNome(), c.getNumero()))
            .orElse(null);
    }

    public void create(ClienteTO cliente) {
        clienteRepository.save(new ClienteModel(cliente));
    }

    public void delete(String cpf) {
        clienteRepository.deleteById(cpf);
    }
    
}
