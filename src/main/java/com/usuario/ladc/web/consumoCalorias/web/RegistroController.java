package com.usuario.ladc.web.consumoCalorias.web;
import java.util.List;
import com.usuario.ladc.web.consumoCalorias.domain.*;
import com.usuario.ladc.web.consumoCalorias.repository.*;
import com.usuario.ladc.web.consumoCalorias.service.*;

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
public class RegistroController {

	 @Autowired
	    private UsuarioDao usuarioDao;

	    public void setUsuarioDao(UsuarioDao usuarioDao) {
	        this.usuarioDao = usuarioDao;
	    }
        
    @RequestMapping(value="registro.htm", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView FormularioRegistro(HttpServletRequest request, FormularioRegistro formularioAntiguo,boolean incorrecto) throws ServletException{
    	
    	ModelAndView vista = new ModelAndView("registro");
    	FormularioRegistro f = formularioAntiguo == null ? new FormularioRegistro() : formularioAntiguo;
    	vista.addObject(f);
    	vista.addObject("usuarioEncontrado", incorrecto);
    	return vista;
			
    }
    
    
    @RequestMapping(value="registro.htm", method = RequestMethod.POST)
    public ModelAndView formularioCargado(@Valid FormularioRegistro formulario, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException	
    {
    	  if (result.hasErrors()) {
	            return FormularioRegistro(request, formulario,false); 
	        }
	    	
    	 
    	
        String correo = formulario.getCorreo();
    	String nombre = formulario.getNombre();
    	String apellido = formulario.getApellido();
        Integer peso = formulario.getPeso();
        Integer calorias = formulario.getMaxCalorias();
        String clave= formulario.getClave();
        Date fecha= new Date();
       
        System.out.println("Nombre: "+nombre+"\n correo: "+correo+"\npeso: "+peso+"\ncalorias tipo: "+calorias+"\nclave tipo: "+clave+"\nApellido tipo: "+apellido+"\nfecha: "+fecha);
     
        Usuario u = new Usuario();
        u.setFechaNacimiento(fecha);
        u.setNombre(nombre);
        u.setApellido(apellido);
        u.setCorreo(correo);
        u.setClave(clave);
        u.setPeso(peso);
        u.setMaxCalorias(calorias);
        
        List<Usuario> verificaCorreo= usuarioDao.getCorreos(correo);
        
    	if(verificaCorreo.size()== 0){
    		usuarioDao.saveUsuario(u);
    	    ModelAndView vista = new ModelAndView("inicio");
    	    vista.addObject(u);
    	    return vista;
    	}else{
    		return FormularioRegistro(request,null,true);
    	}
    		

    }
}