package com.usuario.ladc.web.consumoCalorias.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.usuario.ladc.web.consumoCalorias.domain.*;

@Repository(value = "consumoDao")
public class ConsumoDao {

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
    public List<Consumo> getListaConsumos() {
        return em.createQuery("from Consumo c order by c.id").getResultList();
    }

    @Transactional(readOnly = false)
    public void saveConsumo(Consumo u) {
        em.merge(u);
        em.flush();
    }

}