package com.usuario.ladc.web.consumoCalorias.web;
import java.util.List;
import com.usuario.ladc.web.consumoCalorias.domain.*;
import com.usuario.ladc.web.consumoCalorias.repository.*;
import com.usuario.ladc.web.consumoCalorias.repository.ConsumoDao;
import com.usuario.ladc.web.consumoCalorias.service.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IngresoAlimentoController {

    protected final Log logger = LogFactory.getLog(getClass());
    @Autowired
    private ConsumoDao consumoDao;
    @Autowired
    private TipoDao tipoDao;
    @Autowired
    private AlimentoDao alimentoDao;
    
    public void setConsumoDao(ConsumoDao consumoDao) {
        this.consumoDao = consumoDao;
    }
    
    public void setTipoDao(TipoDao tipoDao) {
        this.tipoDao = tipoDao;
    }
    
    public void setAlimentoDao(AlimentoDao alimentoDao) {
        this.alimentoDao = alimentoDao;
    }
        
    @RequestMapping(value="ingresoAlimento.htm", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView recargarFormularioIngresoAlimento(HttpServletRequest request,FormularioIngresoAlimento formularioAntiguo) throws ServletException{
    	HttpSession session = request.getSession(true);
		Usuario u = (Usuario) session.getAttribute("usuario");
		if(u != null){
			ModelAndView vista = new ModelAndView("ingresoAlimento");
			FormularioIngresoAlimento f = formularioAntiguo == null ? new FormularioIngresoAlimento() : formularioAntiguo;
	    	vista.addObject(f);
	    	vista.addObject("usuario",u);
	    	vista.addObject("listaTipos",tipoDao.getListaTipos());
	    	return vista;
		}else{
			return new ModelAndView("salir");
		}	
    }
    @RequestMapping(value="ingresoAlimento.htm", method = RequestMethod.POST)
    public ModelAndView guardarConsumo(@Valid FormularioIngresoAlimento formulario, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException	
    {
    	Usuario u = comprobarUsuario(request);
    	
    	if(u != null){
	        if (result.hasErrors()) {
	            return recargarFormularioIngresoAlimento(request, formulario); 
	        }
	    	
	        float porcion = formulario.getPorcion();
	        int alimento = formulario.getAlimento();
	        //String fecha = formulario.getFecha();//yyyy-MM-dd
	        Date fecha= new Date();
	        int tipo = formulario.getTipo();
	        System.out.println("Usuario:" + u.getId());
	        int usuario= u.getId();
	        System.out.println("Porcion: "+porcion+"\nId alimento: "+alimento+"\nfecha: "+fecha+"\nId tipo: "+tipo);
	        
	        Tipo tipoObjeto= tipoDao.getTipo(tipo);
	        System.out.println("Tipo:" +tipoObjeto.getId()+ "-"+tipoObjeto.getNombre());
	        
	        Alimento alimentObjeto = alimentoDao.getAlimento(alimento);
	        System.out.println("Alimento: " + alimentObjeto.getNombre()+" "+ alimentObjeto.getId());
	        
	        Consumo c = new Consumo();
	        c.setAlimento(alimentObjeto);
	        c.setFecha(fecha);
	        c.setPorcion(porcion);
	        c.setTipo(tipoObjeto);
	        c.setUsuario(u);
	        
	        consumoDao.saveConsumo(c);
	        
	        //Insertar aquí el resto de la lógica
	        
	        if(fecha != null){
	    		logger.info("Ir a inicio");
	    		ModelAndView i = new ModelAndView("inicio");
	    		int sumaCalorias=calcularTotalCaloriasDiarias(u.getId());
				i.addObject("sumaCalorias", sumaCalorias);
				int maxCalorias=u.getMaxCalorias();
				int porcentajeCalorias=calcularProcentajeCaloriasDiarias(maxCalorias,u.getId());
				i.addObject("porcentajeCalorias", porcentajeCalorias);
	    		i.addObject("usuario", u);
	    		
	    		return i;
	        }
	         
	        return recargarFormularioIngresoAlimento(request,null);
    	}else{
    		//Redireccionar al loggin
    		logger.info("Ir a Loggin");
    		return new ModelAndView("salir");
    	}
    }  
    
    private Usuario comprobarUsuario(HttpServletRequest r){
    	return (Usuario) r.getSession(true).getAttribute("usuario");
    }
    
    public int calcularTotalCaloriasDiarias(int id_usuario){
		Date fechaHoy = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String fechaFormat=sdf.format(fechaHoy);
		
		List <Consumo> ConsumoUsuarioHoy=consumoDao.listaConsumoHoyPorUsuario(id_usuario,fechaFormat);
		int suma=0;
		float calorias=0;
		for (Consumo c :  ConsumoUsuarioHoy){
			calorias= c.getPorcion()*c.getAlimento().getCalorias()/c.getAlimento().getCantidad();
			suma+=calorias;
		}
		
		return suma;
	}
    public int calcularProcentajeCaloriasDiarias(int maxCalorias, int id_usuario){
    	int porcentaje=0;
    	int totalCaloriasDiarias=calcularTotalCaloriasDiarias(id_usuario);
    	porcentaje= totalCaloriasDiarias*100/maxCalorias;
    	return porcentaje;
    }

}

