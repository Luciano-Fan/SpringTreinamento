package br.com.rd.treinamento.springboot.service;

import br.com.rd.treinamento.springboot.service.bo.ClienteBO;
import br.com.rd.treinamento.springboot.model.dto.ClienteDTO;
import br.com.rd.treinamento.springboot.model.entity.ClienteEntity;
import br.com.rd.treinamento.springboot.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ClienteBO clienteBO;

    public List<ClienteDTO> buscarTodosClientes(){
        List <ClienteDTO> listaClientes = new ArrayList<>();

        for (ClienteEntity entity: repository.findAll()) {
            ClienteDTO dto = clienteBO.parseToDTO(entity);
            listaClientes.add(dto);
        }
        return listaClientes;
    }

    public ClienteDTO buscarClienteId(Integer codigo){
        return clienteBO.parseToDTO(repository.getOne(codigo));
    }

}
