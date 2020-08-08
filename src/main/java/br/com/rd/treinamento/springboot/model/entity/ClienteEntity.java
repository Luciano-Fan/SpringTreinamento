package br.com.rd.treinamento.springboot.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "TB_CLIENTE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteEntity {
	
	@Id
	@GeneratedValue
	@Column (name = "ID_CLIENTE")
	private Integer idCliente;
	
	@Column(name = "NM_CLIENTE")
	private String nomeCliente;
	
	@Column(name = "NR_CPF")
	private String numeroCpf;
	
	@Column(name = "NR_CNPJ")
	private String numeroCnpj;
	
	@Column(name = "DT_CADASTRO")
	private String dataCadastro;

}
