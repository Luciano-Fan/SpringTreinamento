package br.com.rd.treinamento.springboot.controller;

import br.com.rd.treinamento.springboot.model.dto.ClienteDTO;
import br.com.rd.treinamento.springboot.repository.ClienteRepository;
import br.com.rd.treinamento.springboot.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    ClienteService service;

    @Autowired
    private ClienteRepository repository;

    @GetMapping("/clientes")
    public List<ClienteDTO> buscarTodosClientes(){
        return service.buscarTodosClientes();
    }

    @GetMapping("/cliente/{codigo}")
    public ClienteDTO buscarClienteId(@PathVariable("codigo") Integer codigo ){
        return service.buscarClienteId(codigo);
    }

    @PostMapping("/clientes")
    public ResponseEntity inserir(@RequestBody ClienteDTO dto){
        service.inserir(dto);
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping("/clientes")
    public ResponseEntity atualizar(@RequestBody ClienteDTO dto){
        service.atualizar(dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/cliente/{codigo}")
    public ResponseEntity excluirCliente(@PathVariable("codigo") Integer codigo ){
        ClienteDTO dto = service.excluirClienteId(codigo);
        return ResponseEntity.ok().body(dto);
    }
}
