package br.com.springmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.springmvc.model.Departamento;

@Repository
@Transactional(readOnly = true)
public class DepartamentoDaoImpl implements DepartamentoDao /*DepartamentoDaoCustom*/ {

	@Autowired
	private SessionFactory sessionFactory;	
	
	public DepartamentoDaoImpl() {
		super();		
	}
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public Departamento buscarDepartamento(Departamento departamento) {
		String hql = "from Departamento d where d.codDepartamento = :codDepartamento";
		Query<Departamento> query = getSession().createQuery(hql, Departamento.class)
		.setParameter("codDepartamento", departamento.getCodDepartamento());
		return query.getSingleResult();
	}
	
	@Override
	public List<Departamento> listarDepartamentos() {
		String hql = "from Departamento order by codDepartamento";
		Query<Departamento> query = getSession()
		.createQuery(hql, Departamento.class);
		return query.getResultList();
	}
	
	public Departamento atualizarDepartamento(Departamento departamento) {
		getSession().update(departamento);
		return departamento;
	}
	
	@Override
	public Departamento excluirDepartamento(Departamento departamento) {
		getSession().delete(departamento);
		return departamento;
	}
	
	@Override
	public Departamento incluirDepartamento(Departamento departamento) {
		getSession().save(departamento);
		return departamento;
	}
}
