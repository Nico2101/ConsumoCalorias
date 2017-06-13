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
import javax.servlet.http.HttpSession;
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
public class LogginController {

    protected final Log logger = LogFactory.getLog(getClass());
    //private String usuario;
    //private String clave;
    
    @Autowired
    private UsuarioDao usuarioDao;

    public void setUsuarioDao(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }
    
    @RequestMapping(value="loggin2.htm", method = RequestMethod.GET)
    public ModelAndView recargarFormularioLoggin(HttpServletRequest request, boolean incorrecto) throws ServletException{
    	ModelAndView x = new ModelAndView("loggin2");
    	x.addObject(new FormularioLoggin());
    	if(incorrecto)
    		x.addObject("usuarioNoEncontrado", "El usuario no fue encontrado");
    	return x;
    }
  
    @RequestMapping(value="loggin2.htm", method = RequestMethod.POST)
    public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, @Valid FormularioLoggin formulario, BindingResult result) throws ServletException, IOException	
    {
    	
        String usuario = formulario.getCorreo();
        String clave = formulario.getClave();
        
        Usuario u = usuarioDao.getUsuario(usuario, clave);
        
        
    	if(u != null){
    		ModelAndView i = new ModelAndView("inicio");
    		i.addObject("usuario", u);
    		HttpSession session = request.getSession(true);
			session.setAttribute("usuario", u);
    		return i;
        }
         logger.info("Ir a Loggin");
        return recargarFormularioLoggin(null,true);
    }
   

   

    
    
}
