package com.usuario.ladc.web.consumoCalorias.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.usuario.ladc.web.consumoCalorias.domain.*;

@Repository(value = "categoriaDao")
public class CategoriaDao {

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
    public List<Categoria> getListaCategorias() {
        return em.createQuery("from Categoria c order by c.id").getResultList();
    }
    

    @Transactional(readOnly = false)
    public void saveCategoria(Categoria c) {
        em.merge(c);
        em.flush();
    }

}