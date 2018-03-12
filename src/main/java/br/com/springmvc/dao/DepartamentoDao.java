package br.com.springmvc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import br.com.springmvc.model.Departamento;

@Repository
//@NoRepositoryBean
public interface DepartamentoDao extends /*JpaRepository<Departamento, Long>,*/ DepartamentoDaoCustom {}

interface DepartamentoDaoCustom {

	Departamento buscarDepartamento(Departamento departamento);
	
	List<Departamento> listarDepartamentos();
	
	Departamento incluirDepartamento(Departamento departamento);
	
	Departamento atualizarDepartamento(Departamento departamento);
	
	Departamento excluirDepartamento(Departamento departamento);
}
