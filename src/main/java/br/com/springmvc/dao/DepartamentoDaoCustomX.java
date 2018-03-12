package br.com.springmvc.dao;

import java.util.List;

import br.com.springmvc.model.Departamento;

public interface DepartamentoDaoCustomX {

	Departamento buscarDepartamento(Departamento departamento);
	
	List<Departamento> listarDepartamentos();
	
	Departamento incluirDepartamento(Departamento departamento);
	
	Departamento atualizarDepartamento(Departamento departamento);
	
	Departamento excluirDepartamento(Departamento departamento);
}
