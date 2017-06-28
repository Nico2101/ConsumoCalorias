package com.usuario.ladc.web.consumoCalorias.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.usuario.ladc.web.consumoCalorias.domain.*;

@Repository(value = "alimentoDao")
public class AlimentoDao {

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
    public List<Alimento> getListaAlimentos(Integer usuario) {
        return em.createQuery("from Alimento a where a.id_usuario= '"+usuario+"' a order by a.id").getResultList();
    }
    
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public Alimento getAlimento(int id_Alimento) {
    	String AlimentoString= ""+id_Alimento;
        return (Alimento)em.createQuery("from Alimento a where a.id='"+AlimentoString+"'").getResultList().get(0);
    }
    
    @Transactional(readOnly = false)
    public void saveAlimento(Alimento a) {
        em.merge(a);
        em.flush();
    }

}
