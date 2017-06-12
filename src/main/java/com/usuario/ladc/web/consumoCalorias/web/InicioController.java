package com.usuario.ladc.web.consumoCalorias.web;
import com.usuario.ladc.web.consumoCalorias.domain.*;
import com.usuario.ladc.web.consumoCalorias.repository.UsuarioDao;
import com.usuario.ladc.web.consumoCalorias.service.*;

import java.awt.List;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InicioController {

    protected final Log logger = LogFactory.getLog(getClass());


    @RequestMapping(value="inicio.htm", method = RequestMethod.GET)
    public ModelAndView recargarFormularioLoggin(HttpServletRequest request) throws ServletException{
    	ModelAndView x = new ModelAndView("inicio");
    	
    	return x;
    }
  
    @RequestMapping(value="inicio.htm", method = RequestMethod.POST)
    public ModelAndView onSubmit( BindingResult result) throws ServletException, IOException	
    {
    	
    		ModelAndView i = new ModelAndView("inicio");
    		
    		
    		return i;
        }
        
    }