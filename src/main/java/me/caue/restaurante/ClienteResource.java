package me.caue.restaurante;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class ClienteResource {

    @Autowired
    public ClienteService clienteService;

    @GetMapping("/clientes")
    public List<ClienteTO> getClientes(@RequestParam(name = "nome", defaultValue = "") String nome) {
        return (nome.length() > 0)
            ? clienteService.list().stream().filter(c -> c.nome().toLowerCase().contains(nome.toLowerCase())).toList()
            : clienteService.list();
    }

    @GetMapping("/cliente/buscar/{cpf}")
    public ClienteTO getCliente(@PathVariable("cpf") String cpf) {
        ClienteTO cliente = clienteService.find(cpf);
        if(cliente == null) {

            return new ClienteTO(null, null, null);
        }
        return cliente;
    }

    @PostMapping("/cliente/cadastrar")
    public void postCliente(@RequestBody ClienteTO in) {
        clienteService.create(in);
    }

    @DeleteMapping("/cliente/{id}")
    public void deleteCliente(@PathVariable("id") String id) {
        clienteService.delete(id);
    }
    
}
