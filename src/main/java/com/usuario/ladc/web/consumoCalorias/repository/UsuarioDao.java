package com.usuario.ladc.web.consumoCalorias.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.usuario.ladc.web.consumoCalorias.domain.*;

@Repository(value = "usuarioDao")
public class UsuarioDao {

    private EntityManager em = null;

    /*
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Usuario> getListaUsuarios() {
        return em.createQuery("from Usuario u order by u.id").getResultList();
    }
    
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public Usuario getUsuario(String correo, String clave) {
    	List<Usuario> resultado = em.createQuery("from Usuario u where u.correo = '"+correo+"' and u.clave = '"+clave+"'").getResultList();
    	if (resultado.size() == 1)	return resultado.get(0);
		return null;
    }

    @Transactional(readOnly = false)
    public void saveUsuario(Usuario u) {
        em.merge(u);
        em.flush();
    }

}