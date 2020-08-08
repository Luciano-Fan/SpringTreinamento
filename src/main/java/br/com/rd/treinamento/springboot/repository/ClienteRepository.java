package br.com.rd.treinamento.springboot.repository;

import br.com.rd.treinamento.springboot.model.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository <ClienteEntity, Integer> {
}
