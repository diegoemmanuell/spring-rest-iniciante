package com.algaworks.osworks.api.model;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;

public class ComentarioModel {

	private @Getter @Setter Long id;
	private @Getter @Setter String descricao;
	private @Getter @Setter OffsetDateTime dataEnvio;
	
	
}
