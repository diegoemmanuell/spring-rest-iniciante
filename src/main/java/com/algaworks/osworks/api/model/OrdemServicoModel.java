package com.algaworks.osworks.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.algaworks.osworks.domain.model.StatusOrdemServico;

import lombok.Getter;
import lombok.Setter;

public class OrdemServicoModel {

	private @Getter @Setter Long id;
	private @Getter @Setter ClienteResumoModel cliente;
	private @Getter @Setter String descricao;
	private @Getter @Setter BigDecimal preco;
	private @Getter @Setter StatusOrdemServico status;
	private @Getter @Setter OffsetDateTime dataAbertura;
	private @Getter @Setter OffsetDateTime dataFinalizacao;
}
