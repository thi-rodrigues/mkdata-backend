package com.mkdata.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
@Entity
public class Cliente implements Serializable {

	private static final long serialVersionUID = 7938154021714488078L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private String tipo;

	@Column(name = "cpf_cnpj")
	private String cpfCnpj;
	
	private String rg;

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "data_cadastro")
	private Date dataCadastro;

	private Boolean ativo;

	private String telefone;

}
