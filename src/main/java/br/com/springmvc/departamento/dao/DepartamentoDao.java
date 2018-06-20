package br.com.springmvc.departamento.dao;

import java.util.List;

import br.com.springmvc.model.Departamento;

public interface DepartamentoDao  {
	
	Departamento buscarDepartamento(Departamento departamento);
	
	List<Departamento> listarDepartamentos();
	
	Departamento incluirDepartamento(Departamento departamento);
	
	Departamento atualizarDepartamento(Departamento departamento);
	
	Departamento excluirDepartamento(Departamento departamento);
}
