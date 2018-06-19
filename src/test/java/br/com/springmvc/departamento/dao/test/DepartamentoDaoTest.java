package br.com.springmvc.departamento.dao.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.springmvc.config.ApplicationConfig;
import br.com.springmvc.departamento.dao.DepartamentoDao;
import br.com.springmvc.model.Departamento;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
@Rollback(value = true)
@Transactional
public class DepartamentoDaoTest {

	@Autowired
	private DepartamentoDao departamentoDao;
	
	@Test
	public void testSuccessBuscarDepartamento(){
		Departamento dep = departamentoDao.buscarDepartamento(new Departamento(1L));
		Assert.assertEquals(new Long(1), dep.getCodDepartamento());
		Assert.assertEquals("FINANCEIRO", dep.getNomeDepartamento());
		Assert.assertEquals("1º ANDAR, SALA 22", dep.getLocalizacaoDepartamento());
	}
	
	@Test
	public void testSuccessListarDepartamentos(){
		List<Departamento> list = departamentoDao.listarDepartamentos();
		Assert.assertNotNull(list !=null ? list : new ArrayList<Departamento>());
	}
	
	@Test
	public void testSuccessAtualizarDepartamento(){
		Departamento dep = new Departamento(1L);
		dep.setNomeDepartamento("FINANCEIROXXX");
		dep.setLocalizacaoDepartamento("1º ANDAR, SALA 22");
		dep = departamentoDao.atualizarDepartamento(dep);
		Assert.assertEquals(new Long(1), dep.getCodDepartamento());
		Assert.assertEquals("FINANCEIROXXX", dep.getNomeDepartamento());
		Assert.assertEquals("1º ANDAR, SALA 22", dep.getLocalizacaoDepartamento());
	}
	
	@Test
	public void testSuccessIncluirDepartamento(){
		Departamento dep = new Departamento();
		dep.setNomeDepartamento("FINANCEIROXXX");
		dep.setLocalizacaoDepartamento("1º ANDAR, SALA 22");
		dep = departamentoDao.incluirDepartamento(dep);
		Assert.assertEquals("FINANCEIROXXX", dep.getNomeDepartamento());
		Assert.assertEquals("1º ANDAR, SALA 22", dep.getLocalizacaoDepartamento());
	}
	
	@Test
	public void testSuccessExcluirDepartamento(){
		Departamento dep = new Departamento();
		dep.setCodDepartamento(1L);
		dep.setNomeDepartamento("FINANCEIRO");
		departamentoDao.excluirDepartamento(dep);
		Assert.assertEquals(Long.valueOf(1L), dep.getCodDepartamento());
		Assert.assertEquals("FINANCEIRO", dep.getNomeDepartamento());
	}
}
