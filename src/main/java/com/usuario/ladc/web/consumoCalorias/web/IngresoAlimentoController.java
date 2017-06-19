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
    private TipoDao tipoDao;

    public void setTipoDao(TipoDao tipoDao) {
        this.tipoDao = tipoDao;
    }
    
    @RequestMapping(value="ingresoAlimento.htm", method = RequestMethod.GET)
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
    public ModelAndView guardarConsumo(HttpServletRequest request, @Valid FormularioIngresoAlimento formulario, BindingResult result) throws ServletException, IOException	
    {
    	HttpSession session = request.getSession(true);
		Usuario u = (Usuario) session.getAttribute("usuario");
		if(u != null){
	        if (result.hasErrors()) {
	            return recargarFormularioIngresoAlimento(request, formulario);
	        }
			
	        float porcion = formulario.getPorcion();
	        int alimento = formulario.getAlimento();
	        String fecha = formulario.getFecha();
	        int tipo = formulario.getTipo();
	        
	        System.out.println("porcion: "+ porcion + "\nid alimento :" + alimento + "\nfecha: " + fecha + "\ntipo : " + tipo);
	        
	        //Insertar resto de la lógica
	        
    		ModelAndView vista = new ModelAndView("inicio");
    		vista.addObject("usuario", u);
    		
    		return vista;
		}else{
			return new ModelAndView("salir");
		}
    }    
}

