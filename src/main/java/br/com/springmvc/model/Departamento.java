package br.com.springmvc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="DEPARTAMENTO")
@SequenceGenerator(name="DEPARTAMENTO_SEQ", sequenceName="DEPARTAMENTO_SEQ")
public class Departamento implements Serializable {

	private static final long serialVersionUID = -7339229349332936402L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEPARTAMENTO_SEQ")
	@SequenceGenerator(name = "DEPARTAMENTO_SEQ", sequenceName = "DEPARTAMENTO_SEQ"/*, allocationSize = 100*/)
	@Column(name="COD_DEPARTAMENTO", nullable=false, length=8)
	private Long codDepartamento;
	
	@Column(name="NOME_DEPARTAMENTO", nullable=false, length=50)
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
}
