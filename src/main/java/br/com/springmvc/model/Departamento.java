package br.com.springmvc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="DEPARTAMENTO")
@SequenceGenerator(name="DEPARTAMENTO_SEQ", sequenceName="DEPARTAMENTO_SEQ")
public class Departamento implements Serializable {

	private static final long serialVersionUID = -7339229349332936402L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEPARTAMENTO_SEQ")
	@SequenceGenerator(name = "DEPARTAMENTO_SEQ", sequenceName = "DEPARTAMENTO_SEQ", allocationSize = 1)
	@Column(name="COD_DEPARTAMENTO", nullable=false, length=8)
	@NotNull
	private Long codDepartamento;
	
	@Column(name="NOME_DEPARTAMENTO", nullable=false, length=50)
	@NotEmpty
	private String nomeDepartamento;
	
	@Column(name="LOCALIZACAO_DEPARTAMENTO", length=60)
	private String localizacaoDepartamento;
	
	public Departamento() {
		super();
	}

	public Departamento(Long codDepartamento) {
		this.codDepartamento = codDepartamento;
	}
	public Long getCodDepartamento() {
		return codDepartamento;
	}
	public void setCodDepartamento(Long codDepartamento) {
		this.codDepartamento = codDepartamento;
	}
	public String getNomeDepartamento() {
		return nomeDepartamento;
	}
	public void setNomeDepartamento(String nomeDepartamento) {
		this.nomeDepartamento = nomeDepartamento;
	}
	public String getLocalizacaoDepartamento() {
		return localizacaoDepartamento;
	}
	public void setLocalizacaoDepartamento(String localizacaoDepartamento) {
		this.localizacaoDepartamento = localizacaoDepartamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codDepartamento == null) ? 0 : codDepartamento.hashCode());
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
		Departamento other = (Departamento) obj;
		if (codDepartamento == null) {
			if (other.codDepartamento != null)
				return false;
		} else if (!codDepartamento.equals(other.codDepartamento))
			return false;
		return true;
	}
}
