package com.algaworks.osworks.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.algaworks.osworks.domain.exception.NegocioException;

import lombok.Getter;
import lombok.Setter;

@Entity
public class OrdemServico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Getter @Setter Long id;
	
	@ManyToOne
	private @Getter @Setter Cliente cliente;
	
	private @Getter @Setter String descricao;
	
	private @Getter @Setter BigDecimal preco;
	
	@Enumerated(EnumType.STRING)
	private @Getter @Setter StatusOrdemServico status;

	private @Getter @Setter OffsetDateTime dataAbertura;
	
	private @Getter @Setter OffsetDateTime dataFinalizacao;
	
	@OneToMany(mappedBy = "ordemServico")
	private @Getter List<Comentario> comentarios = new ArrayList<Comentario>();
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdemServico other = (OrdemServico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public boolean podeSerFinalizada() {
		return StatusOrdemServico.ABERTA.equals(getStatus());
	}
	
	public boolean naoPodeSerFinalizada() {
		return !podeSerFinalizada();
	}
	
	public void finalizar() {
		if(naoPodeSerFinalizada()) {
			throw new NegocioException("Ordem de serviço não pode ser finalizada");
		}
		setStatus(StatusOrdemServico.FINALIZADA);
		setDataFinalizacao(OffsetDateTime.now());
	}
}
