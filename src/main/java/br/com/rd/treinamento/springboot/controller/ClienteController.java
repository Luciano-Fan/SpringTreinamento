package br.com.rd.treinamento.springboot.controller;

import br.com.rd.treinamento.springboot.model.dto.ClienteDTO;
import br.com.rd.treinamento.springboot.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    ClienteService service;

    @GetMapping("/clientes")
    public List<ClienteDTO> buscarTodosClientes(){
        return service.buscarTodosClientes();
    }

    @GetMapping("/cliente/{codigo}")
    public ClienteDTO buscarClienteId(@PathVariable("codigo") Integer codigo ){
        return service.buscarClienteId(codigo);
    }


}
