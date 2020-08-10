package br.com.rd.treinamento.springboot.service;

import br.com.rd.treinamento.springboot.repository.ClienteRepository;
import br.com.rd.treinamento.springboot.model.dto.ClienteDTO;
import br.com.rd.treinamento.springboot.model.entity.ClienteEntity;
import br.com.rd.treinamento.springboot.service.bo.ClienteBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
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

    public void inserir (ClienteDTO dto){
        ClienteEntity entity = clienteBO.parseToEntity(dto,null);
        if(entity.getIdCliente() != null)
            repository.save(entity);
    }

    public void atualizar (ClienteDTO dto){
        ClienteEntity entity = repository.getOne(dto.getIdCliente());
        if (entity != null){
            entity = clienteBO.parseToEntity(dto,entity);
            repository.save(entity);
        }

    }

    public ClienteDTO excluirClienteId(Integer codigo) {
        ClienteEntity entity = repository.getOne(codigo);
        ClienteDTO dto = new ClienteDTO();

        if (entity == null) {
            dto = clienteBO.parseToDTO(entity);
            repository.delete(entity);
        }
        return dto;
    }
}
