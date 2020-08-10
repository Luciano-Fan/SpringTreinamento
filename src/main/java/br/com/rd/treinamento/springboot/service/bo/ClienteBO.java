package br.com.rd.treinamento.springboot.service.bo;

import br.com.rd.treinamento.springboot.model.dto.ClienteDTO;
import br.com.rd.treinamento.springboot.model.entity.ClienteEntity;
import org.springframework.stereotype.Component;

@Component
public class ClienteBO {

    public ClienteDTO parseToDTO(ClienteEntity entity){
        ClienteDTO dto = new ClienteDTO();

        if(entity == null)
            return dto;

        dto.setIdCliente(entity.getIdCliente());
        dto.setNomeCliente(entity.getNomeCliente());
        dto.setNumeroCpf(entity.getNumeroCpf());
        dto.setNumeroCnpj(entity.getNumeroCnpj());
        //dto.setDataCadastro(entity.getDataCadastro());

        return dto;
    }

    public ClienteEntity parseToEntity(ClienteDTO dto, ClienteEntity entity){
        if (entity == null)
             entity = new ClienteEntity();

        if (dto == null)
            return entity;

        entity.setIdCliente(dto.getIdCliente());
        entity.setNomeCliente(dto.getNomeCliente());
        entity.setNumeroCpf(dto.getNumeroCpf());
        entity.setNumeroCnpj(dto.getNumeroCnpj());
        //entity.setDataCadastro(dto.getDataCadastro());

        return entity;
    }

}
