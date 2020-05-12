package com.cristoffer.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import progra3lab.TbUsuariop;

public class LoginDao {

	public List<TbUsuariop> ingresosUsuarios(TbUsuariop usu) {
	List<TbUsuariop> usuario = new ArrayList();
	EntityManager em;
	EntityManagerFactory emf;
	emf = Persistence.createEntityManagerFactory("progra3lab");
	em = emf.createEntityManager();
	
    try {
		em.getTransaction().begin();
		usuario = em.createQuery("from TbUsuariop as u where u.usuario= '"+usu.getUsuario()+"' and u.contrasenia ='"+usu.getContrasenia()+"'").getResultList();
		em.getTransaction().commit();
	} catch (Exception e) {
		System.out.println(e + "Error");
	}
		return usuario;
	}
	
}
