package com.usuario.ladc.web.consumoCalorias.web;
import com.usuario.ladc.web.consumoCalorias.domain.*;
import com.usuario.ladc.web.consumoCalorias.repository.*;
import com.usuario.ladc.web.consumoCalorias.repository.ConsumoDao;
import com.usuario.ladc.web.consumoCalorias.service.*;

import java.awt.List;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Date;
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
    private ConsumoDao consumoDao;

    public void setUsuarioDao(ConsumoDao consumoDao) {
        this.consumoDao = consumoDao;
    }
    
    @RequestMapping(value="ingresoAlimento.htm", method = RequestMethod.GET)
    public ModelAndView recargarFormularioIngresoAlimento(HttpServletRequest request, boolean incorrecto) throws ServletException{
    	ModelAndView x = new ModelAndView("ingresoAlimento");
    	x.addObject(new FormularioIngresoAlimento());
    	if(incorrecto)
    		x.addObject("porcionNoEncontrada", "La porcion no fue encontrado");
    	return x;
    }
    
    
    @ModelAttribute("tipoLista")
    public Map<String,String> tipoAlimentoLista() {
    	Map<String,String> tipo = new LinkedHashMap<String,String>();
    	tipo.put("Desayuno", "Desayuno");
    	tipo.put("Almuerzo", "Almuerzo");
    	tipo.put("Cena", "Cena");
    	tipo.put("Colacion", "Colacion");
     return tipo;
    }
    
    @RequestMapping(value="ingresoAlimento.htm", method = RequestMethod.POST)
    public ModelAndView onSubmit(@Valid FormularioIngresoAlimento formulario, BindingResult result) throws ServletException, IOException	
    {
        if (result.hasErrors()) {
            return recargarFormularioIngresoAlimento(null,true);
        }
		
        float porcion = formulario.getPorcion();
        Alimento alimento = formulario.getAlimento();
        Date fecha = formulario.getFecha();
        
        //Consumo c = consumoDao.saveConsumo(consumo);
        String c = "a";
    	if(c != null){
    		logger.info("Ir a inicio");
    		ModelAndView i = new ModelAndView("inicio");
    		i.addObject("usuario", c);
    		
    		return i;
        }
         logger.info("Ir a Loggin");
        return recargarFormularioIngresoAlimento(null,true);
    }    
}
