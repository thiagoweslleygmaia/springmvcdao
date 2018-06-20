package br.com.springmvc.departamento.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.springmvc.model.Departamento;

@Repository
public class DepartamentoDaoImpl implements DepartamentoDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public DepartamentoDaoImpl() {
		super();		
	}
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Departamento buscarDepartamento(Departamento departamento) {
		String hql = "from Departamento d where d.codDepartamento = :codDepartamento";
		Query<Departamento> query = getSession().createQuery(hql, Departamento.class)
		.setParameter("codDepartamento", departamento.getCodDepartamento());
		//query.getFetchSize()!=null ? query.getSingleResult() : null;
		return query.getSingleResult(); //CORRIGIR NULL POINTER, QUANDO NÃO VEM DADOS
	}
	
	@Override
	public List<Departamento> listarDepartamentos() {
		String hql = "from Departamento order by codDepartamento";
		Query<Departamento> query = getSession()
		.createQuery(hql, Departamento.class);
		return query.getResultList();
	}
	
	public Departamento atualizarDepartamento(Departamento departamento) {
		Departamento dep = getSession().byId(Departamento.class).load(departamento.getCodDepartamento());
		dep.setNomeDepartamento(departamento.getNomeDepartamento());
		dep.setLocalizacaoDepartamento(departamento.getLocalizacaoDepartamento());
		getSession().flush();
		return departamento;
	}
	
	@Override
	public Departamento excluirDepartamento(Departamento departamento) {
		Departamento dep = getSession().byId(Departamento.class).load(departamento.getCodDepartamento());
		getSession().delete(dep);
		return departamento;
	}
	
	@Override
	public Departamento incluirDepartamento(Departamento departamento) {
		getSession().save(departamento);
		getSession().flush();				
		return departamento;
	}
}
