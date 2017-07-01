package com.usuario.ladc.web.consumoCalorias.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
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
    


    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Consumo> getConsumosDeUnUsuarioYUnaCategoria(int idUsuario, int idCategoria, String fechaInicio, String fechaFin) {
        String consulta = "from Consumo c where c.usuario.id="+idUsuario+" and c.fecha >= '"+fechaInicio+"' and c.fecha < '"+fechaFin+"' and c.alimento.categoria.id = "+idCategoria+"";
    	return em.createQuery(consulta).getResultList();
    }

    @Transactional(readOnly = false)
    public void saveConsumo(Consumo u) {
        em.merge(u);
        em.flush();
    }
    
    @SuppressWarnings("unchecked")
	public List<Consumo> listaConsumoHoyPorUsuario(int u, String fecha) {
        return em.createQuery("from Consumo c where c.usuario.id="+u+" and c.fecha='"+fecha+"'").getResultList();
    }

}