package com.algaworks.osworks.api.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

public class OrdemServicoInput {

	@NotBlank
	private @Getter @Setter String descricao;
	
	@NotNull
	private @Getter @Setter BigDecimal preco;
	
	@NotNull
	private @Getter @Setter CienteIdInput cliente;
	
}
