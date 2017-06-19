package com.usuario.ladc.web.consumoCalorias.web;
import java.util.List;
import com.usuario.ladc.web.consumoCalorias.domain.*;
import com.usuario.ladc.web.consumoCalorias.repository.*;
import com.usuario.ladc.web.consumoCalorias.repository.ConsumoDao;
import com.usuario.ladc.web.consumoCalorias.service.*;

import java.io.IOException;
import java.util.LinkedList;
import java.util.ArrayList;
import java.sql.Date;
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

@Controller
public class IngresoAlimentoController {

    protected final Log logger = LogFactory.getLog(getClass());
    
   
    @Autowired
    private ConsumoDao consumoDao;
    @Autowired
    private TipoDao tipoDao;
    
    public void setConsumoDao(ConsumoDao consumoDao) {
        this.consumoDao = consumoDao;
    }
    
    public void setTipoDao(TipoDao tipoDao) {
        this.tipoDao = tipoDao;
    }
        
    @RequestMapping(value="ingresoAlimento.htm", method = RequestMethod.GET)
    public ModelAndView recargarFormularioIngresoAlimento(HttpServletRequest request, FormularioIngresoAlimento formularioAnterior, boolean incorrecto) throws ServletException{
    	Usuario u = comprobarUsuario(request);
    	if(u != null){
    		ModelAndView vista = new ModelAndView("ingresoAlimento");
    		FormularioIngresoAlimento form = formularioAnterior == null ? new FormularioIngresoAlimento() : formularioAnterior;
        	vista.addObject(form);
        	vista.addObject("listaTipos", tipoDao.getListaTipos());
        	vista.addObject("usuario",u);
        	return vista;
    	}else{
    		//Redireccionar al loggin
    		return new ModelAndView("salir");
    	}
    	
    	
    }
    

    public ModelAndView recargarFormularioIngresoAlimento(HttpServletRequest request,FormularioIngresoAlimento formularioAntiguo) throws ServletException{
    	HttpSession session = request.getSession(true);
		Usuario u = (Usuario) session.getAttribute("usuario");
		if(u != null){
			ModelAndView vista = new ModelAndView("ingresoAlimento");
			FormularioIngresoAlimento f = formularioAntiguo == null ? new FormularioIngresoAlimento() : formularioAntiguo;
	    	vista.addObject(f);
	    	vista.addObject("usuario",u);
	    	vista.addObject("listaTipos",listaTipos());
	    	return vista;
		}else{
			return new ModelAndView("salir");
		}
    	
    }
    
    //@ModelAttribute("listaTipos")
    public  List<Tipo> listaTipos(){
    	List<Tipo> t = tipoDao.getListaTipos();
    	return t;
    }
    
    
    @RequestMapping(value="ingresoAlimento.htm", method = RequestMethod.POST)
    public ModelAndView guardarConsumo(@Valid FormularioIngresoAlimento formulario, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException	
    {
    	Usuario u = comprobarUsuario(request);
    	if(u != null){
	        if (result.hasErrors()) {
	            return recargarFormularioIngresoAlimento(request, formulario, false);

	        }
			
	        float porcion = formulario.getPorcion();
	        int alimento = formulario.getAlimento();
	        String fecha = formulario.getFecha();//yyyy-MM-dd
	        int tipo = formulario.getTipo();
	        
	        System.out.println("Porcion: "+porcion+"\nId alimento: "+alimento+"\nfecha: "+fecha+"\nId tipo: "+tipo);
	        
	        //Insertar aquí el resto de la lógica
	        
	        if(fecha != null){
	    		logger.info("Ir a inicio");
	    		ModelAndView i = new ModelAndView("inicio");
	    		i.addObject("usuario", u);
	    		
	    		return i;
	        }
	         
	        return recargarFormularioIngresoAlimento(request,null,true);
    	}else{
    		//Redireccionar al loggin
    		logger.info("Ir a Loggin");
    		return new ModelAndView("salir");
    	}
    }  
    
    
    
    private Usuario comprobarUsuario(HttpServletRequest r){
    	return (Usuario) r.getSession(true).getAttribute("usuario");
    }

}

