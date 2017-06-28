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
    
    @SuppressWarnings("unchecked")
	public List<String> getListaTipos() {
        return em.createQuery("select nombre from Tipo t order by t.id").getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<String> getListaAlimentos() {
        return em.createQuery("select nombre from Alimento a order by a.id").getResultList();
    }
   
	//public void insertarConsumo(int id, Date fecha, float porcion, int id_usuario, int id_tipo, int id_alimento){
    //    em.createQuery("insert into Consumo(id,fecha, porcion, id_usuario, id_tipo, id_alimento) select id, fecha, porcion, id_usuario, id_tipo, id_alimento").executeUpdate();
    //}

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