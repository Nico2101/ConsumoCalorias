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
public class IngresoNuevoAlimentoController {

    protected final Log logger = LogFactory.getLog(getClass());
    
    @Autowired
    private ConsumoDao consumoDao;

    public void getConsumoDao(ConsumoDao consumoDao) {
        this.consumoDao = consumoDao;
    }
    
    @RequestMapping(value="IngresoNuevoAlimento.htm", method = RequestMethod.GET)
    public ModelAndView recargarFormularioIngresoNuevoAlimento(HttpServletRequest request, boolean incorrecto) throws ServletException{
    	ModelAndView x = new ModelAndView("IngresoNuevoAlimento");
    	x.addObject(new FormularioIngresoNuevoAlimento());
    
    	return x;
    }
    
    @ModelAttribute("listaTipos")
    public  List<String> listaTipos(){
    	List<String> t = consumoDao.getListaTipos();
    	return t;	
    }
    
    @ModelAttribute("listaAlimentos")
    public  List<String> listaAlimentos(){
    	List<String> a = consumoDao.getListaAlimentos();
    	return a;
    }
    
    @RequestMapping(value="IngresoNuevoAlimento.htm", method = RequestMethod.POST)
    public ModelAndView onSubmit(@Valid FormularioIngresoNuevoAlimento formulario, BindingResult result) throws ServletException, IOException	
    {
        if (result.hasErrors()) {
            return recargarFormularioIngresoNuevoAlimento(null,true);
        }
		
        float porcion = formulario.getPorcion();
        System.out.println(porcion);
        Alimento alimento = formulario.getAlimento();
        Date fecha = formulario.getFecha();
        Tipo tipo = formulario.getTipo();
        
        
      //Date fecha1 = new Date(0);
       // consumoDao.insertarConsumo(1.2, null, 1, 2 , 1, 1);
        
        //Consumo c = consumoDao.saveConsumo(consumo);
        String c = "a";
    	if(c != null){
    		logger.info("Ir a inicio");
    		ModelAndView i = new ModelAndView("inicio");
    		i.addObject("usuario", c);
    		
    		return i;
        }
         logger.info("Ir a Loggin");
        return recargarFormularioIngresoNuevoAlimento(null,true);
    }    
}