package com.usuario.ladc.web.consumoCalorias.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.usuario.ladc.web.consumoCalorias.domain.*;

@Repository(value = "tipoDao")
public class TipoDao {

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
    public List<Tipo> getListaTipos() {
        return em.createQuery("from Tipo t order by t.id").getResultList();
    }

    @Transactional(readOnly = false)
    public void saveTipo(Tipo t) {
        em.merge(t);
        em.flush();
    }

}