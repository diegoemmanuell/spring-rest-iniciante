package com.algaworks.osworks.api.excepitonhandler;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@JsonInclude(Include.NON_NULL)
public class Problema {

	
	private @Getter @Setter Integer status;
	private @Getter @Setter OffsetDateTime
	dataHora;
	private @Getter @Setter String titulo;
	private @Getter @Setter List<Campo> campos;
	
	public static class Campo{
		
		
		
		public Campo(String nome, String mensagem) {
			super();
			this.nome = nome;
			this.mensagem = mensagem;
		}
		private @Getter @Setter String nome;
		private @Getter @Setter String mensagem;
	}
}
